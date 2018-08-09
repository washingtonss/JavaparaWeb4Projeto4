package br.com.videoaulasneri.javabean.model;

public class ItensVendaModel {
	private int procodigo;
	public double getPrecounitario() {
		return precounitario;
	}
	public void setPrecounitario(double precounitario) {
		this.precounitario = precounitario;
	}
	private int vencodigo;
	private int venquantidade;
	private double ventotal;
	private String prodescricao;
	private double precounitario;
	public String getProdescricao() {
		return prodescricao;
	}
	public void setProdescricao(String prodescricao) {
		this.prodescricao = prodescricao;
	}
	public int getProcodigo() {
		return procodigo;
	}
	public void setProcodigo(int procodigo) {
		this.procodigo = procodigo;
	}
	public int getVencodigo() {
		return vencodigo;
	}
	public void setVencodigo(int vencodigo) {
		this.vencodigo = vencodigo;
	}
	public int getVenquantidade() {
		return venquantidade;
	}
	public void setVenquantidade(int venquantidade) {
		this.venquantidade = venquantidade;
	}
	public double getVentotal() {
		return ventotal;
	}
	public void setVentotal(double ventotal) {
		this.ventotal = ventotal;
	}

}
