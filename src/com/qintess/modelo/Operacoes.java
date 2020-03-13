package com.qintess.modelo;

import java.util.Date;



public class Operacoes  { 


	Date dtInicio; //1
	Date dtFim; // 2
	String nmSubproduto; //9
	double quantidade; // 12
	int idPreco; // 13
	int prazo;
	
	public Operacoes(Date dtInicio, Date dtFim, String nmSubproduto, double quantidade, int idPreco, int prazo) {
		super();
		this.dtInicio = dtInicio;
		this.dtFim = dtFim;
		this.nmSubproduto = nmSubproduto;
		this.quantidade = quantidade;
		this.idPreco = idPreco;
		this.prazo = prazo;
	}
	
	public Date getDtInicio() {
		return dtInicio;
	}
	public void setDtInicio(Date _dtInicio) {
		this.dtInicio = _dtInicio;
	}
	public Date getDtFim() {
		return dtFim;
	}
	public void setDtFim(Date _dtFim) {
		this.dtFim = _dtFim;
	}
	public String getNmSubproduto() {
		return nmSubproduto;
	}
	public void setNmSubproduto(String _nmSubproduto) {
		this.nmSubproduto = _nmSubproduto;
	}
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double _quantidade) {
		this.quantidade = _quantidade;
	}
	public int getIdPreco() {
		return idPreco;
	}
	public void setIdPreco(int _idPreco) {
		this.idPreco = _idPreco;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int _prazo) {
		this.prazo = _prazo;
	}
	

	
}
