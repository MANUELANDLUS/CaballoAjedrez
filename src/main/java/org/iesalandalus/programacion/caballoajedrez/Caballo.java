package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;

public class Caballo {
	private Color color;
	private Posicion posicion;

	// private static final String ERROR_MOVIMIENTO = "Movimiento no permitido: ";

	public Caballo() {
		color = Color.NEGRO;
		posicion = new Posicion(8, 'b');
	}

	public Caballo(Color color) {
		if (color == Color.BLANCO) {
			posicion = new Posicion(1, 'b');
		}
		if (color == Color.NEGRO) {
			posicion = new Posicion(8, 'b');
		}
	}

	public Caballo(Color color, char columna) {
		if (columna == 'b' || columna == 'g') {
			if (color == Color.BLANCO) {
				posicion = new Posicion(1, columna);
			}
			if (color == Color.NEGRO) {
				posicion = new Posicion(8, columna);
			}
		} else {
			throw new IllegalArgumentException("El valor inicial de la columna debe ser \"b\" o \"g\".");
		}
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		if (color == null) {
			throw new IllegalArgumentException("El color no puede ser nulo.");
		}
		if (color == Color.BLANCO) {
			posicion = new Posicion(1, 'b');
		}
		if (color == Color.NEGRO) {
			posicion = new Posicion(8, 'b');
		}
		this.color = color;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		if (posicion == null) {
			throw new IllegalArgumentException("La posición no puede ser nula.");
		}
		this.posicion = new Posicion(posicion);
	}

}
