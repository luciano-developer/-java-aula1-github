import java.util.Date;

import entities.Order;
import entities.enums.OrderStatus;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ola mundo");
		System.out.println("bom dia");
		
		OrderStatus os1 = OrderStatus.DELIVERED;
		OrderStatus os2 = OrderStatus.valueOf("SHIPPED");
		System.out.println(os1);
		System.out.println(os2);
		
		Order pedido = new Order(1080, new Date(), os1);
		System.out.println(pedido);
	}

}
