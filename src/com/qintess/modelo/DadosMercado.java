package com.qintess.modelo;

public class DadosMercado { 
	public DadosMercado(int idPreco, int nuPrazoDiasContados, double vlPreco) {
		super();
		this.idPreco = idPreco;
		this.nuPrazoDiasContados = nuPrazoDiasContados;
		this.vlPreco = vlPreco;
	}
	public int idPreco;
	public int nuPrazoDiasContados;
	public double vlPreco;
	
	
	public int getIdPreco() {
		return this.idPreco;
	}
	public void setIdPreco(int _idPreco) {
		this.idPreco = _idPreco;
	}
	
	public int getNuPrazoDiasContados() {
		return this.nuPrazoDiasContados;
	}
	public void setNuPrazoDiasContados(int _nuPrazoDiasContados) {
		this.nuPrazoDiasContados = _nuPrazoDiasContados;
	}
	
	public double getVlPreco() {
		return this.vlPreco;
	}
	public void setVlPreco(double _vlPreco) {
		this.vlPreco = _vlPreco;
	}
	

	
}
