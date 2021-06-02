# -*- coding: utf-8 -*-
"""
    pygments.lexers.neverlang
    ~~~~~~~~~~~~~~~~~~~~~~~~~

    Lexers for the Neverlang language workbench.
"""

import re

from pygments.lexer import RegexLexer, bygroups, include, inherit, this, using
from pygments.lexers.jvm import JasminLexer, JavaLexer, ScalaLexer
from pygments.token import Comment, Keyword, Name, Number, Operator, Punctuation, String, Text

__all__ = ['NeverlangLexer']  # , 'NeverlangJavaLexer', 'NeverlangScalaLexer', 'NeverlangTemplateLexer']

class NeverlangJavaLexer(JavaLexer):
    """
    For the Java Extension used in Neverlang language workbench to define semantic actions. It is only used internally by the NeverlangLexer.

    .. versionadded:: 0.1
    """

    name = 'Neverlang'
    aliases = ['neverlang']
    filenames = ['*.nl']

    comments_or_spaces = '|'.join(['\s*//.*?\n\s*', '\s*/\*.*?\*/\s*', '\s+', '\s*'])
    references = ['\$\$', '(\#|\$)[\w\d_-]+\[\d+?\]\.[\w\d_]+', '(\#|\$)[\w\d_-]+\[\d+?\]', '(\#|\$)[\w\d_-]+\.[\w\d_]+', '(\#|\$)([\w\d_-]+)', '(\$|\#)\d+?\.[\w\d_]+?', '(\$|\#)\d+?']
    references_and_attributes = '|'.join(references)

    tokens = {
        'root': [
            (r'(eval)({0})({1})(;)'.format(comments_or_spaces, references_and_attributes), bygroups(Keyword.Pseudo, using(this), using(this), Punctuation)),
            (r'(\$(?:resume|suspend))({0})(;)'.format(comments_or_spaces), bygroups(Keyword.Pseudo, using(this), Punctuation)),
            (r'(\$\$)', Keyword.Pseudo),
            (r'(\#|\$)([\w\d_-]+)(\[)(\d+?)(\])(\.)([\w\d_]+)', bygroups(Keyword.Pseudo, Name.Label, Punctuation, Number.Integer, Punctuation, Punctuation, Name.Attribute)),
            (r'(\#|\$)([\w\d_-]+)(\[)(\d+?)(\])', bygroups(Keyword.Pseudo, Name.Label, Punctuation, Number.Integer, Punctuation)),
            (r'(\#|\$)([\w\d_-]+)(.)([\w\d_]+)', bygroups(Keyword.Pseudo, Keyword.Pseudo.Label, Punctuation, Name.Attribute)),
            (r'(\#|\$)([\w\d_-]+)', bygroups(Keyword.Pseudo, Keyword.Pseudo)),
            (r'(\#|\$)(\d+?)(\.)([\w\d_]+?)', bygroups(Keyword.Pseudo, Keyword.Pseudo, Punctuation, Name.Attribute)),
            (r'(\$|\#)(\d+?)', bygroups(Keyword.Pseudo, Keyword.Pseudo)),
            inherit
        ]

    }


