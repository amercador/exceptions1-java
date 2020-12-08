package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	//o SimpleDateFormat será declarado como static para que não seja
	//instanciado um novo SimpleDateFormat para cada objeto Reservation 
	//que a aplicação tiver;
	
	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getCheckin() {
		return checkin;
	}
	/*public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}*/
	public Date getCheckout() {
		return checkout;
	}
	/*public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}*/
	
	//os métodos set checkin e checkout foram apagadas para não deixarem ...
	//as datas serem alteradas arbritáriamente;
	//esses atributos serão alterados pelos métodos apropriados
	
	//método para calcular a duração de dias do hospede no hotel
	//terá que calcular a diferença entre duas datas (checkin e checkout) em milisegundos
	
	public long duration() {
	//declara uma variavel long que vai receber a data de checkout
	//com a função gettime que retorna a qtde em milisegunda(long) 
	//daquela data menos o checkin tb com a função gettime; 
		long dif = checkout.getTime() - checkin.getTime();
		
		//com a diferenca de dias em milisegundos, 
		//teremos que fazer a conversão para dias;
		//e fazer o método retornar esse valor
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkin, Date checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ " Check-in: "
				+ sdf.format(checkin)
				+ ", Check-out: "
				+ sdf.format(checkout)
				+ ", "
				+ duration()
				+ " nights";
		
	}

}
