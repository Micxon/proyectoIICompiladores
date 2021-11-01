/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author Carlo
 */
public class RecursiveProcFuncs extends Declaration{
    public RecursiveProcFuncs(Declaration dAST, SourcePosition thePosition){
        super(thePosition);
        D1 = dAST;
    }
    
    public Object visit(Visitor v, Object o){
        return v.visitRecursiveProcFuncs(this, o);
    }
    
    public Declaration D1;
}