class NeverlangScalaLexer(ScalaLexer):
    """
    For the Scala Extension used in Neverlang language workbench to define semantic actions. It is only used internally by the NeverlangLexer.

    .. versionadded:: 0.1
    """

    name = 'Neverlang'
    aliases = ['neverlang']
    filenames = ['*.nl']

    comments_or_spaces = '|'.join(['\s*//.*?\n\s*', '\s*/\*.*?\*/\s*', '\s+', '\s*'])
    references = ['\$\$', '(\#|\$)[\w\d_-]+\[\d+?\]\.[\w\d_]+', '(\#|\$)[\w\d_-]+\[\d+?\]', '(\#|\$)[\w\d_-]+\.[\w\d_]+', '(\#|\$)([\w\d_-]+)', '(\$|\#)\d+?\.[\w\d_]+?', '(\$|\#)\d+?']
    references_and_attributes = '|'.join(references)

    tokens = {
        'root': [
            (r'(eval)({0})({1})(;)'.format(comments_or_spaces, references_and_attributes), bygroups(Keyword.Pseudo, using(this), using(this), Punctuation)),
            (r'(\$(?:resume|suspend))({0})(;)'.format(comments_or_spaces), bygroups(Keyword.Pseudo, using(this), Punctuation)),
            (r'(\$\$)', Keyword.Pseudo),
            (r'(\#|\$)([\w\d_-]+)(\[)(\d+?)(\])(\.)([\w\d_]+)', bygroups(Keyword.Pseudo, Name.Label, Punctuation, Number.Integer, Punctuation, Punctuation, Name.Attribute)),
            (r'(\#|\$)([\w\d_-]+)(\[)(\d+?)(\])', bygroups(Keyword.Pseudo, Name.Label, Punctuation, Number.Integer, Punctuation)),
            (r'(\#|\$)([\w\d_-]+)(.)([\w\d_]+)', bygroups(Keyword.Pseudo, Name.Label, Punctuation, Name.Attribute)),
            (r'(\#|\$)([\w\d_-]+)', bygroups(Keyword.Pseudo, Name.Label)),
            (r'(\#|\$)(\d+?)(\.)([\w\d_]+?)', bygroups(Keyword.Pseudo, Keyword.Pseudo, Punctuation, Name.Attribute)),
            (r'(\$|\#)(\d+?)', bygroups(Keyword.Pseudo, Keyword.Pseudo)),
            inherit
        ]
    }


class NeverlangTemplateLexer(JasminLexer):
    """
    For the Template Extension used in Neverlang language workbench to define semantic actions. It is only used internally by the NeverlangLexer.

    .. versionadded:: 0.1
    """

    name = 'Neverlang'
    aliases = ['neverlang']
    filenames = ['*.nl']

    flags = re.MULTILINE | re.DOTALL | re.UNICODE

    comments_or_spaces = '|'.join(['\s*//.*?\n\s*', '\s*/\*.*?\*/\s*', '\s+', '\s*'])
    references = ['\$\$', '(\#|\$)[\w\d_-]+\[\d+?\]\.[\w\d_]+', '(\#|\$)[\w\d_-]+\[\d+?\]', '(\#|\$)[\w\d_-]+\.[\w\d_]+', '(\#|\$)([\w\d_-]+)', '(\$|\#)\d+?\.[\w\d_]+?', '(\$|\#)\d+?']
    references_and_attributes = '|'.join(references)

    tokens = {
        'root': [
            (r'{{', Keyword.Pseudo, 'neverlang'),
            (r'.', Text),
            inherit
        ],
        'neverlang': [
            (r'(eval)({0})({1})(;)'.format(comments_or_spaces, references_and_attributes), bygroups(Keyword.Pseudo, using(this), using(this), Punctuation)),
            (r'(\$(?:resume|suspend))({0})(;)'.format(comments_or_spaces), bygroups(Keyword.Pseudo, using(this), Punctuation)),
            (r'(\$\$)', Keyword.Pseudo),
            (r'(\#|\$)([\w\d_-]+)(\[)(\d+?)(\])(\.)([\w\d_]+)', bygroups(Keyword.Pseudo, Name.Label, Punctuation, Number.Integer, Punctuation, Punctuation, Name.Attribute)),
            (r'(\#|\$)([\w\d_-]+)(\[)(\d+?)(\])', bygroups(Keyword.Pseudo, Name.Label, Punctuation, Number.Integer, Punctuation)),
            (r'(\#|\$)([\w\d_-]+)(.)([\w\d_]+)', bygroups(Keyword.Pseudo, Name.Label, Punctuation, Name.Attribute)),
            (r'(\#|\$)([\w\d_-]+)', bygroups(Keyword.Pseudo, Name.Label)),
            (r'(\#|\$)(\d+?)(\.)([\w\d_]+?)', bygroups(Keyword.Pseudo, Keyword.Pseudo, Punctuation, Name.Attribute)),
            (r'(\$|\#)(\d+?)', bygroups(Keyword.Pseudo, Keyword.Pseudo)),
            (r'//.*?\n', Comment.Single),
            (r'/\*.*?\*/', Comment.Multiline),
            (r'\s+', Text),
            (r'}}', Keyword.Pseudo, '#pop'),
            inherit
        ]

    }


