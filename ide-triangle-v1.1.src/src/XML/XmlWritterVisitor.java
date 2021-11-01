/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import Triangle.AbstractSyntaxTrees.AnyTypeDenoter;
import Triangle.AbstractSyntaxTrees.ArrayExpression;
import Triangle.AbstractSyntaxTrees.ArrayTypeDenoter;
import Triangle.AbstractSyntaxTrees.AssignCommand;
import Triangle.AbstractSyntaxTrees.BinaryExpression;
import Triangle.AbstractSyntaxTrees.BinaryOperatorDeclaration;
import Triangle.AbstractSyntaxTrees.BoolTypeDenoter;
import Triangle.AbstractSyntaxTrees.CallCommand;
import Triangle.AbstractSyntaxTrees.CallExpression;
import Triangle.AbstractSyntaxTrees.CharTypeDenoter;
import Triangle.AbstractSyntaxTrees.CharacterExpression;
import Triangle.AbstractSyntaxTrees.CharacterLiteral;
import Triangle.AbstractSyntaxTrees.CompoundSingleDeclaration;
import Triangle.AbstractSyntaxTrees.ConstActualParameter;
import Triangle.AbstractSyntaxTrees.ConstDeclaration;
import Triangle.AbstractSyntaxTrees.ConstFormalParameter;
import Triangle.AbstractSyntaxTrees.DotVname;
import Triangle.AbstractSyntaxTrees.EmptyActualParameterSequence;
import Triangle.AbstractSyntaxTrees.EmptyCommand;
import Triangle.AbstractSyntaxTrees.EmptyExpression;
import Triangle.AbstractSyntaxTrees.EmptyFormalParameterSequence;
import Triangle.AbstractSyntaxTrees.ErrorTypeDenoter;
import Triangle.AbstractSyntaxTrees.FuncActualParameter;
import Triangle.AbstractSyntaxTrees.FuncDeclaration;
import Triangle.AbstractSyntaxTrees.FuncFormalParameter;
import Triangle.AbstractSyntaxTrees.Identifier;
import Triangle.AbstractSyntaxTrees.IfCommand;
import Triangle.AbstractSyntaxTrees.IfExpression;
import Triangle.AbstractSyntaxTrees.InVarDecl;
import Triangle.AbstractSyntaxTrees.IntTypeDenoter;
import Triangle.AbstractSyntaxTrees.IntegerExpression;
import Triangle.AbstractSyntaxTrees.IntegerLiteral;
import Triangle.AbstractSyntaxTrees.LetCommand;
import Triangle.AbstractSyntaxTrees.LetExpression;
import Triangle.AbstractSyntaxTrees.LocalDeclaration;
import Triangle.AbstractSyntaxTrees.MultipleActualParameterSequence;
import Triangle.AbstractSyntaxTrees.MultipleArrayAggregate;
import Triangle.AbstractSyntaxTrees.MultipleFieldTypeDenoter;
import Triangle.AbstractSyntaxTrees.MultipleFormalParameterSequence;
import Triangle.AbstractSyntaxTrees.MultipleRecordAggregate;
import Triangle.AbstractSyntaxTrees.Operator;
import Triangle.AbstractSyntaxTrees.PartialIfCommand;
import Triangle.AbstractSyntaxTrees.ProcActualParameter;
import Triangle.AbstractSyntaxTrees.ProcDeclaration;
import Triangle.AbstractSyntaxTrees.ProcFormalParameter;
import Triangle.AbstractSyntaxTrees.Program;
import Triangle.AbstractSyntaxTrees.RangeVarDecl;
import Triangle.AbstractSyntaxTrees.RecordExpression;
import Triangle.AbstractSyntaxTrees.RecordTypeDenoter;
import Triangle.AbstractSyntaxTrees.RecursiveProcFuncs;
import Triangle.AbstractSyntaxTrees.RepeatDoUntilCommand;
import Triangle.AbstractSyntaxTrees.RepeatDoWhileCommand;
import Triangle.AbstractSyntaxTrees.RepeatForIn;
import Triangle.AbstractSyntaxTrees.RepeatForRangeDo;
import Triangle.AbstractSyntaxTrees.RepeatForRangeUntil;
import Triangle.AbstractSyntaxTrees.RepeatForRangeWhile;
import Triangle.AbstractSyntaxTrees.RepeatUntilDoCommand;
import Triangle.AbstractSyntaxTrees.RepeatWhileDoCommand;
import Triangle.AbstractSyntaxTrees.SequentialCommand;
import Triangle.AbstractSyntaxTrees.SequentialDeclaration;
import Triangle.AbstractSyntaxTrees.SequentialIfCommand;
import Triangle.AbstractSyntaxTrees.SequentialProcFunc;
import Triangle.AbstractSyntaxTrees.SimpleTypeDenoter;
import Triangle.AbstractSyntaxTrees.SimpleVname;
import Triangle.AbstractSyntaxTrees.SingleActualParameterSequence;
import Triangle.AbstractSyntaxTrees.SingleArrayAggregate;
import Triangle.AbstractSyntaxTrees.SingleFieldTypeDenoter;
import Triangle.AbstractSyntaxTrees.SingleFormalParameterSequence;
import Triangle.AbstractSyntaxTrees.SingleRecordAggregate;
import Triangle.AbstractSyntaxTrees.SubscriptVname;
import Triangle.AbstractSyntaxTrees.TypeDeclaration;
import Triangle.AbstractSyntaxTrees.UnaryExpression;
import Triangle.AbstractSyntaxTrees.UnaryOperatorDeclaration;
import Triangle.AbstractSyntaxTrees.VarActualParameter;
import Triangle.AbstractSyntaxTrees.VarDeclaration;
import Triangle.AbstractSyntaxTrees.VarFormalParameter;
import Triangle.AbstractSyntaxTrees.VarInitDeclaration;
import Triangle.AbstractSyntaxTrees.Visitor;
import Triangle.AbstractSyntaxTrees.VnameExpression;
import Triangle.AbstractSyntaxTrees.WhileCommand;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author cato1
 */
