/**
 * 
 * @author Yerko Osorio
 * @author Luis Guevara
 * @author Jhoseph Quiroga
 * @author Norma Armijo
 * @version 1.0
 */
package sistema;

import java.util.HashMap;

//Clase Evaluacion
public class Evaluacion {
	/**
	 * Tipo de evaluación (por ejemplo, Examen, Trabajo, Control).
	 */
	private String tipo; // Examen, Trabajo, Control
	/**
	 * Fecha en que se realizó la evaluación (formato: DD/MM/AAAA).
	 */
	private String fecha; // DD/MM/AAAA
	/**
	 * Puntaje máximo que se puede obtener en la evaluación.
	 */
	private double puntajeMaximo;
	/**
	 * Mapa que almacena las calificaciones de los estudiantes.
	 * La clave es un objeto {@link Estudiante} y el valor es la nota obtenida.
	 */
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