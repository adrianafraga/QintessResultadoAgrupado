package com.qintess.modelo;

public class ResultadoFinal {

	public String subproduto;
	public double resultado;
	
	
	public ResultadoFinal(String subproduto, double resultado) {
		super();
		this.subproduto = subproduto;
		this.resultado = resultado;
	}

	public String getSubproduto() {
		return subproduto;
	}
	public void setSubproduto(String _subproduto) {
		this.subproduto = _subproduto;
	}
	public double getResultado() {
		return resultado;
	}
	public void setResultado(double _resultado) {
		this.resultado = _resultado;
	}

	
	

}
