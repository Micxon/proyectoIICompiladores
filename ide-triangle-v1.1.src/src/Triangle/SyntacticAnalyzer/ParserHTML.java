/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.SyntacticAnalyzer;

import Triangle.SyntacticAnalyzer.Scanner;
import Triangle.SyntacticAnalyzer.Token;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Allison
 */
public class ParserHTML {
    Scanner scanner;
    String name;

    public ParserHTML(Scanner scanner,String name) {
        this.scanner = scanner;
        this.name = name;
        this.scanner.enableisMakingHtml();
    }
    public void makeHtml(){         //crea el contenido del archivo del html
        Token currentToken=this.scanner.scan();             //lee el primer token
        
        String source = "<p style=\"font-family: 'DejaVu Sans', monospace;\">";
        while (currentToken.kind != Token.EOT){
            switch(currentToken.kind){
                case Token.INTLITERAL:
                case Token.CHARLITERAL:
                    source+="<font style= color:blue;'padding-left:1em'>"+currentToken.spelling+"</font> \t";
                    break;
                case Token.IDENTIFIER: case Token.OPERATOR:
                case Token.LPAREN:     case Token.RPAREN:
                case Token.COLON:      case Token.BECOMES:
                case Token.SEMICOLON:  case Token.STICK:
                case Token.COMMA:      case Token.DOUBLEDOT:
                    source+="<font style=color:black;'padding-left:1em'>"+currentToken.spelling+"</font> \t";
                    break;
                case Token.NEXTLINE :
                    source+="<br>";
                    break;
                case Token.SPACE :
                    source+="<font>"+"&nbsp;"+"</font>";
                    break;
                case Token.TAB:
                    source+="<font>&nbsp;&nbsp;&nbsp;&nbsp;</font>";
                    break;
                case  Token.COMMENT:
                    source+="<font style= color:green;'padding-left:1em'>"+currentToken.spelling+"</font> <br>";
                    break;
                default:
                    source+="<font ><b>"+currentToken.spelling+"</b></font> \t";
                    break;
            }
            currentToken=this.scanner.scan();           //lee un nuevo token
        }
        source+="</p>";
        this.makeFile(source);
    }
    /*
    *Crea el archivo nuevo con las etiquetas
    *
    */
    private void makeFile(String contenido){
        try {
            String ruta = this.name+".html";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
