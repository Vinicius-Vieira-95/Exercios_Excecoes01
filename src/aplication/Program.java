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
		System.out.println("Data de saida: ");
		Date saida = sdf.parse(sc.next());
		
		if(!saida.after(entrada)){
			System.out.println("Erro na reserva, a data de saida dever ser depos da data de entrada");
		}
		else {
			Reserva reserva = new Reserva(num, entrada, saida);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Entre com a data atualizada: ");
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			entrada = sdf.parse(sc.next());
			System.out.println("Data de saida: ");
			saida = sdf.parse(sc.next());
			
			Date agora = new Date();
			if(entrada.before(agora) || saida.before(agora)) {
				System.out.println("Erro na reserva: Datas das reservas devem ser datas futuras ");
			}
			else if(!saida.after(entrada)){
				System.out.println("Erro na reserva, a data de saida dever ser depos da data de entrada");
				
			}
			else {
				reserva.atualizarData(entrada, saida);
				System.out.println("Reserva: " +reserva);
			}
			
		}
		
		
		
		
		
		
		sc.close();
	}

}