//Clase base para los vistitor generando la estructura deseado segun cada ast, se va escribiendo en el archivo que se le envia
public class XmlWritterVisitor implements Visitor{
    
    private FileWriter fileWriter;

    XmlWritterVisitor(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }
    private void writeLineXml(String line) {
        try {
            fileWriter.write(line);
            fileWriter.write('\n');
        } catch (IOException e) {
            System.err.println("Error al escribit en el archivo");
            e.printStackTrace();
        }
    }
    
    private String transformOperator(String operator) {
        if (operator.compareTo("<") == 0)
            return "&lt;";
        else if (operator.compareTo("<=") == 0)
            return "&lt;=";
        else
            return operator;
    }

    @Override
    public Object visitAssignCommand(AssignCommand ast, Object o) {
        writeLineXml("<AssignCommand>");
        ast.V.visit(this, null);
        ast.E.visit(this, null);
        writeLineXml("</AssignCommand>");
        return null;
    }

    @Override
    public Object visitCallCommand(CallCommand ast, Object o) {
        writeLineXml("<CallCommand>");
        ast.I.visit(this, null);
        ast.APS.visit(this, null);
        writeLineXml("</CallCommand>");
        return null;
    }

    @Override
    public Object visitEmptyCommand(EmptyCommand ast, Object o) {
        writeLineXml("<EmptyCommand/>");
        return null;
    }

    @Override
    public Object visitIfCommand(IfCommand ast, Object o) {
        writeLineXml("<IfCommand>");
        ast.E.visit(this, null);
        ast.C1.visit(this, null);
        ast.C2.visit(this, null);
        writeLineXml("</IfCommand>");
        return null;    }

    @Override
    public Object visitLetCommand(LetCommand ast, Object o) {
        writeLineXml("<LetCommand>");
        ast.D.visit(this, null);
        ast.C.visit(this, null);
        writeLineXml("</LetCommand>");
        return null;
    }

