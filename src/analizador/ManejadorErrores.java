package analizador;

import java.util.ArrayList;
import java.util.List;

public class ManejadorErrores {
    private List<String> errores;
    
    public ManejadorErrores() {
        errores = new ArrayList<>();
    }
    
    public void agregarError(int linea, String mensaje) {
        errores.add("Error semántico en línea " + linea + ": " + mensaje);
    }
    
    public boolean hayErrores() {
        return !errores.isEmpty();
    }
    
    public void imprimirErrores() {
        for (String error : errores) {
            System.err.println(error);
        }
    }
}