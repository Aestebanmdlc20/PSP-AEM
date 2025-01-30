package org.example;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

public class FTPExample3 {
    public static void main(String[] args) throws IOException {
    	FTPClient ftpClient = null;
        FileOutputStream outputStream = null;
        try {
        	ftpClient = new FTPClient();
        	ftpClient.connect("localhost", 21);
            if (ftpClient.login("aemdlcdev", "toor")) {
            	System.out.println("Conectado al servidor FTP");
            	// Usar pasive mode
                ftpClient.enterLocalPassiveMode();

	            //descargar un archivo
	            outputStream = new FileOutputStream("leer.txt");
	            boolean success = ftpClient.retrieveFile("/leer.txt", outputStream);
	            
	            if (success) {
	                System.out.println("El archivo se ha descargado correctamente.");
	            }
	            else {
	            	System.out.println("El archivo NO se ha descargado.");
	            }
            } else {
                System.out.println("Login fallido");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
        	try {
        		if (null != outputStream) {
        			outputStream.close();
        		}
        	} catch(IOException ex) {
        		
        	}
            try {
                if (ftpClient.isConnected()) {
                	ftpClient.logout();
                	ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
