package br.com.alura.loja;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Server {
	
	public static void main(String[] args) throws IOException{
		
		System.out.println("Iniciando Server...");
		System.out.println(inicializaServidor());
		
		System.in.read();
		
	}
	
	public static String inicializaServidor() {
		ResourceConfig config = new ResourceConfig().packages("br.com.alura.loja");
		URI uri = URI.create("http://localhost:8080/"); 
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
		return "Servidor rodando..." + server.isStarted();
	}

}