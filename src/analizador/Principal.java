package analizador;

import java.io.File;
import java.io.IOException;
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
            "-parser", "Sintax",
            "C:\\Users\\rodri\\OneDrive\\Documentos"
                + "\\NetBeansProjects\\analizadorLexico\\src\\"
                + "analizador\\Sintax.cup"
        };

        String[] rutas2 = {
            "-parser", "SintaxSem",
            "C:\\Users\\rodri\\OneDrive\\Documentos"
                + "\\NetBeansProjects\\analizadorLexico\\src\\"
                + "analizador\\semantico\\SintaxSem.cup"
        };

        generarLexer(ruta1, ruta2, rutas, rutas2);
    }

    public static void generarLexer(String ruta1, String ruta2, String[] rutas, String[] rutas2) throws IOException, Exception {
        // Generar analizadores léxicos
        JFlex.Main.generate(new File(ruta1));
        JFlex.Main.generate(new File(ruta2));

        // Generar analizadores sintácticos
        java_cup.Main.main(rutas);
        java_cup.Main.main(rutas2);

        // Mover archivo sym.java a la carpeta correcta si es necesario
        Path rutaSym = Paths.get("C:\\Users\\rodri\\OneDrive\\Documentos"
                + "\\NetBeansProjects\\analizadorLexico\\src\\analizador\\sym.java");

        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }

        Files.move(
            Paths.get("C:\\Users\\rodri\\OneDrive\\Documentos"
                + "\\NetBeansProjects\\analizadorLexico\\sym.java"),
            rutaSym
        );

        // Mover Sintax.java si fue generado fuera de la carpeta src
        Path rutaSintax = Paths.get("C:\\Users\\rodri\\OneDrive\\Documentos"
                + "\\NetBeansProjects\\analizadorLexico\\src\\analizador\\Sintax.java");

        if (Files.exists(rutaSintax)) {
            Files.delete(rutaSintax);
        }

        Files.move(
            Paths.get("C:\\Users\\rodri\\OneDrive\\Documentos"
                + "\\NetBeansProjects\\analizadorLexico\\Sintax.java"),
            rutaSintax
        );

        // 🔴 NOTA: NO necesitas mover SintaxSem.java si usaste correctamente el package:
        // package analizador.semantico;
        // CUP lo generará directamente en la carpeta src/analizador/semantico
    }
}
