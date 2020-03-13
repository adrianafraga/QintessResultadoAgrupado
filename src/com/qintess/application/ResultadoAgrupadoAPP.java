package com.qintess.application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;


import com.qintess.modelo.DadosMercado;
import com.qintess.modelo.Operacoes;
import com.qintess.modelo.Resultado;
import com.qintess.util.Utilidades;

public class ResultadoAgrupadoAPP {


	public static void main(String[] args) throws FileNotFoundException {
		String arqMercado = "C:\\Users\\re039859\\Documents\\workspace-eclipse\\ResultadoAgrupado\\arquivos\\DadosMercado.csv";
		String arqOperacoes = "C:\\Users\\re039859\\Documents\\workspace-eclipse\\ResultadoAgrupado\\arquivos\\Operacoes.csv";
		String arqSaida = "C:\\Users\\re039859\\Documents\\workspace-eclipse\\ResultadoAgrupado\\arquivos\\Resultados.csv";
		
		Utilidades util = new Utilidades();
		

		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SS");
		long start = Calendar.getInstance().getTimeInMillis();
		SimpleDateFormat sdfDia = new SimpleDateFormat("dd/MM/yyyy");

		Date dtInicio = null;
		Date dtFim = null;
		String nmSubproduto = null;
		double quantidade = 0;
		int idPreco = 0;
		int prazo = 0;

		boolean primeiro = true;
		int idPrecoMercado = 0;
		int nuPrazoDiasContados = 0;
		double vlPreco = 0.0;
		
	   double soma =0;
	   String nomeAnterior = null;
	   String nomeAtual = null;
		
		Boolean naoEncontrado = false;
		
		List<Operacoes> listaOperacoes = new ArrayList<Operacoes>();
		List<DadosMercado> listaMercado = new ArrayList<DadosMercado>();
		List<Resultado> listaResultado = new ArrayList<Resultado>();

		

		try  {
			
			FileReader fileMercado = new FileReader(arqMercado);
			FileReader fileOperacoes = new FileReader(arqOperacoes);

			BufferedReader lerMercado = new BufferedReader(fileMercado);
			BufferedReader lerOperacoes = new BufferedReader(fileOperacoes);

			String linhaMercado = lerMercado.readLine();
			String linhaOperacoes = lerOperacoes.readLine();

			String[] colsMercado = null;
			String[] colsOperacoes = null;

			linhaMercado = lerMercado.readLine();
			linhaOperacoes = lerOperacoes.readLine();
			System.out.println("Em Processamento");
			while (linhaMercado != null) {
				colsMercado = linhaMercado.split(";");
				linhaMercado = lerMercado.readLine();
				idPrecoMercado = Integer.parseInt(colsMercado[0]);
				nuPrazoDiasContados = Integer.parseInt(colsMercado[1]);
				vlPreco = Double.parseDouble(colsMercado[2].replace(",", "."));
				DadosMercado mercado = new DadosMercado(idPrecoMercado, nuPrazoDiasContados, vlPreco);
				listaMercado.add(mercado);
			}
			lerMercado.close();

			while (linhaOperacoes != null) {
				colsOperacoes = linhaOperacoes.split(";");
				linhaOperacoes = lerOperacoes.readLine();
				dtInicio = sdfDia.parse(colsOperacoes[1]);
				dtFim = sdfDia.parse(colsOperacoes[2]);
				prazo =  util.calcularDias(colsOperacoes[1], colsOperacoes[2]); 
				nmSubproduto = colsOperacoes[9];
				quantidade = Double.parseDouble(colsOperacoes[12].replace(",", "."));
				idPreco = Integer.parseInt(colsOperacoes[13]);
				Operacoes operacoes = new Operacoes(dtInicio, dtFim, nmSubproduto, quantidade, idPreco, prazo);
				listaOperacoes.add(operacoes);
			}
			lerOperacoes.close();

			for (Operacoes op : listaOperacoes) {
				naoEncontrado = true;
				for (DadosMercado merc : listaMercado) {
					if (merc.getNuPrazoDiasContados()  == op.getPrazo() && 	
						merc.getIdPreco() == op.getIdPreco())
					{
						listaResultado.add(new Resultado(op.getNmSubproduto(), (op.getQuantidade() * merc.getVlPreco())));
						naoEncontrado = false;
						break;
					} else {
						naoEncontrado = true;
					} 
				}
				if (naoEncontrado == true) {
					listaResultado.add(new Resultado(op.getNmSubproduto(), 0));
				}
				
			}
			
		   Collections.sort(listaResultado);

		   
		   for (Resultado resu : listaResultado) {
			   nomeAnterior = resu.getSubproduto();
			   nomeAtual = nomeAnterior;
			   soma = resu.getResultado();
			   break;
		   } 
		   
			BufferedWriter bufferWrite = new BufferedWriter (new FileWriter(arqSaida));
			bufferWrite.write("subproduto;resultado\n");
			
			
		   for (Resultado res : listaResultado) {
			   
			   nomeAtual =res.getSubproduto().toString(); 
			   if ( nomeAtual.equals(nomeAnterior) ) {
				  if (primeiro == false) {
					  soma = soma + res.getResultado();
				   } else {
					 primeiro = false; 
				   }
				   
				      
				   
			   } else {
				   bufferWrite.write(nomeAnterior+";"+ Double.toString(soma).replace(".", ",")+"\n");
				   soma = res.getResultado();
				   nomeAnterior = res.getSubproduto();
			   }
			   
			//   System.out.println(res.getSubproduto() + " " + res.resultado);
		   }
		   
		   bufferWrite.write(nomeAnterior+";"+ Double.toString(soma).replace(".", ",")+"\n");
			
		   bufferWrite.close();
		
			System.out.println("Saiu");

			

			
			

			
			
						
		} catch (Exception e) {
			System.err.printf("Erro: %s.\n", e.getMessage());
		}

		long stop = Calendar.getInstance().getTimeInMillis();
		long time = stop - start;
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.add(Calendar.SECOND, Integer.parseInt("" + (time / 1000)));
		System.out.println("Tempo de Processamento: " + sdf.format(cal.getTime()));

	}

}
