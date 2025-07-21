package sistema;

public class Inscripcion {
	private Estudiante estudiante; // Relación de asociación
	private Curso curso; // Relación de asociación
	private String fechaInscripcion;

	public Inscripcion() {
		// Constructor sin parámetros

	}

	public Inscripcion(Estudiante estudiante, Curso curso, String fechaInscripcion) {
		this.estudiante = estudiante;
		this.curso = curso;
		this.fechaInscripcion = fechaInscripcion;
	}

	// Getters y Setters para todos los atributos
	public Estudiante getEstudiante() {
		return null;
	}

	public Curso getCurso() {
		return null;
	}

	public String getFechaInscripcion() {
		return null;
	}

	@Override
	public String toString() {
		return String.format("Nombre: %s, Curso: %s, Fecha de inscripción: %s", this.estudiante.getNombre(),
				this.curso.getNombre(), this.fechaInscripcion);
	}
}
