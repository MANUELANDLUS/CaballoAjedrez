package org.iesalandalus.programacion.caballoajedrez;

public class Posicion {
	private int fila;
	private char columna;

	public void setFila(int fila) {
		if (fila < 1 || fila > 8) {
			throw new IllegalArgumentException("El valor de la fila debe ser del 1 al 8.");
		} else {
			this.fila = fila;
		}
	}

	public int getFila() {
		return fila;
	}

	public void setColumna(char columna) {
		if (columna >= 'a' && columna <= 'h') {
			this.columna = columna;
		} else {
			throw new IllegalArgumentException("El valor de la columna debe ser un caracter de la \"a\" a la \"h\".");
		}
	}

	public char getColumna() {
		return columna;
	}
}