class NeverlangLexer(RegexLexer):
    """
    For the Neverlang language workbench.

    .. versionadded:: 0.1
    """

    name = 'Neverlang'
    aliases = ['neverlang']
    filenames = ['*.nl']

    flags = re.MULTILINE | re.DOTALL | re.UNICODE

    keywords = ('bundle', 'categories', 'concrete', 'decl', 'declare',
                'endemic', 'from', 'imports', 'in-buckets', 'init', 'is',
                'language', 'mapping', 'module', 'out-buckets', 'provides',
                'reference', 'rename', 'requires', 'rewrite', 'role', 'roles',
                'slice', 'slices', 'static', 'style', 'syntax', 'with')
    guards = ('type_any', 'type', 'when', 'exception')
    extensions = ('eval', '$suspend', 'resume')

    arrows = {  # dictionary to pretty print the arrows
        '<--': u"\u2190",
        '-->': u"\u2192",
        '=>': u"\u21d2"}

    def __init__(self, **option):
        self.sa_languages = {
            '<java>': NeverlangJavaLexer,
            '<template>': NeverlangTemplateLexer,
            '<scala>': NeverlangScalaLexer}
        self.sa_lang_display = [None, None, None]
        self.sa_lang_flag = -1
        RegexLexer.__init__(self, **option)

    def sa_callback(self, match):  # this match the full regex
        #print("=== token :- '{}' display :- {} flag :- {}".format('.{+', self.sa_lang_display, self.sa_lang_flag), file=sys.stderr)
        if self.sa_lang_flag < 2:
            self.sa_lang_flag = 2
            self.sa_lang_display[self.sa_lang_flag] = self.sa_lang_display[self.sa_lang_flag-1]
        #print("=== token :- '{}' display :- {} flag :- {}".format('.{+', self.sa_lang_display, self.sa_lang_flag), file=sys.stderr)
        #print(80*'-', file=sys.stderr)

        _other = self.sa_languages[self.sa_lang_display[self.sa_lang_flag]]()

        off = match.start(1)
        for i, t, v in _other.get_tokens_unprocessed(match.group(1)):
            yield off+i, t, v

        #print("=== token :- '{}' display :- {} flag :- {}".format('}.', self.sa_lang_display, self.sa_lang_flag), file=sys.stderr)
        self.sa_lang_display[self.sa_lang_flag] = None
        self.sa_lang_flag = self.sa_lang_flag - 1
        #print("=== token :- '{}' display :- {} flag :- {}".format('}.', self.sa_lang_display, self.sa_lang_flag), file=sys.stderr)
        #print(80*'-', file=sys.stderr)

        yield match.start(2), Punctuation, '}.'

    def module_callback(self, match):
        #print("*** token :- '{}' display :- {} flag :- {}".format(match.group(0), self.sa_lang_display, self.sa_lang_flag), file=sys.stderr)
        if self.sa_lang_flag < 0:
            self.sa_lang_flag = 0
            self.sa_lang_display[self.sa_lang_flag] = '<java>'
        #print("*** token :- '{}' display :- {} flag :- {}".format(match.group(0), self.sa_lang_display, self.sa_lang_flag), file=sys.stderr)
        #print(80*'-', file=sys.stderr)

        yield match.start(0), Punctuation, match.group(0)

    def enter_callback(self, match):
        #print("*** token :- '{}' display :- {} flag :- {}".format(match.group(0), self.sa_lang_display, self.sa_lang_flag), file=sys.stderr)
        if self.sa_lang_flag < 1:
            self.sa_lang_flag = 1
            self.sa_lang_display[self.sa_lang_flag] = self.sa_lang_display[self.sa_lang_flag-1]
        #print("*** token :- '{}' display :- {} flag :- {}".format(match.group(0), self.sa_lang_display, self.sa_lang_flag), file=sys.stderr)
        #print(80*'-', file=sys.stderr)

        yield match.start(0), Punctuation, match.group(0)

    def pop_callback(self, match):
        #print("*** token :- '{}' display :- {} flag :- {}".format(match.group(0), self.sa_lang_display, self.sa_lang_flag), file=sys.stderr)
        self.sa_lang_display[self.sa_lang_flag] = None
        self.sa_lang_flag = self.sa_lang_flag - 1
        #print("*** token :- '{}' display :- {} flag :- {}".format(match.group(0), self.sa_lang_display, self.sa_lang_flag), file=sys.stderr)
        #print(80*'-', file=sys.stderr)

        yield match.start(0), Punctuation, match.group(0)

    def get_tokens_unprocessed(self, text):  # redefined to do some magics
        for index, token, value in RegexLexer.get_tokens_unprocessed(self, text):
            if token is Operator and value in self.arrows.keys():  # This is to transform the arrows (<--. -->, and =>) in their pretty version
                yield index, Operator, self.arrows[value]
            elif token is Name.Decorator:  # this is to collect a change of lexer for the semantic actions.
                #print("### token :- '{}' display :- {} flag :- {}".format(value,self.sa_lang_display,self.sa_lang_flag), file=sys.stderr)
                self.sa_lang_flag += 1
                self.sa_lang_display[self.sa_lang_flag] = value
                #print("### token :- '{}' display :- {} flag :- {}".format(value,self.sa_lang_display,self.sa_lang_flag), file=sys.stderr)
                #print(80*'-', file=sys.stderr)
                yield index, token, value
            else:
                yield index, token, value

    # roba da evidenziare in qualche modo
    #   · parentesi: regola sintattica {} azione semantica .{}. valutazione pre-order di un nodo @{ }. nome ruolo () guardia (% %) priorità guardie [n], langauge annotation <>, template {{ }}
    #   · references: $0 ... $n, #0 ... #n, $label[] $$qualcosa endemic
    #   · attributi: .qualcosa
    #   · Lang annotation: <java>, <scala>, <template>
    # roba da trasformare
    #   · <-- in ←
    #   · => in ⇒ (usato nel mapping dei nodi)
    #   · --> in → (usato nel renaming)

    # note that, I chose to color:
    #   · language and bundle names as Name.Namespace
    #   · slice, endemic slice e module names as Name.Class
    #   · nonterminals as Name.Function

    parenthesis = ('{', '}', '\\.{', '}\\.', '@{', '(%', '%)', '\\(', '\\)', '[', ']', '<', '>')
    role_operators = ('<\\+', '<', ':')

    comments_or_spaces = '|'.join(['\s*//.*?\n\s*', '\s*/\*.*?\*/\s*', '\s+', '\s*'])
    anchors = '(@![\w:]*!@){0,1}'

    tokens = {
        'comments and spaces': [
            (r'//.*?\n', Comment.Single),
            (r'/\*.*?\*/', Comment.Multiline),
            (r'\s+', Text)
        ],
        'root': [
            # language or bundle
            (r'(language|bundle)(%s)([^\d\W][\w.-]*)' % comments_or_spaces, bygroups(Keyword, using(this), Name.Namespace), 'language-body'),
            # (r'roles', Keyword, 'roles-seq'),
            # (r'(slices|endemic slices)', Keyword, 'slices-seq'),
            # (r'rename', Keyword, 'rename-seq'),
            # slice
            (r'(slice)({0})([^\d\W][\w.-]*)({0})({{)'.format(comments_or_spaces), bygroups(Keyword, using(this), Name.Class, using(this), Punctuation), 'slice-body'),
            # endemic slice
            (r'(endemic)(\s+)(slice)({0})([^\d\W][\w.-]*)({0})({{)'.format(comments_or_spaces), bygroups(Keyword, Text, Keyword, using(this), Name.Class, using(this), Punctuation), 'endemic-body'),
            # module definition
            (r'((?:<\w+>)?)({0}?)(module)({0})([^\d\W][\w.-]*)'.format(comments_or_spaces), bygroups(Name.Decorator, using(this), Keyword, using(this), Name.Class), ('module-body', 'module-temp-state')),
            # keywords and other neverlang symbols to be highlighted when out of a complete neverlang unit
            (r'\b(%s)\b' % '|'.join(keywords), Keyword),
            (r'\b(%s)\b' % '|'.join(parenthesis), Punctuation),
            (r'(%s)' % '|'.join(arrows), Operator),  # a regime questo va tolto
            # comments and spaces
            include('comments and spaces'),
            # literals
            (r'(/[a-zA-Z0-9_\\|* \"()\[\]\'.:?]+?/)', String.Regex),
            (r'"(\\\\|\\"|[^"])*"', String),
            (r'[^\d\W][\w.]*?', Name),
            (r'.', Text)
        ],
        'language-body': [
            (r'roles', Keyword, 'roles-seq'),
            (r'(slices|endemic slices)', Keyword, 'slices-seq'),
            (r'rename', Keyword, 'rename-seq'),
            (r'(})', Punctuation, '#pop'),
            # comments and spaces
            include('comments and spaces')
        ],
        'module-temp-state': [
            (r'({)', module_callback, '#pop'),
            include('comments and spaces'),
        ],
        # modules body
        'module-body': [
            # reference syntax
            (r'(reference)({0})(syntax)({0})({{)'.format(comments_or_spaces), bygroups(Keyword, using(this), Keyword, using(this), Punctuation), 'reference-body'),
            (r'(reference)({0})(syntax)({0})(from)({0})([^\d\W][\w.-]*)'.format(comments_or_spaces), bygroups(Keyword, using(this), Keyword, using(this), Keyword, using(this), Name.Class)),
            # role definition
            (r'(role)({0})(\()({0})([^\d\W][\w.-]*)({0})(\))({0})((?:<\w+>)?)'.format(comments_or_spaces), bygroups(Keyword, using(this), Punctuation, using(this), Keyword.Pseudo, using(this), Punctuation, using(this), Name.Decorator), ('sa-definition', 'sa-temp-state')),
            # imports
            (r'(imports)({0})({{)'.format(comments_or_spaces), bygroups(Keyword, using(this), Punctuation), 'import-body'),
            # close and comments
            (r'(})', pop_callback, '#pop'),
            include('comments and spaces'),
        ],
        'import-body': [
            (r'([^\d\W][\w.-]*)', Text),
            (r'(;)', Punctuation),
            # close and comments
            (r'}', Punctuation, '#pop'),
            include('comments and spaces'),
        ],
        'sa-temp-state': [
            (r'({)', enter_callback, '#pop'),
            include('comments and spaces'),
        ],
        'sa-definition': [
            # semantic actions
            (r'(\d+|[\w\d+:_\[\]?«»<>{{}}-]+)({0})((?:<\w+>)?)({0})((?:@|\.){{)'.format(comments_or_spaces), bygroups(Name.Label, using(this), Name.Decorator, using(this), Punctuation), 'sa-code'),
            (r'(when|exception|type_any|type)({0})((?:\(\d+\))?)({0})(!?)({0})(\(%)(.+?)(%\))'.format(comments_or_spaces), bygroups(Keyword, using(this), Number, using(this), Keyword, using(this), Punctuation, using(NeverlangJavaLexer), Punctuation)),
            include('comments and spaces'),
            (r'}', pop_callback, '#pop')
        ],
        'sa-code': [
            (r'(.+?)(}\.)', sa_callback, '#pop'),
        ],
        # definitions for roles, slices and renaming in language/bundle.
        'roles-seq': [
            (r'(rename)', Keyword, ('#pop', 'rename-seq')),
            # (r'(endemic slices|slices)', Keyword, ('#pop', 'slices-seq')),
            # (r'(bundle)(()([^\d\W][\w.-]*)())', bygroups(Keyword, Punctuation, Keyword.Pseudo, Punctuation)),
            (r'(})', Punctuation, '#pop'),
            (r'({0})'.format('|'.join(role_operators)), Operator),
            (r'(syntax)', Keyword.Pseudo),
            (r'([^\d\W][\w.-]*)', Keyword.Pseudo),
            include('comments and spaces')
        ],
        'slices-seq': [
            # these are needed because slices sequences are null termined
            (r'(roles)', Keyword, ('#pop', 'roles-seq')),
            (r'(rename)', Keyword, ('#pop', 'rename-seq')),
            (r'(endemic slices|slices)', Keyword, ('#pop', 'slices-seq')),
            (r'(bundle)({0})(\()({0})([^\d\W][\w.-]*)({0})(\))'.format(comments_or_spaces), bygroups(Keyword.Pseudo, using(this), Punctuation, using(this), Name.Class, using(this), Punctuation)),
            (r'([^\d\W][\w.-]*)', Name.Class),
            (r'(})', Punctuation, '#pop'),  # if I get this I'm at the end of the language/bundle body
            include('comments and spaces')
        ],
        'rename-seq': [
            (r'({|;)', Punctuation),
            (r'(-->)', Operator),
            (r'([^\d\W][\w.-]*)', Name.Function),
            (r'}', Punctuation, '#pop'),
            include('comments and spaces')
        ],
        'endemic-body': [
            (r'(declare)({0})({{)'.format(comments_or_spaces), bygroups(Keyword.Declaration, using(this), Punctuation), 'var-declare'),
            (r'(tags)', Keyword.Declaration, 'tags-declaration'),
            (r'(})', Punctuation, '#pop'),
            include('comments and spaces')
        ],
        'tags-declaration': [
            (r'(:|,)(%s)([^\d\W][\w.-]*)' % comments_or_spaces, bygroups(Punctuation, using(this), Name.Tag)),
            (r'(;)', Punctuation, '#pop'),
            include('comments and spaces')
        ],
        'var-declare': [
            (r'(static)({0})([^\d\W][\w.-]*)({0})(:)({0})([^\d\W][\w.-]*)({0})(;)'.format(comments_or_spaces), bygroups(Keyword, using(this), Name.Variable, using(this), Punctuation, using(this), Name.Class, using(this), Punctuation)),
            (r'([^\d\W][\w.-]*)({0})(:)({0})([^\d\W][\w.-]*)({0})(;)'.format(comments_or_spaces), bygroups(Name.Variable, using(this), Punctuation, using(this), Name.Class, using(this), Punctuation)),
            (r'}', Punctuation, '#pop'),
            include('comments and spaces')
        ],
        'slice-body': [
            (r'(concrete)({0})(syntax)({0})(from)({0})([^\d\W][\w.-]*)'.format(comments_or_spaces), bygroups(Keyword, using(this), Keyword, using(this), Keyword, using(this), Name.Class)),
            (r'(module)({0})([^\d\W][\w.-]*)({0})(with)({0})(role)({0})([^\d\W][\w.-]*)({0})(mapping)({0})({{)'.format(comments_or_spaces), bygroups(Keyword, using(this), Name.Class, using(this), Keyword, using(this), Keyword, using(this), Keyword.Pseudo, using(this), Keyword, using(this), Punctuation), 'mapping-seq'),
            (r'(module)({0})([^\d\W][\w.-]*)({0})(with)({0})(role)({0})([^\d\W][\w.-]*)'.format(comments_or_spaces), bygroups(Keyword, using(this), Name.Class, using(this), Keyword, using(this), Keyword, using(this), Keyword.Pseudo)),
            (r'(})', Punctuation, '#pop'),
            include('comments and spaces')
        ],
        'mapping-seq': [
            (r'(\d+)({0})(=>)({0})(\d+)(,)'.format(comments_or_spaces), bygroups(Number.Integer, using(this), Operator, using(this), Number.Integer, Punctuation)),
            (r'(\d+)({0})(=>)({0})(\d+)'.format(comments_or_spaces), bygroups(Number.Integer, using(this), Operator, using(this), Number.Integer)),
            (r'(})', Punctuation, '#pop'),
            include('comments and spaces')
        ],
        'reference-body': [
            # provides/requires clauses
            (r'(provides|requires)({0})({{)'.format(comments_or_spaces), bygroups(Keyword.Declaration, using(this), Punctuation), 'pr-seq'),
            (r'((?:[\w\d+:_\[\]?«»<>{{}}-]+)?)({0})([^\d\W][\w.-]*)({0})(<--)'.format(comments_or_spaces), bygroups(Name.Label, using(this), Name.Function, using(this), Operator), 'rule-dx'),
            # categories clause
            (r'(categories)({0})(:)'.format(comments_or_spaces), bygroups(Keyword.Declaration, using(this), Punctuation), 'categories-body'),
            # in-/out-buckets clauses
            (r'(in-buckets|out-buckets)({0})(:)'.format(comments_or_spaces), bygroups(Keyword.Declaration, using(this), Punctuation), 'buckets-body'),
            (r'(})', Punctuation, '#pop'),
            include('comments and spaces')
        ],
        'categories-body': [
            (r'([^\d\W][\w.-]*)({0})(=)({0})({{)'.format(comments_or_spaces), bygroups(Keyword.Pseudo, using(this), Operator, using(this), Punctuation), 'category-body'),
            (r'(with)({0})(style)({0})("(\\\\|\\"|[^"])*")'.format(comments_or_spaces), bygroups(Keyword, using(this), Keyword, using(this), String)),
            # (r'(with)({0})(style)({0})("(\\\\|\\"|[^"])*")({0})(,)'.format(comments_or_spaces), bygroups(Keyword, using(this), Keyword, using(this), String, using(this), Punctuation)),
            # (r'(with)({0})(style)({0})("(\\\\|\\"|[^"])*")({0})(;)'.format(comments_or_spaces), bygroups(Keyword, using(this), Keyword, using(this), String, using(this), Punctuation), '#pop'),
            (r',', Punctuation),
            (r';', Punctuation, '#pop'),
            include('comments and spaces')
        ],
        'category-body': [
            (r'([^\d\W][\w.-]*)', Name.Attribute),                      # nonterminal
            (r'("(\\\\|\\"|[^"])*")', String),                          # terminal
            (r'(})', bygroups(Punctuation), '#pop'),
            # (r'(}})({0})(;)'.format(comments_or_spaces), bygroups(Punctuation, using(this), Punctuation), ('#pop', '#pop')),
            # (r'(}})({0})(,)'.format(comments_or_spaces), bygroups(Punctuation, using(this), Punctuation), '#pop'),
            (r',', Punctuation),
            include('comments and spaces')
        ],
        'buckets-body': [
            (r'(\#|\$)(\d+?)({0})(<--|-->)({0})({{)'.format(comments_or_spaces), bygroups(Keyword.Pseudo, Keyword.Pseudo, using(this), Operator, using(this), Punctuation), 'bucket-body'),
            # (r'(with)({0})(style)({0})("(\\\\|\\"|[^"])*")'.format(comments_or_spaces), bygroups(Keyword, using(this), Keyword, using(this), String)),
            (r'(,)', Punctuation),
            (r'(;)', Punctuation, '#pop'),
            include('comments and spaces')
        ],
        'bucket-body': [
            (r'([^\d\W][\w.-]*)', Name.Attribute),  # nonterminal
            (r'("(\\\\|\\"|[^"])*")', String),      # terminal
            (r'(})', Punctuation, '#pop'),
            (r',', Punctuation),
            include('comments and spaces')
        ],
        'rule-dx': [
            # (r'({0}[^\d\W][\w.-]*{0}[\w.-]*{0}[\w.-]*)'.format(anchors), bygroups(Name.Function)),  # nonterminal + label (li riconosce ma non funziona lo stesso la riga dopo è un errore)
            (r'([^\d\W][\w.-]*)', bygroups(Name.Function)),  # nonterminal
            (r'("(\\\\|\\"|[^"])*")', bygroups(String)),     # terminal
            # (r'(/[a-zA-Z0-9_\\|* \"()\[\]\'.:?+-]+?/)(\[|{)([a-zA-Z]+)(\]|})', bygroups(String.Regex, Punctuation, Name.Attribute, Punctuation)),    # terminal defined by regex + attribute
            # (r'(/[a-zA-Z0-9_\\|* \"()\[\]\'.:?+-]+?/)', String.Regex),    # terminal defined by regex
            (r';', Punctuation, '#pop'),
            include('comments and spaces')
        ],
        'pr-seq': [
            (r'([^\d\W][\w.-]*)', Name.Function),
            (r'(:|,)(%s)([^\d\W][\w.-]*)' % comments_or_spaces, bygroups(Punctuation, using(this), Name.Tag)),
            (r'(;)', Punctuation),
            (r'(})', Punctuation, '#pop'),
            include('comments and spaces')
        ]

    }