    @Override
    public Object visitSequentialCommand(SequentialCommand ast, Object o) {
        writeLineXml("<SequentialCommand>");
        ast.C1.visit(this, null);
        ast.C2.visit(this, null);
        writeLineXml("</SequentialCommand>");
        return null;
    }

    @Override
    public Object visitWhileCommand(WhileCommand ast, Object o) {
        writeLineXml("<WhileCommand>");
        ast.E.visit(this, null);
        ast.C.visit(this, null);
        writeLineXml("</WhileCommand>");
        return null;
    }

    public Object visitRepeatDoUntilCommand(RepeatDoUntilCommand ast, Object obj) { //Metodo nuevo
      writeLineXml("<RepeatDoUntilCommand>");
      ast.E.visit(this, null);
      ast.C.visit(this, null);
      writeLineXml("</RepeatDoUntilCommand>");
      
      return(null);
  }
  
  public Object visitRepeatDoWhileCommand(RepeatDoWhileCommand ast, Object obj){ //Metodo nuevo
      writeLineXml("<RepeatDoWhileCommand>");
      ast.E.visit(this, null);
      ast.C.visit(this, null);
      writeLineXml("</RepeatDoWhileCommand>");
      
      return(null);
  }
  
  public Object visitRepeatUntilDoCommand(RepeatUntilDoCommand ast, Object obj){ //Metodo nuevo
      writeLineXml("<RepeatUntilDoCommand>");
      ast.E.visit(this, null);
      ast.C.visit(this, null);
      writeLineXml("</RepeatUntilDoCommand>");
      
      return(null);
  }
  
  public Object visitRepeatWhileDoCommand(RepeatWhileDoCommand ast, Object obj){ //Metodo nuevo
      writeLineXml("<RepeatWhileDoCommand>");
      ast.E.visit(this, null);
      ast.C.visit(this, null);
      writeLineXml("</RepeatWhileDoCommand>");
      
      return(null);
  }
  
  public Object visitRepeatForRangeDo(RepeatForRangeDo ast, Object obj){ //Metodo nuevo
      writeLineXml("<RepeatForRangeDo>");
      ast.R.visit(this, null);
      ast.E.visit(this, null);
      ast.C.visit(this, null);
      writeLineXml("</RepeatForRangeDo>");
      
      return(null);
  }
  
  public Object visitRepeatForRangeWhile(RepeatForRangeWhile ast, Object obj){
      writeLineXml("<RepeatForRangeWhile>");
      ast.R.visit(this, null);
      ast.E1.visit(this, null);
      ast.E2.visit(this, null);
      ast.C.visit(this, null);
      writeLineXml("</RepeatForRangeWhile>");
      
      return(null);
  }
  
  public Object visitRepeatForRangeUntil(RepeatForRangeUntil ast, Object obj){
      writeLineXml("<RepeatForRangeUntil>");
      ast.R.visit(this, null);
      ast.E1.visit(this, null);
      ast.E2.visit(this, null);
      ast.C.visit(this, null);
      writeLineXml("</RepeatForRangeUntil>");
      
      return(null);
  }
  
  public Object visitRepeatForIn(RepeatForIn ast, Object obj){
      writeLineXml("<RepeatForIn>");
      ast.R.visit(this, null);
      ast.C.visit(this, null);
      writeLineXml("</RepeatForIn>");
      return(null);
  }

  public Object visitPartialIfCommand(PartialIfCommand ast, Object o) {
      writeLineXml("<PartialIfCommand>");
      ast.E.visit(this, null);
      ast.C.visit(this, null);
      writeLineXml("</PartialIfCommand>");
      
      return(null);
  }

  public Object visitSequentialIfCommand(SequentialIfCommand ast, Object o) {
      writeLineXml("<SequentialIfCommand>");
      ast.C1.visit(this, null);
      ast.C2.visit(this, null);
      writeLineXml("</SequentialIfCommand>");
      return(null);
  }

