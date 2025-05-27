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
        generarLexer(ruta1,ruta2,rutas);
        analizarSemanticamente();
    }
    
    public static void analizarSemanticamente() throws Exception {
        String rutaArchivo = "D:/caso_1.txt";
        Reader reader = new BufferedReader(new FileReader(rutaArchivo));
        LexerCup lexer = new LexerCup(reader);
        Sintax parser = new Sintax(lexer);

        parser.parse();

        if (parser.getS() != null || parser.hayErrores()) {
            System.err.println("Se encontraron errores:");
            parser.imprimirErrores();
        } else {
            System.out.println("Compilación exitosa sin errores");
        }
    }
    
    public static void generarLexer(String ruta1, String ruta2, String[] rutas) throws IOException, Exception{
        File archivo; 
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        
        java_cup.Main.main(rutas);
        
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
        
        if(Files.exists(rutaSintax))
            Files.delete(rutaSintax);
        
        Files.move(
                Paths.get("C:\\Users\\rodri\\OneDrive\\Documentos"
                + "\\NetBeansProjects\\analizadorLexico\\Sintax.java"), 
                Paths.get("C:\\Users\\rodri\\OneDrive\\Documentos"
                + "\\NetBeansProjects\\analizadorLexico\\src\\analizador\\Sintax.java")
        );
    }
}

// En Lexer.flex
/*
-?{D}+(\.{D}+)? {lexeme=yytext(); return Numero;}
-? → Opcionalmente, permite un signo negativo (-).
{D}+ → Uno o más dígitos (ej. 123).
(\.{D}+)? → Opcionalmente, permite decimales (. seguido de uno o más dígitos, como 3.14).
*/
