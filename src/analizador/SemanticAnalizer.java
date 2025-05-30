//package analizador;
//
//import java.util.*;
//import java.util.regex.*;
//
//public class SemanticAnalizer {
//
//    static Map<String, String> variableTable = new HashMap<>();
//
//    public static void analyzeFromTextArea(String inputText) {
//        List<String> lines = Arrays.asList(inputText.split("\\n"));
//        int lineNumber = 0;
//        boolean insideMain = false;
//        boolean mainFound = false;
//
//        for (String rawLine : lines) {
//            lineNumber++;
//            String line = rawLine.trim().replace(";", "");
//
//            // Verificar inicio del main
//            if (line.equals("public static void main()")) {
//                mainFound = true;
//                continue;
//            }
//
//            // Abrir bloque del main
//            if (mainFound && line.equals("{")) {
//                insideMain = true;
//                continue;
//            }
//
//            // Cerrar bloque del main
//            if (insideMain && line.equals("}")) {
//                insideMain = false;
//                continue;
//            }
//
//            // Ignorar líneas fuera del main
//            if (!insideMain) continue;
//
//            // Análisis dentro del método main
//            if (line.matches("^(int|float|boolean|String)\\s+\\w+\\s*=.*")) {
//                handleDeclaration(line, lineNumber);
//            } else if (line.matches("^\\w+\\s*=.*")) {
//                handleAssignment(line, lineNumber);
//            } else if (!line.isEmpty()) {
//                System.out.println("Línea " + lineNumber + ": [Info] Línea no reconocida: \"" + line + "\"");
//            }
//        }
//
//        if (!mainFound) {
//            System.out.println("Error: No se encontró un método main válido.");
//        }
//    }
//
//    private static void handleDeclaration(String line, int lineNumber) {
//        String[] parts = line.split("=", 2);
//        String[] left = parts[0].trim().split("\\s+");
//        String type = left[0];
//        String varName = left[1];
//        String value = parts[1].trim();
//
//        if (isTypeCompatible(type, value)) {
//            variableTable.put(varName, type);
//        } else {
//            System.out.println("Error semántico en línea " + lineNumber + ":");
//            System.out.println("→ Tipo incompatible para variable '" + varName + "'");
//            System.out.println("→ Se esperaba: " + type);
//            System.out.println("→ Se encontró: " + inferType(value));
//            System.out.println();
//        }
//    }
//
//    private static void handleAssignment(String line, int lineNumber) {
//        String[] parts = line.split("=", 2);
//        String varName = parts[0].trim();
//        String value = parts[1].trim();
//
//        if (!variableTable.containsKey(varName)) {
//            System.out.println("Error semántico en línea " + lineNumber + ":");
//            System.out.println("→ Variable no declarada: '" + varName + "'");
//            System.out.println();
//            return;
//        }
//
//        String declaredType = variableTable.get(varName);
//        if (!isTypeCompatible(declaredType, value)) {
//            System.out.println("Error semántico en línea " + lineNumber + ":");
//            System.out.println("→ Asignación incompatible a variable '" + varName + "'");
//            System.out.println("→ Se esperaba: " + declaredType);
//            System.out.println("→ Se encontró: " + inferType(value));
//            System.out.println();
//        }
//    }
//
//    private static boolean isTypeCompatible(String declaredType, String value) {
//        String actualType = inferType(value);
//        if (declaredType.equals("int")) return actualType.equals("int");
//        if (declaredType.equals("float")) return actualType.equals("float") || actualType.equals("int");
//        if (declaredType.equals("String")) return actualType.equals("String");
//        if (declaredType.equals("boolean")) return actualType.equals("boolean");
//        return false;
//    }
//
//    private static String inferType(String value) {
//        if (value.matches("^\".*\"$")) return "String";
//        if (value.matches("^[0-9]+$")) return "int";
//        if (value.matches("^[0-9]*\\.[0-9]+$")) return "float";
//        if (value.equals("true") || value.equals("false")) return "boolean";
//        return "desconocido";
//    }
//}
