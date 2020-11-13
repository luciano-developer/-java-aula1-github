package herancaAplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import herancaEntities.Employee;
import herancaEntities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Employee> employies = new ArrayList<Employee>();

		System.out.println("Entre com o numero de funcionarios: ");
		int countFunc = sc.nextInt();
		
		for (int i = 1; i <= countFunc; i++) {
			System.out.println("Dados do Funcionario #" + i);
			System.out.println("Terceirizado (s/n)? ");
			char terc = sc.next().toLowerCase().charAt(0);
			System.out.println("Nome:");
			String nome = sc.next();
			System.out.println("Horas:");
			int hours = sc.nextInt();
			System.out.println("Valor por hora:");
			Double valuePerHour = sc.nextDouble();
			Double addictional = 0d;
			if (terc == 's') {
				System.out.println("Bonus Adicional:");
				addictional = sc.nextDouble();
				employies.add(new OutsourcedEmployee(nome, hours, valuePerHour, addictional));
			} else
				employies.add(new Employee(nome, hours, valuePerHour));
				
		}
		System.out.println();
		System.out.println("Pagamentos:");

		for (Employee em : employies) {
			System.out.println(em.toString());
		}

		sc.close();
	}

}
