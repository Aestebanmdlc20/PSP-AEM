import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

public class GestorDescargas {

	public void descargarArchivoOLD(String urlDescarga, String nombreArchivo) {

		InputStream is = null;
		InputStreamReader reader = null;
		BufferedReader bReader = null;
		FileWriter fWriter = null;
		try {
			System.out.println("Descargando " + urlDescarga);
			URL url = new URL(urlDescarga);
			is = url.openStream();
			reader = new InputStreamReader(is);
			bReader = new BufferedReader(reader);
			fWriter = new FileWriter(nombreArchivo);
			String linea;
			while ((linea = bReader.readLine()) != null) {
				fWriter.write(linea);
			}
			System.out.println("Done..");
		} catch (MalformedURLException e) {
			System.out.println("URL mal escrita! " + e.getMessage());
			e.printStackTrace();
			return;
		} catch (IOException e) {
			System.out.println("Fallo en la lectura del fichero " + e.getMessage());
			e.printStackTrace();
			return;
		} finally {
			close(fWriter);
			close(bReader);
			close(reader);
			close(is);
		}
	}

	private void close(Closeable stream) {
		try {
			if (null != stream) {
				stream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void descargarArchivo(String urlDescarga, String nombreArchivo) throws IOException {
		HttpURLConnection connection = null;
		try {
			URI uri = URI.create(urlDescarga); // Crear una URI a partir de la URL de descarga
						
			//connection = (HttpURLConnection) uri.toURL().openConnection();
			connection = (HttpURLConnection) URL.of(uri, null).openConnection();

			// Configurar la conexión (puedes añadir más configuraciones si es necesario)
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000); // Tiempo de espera para la conexión
			connection.setReadTimeout(5000); // Tiempo de espera para la lectura

			// Leer la respuesta de la conexión
			int status = connection.getResponseCode();
			System.out.println("Código de respuesta: " + status);
			FileWriter fWriter = null;
			if (status == HttpURLConnection.HTTP_OK) {
				try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
					// Si la respuesta es exitosa, leemos el contenido

					String inputLine;
					fWriter = new FileWriter(nombreArchivo);
					while ((inputLine = in.readLine()) != null) {
						fWriter.write(inputLine);
					}
					System.out.println("Done..");
				} catch (IOException e) {
					e.printStackTrace();
					throw e;
				} finally {
					close(fWriter);
				}
			} else {
				System.out.println("Error: " + status);
			}

		} catch(MalformedURLException e) {
			System.out.println("URL mal escrita! " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			connection.disconnect(); // Cerrar la conexión
		}
	}

	public static void main(String[] argumentos) throws Exception {
		GestorDescargas gd = new GestorDescargas();
		String url = "https://es.wikipedia.org/wiki/Cliente-servidor";
		String salida = "salida.html";
		gd.descargarArchivo(url, salida);
		
//		GestorDescargas gd = new GestorDescargas();
//		String url = "https://es.wikipedia.org/wiki/Java_(lenguaje_de_programación)"; 
//		String salida = "salida2.html";
//		gd.descargarArchivo(url, salida);

//		GestorDescargas gd = new GestorDescargas();
//		String url = "https://es.wikipedia.org/wiki/Java_(lenguaje_de_programación)"; //FileNotFoundException Error: 404
//		String salida = "salida2.html";
//		gd.descargarArchivoOLD(url, salida);
		
//		GestorDescargas gd = new GestorDescargas();
//		String url = "https://es.wikipedia.org/wiki/Java_(lenguaje_de_programaci%C3%B3n)";//opcion 1
//		String salida = "salida2.html";
//		gd.descargarArchivoOLD(url, salida);
		
//		GestorDescargas gd = new GestorDescargas();
//		String url = "https://es.wikipedia.org/wiki/"+URLEncoder.encode("Java_(lenguaje_de_programación)","UTF-8");
//		String salida = "salida2.html";
//		gd.descargarArchivoOLD(url, salida);
	}
}
