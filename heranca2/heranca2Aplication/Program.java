package heranca2Aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import heranca2Entities.ImportedProduct;
import heranca2Entities.Product;
import heranca2Entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> products = new ArrayList<Product>();
		
		System.out.println("Entre com os numeros de produtos:");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Dados do Produto #" + i + ":");
			System.out.println("Comum, Usado ou Importado (c/u/i)? ");
			char ch = sc.next().charAt(0);

			System.out.println("Nome:");
			String name = sc.next();

			System.out.println("Preco:");
			double price = sc.nextDouble();

			switch (ch) {
			case 'c':
				products.add(new Product(name, price));
				break;			
			case 'u':
				System.out.println("Data de fabricacao (dd/MM/yyyy):");
				Date date = sdf.parse(sc.next());
				products.add(new UsedProduct(name, price, date));
				break;
			case 'i':
				System.out.println("Taxa personalizada:");
				Double cFee = sc.nextDouble();
				products.add(new ImportedProduct(name, price, cFee));
				break;
			default:
				products.add(new Product(name, price));
				break;
			}
		}

		System.out.println();
		System.out.println("TAGs de precos:");

		for (Product product : products) {
			System.out.println(product.priceTag());
		}
		
		sc.close();
	}

}
