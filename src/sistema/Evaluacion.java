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

/**
 * Clase que representa una evaluación realizada en un curso. Incluye el tipo de
 * evaluación, la fecha en que se aplica, el puntaje máximo y las calificaciones
 * asignadas a los estudiantes.
 */
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
	 * Mapa que almacena las calificaciones de los estudiantes. La clave es un
	 * objeto {@link Estudiante} y el valor es la nota obtenida.
	 */
	private HashMap<Estudiante, Double> calificaciones;

	/**
	 * Constructor vacío de la clase Evaluacion. Inicializa una evaluación sin
	 * valores asignados.
	 */
	public Evaluacion() {
	}

	/**
	 * Constructor que inicializa una evaluación con sus datos principales.
	 * 
	 * @param tipo          Tipo de evaluación (Ej: Examen, Trabajo, Control).
	 * @param fecha         Fecha en que se aplica la evaluación (formato:
	 *                      DD/MM/AAAA).
	 * @param puntajeMaximo Puntaje máximo que se puede obtener.
	 */
	public Evaluacion(String tipo, String fecha, double puntajeMaximo) {
		this.tipo = tipo;
		this.fecha = fecha;
		this.puntajeMaximo = puntajeMaximo;
		this.calificaciones = new HashMap<>();
	}

	// Getters y Setters

	/**
	 * Obtiene el tipo de evaluación.
	 * 
	 * @return Tipo de evaluación.
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Obtiene la fecha de la evaluación.
	 * 
	 * @return Fecha de la evaluación.
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * Obtiene el puntaje máximo de la evaluación.
	 * 
	 * @return Puntaje máximo posible.
	 */
	public double getPuntajeMaximo() {
		return puntajeMaximo;
	}

	/**
	 * Obtiene el mapa de calificaciones asignadas a estudiantes.
	 * 
	 * @return Mapa con calificaciones de estudiantes.
	 */
	public HashMap<Estudiante, Double> getCalificaciones() {
		return calificaciones;
	}

	// Métodos específicos

	/**
	 * Asigna una calificación a un estudiante.
	 * 
	 * @param estudiante Estudiante al que se asigna la nota.
	 * @param nota       Nota obtenida por el estudiante.
	 * @return true si la nota fue válida y se asignó correctamente, false en
	 *         caso contrario.
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
	 * Obtiene la calificación de un estudiante en esta evaluación.
	 * 
	 * @param estudiante Estudiante del que se desea obtener la nota.
	 * @return Nota asignada al estudiante, o null si no tiene calificación.
	 */
	public Double getCalificacion(Estudiante estudiante) {
		return calificaciones.get(estudiante);
	}

	/**
	 * Calcula el promedio general de las calificaciones registradas en la
	 * evaluación.
	 * 
	 * @return Promedio de las calificaciones, o 0.0 si no hay registros.
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

	/**
	 * Devuelve una representación en texto de la evaluación.
	 * 
	 * @return Cadena con los datos principales de la evaluación.
	 */
	@Override
	public String toString() {
		return "Evaluacion{" + "tipo='" + tipo + '\'' + ", fecha='" + fecha
				+ '\'' + ", puntajeMaximo=" + puntajeMaximo
				+ ", cantidadCalificaciones=" + calificaciones.size() + '}';
	}
}