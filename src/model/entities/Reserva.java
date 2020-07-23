package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer numeroDoQuarto;
	private Date entrada;
	private Date saida;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva() {

	}

	public Reserva(Integer numeroDoQuarto, Date entrada, Date saida) {
		this.numeroDoQuarto = numeroDoQuarto;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Integer getNumeroDoQuarto() {
		return numeroDoQuarto;
	}

	public Date getEntrada() {
		return entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public long duracao() {
		long dif = saida.getTime() - entrada.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}

	public String atualizarData(Date entrada, Date saida) {
		
		Date agora = new Date();
		if (entrada.before(agora) || saida.before(agora)) {
			return "Datas das reservas devem ser datas futuras ";
		}
		if(!saida.after(entrada)) {
			return "Data de saida dever ser depois da data de entrada";
		}
		this.entrada = entrada;
		this.saida = saida;
		return null;
	}

	@Override
	public String toString() {
		return "Quarto: " + this.numeroDoQuarto + ", Entrada: " + sdf.format(entrada) + ", Saida: " + sdf.format(saida)
				+ ", Duração: " + duracao() + " noites";
	}

}
