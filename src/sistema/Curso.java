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
 * Representa un curso dentro del sistema académico.
 * Contiene información como su código, nombre, número de créditos, 
 * docente asignado, evaluaciones y estudiantes inscritos.
 *
 * Mantiene relaciones de asociación con Docente y composición con Evaluación.
 */
public class Curso {
	/**
	 * Código único del curso.
	 */
	private String codigo;
	/**
	 * Nombre del curso.
	 */
	private String nombre;
	/**
	 * Cantidad de créditos del curso.
	 */
	private int numCreditos;
	/**
	 * Docente asignado al curso.
	 */
	private Docente docenteAsignado;
	/**
	 * Lista de evaluaciones asociadas al curso.
	 */
	private ArrayList<Evaluacion> evaluaciones = new ArrayList<>();
	/**
	 * Lista de estudiantes inscritos en el curso.
	 */
	private ArrayList<Estudiante> estudiantesInscritos = new ArrayList<>();

	/**
	 * Constructor por defecto del curso.
	 * Crea una instancia sin inicializar atributos.
	 */
	public Curso() {
	}

	/**
	 * Constructor con parámetros para inicializar un curso.
	 *
	 * @param codigo Código único del curso.
	 * @param nombre Nombre del curso.
	 * @param numCreditos Número de créditos del curso.
	 * @param docenteAsignado Docente responsable del curso.
	 */
	public Curso(String codigo, String nombre, int numCreditos, Docente docenteAsignado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.numCreditos = numCreditos;
		this.docenteAsignado = docenteAsignado;
	}

	// Getters y Setters
	
	/**
	 * Retorna el nombre del curso.
	 * @return nombre del curso.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Retorna el código del curso.
	 * @return código del curso.
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Retorna el número de créditos del curso.
	 * @return número de créditos.
	 */
	public int getNumCreditos() {
		return numCreditos;
	}

	/**
	 * Retorna el docente asignado al curso.
	 * @return docente asignado.
	 */
	public Docente getDocenteAsignado() {
		return docenteAsignado;
	}

	/**
	 * Retorna la lista de estudiantes inscritos en el curso.
	 * @return lista de estudiantes.
	 */
	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantesInscritos;
	}

	/**
	 * Retorna la lista de evaluaciones del curso.
	 * @return lista de evaluaciones.
	 */
	public ArrayList<Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}

	// Métodos específicos
	
	/**
	 * Inscribe un estudiante en el curso si no está ya inscrito.
	 *
	 * @param estudiante Estudiante a inscribir.
	 * @return true si se inscribe correctamente, false si ocurre un error.
	 */
	public boolean inscribirEstudiante(Estudiante estudiante) {
		try {
			if (!estudiantesInscritos.contains(estudiante)) {
				estudiantesInscritos.add(estudiante);
			} else {
				System.out.println("El estudiante ya esta inscrito en el curso.");
			}
			return true;
		} catch (Exception e) {
			System.out.println("No se pudo agregar al estudiante");
			return false;
		}
	}

	/**
	 * Agrega una evaluación a la lista del curso.
	 * 
	 * @param evaluacion Evaluación a agregar.
	 */
	public void agregarEvaluacion(Evaluacion evaluacion) {
		evaluaciones.add(evaluacion);
	}

	/**
	 * Calcula el promedio general del curso basado en el promedio de todos los 
	 * estudiantes inscritos.
	 *
	 * @return Promedio general del curso, o 0.0 si no hay estudiantes.
	 */
	public double getPromedioGeneralDelCurso() {
		if (estudiantesInscritos.isEmpty()) {
			return 0.0;
		}

		double sumaPromedios = 0.0;
		for (Estudiante estudiante : estudiantesInscritos) {
			sumaPromedios += estudiante.getPromedioGeneral();
		}

		return sumaPromedios / estudiantesInscritos.size();
	}

	/**
	 * Retorna el promedio general de una evaluación específica.
	 *
	 * @param evaluacion Evaluación a consultar.
	 * @return Promedio de la evaluación.
	 */
	public double getPromedioDeEvaluacion(Evaluacion evaluacion) {
		return evaluacion.getPromedioGeneral(); // Usa el método ya implementado en Evaluacion
	}

	/**
	 * Retorna una representación en forma de texto del curso,
	 * incluyendo código, nombre, créditos, docente y estudiantes inscritos.
	 *
	 * @return Representación del curso como cadena de texto.
	 */
	@Override
	public String toString() {
		return "--------------------\nCódigo = " + codigo + ",\nNombre =" + nombre + "\nCréditos = " + numCreditos
				+ "\nDocente = " + docenteAsignado + "\nEstudiantesInscritos = " + estudiantesInscritos
				+ "\n---------------------";
	}
}
