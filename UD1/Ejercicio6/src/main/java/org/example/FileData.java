package org.example;

import java.util.*;

public class FileData {
    private String nombreArchivo;
    private String palabraBuscada;
    private int numeroOcurrencias;
    //private List<Integer> numerosLinea;
    //private List<String> contenidoLineas;
    // En vez de Listas utilizamos un Map para almacenar el número de línea y el contenido de la línea
    private Map<Integer, String> numYContenidoLinea;

    public FileData(String nombreArchivo, String palabraBuscada) {
        this.nombreArchivo = nombreArchivo;
        this.palabraBuscada = palabraBuscada;
        this.numeroOcurrencias = 0;
        this.numYContenidoLinea = new HashMap<>();
    }

    public void agregarOcurrencia(int numeroLinea, String contenidoLinea) {
        this.numeroOcurrencias++;
        numYContenidoLinea.put(numeroLinea, contenidoLinea);
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public int getNumeroOcurrencias() {
        return numeroOcurrencias;
    }

    /*
    public List<Integer> getNumerosLinea() {
        return numerosLinea;
    }

    public List<String> getContenidoLineas() {
        return contenidoLineas;
    }
     */

    public Map<Integer, String> getNumYContenidoLinea() {
        return numYContenidoLinea;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Archivo: ").append(nombreArchivo).append("numero de ocurrencias: ").append(numeroOcurrencias).append("\n");
        Set<Integer> keys = numYContenidoLinea.keySet();
        for (Integer key : keys) {
            sb.append("Ocurrencia en línea ").append(key).append(": ").append(numYContenidoLinea.get(key)).append("\n");
        }
        return sb.toString();
    }

}