package br.com.alura.loja.modelo;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;

@XmlRootElement
public class Conteudo {

	private String numeroSinistro;
	private String dataSituacao;
	private boolean flagFornecimentoPecas;
	private String textoNota;
	private String origemRequisicao;

	private StringBuilder textoNotaB;
	
	private char[] vChar = new char[200];
	
	private StringArrayDeserializer textoNotaD;
	
	
	public Conteudo () {}
	
	public Conteudo(String numeroSinistro, String dataSituacao, boolean flagFornecimentoPecas) {
		super();
		this.numeroSinistro = numeroSinistro;
		this.dataSituacao = dataSituacao;
		this.flagFornecimentoPecas = flagFornecimentoPecas;
		
		
	}
	/*
	public String toJson() {
		return new Gson().toJson(this);
	}	
	*/
	
	public String getNumeroSinistro() {
		return numeroSinistro;
	}

	public void setNumeroSinistro(String numeroSinistro) {
		this.numeroSinistro = numeroSinistro;
	}

	public String getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(String dataSituacao) {
		this.dataSituacao = dataSituacao;
	}

	public boolean isFlagFornecimentoPecas() {
		return flagFornecimentoPecas;
	}

	public void setFlagFornecimentoPecas(boolean flagFornecimentoPecas) {
		this.flagFornecimentoPecas = flagFornecimentoPecas;
	}

	public StringBuilder getTextoNotaB() {
		return textoNotaB;
	}

	public void setTextoNotaB(StringBuilder textoNotaB) {
		this.textoNotaB = textoNotaB;
	}

	public String getTextoNota() {
		return textoNota;
	}

	public void setTextoNota(String textoNota) {
		this.textoNota = textoNota;
	}

	public String getOrigemRequisicao() {
		return origemRequisicao;
	}

	public void setOrigemRequisicao(String origemRequisicao) {
		this.origemRequisicao = origemRequisicao;
	}

	public StringArrayDeserializer getTextoNotaD() {
		return textoNotaD;
	}

	public void setTextoNotaD(StringArrayDeserializer textoNotaD) {
		this.textoNotaD = textoNotaD;
	}

	public char[] getvChar() {
		return vChar;
	}

	public void setvChar(char[] vChar) {
		this.vChar = vChar;
	}
	
}
