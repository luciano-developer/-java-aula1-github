package exceptionModel.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public Long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checkin, Date checkout) {
		Date now = new Date();
		if (checkin.after(now) || checkout.after(now)) {
			return "datas de reserva nao podem ser menor que a data corrente";
		}
		if (!checkout.after(checkin)) {
			return "data de saida deve ser depois da data de entrada";
		} 
		this.checkin = checkin;
		this.checkout = checkout;
		return null;
	}
		
	@Override
	public String toString() {
		return "Reserva: quarto " + roomNumber + ", checkin: " + sdf.format(checkin) + ", "
				+ "checkout: " + sdf.format(checkout) + ", duracao: " + duration() + " nigths";
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Reservation() {
		// TODO Auto-generated constructor stub
	}

}
