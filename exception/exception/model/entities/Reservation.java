package exception.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import exception.model.exceptions.DomainException;

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
	
	public void updateDates(Date checkin, Date checkout) throws DomainException {
		Date now = new Date();
		if (checkin.after(now) || checkout.after(now)) {
			throw new DomainException("datas de reserva nao podem ser menor que a data corrente");
		}
		if (!checkout.after(checkin)) {
			throw new DomainException("data de saida deve ser depois da data de entrada");
		} 
		this.checkin = checkin;
		this.checkout = checkout;		
	}
		
	@Override
	public String toString() {
		return "Reserva: quarto " + roomNumber + ", checkin: " + sdf.format(checkin) + ", "
				+ "checkout: " + sdf.format(checkout) + ", duracao: " + duration() + " nigths";
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainException {
		if (!checkout.after(checkin)) {
			throw new DomainException("data de saida deve ser depois da data de entrada");
		} 
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Reservation() {
		// TODO Auto-generated constructor stub
	}

}
