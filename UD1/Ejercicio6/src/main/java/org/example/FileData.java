package org.example;

import java.util.ArrayList;
import java.util.List;

public class FileData {
    private String nombreArchivo;
    private String palabraBuscada;
    private int numeroOcurrencias;
    private List<Integer> numerosLinea;
    private List<String> contenidoLineas;

    public FileData(String nombreArchivo, String palabraBuscada) {
        this.nombreArchivo = nombreArchivo;
        this.palabraBuscada = palabraBuscada;
        this.numeroOcurrencias = 0;
        this.numerosLinea = new ArrayList<>();
        this.contenidoLineas = new ArrayList<>();
    }
    
    public void agregarOcurrencia(int numeroLinea, String contenidoLinea) {
        this.numeroOcurrencias++;
        this.numerosLinea.add(numeroLinea);
        this.contenidoLineas.add(contenidoLinea);
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public int getNumeroOcurrencias() {
        return numeroOcurrencias;
    }

    public List<Integer> getNumerosLinea() {
        return numerosLinea;
    }

    public List<String> getContenidoLineas() {
        return contenidoLineas;
    }
}