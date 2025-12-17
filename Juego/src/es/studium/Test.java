package es.studium;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Arma[] armas = new Arma[7];
		
		armas[0] = new Arma("Palo", 1, 10, 20);
		armas[1]= new Arma("Daga", 10, 30, 100);
		armas[2] = new Arma("Espada corta", 20, 40, 100);
		armas[3]= new Arma("Hacha", 30, 80, 100);
		armas[4] = new Arma("Maza", 20, 50, 100);
		armas[5] = new Arma("Lanza", 15, 40, 100);
		armas[6] = new Arma("Espadón", 40, 95, 100);
		
		Armadura[] armaduras = new Armadura[7];
		
		armaduras[0] = new Armadura("Nada", 0, 25);
		armaduras[1] = new Armadura("Coraza", 35, 100);
		armaduras[2] = new Armadura("Cota de malla", 40, 100);
		armaduras[3] = new Armadura("Ropas de cuero", 10, 100);
		armaduras[4] = new Armadura("Armadura mágica", 50, 100);
		armaduras[5] = new Armadura("Armadura pesada", 65, 100);
		armaduras[6] = new Armadura("Armadura Legendaria", 80, 100);
		
		Personaje[] personajes = new Personaje[6];
		personajes[0] = new Personaje("Pepe", "Humano", armas[0], armaduras[6], 10, 10, 100);
		personajes[1] = new Personaje("Gnome Mates", "Goblin", armas[2], armaduras[2], 20, 20, 75);
		personajes[2] = new Personaje("Pepe", "Elfo", armas[1], armaduras[4], 10, 30, 120);
		personajes[3] = new Personaje("Pepe", "Troll", armas[4], armaduras[0], 40, 10, 200);
		personajes[4] = new Personaje("Enano", "Enano", armas[3], armaduras[5], 20, 10, 140);
		personajes[5] = new Personaje("Sir Pent", "Reptiliano", armas[5], armaduras[3], 10, 20, 110);
		

        Scanner teclado = new Scanner(System.in);
        char salir;
        
        do {
        	System.out.println("CAMPO DE PRUEBAS");
        	System.out.println("");
        	
        	for (int i = 0; i < armas.length; i++) {
        		String nombrearma = armas[i].getNombre();
        		String formateada1 = String.format("%-13s", nombrearma);
        		System.out.println("ARMA: " + formateada1 + " |DAÑO:  " + armas[i].getMindmg() + " ~ " + armas[i].getMaxdmg() + " |DURABILIDAD: " + armas[i].getDurabilidad());
        		
        	}
        	
        	System.out.println("\nELIGE UN ARMA");
        	for (int i = 0; i < armas.length; i++) {
            System.out.println(i + " - " + armas[i].getNombre());
        	}
        
        	int opcionArma = teclado.nextInt();
          
        	while (opcionArma < 0 || opcionArma >= armas.length) {
        		System.out.println("Opción inválida. Elige otra:");
        		opcionArma = teclado.nextInt();
        	}
        	
        	System.out.println("\nElegiste \"" + armas[opcionArma].getNombre() + "\"");
        	Arma armaElegida = armas[opcionArma];
        	System.out.println("");
        	
        	for (int i = 0; i < armaduras.length; i++) {
        		String nombrearmadura = armaduras[i].getNombre();
        		String formateada2 = String.format("%-20s", nombrearmadura);
        		System.out.println("ARMADURA: " + formateada2 + " |RESISTENCIA:  " + armaduras[i].getResistencia() + " |DURABILIDAD: " + armaduras[i].getDurabilidad());        		
        	}
        	
        	System.out.println("\nELIGE UNA ARMADURA");
        	for (int i = 0; i < armaduras.length; i++) {
            System.out.println(i + " - " + armaduras[i].getNombre());
        	}

        	int opcionArmadura = teclado.nextInt();
        
        	
        
        	while (opcionArmadura < 0 || opcionArmadura >= armaduras.length) {
        		System.out.println("Opción inválida. Elige otra:");
        		opcionArmadura = teclado.nextInt();
        	}
        	
        	System.out.println("\nElegiste \"" + armaduras[opcionArmadura].getNombre() + "\"");
        	Armadura armaduraElegida = armaduras[opcionArmadura];

     
        	System.out.println("\nCOMBATE");
        	System.out.println("Vas a realizar un ataque con un/una \"" + armaElegida.getNombre() + "\" a un/una \"" + armaduraElegida.getNombre() + "\"." );
  

        	int dmg = armaElegida.atacar(armaduraElegida);
        
        	if (dmg < armaduraElegida.getResistencia()) {
        		System.out.println("\nEl arma realiza un golpe de " + dmg + " .");
        		System.out.println("El golpe ha sido resistido.");
        		System.out.println("Durabilidad arma: " + armaElegida.getDurabilidad());
        		System.out.println("Durabilidad armadura: " + armaduraElegida.getDurabilidad());
        	}
        
        	else {
        		System.out.println("\nEl arma realiza un golpe de " + dmg + " .");
        		System.out.println("El arma ha atravesado la armadura.");
        		System.out.println("Durabilidad " + armaElegida.getNombre() + " : " + armaElegida.getDurabilidad());
        		System.out.println("Durabilidad " + armaduraElegida.getNombre() + " : " + armaduraElegida.getDurabilidad());
        	}
        	
        	 System.out.println("\nPulsa '.' para salir a la arena de combate o cualquier otra tecla para continuar en el campo de puebas:");
        	 salir = teclado.next().charAt(0);
        	 
        	    
        } while (salir != '.');
        
        System.out.println("\nARENA DE COMBATE");
        
        for (int i = 0; i < personajes.length; i++) {
    		String nombrepersonaje = personajes[i].getNombre();
    		String formateada3 = String.format("%-13s", nombrepersonaje);
    		System.out.println("PERSONAJES: " + formateada3 + " |RAZA:  " + personajes[i].getRaza() + " |ARMA: " + personajes[i].getArma().getNombre() + " |ARMADURA: " + personajes[i].getArmadura().getNombre() + " |FUERZA: " + personajes[i].getFuerza() + " |VELOCIDAD: " + personajes[i].getVelocidad() + " |VIDA: " + personajes[i].getVida() );
    		
    	}
        
        do {
        	
        } while (salir!= '.');
        
        teclado.close();
    }
	
	

}
