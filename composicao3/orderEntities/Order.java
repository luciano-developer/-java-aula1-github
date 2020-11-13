package orderEntities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import orderEntities.enums.OrderStatus;

public class Order {
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date moment;
	private OrderStatus status;
	private List<OrderItem> items = new ArrayList<OrderItem>();
	private Client client;
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Order() {
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public Client getClient() {
		return client;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}

	public Double getTotal() {
		double sum = 0;
		for (OrderItem orderItem : items) {
			sum += orderItem.subTotal();
		}

		return sum;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Resumo do Pedido: \n");
		builder.append("Momento do Pedido: " + sdf.format(moment)+ "\n");
		builder.append("Status: " + status+ "\n");
		builder.append(client.toString()+ "\n");		
		builder.append("Itens: "+ "\n");		
		for (OrderItem orderItem : items) {
			builder.append(orderItem.toString()+"\n");
		}
		builder.append("\n");
		builder.append("Total: " + String.format("%.2f", getTotal()));		
		return builder.toString();
	}
	
	
}
