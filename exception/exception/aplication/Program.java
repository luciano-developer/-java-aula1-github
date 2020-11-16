package exception.aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import exception.model.entities.Reservation;
import exception.model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Numero do quarto: ");
			int num = sc.nextInt();
			System.out.print("Data de entrada: ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Data de saida: ");
			Date checkout = sdf.parse(sc.next());

//		if (!checkout.after(checkin)) {
//			System.out.println("Erro na reserva: data de saida deve ser depois da data de entrada");

			Reservation r = new Reservation(num, checkin, checkout);

			System.out.println();
			System.out.println(r.toString());

			System.out.println();
			System.out.print("Entre com as datas atualizadas: ");
			System.out.print("Data de entrada: ");
			checkin = sdf.parse(sc.next());
			System.out.print("Data de saida: ");
			checkout = sdf.parse(sc.next());

			r.updateDates(checkin, checkout);

			System.out.println(r.toString());
		} catch (ParseException e) {
			System.out.println("Data no formato invalido");
		} catch (DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("erro inesperado");
		} finally {
			sc.close();
		}
	}

}
