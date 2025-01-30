package org.example;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FTPExample2 {
    public static void main(String[] args) throws IOException {
    	FTPClient ftpClient = null;
        FileInputStream inputStream = null;
        try {
            
        	//establecer una conexión con el servidor FTP
        	ftpClient = new FTPClient();
        	ftpClient.connect("localhost",21);
            if (ftpClient.login("aemdlcdev", "toor")) {
            	System.out.println("Conectado al servidor FTP");
            	// Usar pasive mode
            	ftpClient.enterLocalPassiveMode();
                
            	ftpClient.setFileType(FTP.ASCII_FILE_TYPE);
            	
            	//enviar un archivo
                inputStream = new FileInputStream("prueba.txt");
                boolean done = ftpClient.storeFile("/prueba.txt", inputStream);
                if (done) {
                    System.out.println("El archivo se ha enviado correctamente.");
                }
                else {
                	System.out.println("El archivo NO se ha enviado.");
                }
            } else {
                System.out.println("Login fallido");
            }

            
        } catch (IOException ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
        	try {
        		if (null != inputStream) {
        			inputStream.close();
        		}
        	} catch(IOException ex) {
        		
        	}
            try {
                if (ftpClient.isConnected()) {
                	ftpClient.logout();
                	ftpClient.disconnect();
                }
            } catch (IOException ex) {
            }
        }
    }
}
