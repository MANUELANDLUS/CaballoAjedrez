package org.iesalandalus.programacion.caballoajedrez;


public class Posicion {
	private int fila;
	private char columna;

	public Posicion(int fila, char columna) {
		if (fila < 1 || fila > 8) {
			throw new IllegalArgumentException("El valor de la fila debe ser del 1 al 8.");
		} else {
			setFila(fila);
		}
		if (columna >= 'a' && columna <= 'h') {
			setColumna(columna);
		} else {
			throw new IllegalArgumentException("El valor de la columna debe ser un caracter de la \"a\" a la \"h\".");
		}
	}

	public Posicion(Posicion posicion) { // constructor copia
		if (posicion == null) {
			throw new IllegalArgumentException("No se puede copiar una posición con valor nulo");
		}
		this.fila = posicion.getFila();
		this.columna = posicion.getColumna();
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + columna;
		result = prime * result + fila;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		if (columna != other.columna)
			return false;
		if (fila != other.fila)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "[fila=" + fila + ", columna=" + columna + "]";
	}
}
