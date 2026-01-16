package es.studium;

import java.util.Random;

public class Arma {

	private String nombre;
	private int mindmg;
	private int maxdmg;
	private int durabilidad;
	
	public Arma() {
		this.nombre = "";
		this.mindmg = 0;
		this.maxdmg = 0;
		this.durabilidad = 100;
	}
	
	public Arma(String nombre, int mindmg, int maxdmg, int durabilidad) {
		this.nombre = nombre;
		this.mindmg = mindmg;
		this.maxdmg = maxdmg;
		this.durabilidad = durabilidad;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getMindmg() {
		return this.mindmg;
	}
	public int getMaxdmg() {
		return this.maxdmg;
	}
	
	public int getDurabilidad() {
		return this.durabilidad;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setMindmg(int mindmg) {
		this.mindmg = mindmg;
	}
	public void setMaxdmg(int maxdmg) {
		this.maxdmg = maxdmg;
	}
	
	public void setDurabilidad(int durabilidad) {
		this.durabilidad = durabilidad;
	}

	public int atacar(Armadura armadura) {
		Random aleatorio = new Random();
		int ataque;
		ataque = aleatorio.nextInt((maxdmg-mindmg)+1)+mindmg;
		if (ataque <= armadura.getResistencia()){
			armadura.setDurabilidad(armadura.getDurabilidad() - 5);
			this.durabilidad = this.durabilidad -5;
		}
		else {
			
			armadura.setDurabilidad(armadura.getDurabilidad() - 10);
		}
		
		return ataque;
	}
	
	public void mostrarStats() {
	    System.out.println("ARMA: " + getNombre() + " |DAÑO:  " + getMindmg() + " ~ " + getMaxdmg() + " |DURABILIDAD: " + getDurabilidad());
	}
	
	public void reparar() {
        this.durabilidad = 100;
    }


}
