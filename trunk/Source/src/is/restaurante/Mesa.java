package is.restaurante;

import java.util.ArrayList;
import java.util.Vector;

public class Mesa {
	public Mesa(int num){
		this.setNumeroMesa(num);
	}
	
	public void addPedido(Comanda comanda){
		pedidos.add(comanda);
		//pedidos.
	}
	
//TODO editComanda, selectComanda delete Comanda
	
	
	public int getNumeroMesa() {
		return numeroMesa;
	}
	
	public void setNumeroMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}
	public String generarFactura(){
		return pedidos.toString();
	}
	

	private Vector<Comanda> pedidos;
	private int numeroMesa;
	private int capacidadMaxima;
}