    @Override
    public Object visitArrayExpression(ArrayExpression ast, Object o) {
        writeLineXml("<ArrayExpression>");
        ast.AA.visit(this, null);
        writeLineXml("</ArrayExpression>");
        return null;
    }

    @Override
    public Object visitBinaryExpression(BinaryExpression ast, Object o) {
        writeLineXml("<BinaryExpression>");
        ast.E1.visit(this, null);
        ast.O.visit(this, null);
        ast.E2.visit(this, null);
        writeLineXml("</BinaryExpression>");
        return null;
    }

    @Override
    public Object visitCallExpression(CallExpression ast, Object o) {
        writeLineXml("<CallExpression>");
        ast.I.visit(this, null);
        ast.APS.visit(this, null);
        writeLineXml("</CallExpression>");
        return null;
    }

    @Override
    public Object visitCharacterExpression(CharacterExpression ast, Object o) {
        writeLineXml("<CharacterExpression>");
        ast.CL.visit(this, null);
        writeLineXml("</CharacterExpression>");
        return null;
    }

    @Override
    public Object visitEmptyExpression(EmptyExpression ast, Object o) {
        writeLineXml("<EmptyExpression/>");
        return null;
    }

    @Override
    public Object visitIfExpression(IfExpression ast, Object o) {
        writeLineXml("<IfExpression>");
        ast.E1.visit(this, null);
        ast.E2.visit(this, null);
        ast.E3.visit(this, null);
        writeLineXml("</IfExpression>");
        return null;
    }

    @Override
    public Object visitIntegerExpression(IntegerExpression ast, Object o) {
        writeLineXml("<IntegerExpression>");
        ast.IL.visit(this, null);
        writeLineXml("</IntegerExpression>");
        return null;
    }

    @Override
    public Object visitLetExpression(LetExpression ast, Object o) {
        writeLineXml("<LetExpression>");
        ast.D.visit(this, null);
        ast.E.visit(this, null);
        writeLineXml("</LetExpression>");
        return null;
    }

    @Override
    public Object visitRecordExpression(RecordExpression ast, Object o) {
        writeLineXml("<RecordExpression>");
        ast.RA.visit(this, null);
        writeLineXml("</RecordExpression>");
        return null;
    }

    @Override
    public Object visitUnaryExpression(UnaryExpression ast, Object o) {
        writeLineXml("<UnaryExpression>");
        ast.O.visit(this, null);
        ast.E.visit(this, null);
        writeLineXml("</UnaryExpression>");
        return null;
    }

    @Override
    public Object visitVnameExpression(VnameExpression ast, Object o) {
        writeLineXml("<VnameExpression>");
        ast.V.visit(this, null);
        writeLineXml("</VnameExpression>");
        return null;
    }

    @Override
    public Object visitBinaryOperatorDeclaration(BinaryOperatorDeclaration ast, Object o) {
        writeLineXml("<BinaryOperatorDeclaration>");
        ast.O.visit(this, null);
        ast.ARG1.visit(this, null);
        ast.ARG2.visit(this, null);
        ast.RES.visit(this, null);
        writeLineXml("</BinaryOperatorDeclaration>");
        return null;
    }

    @Override
    public Object visitConstDeclaration(ConstDeclaration ast, Object o) {
        writeLineXml("<ConstDeclaration>");
        ast.I.visit(this, null);
        ast.E.visit(this, null);
        writeLineXml("</ConstDeclaration>");
        return null;
    }

    @Override
    public Object visitFuncDeclaration(FuncDeclaration ast, Object o) {
        writeLineXml("<FuncDeclaration>");
        ast.I.visit(this, null);
        ast.FPS.visit(this, null);
        ast.T.visit(this, null);
        ast.E.visit(this, null);
        writeLineXml("</FuncDeclaration>");
        return null;
    }

    @Override
    public Object visitProcDeclaration(ProcDeclaration ast, Object o) {
        writeLineXml("<ProcDeclaration>");
        ast.I.visit(this, null);
        ast.FPS.visit(this, null);
        ast.C.visit(this, null);
        writeLineXml("</ProcDeclaration>");
        return null;
    }

