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

	// constructor copia
	public Caballo(Caballo caballo) {
		if (caballo == null) {
			throw new IllegalArgumentException("No se puede copiar un caballo nulo");
		}
		this.color = caballo.getColor();
		this.posicion = caballo.getPosicion();
	}

	public void mover(Direccion direccion) {
		char letra;
		letra = posicion.getColumna();

		if (direccion == null) {
			posicion.setFila(posicion.getFila());
			posicion.setColumna(posicion.getColumna());
		}

		switch (direccion) {
		case ARRIBA_IZQUIERDA:
			if (posicion.getFila() >= 1 && posicion.getFila() <= 8) {
				posicion.setFila(posicion.getFila() + 2);
			} else {
				throw new IllegalArgumentException("Movimiento no permitido.");
			}
			if (letra >= 'a' && letra <= 'h') {
				posicion.setColumna((char) (letra - 1));
			} else {
				throw new IllegalArgumentException("Movimiento no permitido.");
			}
			break;
		case ARRIBA_DERECHA:
			if (posicion.getFila() >= 1 && posicion.getFila() <= 8) {
				posicion.setFila(posicion.getFila() + 2);
			} else {
				throw new IllegalArgumentException("Movimiento no permitido.");
			}
			if (letra >= 'a' && letra <= 'h') {
				posicion.setColumna((char) (letra + 1));
			} else {
				throw new IllegalArgumentException("Movimiento no permitido.");
			}
			break;
		case DERECHA_ARRIBA:
			if (posicion.getFila() >= 1 && posicion.getFila() <= 8) {
				posicion.setFila(posicion.getFila() + 1);
			} else {
				throw new IllegalArgumentException("Movimiento no permitido.");
			}
			if (letra >= 'a' && letra <= 'h') {
				posicion.setColumna((char) (letra + 2));
			} else {
				throw new IllegalArgumentException("Movimiento no permitido.");
			}
			break;
		case DERECHA_ABAJO:
			if (posicion.getFila() >= 1 && posicion.getFila() <= 8) {
				posicion.setFila(posicion.getFila() - 1);
			} else {
				throw new IllegalArgumentException("Movimiento no permitido.");
			}
			if (letra >= 'a' && letra <= 'h') {
				posicion.setColumna((char) (letra + 2));
			} else {
				throw new IllegalArgumentException("Movimiento no permitido.");
			}
			break;
		case ABAJO_DERECHA:
			if (posicion.getFila() >= 1 && posicion.getFila() <= 8) {
				posicion.setFila(posicion.getFila() - 2);
			} else {
				throw new IllegalArgumentException("Movimiento no permitido.");
			}
			if (letra >= 'a' && letra <= 'h') {
				posicion.setColumna((char) (letra + 1));
			} else {
				throw new IllegalArgumentException("Movimiento no permitido.");
			}
			break;
		case ABAJO_IZQUIERDA:
			if (posicion.getFila() >= 1 && posicion.getFila() <= 8) {
				posicion.setFila(posicion.getFila() - 2);
			} else {
				throw new IllegalArgumentException("Movimiento no permitido.");
			}
			if (letra >= 'a' && letra <= 'h') {
				posicion.setColumna((char) (letra - 1));
			} else {
				throw new IllegalArgumentException("Movimiento no permitido.");
			}
			break;
		case IZQUIERDA_ARRIBA:
			if (posicion.getFila() >= 1 && posicion.getFila() <= 8) {
				posicion.setFila(posicion.getFila() + 1);
			} else {
				throw new IllegalArgumentException("Movimiento no permitido.");
			}
			if (letra >= 'a' && letra <= 'h') {
				posicion.setColumna((char) (letra - 2));
			} else {
				throw new IllegalArgumentException("Movimiento no permitido.");
			}
			break;
		case IZQUIERDA_ABAJO:
			if (posicion.getFila() >= 1 && posicion.getFila() <= 8) {
				posicion.setFila(posicion.getFila() - 1);
			} else {
				throw new IllegalArgumentException("Movimiento no permitido.");
			}
			if (letra >= 'a' && letra <= 'h') {
				posicion.setColumna((char) (letra - 2));
			} else {
				throw new IllegalArgumentException("Movimiento no permitido.");
			}
			break;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((posicion == null) ? 0 : posicion.hashCode());
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
		Caballo other = (Caballo) obj;
		if (color != other.color)
			return false;
		if (posicion == null) {
			if (other.posicion != null)
				return false;
		} else if (!posicion.equals(other.posicion))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Caballo [color=" + color + ", posicion=" + posicion + "]";
	}

}
