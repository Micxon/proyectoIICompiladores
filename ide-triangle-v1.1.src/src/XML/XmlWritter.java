/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;
import Triangle.AbstractSyntaxTrees.Program;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author cato1
 */
//Clase encargada de generar el xml usando los visitors
public class XmlWritter {
    private String fileName;
    
    public XmlWritter(String fileName){
        this.fileName = fileName;
    }
    public void write(Program ast) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);

           
            fileWriter.write("<?xml version=\"1.0\" standalone=\"yes\"?>\n");

            XmlWritterVisitor layout = new XmlWritterVisitor(fileWriter);
            ast.visit(layout, null);

            fileWriter.close();

        } catch (IOException e) {
            System.err.println("Error al crear el xml del ASt");
            e.printStackTrace();
        }
    }
}
