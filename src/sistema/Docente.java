package sistema;

import java.util.ArrayList;

//Clase Docente
public class Docente {
	private String rut;
	private String nombre;
	private String areaEspecializacion;
	private ArrayList<Curso> cursosDictados; // Relación de asociación

	public Docente() {
		// Constructor sin parámetros
	}

	public Docente(String rut, String nombre, String areaEspecializacion) {
		this.rut = rut;
		this.nombre = nombre;
		this.areaEspecializacion = areaEspecializacion;
	}

	// Getters y Setters para todos los atributos
	public String getRut() {
		return rut;
	}

	public String getNombre() {
		return nombre;
	}

	public String getAreaEspecializacion() {
		return areaEspecializacion;
	}

	public ArrayList<Curso> getCursosDictados() {
		return cursosDictados;
	}

	// Métodos específicos
	public void agregarCurso(Curso curso) {
		/* ... */ } // Para asociar cursos que dicta

	@Override
	public String toString() {
		return "RUT: " + rut + ", Nombre: " + nombre + ", Área: " + areaEspecializacion;
	}
}