    @Override
    public Object visitSequentialDeclaration(SequentialDeclaration ast, Object o) {
        writeLineXml("<SequentialDeclaration>");
        ast.D1.visit(this, null);
        ast.D2.visit(this, null);
        writeLineXml("</SequentialDeclaration>");
        return null;
    }

    @Override
    public Object visitTypeDeclaration(TypeDeclaration ast, Object o) {
        writeLineXml("<TypeDeclaration>");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
        writeLineXml("</TypeDeclaration>");
        return null;
    }

    @Override
    public Object visitUnaryOperatorDeclaration(UnaryOperatorDeclaration ast, Object o) {
        writeLineXml("<UnaryOperatorDeclaration>");
        ast.O.visit(this, null);
        ast.ARG.visit(this, null);
        ast.RES.visit(this, null);
        writeLineXml("</UnaryOperatorDeclaration>");
        return null;
    }

    @Override
    public Object visitVarDeclaration(VarDeclaration ast, Object o) {
        writeLineXml("<VarDeclaration>");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
        writeLineXml("</VarDeclaration>");
        return null;
    }
    
    @Override
    public Object visitVarInitDeclaration(VarInitDeclaration ast, Object o) {
      writeLineXml("<VarInitDeclaration>");
      ast.I.visit(this, null);
      ast.E.visit(this, null);
      writeLineXml("</VarInitDeclaration>");
      return(null);
  }
    
    @Override
    public Object visitRangeVarDecl(RangeVarDecl ast, Object o){
      writeLineXml("<RangeVarDecl>");
      ast.I.visit(this, null);
      ast.E.visit(this, null);
      writeLineXml("</RangeVarDecl>");
      return(null);
  }

  @Override  
  public Object visitInVarDecl(InVarDecl ast, Object o){
      writeLineXml("<InVarDecl>");
      ast.I.visit(this, null);
      ast.E.visit(this, null);
      writeLineXml("</InVarDecl>");
      return(null);
  }

  @Override
  public Object visitRecursiveProcFuncs(RecursiveProcFuncs ast, Object o) {
      writeLineXml("<RecursiveProcFuncs>");
      ast.D1.visit(this, null);
      writeLineXml("</RecursiveProcFuncs>");
      return(null);
  }

  @Override
  public Object visitLocalDeclaration(LocalDeclaration ast, Object o) {
      writeLineXml("<LocalDeclaration>");
      ast.D1.visit(this, null);
      ast.D2.visit(this, null);
      writeLineXml("</LocalDeclaration>");
      return(null);
  }

  @Override
  public Object visitCompoundSingleDeclaration(CompoundSingleDeclaration ast, Object o) {
      writeLineXml("<CompoundSingleDeclaration>");
      ast.D.visit(this, null);
      writeLineXml("</CompoundSingleDeclaration>");
      return(null);
  }

  @Override
  public Object visitSequentialProcFunc(SequentialProcFunc ast, Object o) {
      writeLineXml("<SequentialProcFunc>");
      ast.D1.visit(this, null);
      ast.D2.visit(this, null);
      writeLineXml("</SequentialProcFunc>");
      return(null);
  }

    @Override
    public Object visitMultipleArrayAggregate(MultipleArrayAggregate ast, Object o) {
        writeLineXml("<MultipleArrayAggregate>");
        ast.E.visit(this, null);
        ast.AA.visit(this, null);
        writeLineXml("</MultipleArrayAggregate>");
        return null;    }

    @Override
    public Object visitSingleArrayAggregate(SingleArrayAggregate ast, Object o) {
        writeLineXml("<SingleArrayAggregate>");
        ast.E.visit(this, null);
        writeLineXml("</SingleArrayAggregate>");
        return null;    }

    @Override
    public Object visitMultipleRecordAggregate(MultipleRecordAggregate ast, Object o) {
        writeLineXml("<MultipleRecordAggregate>");
        ast.I.visit(this, null);
        ast.E.visit(this, null);
        ast.RA.visit(this, null);
        writeLineXml("</MultipleRecordAggregate>");
        return null;    }

