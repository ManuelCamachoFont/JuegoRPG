package es.studium;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Ejecutable implements ActionListener, WindowListener {

	Frame vntInicio, vntPrbs, vntCombate, vntCombatientes;

	Button btnPrbs = new Button("Campo de Pruebas");
	Button btnAre = new Button("Arena a muerte");
	Button btnExit = new Button("Salir");

	Button btnSlct = new Button("Seleccionar");
	Button btnFight = new Button("¡A pelear!");

	Button btnStats = new Button("Consultar estadísticas");
	Button btnAtk = new Button("Atacar");
	Label wpnEleg = new Label("Elige un arma para atacar");
	Choice wpnList = new Choice();
	Label armrEleg = new Label("Elige una armadura para defender");
	Choice armrList = new Choice();
	PanelWpn pnlWpn;
	PanelArmr pnlArmr;
	TextArea txtInfo = new TextArea("", 2, 40, TextArea.SCROLLBARS_NONE);
	Button btnRprWpn = new Button("Repara el arma");
	Button btnRprArmr = new Button("Repara la armadura");
	Dialog winPrbs = new Dialog(vntPrbs, "Enhorabuena", true);
	Label lblWinPrbs = new Label("Has destrozado la armadura");
	Button btnPrbsExit = new Button("Volver al inicio");

	GridBagConstraints gbc = new GridBagConstraints();

	Random aleatorio = new Random();
	int colorR = aleatorio.nextInt(255) + 1;
	int colorG = aleatorio.nextInt(255) + 1;
	int colorB = aleatorio.nextInt(255) + 1;

	private static Arma[] armas = new Arma[7];
	private static Armadura[] armaduras = new Armadura[7];
	private static Personaje[] personajes = new Personaje[6];

	{
		armas[0] = new Arma("Palo", 1, 10, 20);
		armas[1] = new Arma("Daga", 10, 30, 100);
		armas[2] = new Arma("Espada corta", 20, 40, 100);
		armas[3] = new Arma("Hacha", 30, 80, 100);
		armas[4] = new Arma("Maza", 20, 50, 100);
		armas[5] = new Arma("Lanza", 15, 40, 100);
		armas[6] = new Arma("Espadón", 40, 95, 100);

		armaduras[0] = new Armadura("Ropas de tela", 0, 25);
		armaduras[1] = new Armadura("Ropas de cuero", 10, 100);
		armaduras[2] = new Armadura("Coraza", 35, 100);
		armaduras[3] = new Armadura("Cota de malla", 40, 100);
		armaduras[4] = new Armadura("Armadura mágica", 50, 100);
		armaduras[5] = new Armadura("Armadura pesada", 65, 100);
		armaduras[6] = new Armadura("Armadura Legendaria", 80, 100);

		personajes[0] = new Personaje("Pepe", "Humano", armas[0], armaduras[6], 10, 10, 100);
		personajes[1] = new Personaje("Gnome Mates", "Goblin", armas[2], armaduras[2], 20, 20, 75);
		personajes[2] = new Personaje("Pepe", "Elfo", armas[1], armaduras[4], 10, 30, 120);
		personajes[3] = new Personaje("Pepe", "Troll", armas[4], armaduras[0], 40, 10, 200);
		personajes[4] = new Personaje("Enano", "Enano", armas[3], armaduras[5], 20, 10, 140);
		personajes[5] = new Personaje("Sir Pent", "Reptiliano", armas[5], armaduras[3], 10, 20, 110);
	}

	public Ejecutable() {

		inicio();
		
		btnPrbs.addActionListener(this);
		btnAre.addActionListener(this);
		btnExit.addActionListener(this);

		btnStats.addActionListener(this);
		btnAtk.addActionListener(this);
		btnRprArmr.addActionListener(this);
		btnRprWpn.addActionListener(this);
		btnPrbsExit.addActionListener(this);
	}

	private void inicio() {

		vntInicio = new Frame("Inicio");
		vntInicio.setLayout(new GridBagLayout());

		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);

		gbc.gridy = 0;
		vntInicio.add(btnPrbs, gbc);

		gbc.gridy = 1;
		vntInicio.add(btnAre, gbc);

		gbc.gridy = 2;

		vntInicio.add(btnExit, gbc);

		vntInicio.addWindowListener(this);
		vntInicio.setBackground(new Color(colorR, colorG, colorB));
		vntInicio.setSize(250, 250);
		vntInicio.setResizable(false);
		vntInicio.setLocationRelativeTo(null);
		vntInicio.setVisible(true);
	}

	private void prbs() {

		if (vntPrbs != null) {
			vntPrbs.dispose();
		}
		vntInicio.setVisible(false);

		for (Arma wpns : armas) {
			wpns.setDurabilidad(100);
		}
		for (Armadura armrs : armaduras) {
			armrs.setDurabilidad(100);
		}

		wpnList.removeAll();
		armrList.removeAll();

		vntPrbs = new Frame("Campo de Pruebas");
		vntPrbs.setLayout(new GridBagLayout());

		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		vntPrbs.add(btnStats, gbc);
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;

		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridy = 1;
		vntPrbs.add(wpnEleg, gbc);
		for (Arma wpns : armas) {
			wpnList.add(wpns.getNombre());
		}
		gbc.gridy = 2;
		vntPrbs.add(wpnList, gbc);
		wpnList.removeItemListener(null);
		wpnList.addItemListener(e -> {
			String arma = wpnList.getSelectedItem();
			pnlWpn.cambiarImagen(arma);
		});

		gbc.gridy = 3;
		armrList.removeItemListener(null);
		vntPrbs.add(armrEleg, gbc);
		for (Armadura armr : armaduras) {
			armrList.add(armr.getNombre());
		}
		gbc.gridy = 4;
		vntPrbs.add(armrList, gbc);
		armrList.addItemListener(e -> {
			String armadura = armrList.getSelectedItem();
			pnlArmr.cambiarImagen(armadura);
		});

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 4;
		gbc.anchor = GridBagConstraints.CENTER;
		vntPrbs.add(btnAtk, gbc);
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;

		pnlWpn = new PanelWpn();
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		gbc.fill = GridBagConstraints.BOTH;
		vntPrbs.add(pnlWpn, gbc);

		pnlArmr = new PanelArmr();
		gbc.gridy = 3;
		vntPrbs.add(pnlArmr, gbc);
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.NONE;

		if (wpnList.getItemCount() > 0) {
			pnlWpn.cambiarImagen(wpnList.getSelectedItem());
		}
		if (armrList.getItemCount() > 0) {
			pnlArmr.cambiarImagen(armrList.getSelectedItem());
		}

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 3;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		txtInfo.setEditable(false);
		vntPrbs.add(txtInfo, gbc);
		gbc.gridwidth = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.NONE;

		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		vntPrbs.add(btnRprArmr, gbc);

		gbc.gridx = 2;
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		vntPrbs.add(btnRprWpn, gbc);

		gbc.gridy = 7;
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		vntPrbs.add(btnPrbsExit, gbc);

		winPrbs.setLayout(new FlowLayout());
		winPrbs.setSize(250, 80);
		winPrbs.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				winPrbs.dispose(); // solo cierra el Dialog
			}
		});
		winPrbs.add(lblWinPrbs);
		winPrbs.setLocationRelativeTo(null);
		winPrbs.setResizable(false);
		winPrbs.setVisible(false);

		vntPrbs.addWindowListener(this);
		vntPrbs.setBackground(new Color(colorR, colorG, colorB));
		vntPrbs.setSize(500, 380);
		vntPrbs.setResizable(false);
		vntPrbs.setLocationRelativeTo(null);
		vntPrbs.setVisible(true);
		pnlWpn.repaint();

	}

	public class PanelWpn extends Panel {

		private Image imagen;

		public PanelWpn() {

			setPreferredSize(new Dimension(220, 220));
		}

		public void cambiarImagen(String nombre) {
			try {

				String archivo = nombre.replace(" ", "") + ".png";
				String ruta = "/img/" + archivo;

				var url = getClass().getResource(ruta);
				if (url != null) {
					imagen = ImageIO.read(url);
				} else {
					imagen = null;
					System.out.println("No existe: " + ruta);
				}
				repaint();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			if (imagen != null) {
				int panelW = getWidth();
				int panelH = getHeight();
				int imgW = imagen.getWidth(this);
				int imgH = imagen.getHeight(this);

				double escala = Math.min((double) panelW / imgW, (double) panelH / imgH);
				int newW = (int) (imgW * escala);
				int newH = (int) (imgH * escala);
				int x = (panelW - newW) / 2;
				int y = (panelH - newH) / 2;

				g.drawImage(imagen, x, y, newW, newH, this);
			}
		}
	}

	private Arma getArmaSeleccionada() {
		String nombre = wpnList.getSelectedItem();
		for (Arma a : armas) {
			if (a.getNombre().equals(nombre)) {
				return a;
			}
		}
		return null;
	}

	private Armadura getArmaduraSeleccionada() {
		String nombre = armrList.getSelectedItem();
		for (Armadura a : armaduras) {
			if (a.getNombre().equals(nombre)) {
				return a;
			}
		}
		return null;
	}

	public class PanelArmr extends Panel {

		private Image imagen;

		public PanelArmr() {

			setPreferredSize(new Dimension(220, 220));
		}

		public void cambiarImagen(String nombre) {
			try {

				String archivo = nombre.replace(" ", "") + ".png";
				String ruta = "/img/" + archivo;

				var url = getClass().getResource(ruta);
				if (url != null) {
					imagen = ImageIO.read(url);
				} else {
					imagen = null;
					System.out.println("No existe: " + ruta);
				}
				repaint();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			if (imagen != null) {
				int panelW = getWidth();
				int panelH = getHeight();
				int imgW = imagen.getWidth(this);
				int imgH = imagen.getHeight(this);

				double escala = Math.min((double) panelW / imgW, (double) panelH / imgH);
				int newW = (int) (imgW * escala);
				int newH = (int) (imgH * escala);
				int x = (panelW - newW) / 2;
				int y = (panelH - newH) / 2;

				g.drawImage(imagen, x, y, newW, newH, this);
			}
		}
	}

	private void arena() {

	}

	private void combate() {

	}

	private void stats() {

	}

	private void atk() {

	}

	public static void main(String[] args) {

		new Ejecutable();
//
//		Scanner teclado = new Scanner(System.in);
//		char salir;
//
//		do {
//			System.out.println("CAMPO DE PRUEBAS");
//			System.out.println("");
//
//			for (int i = 0; i < armas.length; i++) {
//				String nombrearma = armas[i].getNombre();
//				String formateada1 = String.format("%-13s", nombrearma);
//				System.out.println("ARMA: " + formateada1 + " |DAÑO:  " + armas[i].getMindmg() + " ~ "
//						+ armas[i].getMaxdmg() + " |DURABILIDAD: " + armas[i].getDurabilidad());
//
//			}
//
//			System.out.println("\nELIGE UN ARMA");
//			for (int i = 0; i < armas.length; i++) {
//				System.out.println(i + " - " + armas[i].getNombre());
//			}
//
//			int opcionArma = teclado.nextInt();
//
//			while (opcionArma < 0 || opcionArma >= armas.length) {
//				System.out.println("Opción inválida. Elige otra:");
//				opcionArma = teclado.nextInt();
//			}
//
//			System.out.println("\nElegiste \"" + armas[opcionArma].getNombre() + "\"");
//			Arma armaElegida = armas[opcionArma];
//			System.out.println("");
//
//			for (int i = 0; i < armaduras.length; i++) {
//				String nombrearmadura = armaduras[i].getNombre();
//				String formateada2 = String.format("%-20s", nombrearmadura);
//				System.out.println("ARMADURA: " + formateada2 + " |RESISTENCIA:  " + armaduras[i].getResistencia()
//						+ " |DURABILIDAD: " + armaduras[i].getDurabilidad());
//			}
//
//			System.out.println("\nELIGE UNA ARMADURA");
//			for (int i = 0; i < armaduras.length; i++) {
//				System.out.println(i + " - " + armaduras[i].getNombre());
//			}
//
//			int opcionArmadura = teclado.nextInt();
//
//			while (opcionArmadura < 0 || opcionArmadura >= armaduras.length) {
//				System.out.println("Opción inválida. Elige otra:");
//				opcionArmadura = teclado.nextInt();
//			}
//
//			System.out.println("\nElegiste \"" + armaduras[opcionArmadura].getNombre() + "\"");
//			Armadura armaduraElegida = armaduras[opcionArmadura];
//
//			System.out.println("\nCOMBATE");
//			System.out.println("Vas a realizar un ataque con un/una \"" + armaElegida.getNombre() + "\" a un/una \""
//					+ armaduraElegida.getNombre() + "\".");
//
//			int dmg = armaElegida.atacar(armaduraElegida);
//
//			if (dmg < armaduraElegida.getResistencia()) {
//				System.out.println("\nEl arma realiza un golpe de " + dmg + " .");
//				System.out.println("El golpe ha sido resistido.");
//				System.out.println("Durabilidad arma: " + armaElegida.getDurabilidad());
//				System.out.println("Durabilidad armadura: " + armaduraElegida.getDurabilidad());
//			}
//
//			else {
//				System.out.println("\nEl arma realiza un golpe de " + dmg + " .");
//				System.out.println("El arma ha atravesado la armadura.");
//				System.out.println("Durabilidad " + armaElegida.getNombre() + " : " + armaElegida.getDurabilidad());
//				System.out.println(
//						"Durabilidad " + armaduraElegida.getNombre() + " : " + armaduraElegida.getDurabilidad());
//			}
//
//			System.out.println(
//					"\nPulsa '.' para salir a la arena de combate o cualquier otra tecla para continuar en el campo de puebas:");
//			salir = teclado.next().charAt(0);
//
//		} while (salir != '.');
//
//		System.out.println("\nARENA DE COMBATE");
//
//		for (int i = 0; i < personajes.length; i++) {
//			String nombrepersonaje = personajes[i].getNombre();
//			String formateada3 = String.format("%-13s", nombrepersonaje);
//			System.out.println("PERSONAJES: " + formateada3 + " |RAZA:  " + personajes[i].getRaza() + " |ARMA: "
//					+ personajes[i].getArma().getNombre() + " |ARMADURA: " + personajes[i].getArmadura().getNombre()
//					+ " |FUERZA: " + personajes[i].getFuerza() + " |VELOCIDAD: " + personajes[i].getVelocidad()
//					+ " |VIDA: " + personajes[i].getVida());
//
//		}
//
//		do {
//
//		} while (salir != '.');
//
//		teclado.close();
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// INICIO

		if (e.getSource() == btnPrbs) {
			prbs();
		} else if (e.getSource() == btnAre) {
			arena();
		} else if (e.getSource() == btnExit) {
			System.exit(0);
		}

		// CAMPO DE PRUEBAS

		// Botón Stats
		if (e.getSource() == btnStats) {

			Arma arma = getArmaSeleccionada();
			Armadura armadura = getArmaduraSeleccionada();

			if (arma == null || armadura == null)
				return;
			txtInfo.setText("ARMA: " + arma.getNombre() + " // DAÑO:  " + arma.getMindmg() + " ~ " + arma.getMaxdmg()
					+ "  // DURABILIDAD: " + arma.getDurabilidad() + "\nARMADURA: " + armadura.getNombre()
					+ " // RESISTENCIA:  " + armadura.getResistencia() + " // DURABILIDAD: "
					+ armadura.getDurabilidad());
		}

		// Botón Atacar
		if (e.getSource() == btnAtk) {

			Arma arma = getArmaSeleccionada();
			Armadura armadura = getArmaduraSeleccionada();

			if (arma == null || armadura == null)
				return;

			if (armadura.getDurabilidad() > 0) {
				if (arma.getDurabilidad() > 0) {
					int dmg = arma.atacar(armadura);

					if (dmg < armadura.getResistencia()) {
						txtInfo.setText("Vas a realizar un ataque con un/una \"" + arma.getNombre() + "\" a un/una \""
								+ armadura.getNombre() + "\"." + "\nEl arma realiza un golpe de " + dmg + " ."
								+ "\nEl golpe ha sido resistido." + "\nDurabilidad arma: " + arma.getDurabilidad()
								+ "\nDurabilidad armadura: " + armadura.getDurabilidad());
					}

					else {
						txtInfo.setText("Vas a realizar un ataque con un/una \"" + arma.getNombre() + "\" a un/una \""
								+ armadura.getNombre() + "\"." + "\nEl arma realiza un golpe de " + dmg + " ."
								+ "\nEl arma ha atravesado la armadura." + "\nDurabilidad " + arma.getNombre() + " : "
								+ arma.getDurabilidad() + "\nDurabilidad " + armadura.getNombre() + " : "
								+ armadura.getDurabilidad());
					}
				} else {
					txtInfo.setText("El arma está rota, deberías repararla");
				}
			} else {
				winPrbs.setVisible(true);
				arma.reparar();
				armadura.reparar();
				txtInfo.setText("");

			}
		}

		// Botón reparar
		if (e.getSource() == btnRprArmr) {

			Armadura armadura = getArmaduraSeleccionada();

			if (armadura == null)
				return;

			if (armadura.getDurabilidad() == 100) {
				txtInfo.setText("La armadura está intacta.");
				return;
			}
			armadura.reparar();
			txtInfo.setText("La armadura \"" + armadura.getNombre() + "\" ha sido reparada." + "\nDurabilidad actual: "
					+ armadura.getDurabilidad());
		}

		if (e.getSource() == btnRprWpn) {

			Arma arma = getArmaSeleccionada();

			if (arma == null)
				return;

			if (arma.getDurabilidad() == 100) {
				txtInfo.setText("El arma está intacta.");
				return;
			}
			arma.reparar();
			txtInfo.setText("El arma \"" + arma.getNombre() + "\" ha sido reparada." + "\nDurabilidad actual: "
					+ arma.getDurabilidad());
		}

		// Boton volver

		if (e.getSource() == btnPrbsExit) {

			Arma arma = getArmaSeleccionada();
			Armadura armadura = getArmaduraSeleccionada();

			if (arma == null || armadura == null)
				return;

			arma.reparar();
			armadura.reparar();
			txtInfo.setText("");
			vntPrbs.setVisible(false);
			vntInicio.setVisible(true);
		}
	}

}
