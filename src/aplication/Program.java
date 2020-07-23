package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		

		try {
			System.out.print("Numero do quarto: ");
			int num = sc.nextInt();
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			Date entrada = sdf.parse(sc.next());
			System.out.print("Data de saida: ");
			Date saida = sdf.parse(sc.next());
	
			
			Reserva reserva = new Reserva(num, entrada, saida);
			System.out.println("Reserva: " + reserva);
	
			System.out.println();
			System.out.println("Entre com a data atualizada: ");
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			entrada = sdf.parse(sc.next());
			System.out.print("Data de saida: ");
			saida = sdf.parse(sc.next());
	
			
			reserva.atualizarData(entrada, saida);
			System.out.println("Reserva: " + reserva.toString());
		}
		catch(ParseException e) {
			System.out.println("Formato da data  invalida");
		}
		catch(DomainException e) {
			System.out.println("Erro na Reserva: "+ e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado");
		}

		sc.close();
	}

}
