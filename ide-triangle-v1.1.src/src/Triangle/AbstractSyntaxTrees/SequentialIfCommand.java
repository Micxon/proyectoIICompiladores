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
public class SequentialIfCommand extends Command{
    public SequentialIfCommand(Command cAST1, Command cAST2, SourcePosition thePosition) {
        super(thePosition);
        C1 = cAST1;
        C2 = cAST2;
      }

      public Object visit(Visitor v, Object o) {
        return v.visitSequentialIfCommand(this, o);
      }

    public Command C1, C2;
}
