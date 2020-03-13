package com.qintess.modelo;

public class Resultado implements Comparable<Resultado> {


	public String subproduto;
	public double resultado;
	
	 @Override
	 public int compareTo(Resultado p) {
	        return this.getSubproduto().compareTo(p.getSubproduto());
	 }
	 
	
	public Resultado(String subproduto, double resultado) {
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
