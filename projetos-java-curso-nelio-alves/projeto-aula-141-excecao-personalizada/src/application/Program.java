package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/mm/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/mm/yyyy): ");
		Date checkout = sdf.parse(sc.next());
		//parse é uma chamada que pode lançar uma exceção, logo
		//ela precisará ser tratada (try/catch) ou propagada no método que ...
		//ela se encontra, nesse exemplo iremos propagá-la no método ...
		//adicionando a declaração throws e o tipo da exceção, isto é o ...
		//método passa a lançar essa exceção que deverá ser tratada por ...
		//algum outro método que venha fazer alguma chamada a esse método;
		
		//depois de todos os dados lançados teremos que instanciar a reserva
		//porém a reserva não pode ser instanciada se a data de checkout ...
		//for posterior a data de checkin ...
		//para isso faremos um teste...
		//vai testar se a data do checkout não é depois do checkin
		if(!checkout.after(checkin)) {
			//se a data checkin for antes do checkout o sistema exibirá a msg abaixo
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			//caso contrário ... a reserva poderá ser instanciada 
			Reservation r = new Reservation(number, checkin, checkout);
			//e impressa na tela
			System.out.println(r);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/mm/yyyy): ");
			checkout = sdf.parse(sc.next());
			
			//nao poderei atualizar as datas se não forem datas futuras...
			//e tb nao poderei atualizar se o checkout for antes do checkin
			Date date = new Date();
			if(checkin.before(date) || checkout.before(date)) {
				System.out.println
				("Error in reservation: Reservation dates for update must be future dates");
			} else if (!checkout.after(checkin)){
				System.out.println
				("Error in reservation: Check-out date must be after check-in date");
			} else {
				r.updateDates(checkin, checkout);
				System.out.println(r);
			}
			
			
		}

		sc.close();

	}

}
