package neverlang.commons.expressions.test;
import dexter.lexter.QualifiedToken;

import neverlang.runtime.*;

import neverlang.runtime.dexter.ASTNode;

import neverlang.runtime.dexter.UndefinedAttributeException;

import neverlang.commons.unit.CompilationUnitDescriptor;

import java.util.function.Supplier;

import neverlang.commons.errors.ErrorReport;


public class ExpressionUnit$role$translate$0 implements PostorderSemanticAction, java.io.Serializable {

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
  public int getPosition() { return 0; }

  @Override
  public java.util.Map<java.lang.Integer, java.util.Set<java.lang.String>> getRequiredNtAttributes() {
    return java.util.Map.ofEntries(
      new java.util.AbstractMap.SimpleImmutableEntry<java.lang.Integer, java.util.Set<java.lang.String>>(0, java.util.Set.of( "skipEvaluation" ) ),
      new java.util.AbstractMap.SimpleImmutableEntry<java.lang.Integer, java.util.Set<java.lang.String>>(1, java.util.Set.of( "Text" ) )
    );
  }

  @Override
  public java.util.Map<java.lang.Integer, java.util.Set<java.lang.String>> getProvidedNtAttributes() {
    return java.util.Map.ofEntries(
      new java.util.AbstractMap.SimpleImmutableEntry<java.lang.Integer, java.util.Set<java.lang.String>>(0, java.util.Set.of( "unit" ) )
    );
  }

  @Override
  public boolean predicate(Context $ctx) {
    ASTNode $n = $ctx.node();
    return true;
  }

  public void apply(Context $ctx) {
    ASTNode $n = $ctx.node();
    if($ctx.nt(0).getValue("skipEvaluation")) {                $ctx.nt(0).setValue("unit",  null);
    return;
    }            String src = $ctx.nt(1).getValue("Text");
    src = String.format("public class OutputExpression { public static void main(String[] args) { System.out.println(%s); } }", src);
    $ctx.nt(0).setValue("unit",  new CompilationUnitDescriptor(src, "./OutputExpression.java"));
    
  }
}