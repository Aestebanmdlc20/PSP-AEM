package org.example;

import java.io.File;
import java.io.IOException;

public class CmdDir {

    public static void lanzarCmdDir(){
        ProcessBuilder pb=null;
        Process proceso = null;
        int exitVal;
        pb = new ProcessBuilder("cmd", "/C", "dir");
        pb.redirectOutput(new File("Files","output.txt"));
        pb.redirectError(new File("Files","error.txt"));
        try {
            proceso=pb.start();
            exitVal = proceso.waitFor();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        lanzarCmdDir();
    }

}
