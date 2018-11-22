package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	static Caballo caballo;
	static Posicion posicion;
	static Color color;
	static char columna;

	public static void main(String[] args) {
		System.out.println("Programa para aprender a colocar y mover un caballo en el tablero " + "de ajedrez");
		caballo = new Caballo();
		posicion = new Posicion();
		mostrarMenu();
	}

	private static void mostrarMenu() {
		int opcion;
		do {
			System.out.println("MENU PRINCIPAL");
			System.out.println("1 - Crear un caballo por defecto");
			System.out.println("2 - Crear un caballo de un color");
			System.out.println("3 - Crear un caballo de un color en una columna");
			System.out.println("4 - Mover el caballo");
			System.out.println("5 - Salir");
			opcion = elegirOpcion();
		} while (opcion < 1 || opcion > 5);
		ejecutarOpcion(opcion);
	}

	private static int elegirOpcion() {
		int opcion;
		opcion = Entrada.entero();
		return opcion;
	}

	private static void ejecutarOpcion(int opcion) {
		// if (opcion != 5) {
		// caballo = new Caballo();
		// posicion = new Posicion();
		// }
		switch (opcion) {
		case 1:
			crearCaballoDefecto();
			mostrarMenu();
			break;
		case 2:
			crearCaballoDefectoColor();
			mostrarMenu();
			break;
		case 3:
			crearCaballoColorPosicion();
			mostrarMenu();
			break;
		case 4:
			mover();
			mostrarMenu();
			break;
		case 5:
			break;
		}
	}

	private static void crearCaballoDefecto() {
		caballo = new Caballo();
		posicion = new Posicion();
		System.out.println(caballo.toString());
	}

	private static void crearCaballoDefectoColor() {
		color = elegirColor();
		caballo.setColor(color);
		System.out.println(caballo.toString());
	}

	private static Color elegirColor() {
		int opcion;
		Color color = null;
		do {
			System.out.println("1 - Blanco");
			System.out.println("2 - Negro");
			opcion = Entrada.entero();
		} while (opcion < 1 || opcion > 2);
		if (opcion == 1) {
			color = Color.BLANCO;
		}
		if (opcion == 2) {
			color = Color.NEGRO;
		}
		return color;

	}

	private static void crearCaballoColorPosicion() {
		color = elegirColor();
		columna = elegirColumnaInicial();
		caballo.setColor(color);
		posicion.setColumna(columna);
		caballo.setPosicion(posicion);
		System.out.println(caballo.toString());
	}

	private static char elegirColumnaInicial() {
		do {
			System.out.println("Elige la columna inicial (a-h):");
			columna = Entrada.caracter();
		} while (columna < 'a' || columna > 'h');
		return columna;
	}

	private static void mover() {
		Direccion direccion;
		direccion = elegirDireccion();
		System.out.println("Movimiento: " + direccion);
		caballo.mover(direccion);
		System.out.println(caballo.toString());

	}

	private static void mostrarMenuDirecciones() {
		System.out.println("1 - ARRIBA IZQUIERDA");
		System.out.println("2 - ARRIBA DERECHA");
		System.out.println("3 - DERECHA ARRIBA");
		System.out.println("4 - DERECHA ABAJO");
		System.out.println("5 - ABAJO DERECHA");
		System.out.println("6 - ABAJO IZQUIERDA");
		System.out.println("7 - IZQUIERDA ARRIBA");
		System.out.println("8 - IZQUIERDA ABAJO");
	}

	private static Direccion elegirDireccion() {
		int opcion;
		Direccion direccion;
		direccion = Direccion.ARRIBA_IZQUIERDA;
		do {
			mostrarMenuDirecciones();
			opcion = Entrada.entero();
		} while (opcion < 1 || opcion > 8);
		switch (opcion) {
		case 1:
			direccion = Direccion.ARRIBA_IZQUIERDA;
			break;
		case 2:
			direccion = Direccion.ARRIBA_DERECHA;
			break;
		case 3:
			direccion = Direccion.DERECHA_ARRIBA;
			break;
		case 4:
			direccion = Direccion.DERECHA_ABAJO;
			break;
		case 5:
			direccion = Direccion.ABAJO_DERECHA;
			break;
		case 6:
			direccion = Direccion.ABAJO_IZQUIERDA;
			break;
		case 7:
			direccion = Direccion.IZQUIERDA_ARRIBA;
			break;
		case 8:
			direccion = Direccion.IZQUIERDA_ABAJO;
			break;
		}
		return direccion;
	}
}