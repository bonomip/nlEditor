import dexter.lexter.QualifiedToken;

import neverlang.runtime.*;

import neverlang.runtime.dexter.ASTNode;

import neverlang.runtime.dexter.UndefinedAttributeException;


public class Expr$role$eval$2 implements PostorderSemanticAction, java.io.Serializable {

  private int priority = -2147483648;

  private boolean softGuard = false;

  @Override
  public boolean isSoftGuarded() { return softGuard; }

  @Override
  public int getPriority() { return priority; }

  @Override
  public void setPriority(int p) { priority = p; }

  @Override
  public java.lang.String getLabel() { return ""; }

  @Override
  public int getPosition() { return 2; }

  @Override
  public java.util.Map<java.lang.Integer, java.util.Set<java.lang.String>> getRequiredNtAttributes() {
    return java.util.Map.ofEntries(
      new java.util.AbstractMap.SimpleImmutableEntry<java.lang.Integer, java.util.Set<java.lang.String>>(3, java.util.Set.of( "value" ) )
    );
  }

  @Override
  public java.util.Map<java.lang.Integer, java.util.Set<java.lang.String>> getProvidedNtAttributes() {
    return java.util.Map.ofEntries(
      new java.util.AbstractMap.SimpleImmutableEntry<java.lang.Integer, java.util.Set<java.lang.String>>(2, java.util.Set.of( "value" ) )
    );
  }

  @Override
  public boolean predicate(Context $ctx) {
    ASTNode $n = $ctx.node();
    return true;
  }

  public void apply(Context $ctx) {
    ASTNode $n = $ctx.node();
    $ctx.nt(2).setValue("value",  (Integer) $ctx.nt(3).getValue("value"));
    
  }
}