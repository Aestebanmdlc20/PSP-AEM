package org.example;

import java.util.ArrayList;
import java.util.List;

public class FileData {
    private String nombreFichero;
    private String palabra;
    private int ocurrencias;
    private List<Integer> lineNumbers;
    private List<String> lines;

    public FileData(String nombreFichero, String palabra) {
        this.nombreFichero = nombreFichero;
        this.palabra = palabra;
        this.ocurrencias = 0;
        this.lineNumbers = new ArrayList<>();
        this.lines = new ArrayList<>();
    }

    public String getNombreFichero() {
        return nombreFichero;
    }

    public String getPalabra() {
        return palabra;
    }

    public int getOcurrencias() {
        return ocurrencias;
    }

    public void setOcurrencias(int ocurrencias) {
        this.ocurrencias = ocurrencias;
    }

    public void addLineNumber(int lineNumber) {
        this.lineNumbers.add(lineNumber);
    }

    public void addLine(String line) {
        this.lines.add(line);
    }
}