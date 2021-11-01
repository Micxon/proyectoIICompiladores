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
public class RepeatForRangeDo extends Command{
    public RepeatForRangeDo(RangeVarDecl rAST, Expression eAST, Command cAST, SourcePosition thePosition) {
        super(thePosition);
        R = rAST;
        E = eAST;
        C = cAST;
        
    }
    
    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitRepeatForRangeDo(this, o);
    }
    
    public RangeVarDecl R;
    public Expression E;
    public Command C;
    
}
