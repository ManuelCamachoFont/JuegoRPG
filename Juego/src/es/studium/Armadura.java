package es.studium;

public class Armadura {
	
	private String nombre;
	private int resistencia;
	private int durabilidad;
	
	public Armadura() {
		this.nombre = "";
		this.resistencia = 0;
		this.durabilidad = 100;
	}
	
	public Armadura(String nombre, int resistencia, int durabilidad) {
		this.nombre = nombre;
		this.resistencia = resistencia;
		this.durabilidad = durabilidad;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getResistencia() {
		return this.resistencia;
	}
	
	public int getDurabilidad() {
		return this.durabilidad;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}
	
	public void setDurabilidad(int durabilidad) {
		this.durabilidad = durabilidad;
	}

	public void mostrarStats() {
	    System.out.println("ARMADURA: " + getNombre() + " |RESISTENCIA:  " + getResistencia() + " |DURABILIDAD: " + getDurabilidad());
	}
}
