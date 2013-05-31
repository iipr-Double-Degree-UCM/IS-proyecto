package is.restaurante;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import is.Fecha;
import is.List;
public class LibroReservas {
	/**
	 * Constructor
	 */
	public LibroReservas(){
		listaReservas = new List<Reserva>();
		numeroReservas = 0;
	}
	
	
	public boolean addReserva(Reserva res){
		numeroReservas++;
		return listaReservas.add(res);

	}
	
	public ArrayList<Reserva> reservasHoy(){
		Date date = new Date();
		Fecha fecha = new Fecha(0, 0, 0, 0, 0); //new Date (hoy) o algo asi
		ArrayList<Reserva> reservasDeHoy = new ArrayList<Reserva>();
		buscarReserva(fecha);
		Fecha hoy = new Fecha(date.getYear(),
		date.getMonth(),
		date.getDay(),
		date.getHours(),
		date.getMinutes());
		for (int i=0; i< listaReservas.size(); i++){
			if (listaReservas.get(i).equals(hoy))
				reservasDeHoy.add(listaReservas.get(i));
		}
		
		
		
		return reservasDeHoy;
		
	}

	public boolean eliminarReserva(Reserva res){
		numeroReservas--;
		return listaReservas.erase(res);
	}/*
	
	Ya me parecia a mi que esta puta  mierda no iba a funcionar xD
	jajajaj xD
	public ArrayList<Reserva> buscarReserva(String nombre){
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		for (int i = 0; i <numeroReservas; i++){
			reservas.add(listaReservas.get(new Reserva(null, 0, 59, nombre, 0, null)));
		}
		return reservas;
	}*/
	
	public int buscarReserva(String nombre){
		int i=0;
		while (i<listaReservas.size()){
			if (listaReservas.get(i).getNombre().equals(nombre)) break;
			i++;
		}
		if (i < listaReservas.size()) return i;
		else return -1;
	}
	
	public ArrayList<Reserva> buscarReserva(Fecha date){
		ArrayList <Reserva> reservasHoy = new ArrayList<Reserva>();
		for ( int i = 0; i < listaReservas.size(); i++){
			if (listaReservas.get(i).getFecha().equals(date)) reservasHoy.add(listaReservas.get(i));
		}
		return reservasHoy;
	}
	
	
	private List<Reserva> listaReservas;
	private int numeroReservas;//TODO creo que numero reservas se puede ver con listaReservas.size();
}
