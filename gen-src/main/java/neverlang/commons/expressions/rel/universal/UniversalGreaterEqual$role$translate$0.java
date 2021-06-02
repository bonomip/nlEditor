package neverlang.commons.expressions.rel.universal;
import dexter.lexter.QualifiedToken;

import neverlang.runtime.*;

import neverlang.runtime.dexter.ASTNode;

import neverlang.runtime.dexter.UndefinedAttributeException;

import java.util.function.Supplier;

import neverlang.commons.expressions.errors.*;

import neverlang.commons.errors.ErrorReport;


public class UniversalGreaterEqual$role$translate$0 implements PostorderSemanticAction, java.io.Serializable {

  private int priority = -2147483648;

  private boolean softGuard = false;

  @Override
  public boolean isSoftGuarded() { return softGuard; }

  @Override
  public int getPriority() { return priority; }

  @Override
  public void setPriority(int p) { priority = p; }

  @Override
  public java.lang.String getLabel() { return "greater"; }

  @Override
  public int getPosition() { return 0; }

  @Override
  public java.util.Map<java.lang.Integer, java.util.Set<java.lang.String>> getRequiredNtAttributes() {
    return java.util.Map.ofEntries(
      new java.util.AbstractMap.SimpleImmutableEntry<java.lang.Integer, java.util.Set<java.lang.String>>(1, java.util.Set.of( "Text" ) ),
      new java.util.AbstractMap.SimpleImmutableEntry<java.lang.Integer, java.util.Set<java.lang.String>>(2, java.util.Set.of( "Text" ) )
    );
  }

  @Override
  public java.util.Map<java.lang.Integer, java.util.Set<java.lang.String>> getProvidedNtAttributes() {
    return java.util.Map.ofEntries(
      new java.util.AbstractMap.SimpleImmutableEntry<java.lang.Integer, java.util.Set<java.lang.String>>(0, java.util.Set.of( "Text" ) )
    );
  }

  @Override
  public boolean predicate(Context $ctx) {
    ASTNode $n = $ctx.node();
    return true;
  }

  public void apply(Context $ctx) {
    ASTNode $n = $ctx.node();
$ctx.node().setValue("Text",
"Boolean.valueOf( (" + (     $ctx.nt(1).getValue("Text") ) + ").compareTo(" + (     $ctx.nt(2).getValue("Text") ) + ") >= 0 )");
  }
}