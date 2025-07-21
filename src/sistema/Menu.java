/**
 * 
 * @author Yerko Osorio
 * @author Luis Guevara
 * @author Jhoseph Quiroga
 * @author Norma Armijo
 * @version 1.0
 */
package sistema;

import java.util.InputMismatchException;

/**
 * Clase encargada de mostrar y gestionar los menús de interacción del sistema
 * académico.
 * 
 * Ofrece opciones principales, submenús de registros, gestiones y
 * consultas/reportes. Permite también capturar la opción seleccionada por el
 * usuario.
 */
public class Menu {

	/**
	 * Constructor por defecto de la clase Menu.
	 */
	public Menu() {
	}

	/**
	 * Solicita al usuario que ingrese una opción del menú.
	 * 
	 * @return Número entero correspondiente a la opción seleccionada. Retorna
	 *         -1000 si hay error de entrada.
	 */
	public static int opcion() {
		try {
			System.out.println("\nIngrese el número de la opción seleccionada");
			int opcionSeleccionada = SistemaAcademico.sc.nextInt();
			SistemaAcademico.sc.nextLine();
			return opcionSeleccionada;
		} catch (InputMismatchException e) {
			System.out.println("⚠️ Entrada inválida. Debe ingresar un número.");
			SistemaAcademico.sc.nextLine();
			return -1000;
		}

	}

	/**
	 * Muestra el menú principal con las opciones generales del sistema.
	 */
	public void mostrarMenu() {
		int numeroOpcion = 1;
		System.out.println("\n" + "-".repeat(22) + " Menú " + "-".repeat(22));
		System.out.printf("(%d) Registros.\n", numeroOpcion++);
		System.out.printf("(%d) Gestionar.\n", numeroOpcion++);
		System.out.printf("(%d) Consultas y Reportes.\n", numeroOpcion++);
		System.out.printf("(%d) Salir.\n", numeroOpcion++);
	}

	/**
	 * Muestra el submenú correspondiente a las opciones de registro:
	 * estudiantes, docentes y cursos.
	 */
	public void mostrarSubmenuRegistros() {
		int numeroOpcion = 1;
		System.out.println(
				"\n" + "-".repeat(20) + " Registros " + "-".repeat(20));
		System.out.printf("(0) Volver al menú principal. \n");
		System.out.printf("(%d) Registar estudiantes.\n", numeroOpcion++);
		System.out.printf("(%d) Registrar docentes.\n", numeroOpcion++);
		System.out.printf("(%d) Registrar cursos.\n", numeroOpcion++);

	}

	/**
	 * Muestra el submenú correspondiente a la gestión de inscripciones y
	 * evaluaciones.
	 */
	public void mostrarSubmenuGestiones() {
		int numeroOpcion = 1;
		System.out.println(
				"\n" + "-".repeat(22) + " Gestionar " + "-".repeat(22));
		System.out.printf("(0) Volver al menú principal. \n");
		System.out.printf("(%d) Ingresar inscripción a curso.\n",
				numeroOpcion++);
		System.out.printf("(%d) Gestionar evaluaciones.\n", numeroOpcion++);

	}

	/**
	 * Muestra el submenú de consultas y reportes: listas de estudiantes,
	 * calificaciones, cursos destacados, y docentes con mayor carga.
	 */
	public void mostrarSubmenuConsultas() {
		int numeroOpcion = 1;
		System.out.println("\n" + "-".repeat(22) + " Consultas y Reportes "
				+ "-".repeat(22));
		System.out.printf("(0) Volver al menú principal. \n");
		System.out.printf("(%d) Listar todos los estudiantes del curso.\n",
				numeroOpcion++);
		System.out.printf("(%d) Mostrar calificaciones del alumno.\n",
				numeroOpcion++);
		System.out.printf("(%d) Mostrar cursos con promedios más altos.\n",
				numeroOpcion++);
		System.out.printf("(%d) Mostrar docentes con mayor carga académica.\n",
				numeroOpcion++);
		System.out.printf("(%d) Mostrar todos los cursos disponibles.\n",
				numeroOpcion++);
		System.out.printf("(%d) Mostrar todos los estudiantes inscritos.\n",
				numeroOpcion++);
		System.out.printf("(%d) Mostrar todos los profesores.\n",
				numeroOpcion++);

	}

}