    @Override
    public Object visitSingleRecordAggregate(SingleRecordAggregate ast, Object o) {
        writeLineXml("<SingleRecordAggregate>");
        ast.I.visit(this, null);
        ast.E.visit(this, null);
        writeLineXml("</SingleRecordAggregate>");
        return null;    }

    @Override
    public Object visitConstFormalParameter(ConstFormalParameter ast, Object o) {
        writeLineXml("<ConstFormalParameter>");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
        writeLineXml("</ConstFormalParameter>");
        return null;    }

    @Override
    public Object visitFuncFormalParameter(FuncFormalParameter ast, Object o) {
        writeLineXml("<FuncFormalParameter>");
        ast.I.visit(this, null);
        ast.FPS.visit(this, null);
        ast.T.visit(this, null);
        writeLineXml("<FuncFormalParameter>");
        return null;    }

    @Override
    public Object visitProcFormalParameter(ProcFormalParameter ast, Object o) {
        writeLineXml("<ProcFormalParameter>");
        ast.I.visit(this, null);
        ast.FPS.visit(this, null);
        writeLineXml("</ProcFormalParameter>");
        return null;    }

    @Override
    public Object visitVarFormalParameter(VarFormalParameter ast, Object o) {
        writeLineXml("<VarFormalParameter>");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
        writeLineXml("</VarFormalParameter>");
        return null;    }

    @Override
    public Object visitEmptyFormalParameterSequence(EmptyFormalParameterSequence ast, Object o) {
        writeLineXml("<EmptyFormalParameterSequence/>");
        return null;    }

    @Override
    public Object visitMultipleFormalParameterSequence(MultipleFormalParameterSequence ast, Object o) {
        writeLineXml("<MultipleFormalParameterSequence>");
        ast.FP.visit(this, null);
        ast.FPS.visit(this, null);
        writeLineXml("</MultipleFormalParameterSequence>");
        return null; 
    }

    @Override
    public Object visitSingleFormalParameterSequence(SingleFormalParameterSequence ast, Object o) {
        writeLineXml("<SingleFormalParameterSequence>");
        ast.FP.visit(this, null);
        writeLineXml("</SingleFormalParameterSequence>");
        return null;    }

    @Override
    public Object visitConstActualParameter(ConstActualParameter ast, Object o) {
        writeLineXml("<ConstActualParameter>");
        ast.E.visit(this, null);
        writeLineXml("</ConstActualParameter>");
        return null;    }

    @Override
    public Object visitFuncActualParameter(FuncActualParameter ast, Object o) {
        writeLineXml("<FuncActualParameter>");
        ast.I.visit(this, null);
        writeLineXml("</FuncActualParameter>");
        return null;    }

    @Override
    public Object visitProcActualParameter(ProcActualParameter ast, Object o) {
        writeLineXml("<ProcActualParameter>");
        ast.I.visit(this, null);
        writeLineXml("</ProcActualParameter>");
        return null;    }

    @Override
    public Object visitVarActualParameter(VarActualParameter ast, Object o) {
        writeLineXml("<VarActualParameter>");
        ast.V.visit(this, null);
        writeLineXml("</VarActualParameter>");
        return null;    }

    @Override
    public Object visitEmptyActualParameterSequence(EmptyActualParameterSequence ast, Object o) {
        writeLineXml("<EmptyActualParameterSequence/>");
        return null;    }

    @Override
    public Object visitMultipleActualParameterSequence(MultipleActualParameterSequence ast, Object o) {
        writeLineXml("<MultipleActualParameterSequence>");
        ast.AP.visit(this, null);
        ast.APS.visit(this, null);
        writeLineXml("</MultipleActualParameterSequence>");
        return null;    }

    @Override
    public Object visitSingleActualParameterSequence(SingleActualParameterSequence ast, Object o) {
        writeLineXml("<SingleActualParameterSequence>");
        ast.AP.visit(this, null);
        writeLineXml("</SingleActualParameterSequence>");
        return null;    }

