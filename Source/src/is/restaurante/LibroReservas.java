package is.restaurante;

import java.util.ArrayList;
import java.util.Date;
import is.Fecha;
import is.List;

/**
 * Clase que guarda todas las reservas
 * 
 * @author JaimeDan
 * 
 */
public class LibroReservas {
	/**
	 * Constructor
	 */
	public LibroReservas() {
		listaReservas = new List<Reserva>();
		numeroReservas = 0;
	}

	public boolean addReserva(Reserva res) {
		numeroReservas++;
		return listaReservas.add(res);

	}

	public ArrayList<ReservaInfo> reservasHoy() {
		Date date = new Date();
		Fecha fecha = new Fecha(0, 0, 0, 0, 0);
		fecha.parse(date.toString(), 0, 0);
		ArrayList<ReservaInfo> reservasDeHoy = new ArrayList<ReservaInfo>();
		reservasDeHoy = buscarReservaHoy(fecha);
		return reservasDeHoy;

	}

	public ArrayList<ReservaInfo> reservasSemana() {
		Date date = new Date();

		Fecha fecha = new Fecha(0, 0, 0, 0, 0); // new Date (hoy) o algo asi
		fecha.parse(date.toString(), 0, 0);
		ArrayList<ReservaInfo> reservasSemana = new ArrayList<ReservaInfo>();
		reservasSemana = buscarReservaSemana(fecha);
		return reservasSemana;

	}

	public ArrayList<ReservaInfo> reservasMes() {
		Date date = new Date();
		Fecha fecha = new Fecha(0, 0, 0, 0, 0); // new Date (hoy) o algo asi
		fecha.parse(date.toString(), 0, 0);
		ArrayList<ReservaInfo> reservasMes = new ArrayList<ReservaInfo>();
		reservasMes = buscarReservaMes(fecha);
		return reservasMes;

	}

	public boolean eliminarReserva(Reserva res) {
		numeroReservas--;
		return listaReservas.erase(res);
	}/*
	 * 
	 * Ya me parecia a mi que esta puta mierda no iba a funcionar xD jajajaj xD
	 * public ArrayList<Reserva> buscarReserva(String nombre){
	 * ArrayList<Reserva> reservas = new ArrayList<Reserva>(); for (int i = 0; i
	 * <numeroReservas; i++){ reservas.add(listaReservas.get(new Reserva(null,
	 * 0, 59, nombre, 0, null))); } return reservas; }
	 */

	/**
	 * Por que coño ahora esto es con integers? De donde sacas entonces la
	 * reserva para poder mostrarla en verReserva??
	 */
	public/* int */ArrayList<ReservaInfo> buscarReserva(String nombre) {
		ArrayList<ReservaInfo> listaRes = new ArrayList<ReservaInfo>();
		int i = 0;
		while (i < listaReservas.size()) {
			if (listaReservas.get(i).getNombre().equals(nombre))
				;
			// i++;
			listaRes.add(listaReservas.get(i));
		}
		// if (i < listaReservas.size()) return i;
		/* else */return listaRes;
	}

	public ArrayList<ReservaInfo> todasReservas() {
		ArrayList<ReservaInfo> listaRes = new ArrayList<ReservaInfo>();
		for (int i = 0; i < this.numeroReservas; i++)
			listaRes.add(this.listaReservas.get(i));
		return listaRes;
	}

	public/* int */ArrayList<ReservaInfo> buscarReserva(int j) {
		if (j == -1)
			return todasReservas();
		if (j == 0)
			return reservasHoy();
		else if (j == 1)
			return reservasSemana();
		else if (j == 2)
			return reservasMes();
		return null;
		/*
		 * int i=0; while (i<listaReservas.size()){ if
		 * (listaReservas.get(i).getNombre().equals(nombre)) ; //i++;
		 * listaRes.add(listaReservas.get(i)); } //if (i < listaReservas.size())
		 * return i; //else return listaRes;
		 */
	}

	public ArrayList<ReservaInfo> buscarReservaHoy(Fecha date) {
		ArrayList<ReservaInfo> reservasHoy = new ArrayList<ReservaInfo>();
		for (int i = 0; i < listaReservas.size(); i++) {
			if (listaReservas.get(i).getFecha().mismoDia(date))
				reservasHoy.add(listaReservas.get(i));
		}
		return reservasHoy;
	}

	public ArrayList<ReservaInfo> buscarReservaSemana(Fecha dateInicial) {
		ArrayList<ReservaInfo> reservasSemana = new ArrayList<ReservaInfo>();
		// Fecha dateTope = new Fecha(dateInicial.getAño(),
		// dateInicial.getMes(), dateInicial.getDia(), dateInicial.getHora(),
		// dateInicial.getMinutos());
		// dateTope = dateTope.siguienteSemana();//
		Fecha dateTope = dateInicial.siguienteSemana();
		for (int i = 0; i < listaReservas.size(); i++) {
			if (!listaReservas.get(i).getFecha().esMayorQue(dateTope)
					&& (listaReservas.get(i).getFecha().esMayorQue(dateInicial) || listaReservas
							.get(i).getFecha().mismoDia(dateInicial)))
				reservasSemana.add(listaReservas.get(i));
		}
		return reservasSemana;
	}

	public ArrayList<ReservaInfo> buscarReservaMes(Fecha dateInicial) {
		ArrayList<ReservaInfo> reservasSemana = new ArrayList<ReservaInfo>();
		Fecha dateTope = dateInicial.siguienteMes();
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < listaReservas.size(); i++) {
				if (!listaReservas.get(i).getFecha().esMayorQue(dateTope)
						&& (listaReservas.get(i).getFecha()
								.esMayorQue(dateInicial) || listaReservas
								.get(i).getFecha().equals(dateInicial)))
					reservasSemana.add(listaReservas.get(i));
				dateInicial = dateInicial.siguienteSemana();
				dateTope = dateTope.siguienteSemana();

			}
		}
		return reservasSemana;
	}

	private List<Reserva> listaReservas;
	private int numeroReservas;// TODO creo que numero reservas se puede ver con
								// listaReservas.size();

	public ArrayList<ReservaInfo> buscarReserva(Fecha fecha) {
		// TODO Auto-generated method stub
		return null;
	}
}
