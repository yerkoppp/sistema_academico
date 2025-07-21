/**
 * 
 * @author Yerko Osorio
 * @author Luis Guevara
 * @author Jhoseph Quiroga
 * @author Norma Armijo
 * @version 1.0
 */
package sistema;

import java.util.ArrayList;

/**
 * Clase que representa a un estudiante dentro del sistema académico.
 * 
 * Cada estudiante tiene un RUT, nombre, carrera, año de ingreso y mantiene
 * relaciones de composición con inscripciones y cursos.
 * 
 * Esta clase permite gestionar la información y participación del estudiante en
 * los cursos.
 */
public class Estudiante {

	/**
	 * RUT único del estudiante, utilizado como identificador principal.
	 */
	private String rut;
	/**
	 * Nombre completo del estudiante.
	 */
	private String nombre;
	/**
	 * Carrera universitaria que cursa el estudiante.
	 */
	private String carrera;
	/**
	 * Año en que el estudiante ingresó a la institución.
	 */
	private int anioIngreso;
	/**
	 * Lista de inscripciones realizadas por el estudiante.
	 */
	private ArrayList<Inscripcion> inscripciones = new ArrayList<>();
	/**
	 * Lista de cursos en los que el estudiante está inscrito. Esta relación
	 * también se considera de composición.
	 */
	private ArrayList<Curso> cursos = new ArrayList<>();
	/**
	 * Lista de evaluaciones del estudiante.
	 */
	private ArrayList<Evaluacion> evaluaciones = new ArrayList<>();

	/**
	 * Constructor vacío de la clase Estudiante.
	 */
	public Estudiante() {
	}

	/**
	 * Constructor que inicializa un estudiante con sus datos personales.
	 * 
	 * @param rut         RUT del estudiante.
	 * @param nombre      Nombre completo del estudiante.
	 * @param carrera     Carrera que cursa el estudiante.
	 * @param anioIngreso Año de ingreso del estudiante a la institución.
	 */
	public Estudiante(String rut, String nombre, String carrera,
			int anioIngreso) {
		this.rut = rut;
		this.nombre = nombre;
		this.carrera = carrera;
		this.anioIngreso = anioIngreso;
	}

	// Getters y Setters

	/**
	 * Retorna el RUT del estudiante.
	 * 
	 * @return RUT como String.
	 */
	public String getRut() {
		return rut;
	}

	/**
	 * Retorna el nombre del estudiante.
	 * 
	 * @return Nombre como String.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Retorna la carrera del estudiante.
	 * 
	 * @return Carrera como String.
	 */
	public String getCarrera() {
		return carrera;
	}

	/**
	 * Retorna el año de ingreso del estudiante.
	 * 
	 * @return Año de ingreso como entero.
	 */
	public int getAnoIngreso() {
		return anioIngreso;
	}

	/**
	 * Retorna la lista de inscripciones del estudiante.
	 * 
	 * @return Lista de objetos Inscripcion.
	 */
	public ArrayList<Inscripcion> getInscripciones() {
		return inscripciones;
	}

	/**
	 * Retorna la lista de cursos en los que está inscrito el estudiante.
	 * 
	 * @return Lista de objetos Curso.
	 */
	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	// Métodos específicos

	/**
	 * Calcula el promedio general del estudiante. Actualmente retorna 0.0 como
	 * valor predeterminado.
	 * 
	 * @return Promedio general del estudiante.
	 */
	public double getPromedioGeneral() {
		if (evaluaciones.isEmpty()) {
			return 0.0;
		}

		double sumaNotas = 0.0;
		int cantidadNotas = 0;
		for (Evaluacion evaluacion : evaluaciones) {
			for (Double nota : evaluacion.getCalificaciones().values()) {
				sumaNotas += nota;
				cantidadNotas++;
			}
		}
		if (cantidadNotas == 0) {
			return 0.0;
		}

		return sumaNotas / cantidadNotas;
	}

	/**
	 * Agrega una evaluación a la lista del estudiante.
	 * 
	 * @param evaluacion Evaluación a agregar.
	 */
	public void agregarEvaluacion(Evaluacion evaluacion) {
		evaluaciones.add(evaluacion);
	}

	/**
	 * Agrega una inscripción a la lista de inscripciones del estudiante si no
	 * está duplicada.
	 * 
	 * @param inscripcion Objeto Inscripcion a agregar.
	 */
	public void agregarInscripcion(Inscripcion inscripcion) {
		if (!inscripciones.contains(inscripcion)) {
			inscripciones.add(inscripcion);
			System.out.println("Curso inscrito exitosamente.");
		} else {
			System.out.println("Ya se encuentra inscrito en el curso");
		}
	}

	/**
	 * Retorna una representación textual del estudiante.
	 * 
	 * @return Cadena con nombre, RUT, carrera y año de ingreso.
	 */
	@Override
	public String toString() {
		return String.format(
				"Nombre: %s, RUT: %s, Carrera: %s, Año de ingreso: %d",
				this.nombre, this.rut, this.carrera, this.anioIngreso);
	}
}