    @Override
    public Object visitAnyTypeDenoter(AnyTypeDenoter ast, Object o) {
        writeLineXml("<AnyTypeDenoter/>");
        return null;    }

    @Override
    public Object visitArrayTypeDenoter(ArrayTypeDenoter ast, Object o) {
        writeLineXml("<ArrayTypeDenoter>");
        ast.IL.visit(this, null);
        ast.T.visit(this, null);
        writeLineXml("</ArrayTypeDenoter>");
        return null;    }

    @Override
    public Object visitBoolTypeDenoter(BoolTypeDenoter ast, Object o) {
        writeLineXml("<BoolTypeDenoter/>");
        return null;    }

    @Override
    public Object visitCharTypeDenoter(CharTypeDenoter ast, Object o) {
        writeLineXml("<CharTypeDenoter/>");
        return null;    }

    @Override
    public Object visitErrorTypeDenoter(ErrorTypeDenoter ast, Object o) {
        writeLineXml("<ErrorTypeDenoter/>");
        return null;    }

    @Override
    public Object visitSimpleTypeDenoter(SimpleTypeDenoter ast, Object o) {
        writeLineXml("<SimpleTypeDenoter>");
        ast.I.visit(this, null);
        writeLineXml("</SimpleTypeDenoter>");
        return null;    }

    @Override
    public Object visitIntTypeDenoter(IntTypeDenoter ast, Object o) {
        writeLineXml("<IntTypeDenoter/>");
        return null;    }

    @Override
    public Object visitRecordTypeDenoter(RecordTypeDenoter ast, Object o) {
        writeLineXml("<RecordTypeDenoter>");
        ast.FT.visit(this, null);
        writeLineXml("</RecordTypeDenoter>");
        return null;    }

    @Override
    public Object visitMultipleFieldTypeDenoter(MultipleFieldTypeDenoter ast, Object o) {
        writeLineXml("<MultipleFieldTypeDenoter>");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
        ast.FT.visit(this, null);
        writeLineXml("</MultipleFieldTypeDenoter>");
        return null;    }

    @Override
    public Object visitSingleFieldTypeDenoter(SingleFieldTypeDenoter ast, Object o) {
        writeLineXml("<SingleFieldTypeDenoter>");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
        writeLineXml("</SingleFieldTypeDenoter>");
        return null;    }

    @Override
    public Object visitCharacterLiteral(CharacterLiteral ast, Object o) {
        writeLineXml("<CharacterLiteral value=\"" + ast.spelling + "\"/>");
        return null;    }

    @Override
    public Object visitIdentifier(Identifier ast, Object o) {
        writeLineXml("<Identifier value=\"" + ast.spelling + "\"/>");
        return null;    }

    @Override
    public Object visitIntegerLiteral(IntegerLiteral ast, Object o) {
        writeLineXml("<IntegerLiteral value=\"" + ast.spelling + "\"/>");
        return null;    }

    @Override
    public Object visitOperator(Operator ast, Object o) {
        writeLineXml("<Operator value=\"" + transformOperator(ast.spelling) + "\"/>");
        return null;    }

    @Override
    public Object visitDotVname(DotVname ast, Object o) {
        writeLineXml("<DotVname>");
        ast.V.visit(this, null);
        ast.I.visit(this, null);
        writeLineXml("</DotVname>");
        return null;    }

    @Override
    public Object visitSimpleVname(SimpleVname ast, Object o) {
        writeLineXml("<SimpleVname>");
        ast.I.visit(this, null);
        writeLineXml("</SimpleVname>");
        return null;    }

    @Override
    public Object visitSubscriptVname(SubscriptVname ast, Object o) {
        writeLineXml("<SubscriptVname>");
        ast.V.visit(this, null);
        ast.E.visit(this, null);
        writeLineXml("</SubscriptVname>");
        return null;    }

    @Override
    public Object visitProgram(Program ast, Object o) {
        writeLineXml("<Program>");
        ast.C.visit(this, null);
        writeLineXml("</Program>");
        return null;    }
    
}
