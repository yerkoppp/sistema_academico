/**
 * 
 * @author Yerko Osorio
 * @author Luis Guevara
 * @author Jhoseph Quiroga
 * @author Norma Armijo
 * @version 1.0
 */

package sistema;

/**
 * Representa la inscripción de un estudiante en un curso específico. Contiene
 * la relación entre un estudiante, un curso y la fecha de inscripción.
 * 
 */
public class Inscripcion {
	/**
	 * Estudiante que se inscribe en el curso.
	 */
	private Estudiante estudiante;
	/**
	 * Curso en el cual se inscribe el estudiante.
	 */
	private Curso curso;
	/**
	 * Fecha en que se realizó la inscripción (formato: DD/MM/AAAA).
	 */
	private String fechaInscripcion;

	/**
	 * Constructor sin parámetros. Se recomienda utilizar el constructor con
	 * parámetros para inicializar la inscripción.
	 */
	public Inscripcion() {
	}

	/**
	 * Constructor que permite crear una inscripción con todos los datos
	 * necesarios.
	 *
	 * @param estudiante       Estudiante que se inscribe.
	 * @param curso            Curso en el que se inscribe.
	 * @param fechaInscripcion Fecha de inscripción.
	 */
	public Inscripcion(Estudiante estudiante, Curso curso,
			String fechaInscripcion) {
		this.estudiante = estudiante;
		this.curso = curso;
		this.fechaInscripcion = fechaInscripcion;
	}

	// Getters y Setters para todos los atributos

	/**
	 * Obtiene el estudiante inscrito.
	 * 
	 * @return Objeto de tipo {@link Estudiante}.
	 */
	public Estudiante getEstudiante() {
		return estudiante;
	}

	/**
	 * Obtiene el curso en el que se inscribió el estudiante.
	 * 
	 * @return Objeto de tipo {@link Curso}.
	 */
	public Curso getCurso() {
		return curso;
	}

	/**
	 * Obtiene la fecha en la que se realizó la inscripción.
	 * 
	 * @return Fecha de inscripción en formato String.
	 */
	public String getFechaInscripcion() {
		return fechaInscripcion;
	}

	/**
	 * Devuelve una representación en formato String de la inscripción.
	 * 
	 * @return Información formateada del estudiante, curso y fecha.
	 */
	@Override
	public String toString() {
		return String.format("Nombre: %s, Curso: %s, Fecha de inscripción: %s",
				this.estudiante.getNombre(), this.curso.getNombre(),
				this.fechaInscripcion);
	}
}
