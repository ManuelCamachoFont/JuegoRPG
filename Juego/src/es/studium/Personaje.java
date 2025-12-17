package es.studium;

public class Personaje {

	private String nombre;
	private String raza;
	private Arma arma;
	private Armadura armadura;
	private int fuerza;
	private int velocidad;
	private int vida;
	
	public Personaje() {
		this.nombre = "";
		this.raza = "";
		this.arma = new Arma();
		this.armadura = new Armadura();
		this.fuerza = 0;
		this.velocidad = 0;
		this.vida = 0;	
	}
	
	public Personaje(String nombre, String raza, Arma arma, Armadura armadura, int fuerza, int velocidad, int vida) {
		this.nombre = nombre;
		this.raza = raza;
		this.arma = arma;
		this.armadura = armadura;
		this.fuerza = fuerza;
		this.velocidad = velocidad;
		this.vida = vida;		
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getRaza() {
		return this.raza;
	}
	
	public Arma getArma() {
		return this.arma;
	}
	
	public Armadura getArmadura() {
		return this.armadura;
	}
	
	public int getFuerza() {
		return this.fuerza;
	}
	
	public int getVelocidad() {
		return this.velocidad;
	}
	
	public int getVida() {
		return this.vida;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setRaza(String raza) {
		this.raza = raza;
	}
	
	public void setArma (Arma arma) {
		this.arma = arma;
	}
	
	public void setArmadura(Armadura armadura) {
		this.armadura = armadura;
	}
	
	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	
}
