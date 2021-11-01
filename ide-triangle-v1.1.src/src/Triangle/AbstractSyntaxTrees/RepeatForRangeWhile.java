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
public class RepeatForRangeWhile extends Command{
    public RepeatForRangeWhile(RangeVarDecl rAST, Expression eAST1, Command cAST, Expression eAST2, SourcePosition thePosition) {
        super(thePosition);
        R = rAST;
        E1 = eAST1;
        E2 = eAST2;
        C = cAST;
    }
    
    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitRepeatForRangeWhile(this, o);
    }
    
    public RangeVarDecl R;
    public Expression E1;
    public Expression E2;
    public Command C;
}
