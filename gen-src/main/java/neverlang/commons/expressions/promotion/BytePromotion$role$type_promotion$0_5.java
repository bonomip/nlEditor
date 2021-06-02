package neverlang.commons.expressions.promotion;
import dexter.lexter.QualifiedToken;

import neverlang.runtime.*;

import neverlang.runtime.dexter.ASTNode;

import neverlang.runtime.dexter.UndefinedAttributeException;

import java.util.function.Supplier;


public class BytePromotion$role$type_promotion$0_5 implements PostorderSemanticAction, java.io.Serializable {

  private int priority = -2147483648;

  private boolean softGuard = false;

  @Override
  public boolean isSoftGuarded() { return softGuard; }

  @Override
  public int getPriority() { return priority; }

  @Override
  public void setPriority(int p) { priority = p; }

  @Override
  public java.lang.String getLabel() { return "operation"; }

  @Override
  public int getPosition() { return 0; }

  @Override
  public java.util.Map<java.lang.Integer, java.util.Set<java.lang.String>> getRequiredNtAttributes() {
    return java.util.Map.ofEntries(
      new java.util.AbstractMap.SimpleImmutableEntry<java.lang.Integer, java.util.Set<java.lang.String>>(1, java.util.Set.of( "type", "expr" ) ),
      new java.util.AbstractMap.SimpleImmutableEntry<java.lang.Integer, java.util.Set<java.lang.String>>(2, java.util.Set.of( "type" ) )
    );
  }

  @Override
  public java.util.Map<java.lang.Integer, java.util.Set<java.lang.String>> getProvidedNtAttributes() {
    return java.util.Map.ofEntries(
      new java.util.AbstractMap.SimpleImmutableEntry<java.lang.Integer, java.util.Set<java.lang.String>>(1, java.util.Set.of( "type" ) ),
      new java.util.AbstractMap.SimpleImmutableEntry<java.lang.Integer, java.util.Set<java.lang.String>>(2, java.util.Set.of( "expr" ) )
    );
  }

  @Override
  public boolean predicate(Context $ctx) {
    ASTNode $n = $ctx.node();
    try {return  $ctx.nt(1).getValue("type").equals(java.lang.Byte.class) && $ctx.nt(2).getValue("type").equals(java.lang.Long.class) ;} catch (UndefinedAttributeException e) { return false; }
  }

  public void apply(Context $ctx) {
    ASTNode $n = $ctx.node();
    Supplier<java.lang.Byte> oldExpr = $ctx.nt(1).getValue("expr");
    Supplier<java.lang.Long> newExpr = () -> new java.lang.Long(oldExpr.get().byteValue());
    $ctx.nt(1).setValue("type",  java.lang.Long.class);
    $ctx.nt(2).setValue("expr",  newExpr);
    
  }
}