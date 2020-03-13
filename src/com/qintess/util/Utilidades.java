package com.qintess.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades {

	public int calcularDias(String dtInicio, String dtFim) {
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		Date dataIni = null;
		Date dataFim = null;
		try {
			dataIni = sdf.parse(dtInicio);
			dataFim = sdf.parse(dtFim);
		} catch (Exception e) {

		}
		long qtdMils = (dataFim.getTime() - dataIni.getTime()) + 3600000; // 1 hora para compensar horário de verão
		int dias = (int) (qtdMils / 86400000L);
		return dias;
	}
}
