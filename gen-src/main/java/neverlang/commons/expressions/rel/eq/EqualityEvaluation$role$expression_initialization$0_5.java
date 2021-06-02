package neverlang.commons.expressions.rel.eq;
import dexter.lexter.QualifiedToken;

import neverlang.runtime.*;

import neverlang.runtime.dexter.ASTNode;

import neverlang.runtime.dexter.UndefinedAttributeException;

import java.util.function.Supplier;

import neverlang.commons.expressions.errors.*;

import neverlang.commons.errors.ErrorReport;


public class EqualityEvaluation$role$expression_initialization$0_5 implements PostorderSemanticAction, java.io.Serializable {

  private int priority = -2147483648;

  private boolean softGuard = false;

  @Override
  public boolean isSoftGuarded() { return softGuard; }

  @Override
  public int getPriority() { return priority; }

  @Override
  public void setPriority(int p) { priority = p; }

  @Override
  public java.lang.String getLabel() { return "equals"; }

  @Override
  public int getPosition() { return 0; }

  @Override
  public java.util.Map<java.lang.Integer, java.util.Set<java.lang.String>> getRequiredNtAttributes() {
    return java.util.Map.ofEntries(
      new java.util.AbstractMap.SimpleImmutableEntry<java.lang.Integer, java.util.Set<java.lang.String>>(1, java.util.Set.of( "type", "expr" ) ),
      new java.util.AbstractMap.SimpleImmutableEntry<java.lang.Integer, java.util.Set<java.lang.String>>(2, java.util.Set.of( "type", "expr" ) )
    );
  }

  @Override
  public java.util.Map<java.lang.Integer, java.util.Set<java.lang.String>> getProvidedNtAttributes() {
    return java.util.Map.ofEntries(
      new java.util.AbstractMap.SimpleImmutableEntry<java.lang.Integer, java.util.Set<java.lang.String>>(0, java.util.Set.of( "type", "expr" ) )
    );
  }

  @Override
  public boolean predicate(Context $ctx) {
    ASTNode $n = $ctx.node();
    try {return  $ctx.nt(1).getValue("type").equals(java.lang.Short.class) && $ctx.nt(2).getValue("type").equals(java.lang.Short.class) ;} catch (UndefinedAttributeException e) { return false; }
  }

  public void apply(Context $ctx) {
    ASTNode $n = $ctx.node();
    Supplier<java.lang.Short> leftExpr = $ctx.nt(1).getValue("expr");
    Supplier<java.lang.Short> rightExpr = $ctx.nt(2).getValue("expr");
    Supplier<java.lang.Boolean> expr = () -> leftExpr.get().shortValue() == rightExpr.get().shortValue();
    $ctx.nt(0).setValue("type",  java.lang.Boolean.class);
    $ctx.nt(0).setValue("expr",  expr);
    
  }
}