package es.studium;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Arma[] armas = new Arma[6];
		
		armas[0] = new Arma("Espadón", 40, 95, 100);
		armas[1]= new Arma("Daga", 5, 30, 100);
		armas[2] = new Arma("Espada corta", 20, 40, 100);
		armas[3]= new Arma("Hacha", 30, 80, 100);
		armas[4] = new Arma("Maza", 20, 50, 100);
		armas[5] = new Arma("Lanza", 15, 40, 100);
		
		Armadura[] armaduras = new Armadura[6];
		armaduras[0] = new Armadura("Coraza", 35, 100);
		armaduras[1] = new Armadura("Cota de malla", 40, 100);
		armaduras[2] = new Armadura("Ropas de cuero", 5, 100);
		armaduras[3] = new Armadura("Armadura mágica", 50, 100);
		armaduras[4] = new Armadura("Armadura pesada", 65, 100);
		armaduras[5] = new Armadura("Armadura Legendaria", 80, 100);
		

        Scanner teclado = new Scanner(System.in);
        char salir;
        
        do {
        	
        	System.out.println("ELIGE UN ARMA");
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
        	
        	 System.out.println("\nPulsa '.' para salir o cualquier otra tecla para continuar:");
        	 salir = teclado.next().charAt(0);
        	 
        	    
        } while (salir != '.');
        
        teclado.close();
    }
	
	

}
