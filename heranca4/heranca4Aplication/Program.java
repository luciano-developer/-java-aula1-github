package heranca4Aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import heranca4Entities.PF;
import heranca4Entities.PJ;
import heranca4Entities.Pessoa;
import heranca4Entities.enums.TipoPessoa;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Pessoa> contribuintes = new ArrayList<Pessoa>();
		
		System.out.print("Entre com o numero de contribuintes: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.print("Pessoa Fisica/Juridica (F/J)?");
			TipoPessoa tp = TipoPessoa.valueOf(sc.next().toUpperCase());
			System.out.print("Nome: ");
			String nome = sc.next();
			System.out.print("Renda: ");
			double renda = sc.nextDouble();
			if(tp==TipoPessoa.F)
			{
				System.out.print("Gastos saude: ");
				double gs = sc.nextDouble();
				contribuintes.add(new PF(nome, renda, gs));
			}else if(tp==TipoPessoa.J){
				System.out.print("Numero de funcionarios: ");
				int numFuncionarios = sc.nextInt();
				contribuintes.add(new PJ(nome, renda, numFuncionarios));
			}
		}
		
		System.out.println();
		System.out.println("Arrecadacao:");
		double sum = 0;
		for (Pessoa pessoa : contribuintes) {
			sum += pessoa.calculoImposto();
			System.out.println("Imposto pago por "+ pessoa.getNome() + ": " + String.format("%.2f",pessoa.calculoImposto()));
		}
		
		System.out.println("Total: " + String.format("%.2f",sum));
		
		
		
		sc.close();
	}

}
