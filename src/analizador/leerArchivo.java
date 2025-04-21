package analizador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

public class leerArchivo {
    public String leerTXT(String ruta) {
        String rutaArchivo = ruta; 
        StringBuilder contenido = new StringBuilder();
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
        return contenido.toString();
    }
    
    public String analizarTokens(String ruta) {
        StringBuilder resultado = new StringBuilder();
        HashMap<Tokens, Integer> conteoTokens = new HashMap<>();

        // Inicializar el mapa con todos los tokens en 0
        for (Tokens token : Tokens.values()) {
            conteoTokens.put(token, 0);
        }

        try (Reader lector = new BufferedReader(new FileReader(ruta))) {
            Lexer lexer = new Lexer(lector);
            Tokens token;

            while ((token = lexer.yylex()) != null) {
                // Sumar 1 al token encontrado
                conteoTokens.put(token, conteoTokens.get(token) + 1);
            }

            // Construir el resultado
            for (Tokens tokenKey : Tokens.values()) {
                resultado.append(tokenKey).append(": ").append(conteoTokens.get(tokenKey)).append("\n");
            }

        } catch (IOException e) {
            return "Error al leer el archivo: " + e.getMessage();
        }

        return resultado.toString();
    }
}
