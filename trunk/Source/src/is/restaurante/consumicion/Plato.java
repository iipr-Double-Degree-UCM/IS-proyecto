package is.restaurante.consumicion;

public class Plato implements Consumicion{
	
	public Plato(){
		
	}

	/**
	 * Constructor de un plato
	 * @param descripción: descripción del plato
	 * @param nombre: nombre del plato
	 * @param precio: precio del plato
	 */
	public Plato(String nombre, float precio, boolean disp, String descripción){
		this.descripción = descripción;
		this.nombre = nombre;
		this.precio = precio;
		this.disponible = disp;
	}
	


	@Override
	public String getDescripcion() {
		return this.descripción;
	}
	
	/**
	 * 
	 * @return precio del plato
	 */
	@Override
	public float getPrecio() {
		return precio;
	}

	/**
	 * Precio que queremos que tenga el plato
	 * @param precio
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	/**
	 * comprueba si el plato está disponible
	 * @return disponible si el plato está disponible
	 */
	@Override
	public boolean isDisponible() {
		return disponible;
	}

	/**
	 * marca la disponibilidad de un plato
	 * @param 
	 */
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	@Override
	public String getNombre(){
		return this.nombre;
	}



	private String descripción;
	private String nombre;
	private float precio;
	private boolean disponible;
	

}
