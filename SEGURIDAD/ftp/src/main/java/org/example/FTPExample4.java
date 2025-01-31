package org.example;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class FTPExample4 {
	public static void main(String[] args) {
		FTPClient ftpClient = null;
		try {
			ftpClient = new FTPClient();
			ftpClient.connect("localhost", 21);
			if (ftpClient.login("aemdlcdev", "toor")) {
				System.out.println("Conectado al servidor FTP");
				// Usar pasive mode
				ftpClient.enterLocalPassiveMode();

				// listar los archivos en un directorio
				FTPFile[] files = ftpClient.listFiles("/");
				for (FTPFile file : files) {
					System.out.println("Nombre: " + file.getName());
				}
			} else {
				System.out.println("Login fallido");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
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