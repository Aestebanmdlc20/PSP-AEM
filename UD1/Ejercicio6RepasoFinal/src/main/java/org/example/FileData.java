package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileData {

    private String fichero;
    private String palabraBuscada;
    private int numeroOcurrencias;
    private List<Integer> numLinea;
    private List<String> contenidoLinea;

    public FileData(String fichero, String palabraBuscada) {
        this.fichero = fichero;
        this.palabraBuscada = palabraBuscada;
        this.numeroOcurrencias=0;
        this.numLinea = new ArrayList<>();
        this.contenidoLinea = new ArrayList<>();
    }

    public String getFichero() {
        return fichero;
    }

    public void setFichero(String fichero) {
        this.fichero = fichero;
    }

    public String getPalabraBuscada() {
        return palabraBuscada;
    }

    public void setPalabraBuscada(String palabraBuscada) {
        this.palabraBuscada = palabraBuscada;
    }

    public int getNumeroOcurrencias() {
        return numeroOcurrencias;
    }

    public void setNumeroOcurrencias(int numeroOcurrencias) {
        this.numeroOcurrencias = numeroOcurrencias;
    }

    public List<Integer> getNumLinea() {
        return numLinea;
    }

    public void setNumLinea(int numLinea) {
        this.numLinea.add(numLinea);
    }

    public List<String> getContenidoLinea() {
        return contenidoLinea;
    }

    public void setContenidoLinea(String contenidoLinea) {
        this.contenidoLinea.add(contenidoLinea);
    }
}
