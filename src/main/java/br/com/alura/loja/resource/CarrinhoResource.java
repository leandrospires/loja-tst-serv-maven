package br.com.alura.loja.resource;

import java.net.URI;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.modelo.Conteudo;

@Path("carrinhos")
public class CarrinhoResource {
	Date data = new Date();
	
	/*
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String busca(@PathParam("id") long id) {
		
		Carrinho carrinho = new CarrinhoDAO().busca(id);
				
		return carrinho.toXML();
	}
	*/

	@POST
	@Path("/testePostObj")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response testePostObj (
			@Context HttpServletRequest request,
			@Context HttpServletResponse response,
			Conteudo conteudo) {
		
		System.out.println("Teste-Obj Inicio");
		System.out.println(data.toString());

		System.out.println("Sinistro Obj  : " + conteudo.getNumeroSinistro());
		System.out.println("origemRequisicao      : " + conteudo.getOrigemRequisicao());
		System.out.println("textoNota      : " + conteudo.getTextoNota());
		
		System.out.println("Teste-Obj Fim");
		return Response.ok().build();
	}
	
	
	@POST
	@Path("/testePostParam")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")	
	public Response testePostParam (
			@Context HttpServletRequest request,
			@Context HttpServletResponse response,
			String conteudo) {
		
		try {
			System.out.println("Teste-Post Inicio");
			System.out.println(data.toString());
			
			if (conteudo == null) {
				conteudo = "vazio";
				System.out.println(conteudo);
				return Response.ok().build();
			}
			
			System.out.println("----------");
			System.out.println("Chamando classe - GSon!");

			GsonBuilder builder = new GsonBuilder();
			Gson g = builder.create();
			Conteudo conteudoObj = g.fromJson(conteudo, Conteudo.class);
			
 			System.out.println("Sinistro GSON  : " + conteudoObj.getNumeroSinistro());
			System.out.println("Data GSON      : " + conteudoObj.getDataSituacao());
			System.out.println("Flag GSON      : " + conteudoObj.isFlagFornecimentoPecas());
			System.out.println("Texto          : " + conteudoObj.getTextoNota());
			System.out.println("TextoB         : " + conteudoObj.getTextoNotaB());

			System.out.println("vChar         : " + conteudoObj.getvChar());
			System.out.println("----------");
			
			System.out.println("Chamando classe - JSon!");

						
			
			JSONObject conteudoJ = new JSONObject(conteudo);

			System.out.println("Sinistro JSON  : " + conteudoJ.getString("numeroSinistro"));
			System.out.println("Data JSON      : " + conteudoJ.getString("dataSituacao"));
			System.out.println("Flag JSON      : " + conteudoJ.getBoolean("flagFornecimentoPecas"));
			System.out.println("Texto          : " + conteudoObj.getTextoNota());
			System.out.println("TextoB         : " + conteudoObj.getTextoNotaB());			
			System.out.println("----------");
			
			System.out.println("Teste-Post Chamado OK");

			return Response.ok().build();			
		}
		catch (Exception e) {
			
			System.out.println("Erro: " + e.toString());

			return Response.ok().build();
			
		}

	}


	@Path("/testePost")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String testePost () {
		System.out.println(data.toString());
		System.out.println("Teste-Post Chamado: sem par�metro");
		
		Conteudo conteudo = new Conteudo("53120201234", data.toString(), false);
		
		//return Response.ok().build();
		return "ok"; //conteudo.toJson();
	}
	
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String busca(@PathParam("id") long id) {
		
		//Carrinho carrinho = new CarrinhoDAO().busca(id);
		
		System.out.println("Teste-Get: OK");
		
		return null;//carrinho.toJson();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response adiciona(String conteudo) {
		//Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
		//new CarrinhoDAO().adiciona(carrinho);
		
		//URI uri = URI.create("/carrinhos/" + carrinho.getId());
		return null;//Response.created(uri).build();
	}
	
	@Path("{id}/produto/{produtoId}")
	@DELETE
	public Response removeProduto(@PathParam("id") long id, @PathParam("produtoId") long produtoId) {
		//Carrinho carrinho = new CarrinhoDAO().busca(id);
		//carrinho.remove(produtoId);
		
		return Response.ok().build();
	}
	
	@Path("{id}/produto/{produtoId}/quantidade")
	@PUT
	public Response alteraProduto(String conteudo, @PathParam("id") long id, @PathParam("produtoId") long produtoId) {
		//Carrinho carrinho = new CarrinhoDAO().busca(id);
		
		//Produto produto = (Produto) new XStream().fromXML(conteudo);
		//carrinho.trocaQuantidade(produto);
		
		return Response.ok().build();
		
		//PATCH - Atualiza um peda�o do recurso 
	}
}
