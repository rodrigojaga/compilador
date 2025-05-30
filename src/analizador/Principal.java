package analizador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Principal {
    public static void main(String[] args) throws Exception {
        String ruta1 =  "C:\\Users\\rodri\\OneDrive\\Documentos"
                + "\\NetBeansProjects\\analizadorLexico\\src\\"
                + "analizador\\Lexer.flex";
        
        String ruta2 =  "C:\\Users\\rodri\\OneDrive\\Documentos"
                + "\\NetBeansProjects\\analizadorLexico\\src\\"
                + "analizador\\LexerCup.flex";
        
        String[] rutas = {
            "-parser",
            "Sintax",
            "C:\\Users\\rodri\\OneDrive\\Documentos"
                + "\\NetBeansProjects\\analizadorLexico\\src\\"
                + "analizador\\Sintax.cup"
        };
        
        String[] rutas2 = {
            "-parser",
            "SintaxSem",
            "C:\\Users\\rodri\\OneDrive\\Documentos"
                + "\\NetBeansProjects\\analizadorLexico\\src\\"
                + "analizador\\SintaxSem.cup"
        };
        
        generarLexer(ruta1,ruta2,rutas, rutas2);
        //analizarSemanticamente();
    }
   
    
    public static void generarLexer(String ruta1, String ruta2, String[] rutas, String[] rutas2) throws IOException, Exception{
        File archivo; 
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        
        java_cup.Main.main(rutas);
        java_cup.Main.main(rutas2);
        
        Path rutaSym = Paths.get("C:\\Users\\rodri\\OneDrive\\Documentos"
                + "\\NetBeansProjects\\analizadorLexico\\src\\analizador\\sym.java");
        
        if(Files.exists(rutaSym))
            Files.delete(rutaSym);
        
        Files.move(
                Paths.get("C:\\Users\\rodri\\OneDrive\\Documentos"
                + "\\NetBeansProjects\\analizadorLexico\\sym.java"), 
                Paths.get("C:\\Users\\rodri\\OneDrive\\Documentos"
                + "\\NetBeansProjects\\analizadorLexico\\src\\analizador\\sym.java")
        );
        
        Path rutaSintax = Paths.get("C:\\Users\\rodri\\OneDrive\\Documentos"
                + "\\NetBeansProjects\\analizadorLexico\\src\\analizador\\Sintax.java");
        
        Path rutaSintaxSem = Paths.get("C:\\Users\\rodri\\OneDrive\\Documentos"
                + "\\NetBeansProjects\\analizadorLexico\\src\\analizador\\SintaxSem.java");
        
        if(Files.exists(rutaSintax))
            Files.delete(rutaSintax);
        
            Files.move(
                    Paths.get("C:\\Users\\rodri\\OneDrive\\Documentos"
                    + "\\NetBeansProjects\\analizadorLexico\\Sintax.java"), 
                    Paths.get("C:\\Users\\rodri\\OneDrive\\Documentos"
                    + "\\NetBeansProjects\\analizadorLexico\\src\\analizador\\Sintax.java")
            );
            
        if(Files.exists(rutaSintaxSem))
            Files.delete(rutaSintaxSem);
        
            Files.move(
                    Paths.get("C:\\Users\\rodri\\OneDrive\\Documentos"
                    + "\\NetBeansProjects\\analizadorLexico\\SintaxSem.java"), 
                    Paths.get("C:\\Users\\rodri\\OneDrive\\Documentos"
                    + "\\NetBeansProjects\\analizadorLexico\\src\\analizador\\SintaxSem.java")
            );
        }
    
        
}

