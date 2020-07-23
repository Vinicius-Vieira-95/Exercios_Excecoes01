package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Numero do quarto: ");
		int num = sc.nextInt();
		System.out.print("Data de entrada (dd/MM/yyyy): ");
		Date entrada = sdf.parse(sc.next());
		System.out.print("Data de saida: ");
		Date saida = sdf.parse(sc.next());

		if (!saida.after(entrada)) {
			System.out.println("Erro na reserva, a data de saida dever ser depois da data de entrada");
		} else {
			Reserva reserva = new Reserva(num, entrada, saida);
			System.out.println("Reserva: " + reserva);

			System.out.println();
			System.out.println("Entre com a data atualizada: ");
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			entrada = sdf.parse(sc.next());
			System.out.print("Data de saida: ");
			saida = sdf.parse(sc.next());

			
			String erro = reserva.atualizarData(entrada, saida);
			if(erro != null) {
				System.out.println("Erro na Reserva: "+erro);
			}
			else {
				System.out.println("Reserva: " + reserva.toString());
			}
		}

		sc.close();
	}

}
