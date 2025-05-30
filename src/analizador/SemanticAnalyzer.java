package analizador;

import java.util.*;
import java.util.regex.*;

public class SemanticAnalyzer {

    static Map<String, String> variableTable = new HashMap<>();

    public static void analyzeFromTextArea(String inputText, frmPrincipal fp) {
        variableTable.clear();

        List<String> lines = Arrays.asList(inputText.split("\\n"));
        int lineNumber = 0;
        boolean insideMain = false;
        boolean mainFound = false;

        for (String rawLine : lines) {
            lineNumber++;
            String line = rawLine.trim().replace(";", "");

            // Detectar inicio del método main con llave opcional en la misma línea
            if (line.matches("^public\\s+static\\s+void\\s+main\\s*\\(\\s*\\)\\s*\\{?\\s*$")) {
                mainFound = true;
                if (line.endsWith("{")) {
                    insideMain = true;
                }
                continue;
            }

            // Si la llave abre el bloque main en línea separada
            if (mainFound && !insideMain && line.equals("{")) {
                insideMain = true;
                continue;
            }

            // Cerrar bloque main
            if (insideMain && line.equals("}")) {
                insideMain = false;
                continue;
            }

            // Ignorar líneas fuera del main
            if (!insideMain) continue;

            // Análisis dentro del método main
            if (line.matches("^(int|float|boolean|String)\\s+\\w+\\s*=.*")) {
                handleDeclaration(line, lineNumber,fp);
            } else if (line.matches("^\\w+\\s*=.*")) {
                handleAssignment(line, lineNumber,fp);
            } else if (!line.isEmpty()) {
                fp.escribir("Línea " + lineNumber + ": [Info] Línea no reconocida: \"" + line + "\"");
            }
        }

        if (!mainFound) {
            fp.escribir("Error: No se encontró un método main válido.");
        }
    }

    private static void handleDeclaration(String line, int lineNumber, frmPrincipal fp) {
        String[] parts = line.split("=", 2);
        if(parts.length < 2){
            fp.escribir("Error semántico en línea " + lineNumber + ": declaración incompleta");
            return;
        }

        String[] left = parts[0].trim().split("\\s+");
        if(left.length < 2){
            fp.escribir("Error semántico en línea " + lineNumber + ": declaración inválida");
            return;
        }

        String type = left[0];
        String varName = left[1];
        String value = parts[1].trim();

        if (isTypeCompatible(type, value)) {
            variableTable.put(varName, type);
            fp.escribir("✔ Línea " + lineNumber + ": declaración válida → " + varName + " : " + type);
        } else {
            fp.escribir("Error semántico en línea " + lineNumber + ":");
            fp.escribir("→ Tipo incompatible para variable '" + varName + "'");
            fp.escribir("→ Se esperaba: " + type);
            fp.escribir("→ Se encontró: " + inferType(value));
            fp.escribir("\n");
        }
    }

    private static void handleAssignment(String line, int lineNumber, frmPrincipal fp) {
        String[] parts = line.split("=", 2);
        if(parts.length < 2){
            fp.escribir("Error semántico en línea " + lineNumber + ": asignación incompleta");
            return;
        }

        String varName = parts[0].trim();
        String value = parts[1].trim();

        if (!variableTable.containsKey(varName)) {
            fp.escribir("Error semántico en línea " + lineNumber + ":");
            fp.escribir("→ Variable no declarada: '" + varName + "'");
            fp.escribir("\n");
            return;
        }

        String declaredType = variableTable.get(varName);
        if (isTypeCompatible(declaredType, value)) {
            fp.escribir("✔ Línea " + lineNumber + ": asignación válida → " + varName);
        } else {
            fp.escribir("Error semántico en línea " + lineNumber + ":");
            fp.escribir("→ Asignación incompatible a variable '" + varName + "'");
            fp.escribir("→ Se esperaba: " + declaredType);
            fp.escribir("→ Se encontró: " + inferType(value));
            fp.escribir("\n");
        }
    }

    private static boolean isTypeCompatible(String declaredType, String value) {
        String actualType = inferType(value);
        if (declaredType.equals("int")) return actualType.equals("int");
        if (declaredType.equals("float")) return actualType.equals("float") || actualType.equals("int");
        if (declaredType.equals("String")) return actualType.equals("String");
        if (declaredType.equals("boolean")) return actualType.equals("boolean");
        return false;
    }

    private static String inferType(String value) {
        if (value.matches("^\".*\"$")) return "String";
        if (value.matches("^[0-9]+$")) return "int";
        if (value.matches("^[0-9]*\\.[0-9]+$")) return "float";
        if (value.equals("true") || value.equals("false")) return "boolean";
        return "desconocido";
    }
}
