package br.com.videoaulasneri.javabean.model;

import java.util.Date;

public class VendaModel {
	private int venCodigo;
	private int cliCodigo;
	private Date venData;
	private double venValorTotal;
	public int getVenCodigo() {
		return venCodigo;
	}
	public void setVenCodigo(int venCodigo) {
		this.venCodigo = venCodigo;
	}
	public int getCliCodigo() {
		return cliCodigo;
	}
	public void setCliCodigo(int cliCodigo) {
		this.cliCodigo = cliCodigo;
	}
	public Date getVenData() {
		return venData;
	}
	public void setVenData(Date venData) {
		this.venData = venData;
	}
	public double getVenValorTotal() {
		return venValorTotal;
	}
	public void setVenValorTotal(double venValorTotal) {
		this.venValorTotal = venValorTotal;
	}
		
}
