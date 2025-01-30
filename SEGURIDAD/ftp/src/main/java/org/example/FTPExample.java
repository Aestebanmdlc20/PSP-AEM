package org.example;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;

public class FTPExample {
    public static void main(String[] args) throws IOException {
    	FTPClient ftpClient = null;
        try {
        	//establecer una conexión con el servidor FTP
        	ftpClient = new FTPClient();
        	ftpClient.connect("localhost", 21);
            if (ftpClient.login("aemdlcdev", "toor")) {
            	System.out.println("Conectado al servidor FTP");
            	// Usar pasive mode
            	ftpClient.enterLocalPassiveMode();
            } else {
                System.out.println("Login fallido");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
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
