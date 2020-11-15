package exceptionAplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import exceptionModel.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Numero do quarto: ");
		int num = sc.nextInt();
		System.out.print("Data de entrada: ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Data de saida: ");
		Date checkout = sdf.parse(sc.next());

		if (!checkout.after(checkin)) {
			System.out.println("Erro na reserva: data de saida deve ser depois da data de entrada");
		} else {
			Reservation r = new Reservation(num, checkin, checkout);

			System.out.println();
			System.out.println(r.toString());

			System.out.println();
			System.out.print("Entre com as datas atualizadas: ");
			System.out.print("Data de entrada: ");
			checkin = sdf.parse(sc.next());
			System.out.print("Data de saida: ");
			checkout = sdf.parse(sc.next());

			Date now = new Date();
			if (checkin.after(now) || checkout.after(now)) {
				System.out.println("Erro na reserva: datas de reserva nao podem ser menor que a data corrente");
			} else if (!checkout.after(checkin)) {
				System.out.println("Erro na reserva: data de saida deve ser depois da data de entrada");
			} else {

				r.updateDates(checkin, checkout);
				System.out.println(r.toString());
			}
		}
		sc.close();
	}

}
