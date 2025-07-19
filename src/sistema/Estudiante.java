package sistema;

import java.util.ArrayList;

// Clase Estudiante
public class Estudiante {
	private String rut;
	private String nombre;
	private String carrera;
	private int anioIngreso;
	private ArrayList<Inscripcion> inscripciones; // Relación de composición
	private ArrayList<Curso> cursos; // Relación de composición

	public Estudiante() {
		// Constructor sin parámetros
	}

	/**
	 * @param rut
	 * @param nombre
	 * @param carrera
	 * @param anoIngreso
	 * @param inscripciones
	 */
	public Estudiante(String rut, String nombre, String carrera, int anioIngreso) {
		this.rut = rut;
		this.nombre = nombre;
		this.carrera = carrera;
		this.anioIngreso = anioIngreso;
	}

	// Getters y Setters para todos los atributos
	public String getRut() {
		return rut;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCarrera() {
		return carrera;
	}

	public int getAnoIngreso() {
		return anioIngreso;
	}

	public ArrayList<Inscripcion> getInscripciones() {
		return inscripciones;
	}

	/**
	 * @return the cursos
	 */
	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	// Métodos específicos
	public double getPromedioGeneral() {
		return 0.0;
	}

	public void agregarInscripcion(Inscripcion inscripcion) {
		if (!inscripciones.contains(inscripcion)) {
			inscripciones.add(inscripcion);
			System.out.println("Curso inscrito exitosamente");
		} else {
			System.out.println("Ya se encuentra inscrito en el curso");
		}
	}

	@Override
	public String toString() {
		return String.format("Nombre: %s, RUT: %s, Carrera: %s, Año de ingreso: %d", this.nombre, this.rut,
				this.carrera, this.anioIngreso);
	}
}