package neverlang.commons.expressions.test;
import dexter.lexter.QualifiedToken;

import neverlang.runtime.*;

import neverlang.runtime.dexter.ASTNode;

import neverlang.runtime.dexter.UndefinedAttributeException;

import neverlang.commons.unit.CompilationUnitDescriptor;

import java.util.function.Supplier;

import neverlang.commons.errors.ErrorReport;


public class ExpressionUnit$role$expression_initialization$0 implements PostorderSemanticAction, java.io.Serializable {

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
      
    );
  }

  @Override
  public java.util.Map<java.lang.Integer, java.util.Set<java.lang.String>> getProvidedNtAttributes() {
    return java.util.Map.ofEntries(
      new java.util.AbstractMap.SimpleImmutableEntry<java.lang.Integer, java.util.Set<java.lang.String>>(0, java.util.Set.of( "skipEvaluation" ) )
    );
  }

  @Override
  public boolean predicate(Context $ctx) {
    ASTNode $n = $ctx.node();
    return true;
  }

  public void apply(Context $ctx) {
    ASTNode $n = $ctx.node();
    if($ctx.root().<ErrorReport>getValue("$ErrorReport").failed()) {                System.err.println($ctx.root().<ErrorReport>getValue("$ErrorReport"));
    $ctx.nt(0).setValue("skipEvaluation",  true);
    } else {                $ctx.nt(0).setValue("skipEvaluation",  false);
    }            $ctx.root().<ErrorReport>getValue("$ErrorReport").removeAll($ctx.root().<ErrorReport>getValue("$ErrorReport"));
    
  }
}