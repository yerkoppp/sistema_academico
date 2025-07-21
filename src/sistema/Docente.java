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
 * Clase que representa a un docente dentro del sistema académico.
 * 
 * Cada docente posee un RUT, nombre, área de especialización y una lista de
 * cursos que dicta. Esta clase mantiene una relación de asociación con la clase
 * Curso.
 */
public class Docente {
	/**
	 * RUT del docente, utilizado como identificador único.
	 */
	private String rut;
	/**
	 * Nombre completo del docente.
	 */
	private String nombre;
	/**
	 * Área de especialización del docente (por ejemplo, Matemáticas, Lenguaje).
	 */
	private String areaEspecializacion;
	/**
	 * Lista de cursos que el docente ha dictado.
	 */
	private ArrayList<Curso> cursosDictados = new ArrayList<>();

	/**
	 * Constructor vacío de la clase Docente.
	 */
	public Docente() {
	}

	/**
	 * Constructor que inicializa un docente con sus datos básicos.
	 *
	 * @param rut                 RUT del docente.
	 * @param nombre              Nombre completo del docente.
	 * @param areaEspecializacion Área de especialización del docente.
	 */
	public Docente(String rut, String nombre, String areaEspecializacion) {
		this.rut = rut;
		this.nombre = nombre;
		this.areaEspecializacion = areaEspecializacion;
	}

	// Getters y Setters para todos los atributos

	/**
	 * Retorna el RUT del docente.
	 * 
	 * @return RUT como String.
	 */
	public String getRut() {
		return rut;
	}

	/**
	 * Retorna el nombre del docente.
	 * 
	 * @return Nombre como String.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Retorna el área de especialización del docente.
	 * 
	 * @return Área de especialización como String.
	 */
	public String getAreaEspecializacion() {
		return areaEspecializacion;
	}

	/**
	 * Retorna la lista de cursos dictados por el docente.
	 * 
	 * @return Lista de cursos.
	 */
	public ArrayList<Curso> getCursosDictados() {
		return cursosDictados;
	}

	// Métodos específicos

	/**
	 * Agrega un curso a la lista de cursos dictados por el docente.
	 *
	 * @param curso Curso que será agregado.
	 */
	public void agregarCurso(Curso curso) {
		cursosDictados.add(curso);
	}

	/**
	 * Retorna una representación en texto del docente.
	 * 
	 * @return Cadena con RUT, nombre y área de especialización.
	 */
	@Override
	public String toString() {
		return "RUT: " + rut + ", Nombre: " + nombre + ", Área: "
				+ areaEspecializacion;
	}
}