package exception2.aplication;

import java.util.Scanner;

import exception2.model.entities.Account;
import exception2.model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Entre com os dados da conta: ");
			System.out.print("Numero:");
			int number = sc.nextInt();
			System.out.print("Correntista: ");
			String holder = sc.next();
			System.out.print("Saldo inicial: ");
			double balance = sc.nextDouble();
			System.out.print("Limite saque: ");
			double withdrawLimit = sc.nextDouble();
			
			System.out.println();
			System.out.print("Entre com o valor de saque: ");
			double amountWithdraw = sc.nextDouble();
			
			Account acc = new Account(number, holder, balance, withdrawLimit);
			acc.withDraw(amountWithdraw);
			
			System.out.print("Saldo atualizado: ");
			System.out.print(String.format("%.2f%n", acc.getBalance()));
		} catch (DomainException e) {
			System.out.println(e.getMessage());
		}catch (RuntimeException e) {
			System.out.println("erro inesperado");
		} finally {
			sc.close();
		}
		
	}

}
