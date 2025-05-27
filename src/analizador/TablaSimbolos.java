package analizador;

import java.util.HashMap;

public class TablaSimbolos {
    private HashMap<String, Simbolo> tabla;

    public TablaSimbolos() {
        tabla = new HashMap<>();
    }

    public void agregarSimbolo(String nombre, String tipo, String ambito) {
        tabla.put(nombre, new Simbolo(nombre, tipo, ambito));
    }

    public Simbolo buscarSimbolo(String nombre) {
        return tabla.get(nombre);
    }

    public boolean existeSimbolo(String nombre) {
        return tabla.containsKey(nombre);
    }

    public static class Simbolo {
        private String nombre;
        private String tipo;
        private String ambito;

        public Simbolo(String nombre, String tipo, String ambito) {
            this.nombre = nombre;
            this.tipo = tipo;
            this.ambito = ambito;
        }

        public String getNombre() { return nombre; }
        public String getTipo() { return tipo; }
        public String getAmbito() { return ambito; }
    }
}