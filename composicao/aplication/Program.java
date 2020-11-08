package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Entre com o nome do departamento: ");
		String departamentName = sc.nextLine();
		System.out.println("Entre com os dados do usuario: ");
		System.out.println("Nome: ");
		String workerName = sc.nextLine();
		System.out.println("Nivel: ");
		String workerLevel = sc.nextLine();
		System.out.println("Salario: ");
	    Double workerSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), 
				workerSalary,new Departament(departamentName));
		
		System.out.print("Quantos contratos para este funcionario? ");
		int num = sc.nextInt();
			
		for (int i = 1; i <= num; i++) {
			System.out.print("Entre com os dados do contrato "+i+": ");
				System.out.print("Data (DD/MM/YYYY): ");
				Date dateContract = sf.parse(sc.next());
				System.out.print("Valor por hora: ");
				Double valuePerHour =sc.nextDouble();
				System.out.print("Duracao (horas): ");
				int hour = sc.nextInt();
				HourContract contract = 
						new HourContract(dateContract, valuePerHour, hour);
				worker.addContract(contract);
		}
		
		System.out.println();
		
		System.out.println("Entre com o mes e ano para calcular a renda (MM/YYYY): ");
		String mesAno = sc.next();
		Integer mes = Integer.parseInt(mesAno.substring(0, 2));
		Integer ano = Integer.parseInt(mesAno.substring(3));
		System.out.println("Nome: "+ worker.getName());
		System.out.println("Departamento: "+ worker.getDepartament().getName());
		System.out.println("Renda para "+mesAno+" : " + String.format("%.2f", worker.income(ano, mes)));
		
		sc.close();
	}

}
