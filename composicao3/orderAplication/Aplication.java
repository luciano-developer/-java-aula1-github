package orderAplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import orderEntities.Client;
import orderEntities.Order;
import orderEntities.OrderItem;
import orderEntities.Product;
import orderEntities.enums.OrderStatus;

public class Aplication {
	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Entre com os dados do cliente:");

		System.out.println("Nome: ");
		String name = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.nextLine();
		System.out.println("Aniversario: ");		
		Date date = sdf.parse(sc.next());

		Client client = new Client(name, email, date);

		System.out.println("Entre com os dados do pedido: ");
		System.out.println("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		System.out.println("Quantos itens para este pedido? ");
		int count = sc.nextInt();
		
		Order order = new Order(new Date(), status, client);

		for (int i = 1; i <= count; i++) {
			System.out.println("Entre com os dados do #" + i + " item: ");
			System.out.println("Nome do Produto: ");
			String nameProduct = sc.next();
			System.out.println("Preco do Produto: ");
			Double price = sc.nextDouble();
			System.out.println("Quantida: ");
			int quantity = sc.nextInt();

			Product p = new Product(nameProduct, price);
			OrderItem orderItem = new OrderItem(quantity, price, p);
			order.addItem(orderItem);
		}

		System.out.println(order.toString());
		sc.close();
		
//		Client client = new Client("Alex", "alex@gmail.com", sdf.parse("15/03/1985"));
//		Product p1 = new Product("TV", 1000.0);
//		Product p2 = new Product("Mouse", 40.0);
//
//		OrderItem oi1 = new OrderItem(1, 1000.0, p1);
//		OrderItem oi2 = new OrderItem(2, 40.0, p2);
//
//		oi1.subTotal();
//		oi2.subTotal();
//
//		Order order = new Order(new Date(), OrderStatus.PENDENTE_PAGAMENTO);
//		order.addItem(oi1);
//		order.addItem(oi2);
//		order.getTotal();



	}
}
