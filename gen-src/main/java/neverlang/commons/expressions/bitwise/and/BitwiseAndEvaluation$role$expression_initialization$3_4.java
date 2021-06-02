package neverlang.commons.expressions.bitwise.and;
import dexter.lexter.QualifiedToken;

import neverlang.runtime.*;

import neverlang.runtime.dexter.ASTNode;

import neverlang.runtime.dexter.UndefinedAttributeException;

import java.util.function.Supplier;

import neverlang.commons.expressions.errors.*;

import neverlang.commons.errors.ErrorReport;


public class BitwiseAndEvaluation$role$expression_initialization$3_4 implements PostorderSemanticAction, java.io.Serializable {

  private int priority = -2147483648;

  private boolean softGuard = false;

  @Override
  public boolean isSoftGuarded() { return softGuard; }

  @Override
  public int getPriority() { return priority; }

  @Override
  public void setPriority(int p) { priority = p; }

  @Override
  public java.lang.String getLabel() { return "and"; }

  @Override
  public int getPosition() { return 3; }

  @Override
  public java.util.Map<java.lang.Integer, java.util.Set<java.lang.String>> getRequiredNtAttributes() {
    return java.util.Map.ofEntries(
      new java.util.AbstractMap.SimpleImmutableEntry<java.lang.Integer, java.util.Set<java.lang.String>>(4, java.util.Set.of( "type" ) ),
      new java.util.AbstractMap.SimpleImmutableEntry<java.lang.Integer, java.util.Set<java.lang.String>>(5, java.util.Set.of( "type" ) )
    );
  }

  @Override
  public java.util.Map<java.lang.Integer, java.util.Set<java.lang.String>> getProvidedNtAttributes() {
    return java.util.Map.ofEntries(
      new java.util.AbstractMap.SimpleImmutableEntry<java.lang.Integer, java.util.Set<java.lang.String>>(3, java.util.Set.of( "type", "expr" ) )
    );
  }

  @Override
  public boolean predicate(Context $ctx) {
    ASTNode $n = $ctx.node();
    return true;
  }

  public void apply(Context $ctx) {
    ASTNode $n = $ctx.node();
    BadOperandTypesException error = new BadOperandTypesException($n.tchild(0).token.row, $n.tchild(0).token.col, "&", $ctx.nt(4).getValue("type"), $ctx.nt(5).getValue("type"));
    $ctx.root().<ErrorReport>getValue("$ErrorReport").add(error);
    $ctx.nt(3).setValue("type",  UndefinedExpressionType.class);
    $ctx.nt(3).setValue("expr",  null);
    
  }
}