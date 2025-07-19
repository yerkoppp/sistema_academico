package sistema;

import java.util.ArrayList;

//Clase Curso
public class Curso {
	private String codigo;
	private String nombre;
	private int numCreditos;
	private Docente docenteAsignado; // Relación de asociación
	private ArrayList<Evaluacion> evaluaciones; // Relación de composición
	private ArrayList<Estudiante> estudiantesInscritos; // Para gestionar inscripciones de estudiantes

	public Curso() {
		// Constructor sin parámetros
	}

	public Curso(String codigo, String nombre, int numCreditos, Docente docenteAsignado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.numCreditos = numCreditos;
		this.docenteAsignado = docenteAsignado;
		this.evaluaciones = new ArrayList<>();
	}

	// Getters y Setters para todos los atributos
	public String getNombre() {
		return nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public int getNumCreditos() {
		return numCreditos;
	}

	public void setNumCreditos(int numCreditos) {
		this.numCreditos = numCreditos;
	}

	public Docente getDocenteAsignado() {
		return docenteAsignado;
	}

	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantesInscritos;
	}

	public ArrayList<Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}

	// Métodos específicos
	public boolean inscribirEstudiante(Estudiante estudiante) {
		try {
			if (!estudiantesInscritos.contains(estudiante)) {
				estudiantesInscritos.add(estudiante);
			}
			return true;
		} catch (Exception e) {
			System.out.println("No se pudo agregar al estudiante");
			return false;
		}
	}

	public void agregarEvaluacion(Evaluacion evaluacion) {
		evaluaciones.add(evaluacion);
		System.out.println("Se agrego la evaluacion con exito.");
	}

	/**
	 * Calcula el promedio general del curso Basado en el promedio de cada
	 * estudiante
	 */
	public double getPromedioGeneralDelCurso() {
		if (estudiantesInscritos.isEmpty()) {
			System.out.println("No hay estudiantes en el curso.");
			return 0.0;
		}

		double sumaPromedios = 0.0;
		for (Estudiante estudiante : estudiantesInscritos) {
			sumaPromedios += estudiante.getPromedioGeneral();
		}

		return sumaPromedios / estudiantesInscritos.size();
	}

	/**
	 * Obtiene el promedio de una evaluación específica
	 */
	public double getPromedioDeEvaluacion(Evaluacion evaluacion) {
		return evaluacion.getPromedioGeneral(); // Usa el método ya implementado en Evaluacion
	}

	@Override
	public String toString() {
		return "--------------------\nCódigo = " + codigo + ",\nNombre =" + nombre + "\nCréditos = " + numCreditos
				+ "\nDocente = " + docenteAsignado + "\nEstudiantesInscritos = " + estudiantesInscritos
				+ "\n---------------------";
	}
}
