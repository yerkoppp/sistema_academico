package sistema;

import java.util.HashMap;

//Clase Evaluacion
public class Evaluacion {
	private String tipo; // Examen, Trabajo, Control
	private String fecha; // DD/MM/AAAA
	private double puntajeMaximo;
	private HashMap<Estudiante, Double> calificaciones;

	public Evaluacion() {
		// Constructor sin parámetros
	}

	public Evaluacion(String tipo, String fecha, double puntajeMaximo) {
		this.tipo = tipo;
		this.fecha = fecha;
		this.puntajeMaximo = puntajeMaximo;
		this.calificaciones = new HashMap<>();
	}

	// Getters y Setters
	public String getTipo() {
		return tipo;
	}

	public String getFecha() {
		return fecha;
	}

	public double getPuntajeMaximo() {
		return puntajeMaximo;
	}

	public HashMap<Estudiante, Double> getCalificaciones() {
		return calificaciones;
	}

	// Métodos específicos
	/**
	 * Asigna una calificación a un estudiante
	 */
	public boolean asignarCalificacion(Estudiante estudiante, double nota) {
		if (nota >= 0 && nota <= this.puntajeMaximo) {
			calificaciones.put(estudiante, nota);
			return true;
		} else {
			System.out.println("Nota inválida para " + estudiante.getNombre());
			return false;
		}
	}

	/**
	 * Obtiene la calificación de un estudiante
	 */
	public Double getCalificacion(Estudiante estudiante) {
		return calificaciones.get(estudiante);
	}

	/**
	 * Calcula el promedio general de las calificaciones asignadas
	 */
	public double getPromedioGeneral() {
		if (calificaciones.isEmpty()) {
			System.out.println("No hay calificaciones registradas.");
			return 0.0;
		}

		double suma = 0.0;
		for (Double nota : calificaciones.values()) {
			suma += nota;
		}

		return suma / calificaciones.size();
	}

	@Override
	public String toString() {
		return "Evaluacion{" + "tipo='" + tipo + '\'' + ", fecha='" + fecha + '\'' + ", puntajeMaximo=" + puntajeMaximo
				+ ", cantidadCalificaciones=" + calificaciones.size() + '}';
	}
}