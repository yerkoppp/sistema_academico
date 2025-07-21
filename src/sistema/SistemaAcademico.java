/**
 * 
 * @author Yerko Osorio
 * @author Luis Guevara
 * @author Jhoseph Quiroga
 * @author Norma Armijo
 * @version 1.0
 */
package sistema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * lase principal del sistema académico. Se encarga de gestionar el flujo
 * principal del programa: menú, registros, inscripciones, evaluaciones,
 * reportes, etc.
 * 
 * Contiene listas estáticas de estudiantes, docentes, cursos, inscripciones y
 * evaluaciones.
 */

public class SistemaAcademico {

	/**
	 * Scanner global para la entrada por consola.
	 */
	static Scanner sc = new Scanner(System.in);
	/**
	 * Lista de todos los estudiantes registrados en el sistema.
	 */
	static ArrayList<Estudiante> estudiantes = new ArrayList<>();
	/**
	 * Lista de todos los docentes registrados en el sistema.
	 */
	static ArrayList<Docente> docentes = new ArrayList<>();
	/**
	 * Lista de todos los cursos registrados en el sistema.
	 */
	static ArrayList<Curso> cursos = new ArrayList<>();
	/**
	 * Lista de todas las inscripciones registradas.
	 */
	static ArrayList<Inscripcion> inscripciones = new ArrayList<>();
	/**
	 * Lista de todas las evaluaciones realizadas.
	 */
	static ArrayList<Evaluacion> evaluaciones = new ArrayList<>();

	/**
	 * Menú principal del sistema académico.
	 */
	static Menu menu = new Menu();
	/**
	 * Bandera que controla la ejecución del bucle principal.
	 */
	static boolean continuarMain = true;

	/**
	 * Punto de entrada del programa. Muestra la bienvenida y ejecuta el menú
	 * principal.
	 */
	public static void main(String[] args) {
		mostrarBienvenida();

		do {
			menu.mostrarMenu();
			ejecutarOpcion(menu.opcion());

		} while (continuarMain);

		sc.close();
	}

	/**
	 * Muestra un mensaje de bienvenida estilizado por consola al iniciar el
	 * sistema académico.
	 */
	public static void mostrarBienvenida() {
		System.out.println("=".repeat(50));
		System.out.println("-".repeat(6) + " BIENVENIDO AL SISTEMA ACADÉMICO "
				+ "-".repeat(6));
		System.out.println("=".repeat(50));
	}

	/**
	 * Ejecuta la opción seleccionada del menú principal.
	 * 
	 * @param opcion Número entero correspondiente a la opción del menú.
	 */
	public static void ejecutarOpcion(int opcion) {
		switch (opcion) {
		case 0: // CARGAR DATOS DE PRUEBA
			DatosPrueba datosPrueba = new DatosPrueba(cursos, docentes,
					estudiantes, inscripciones);
			break;
		case 1: // REGISTROS
			int opcionRegistros = -1;
			do {
				menu.mostrarSubmenuRegistros();
				opcionRegistros = menu.opcion();
				switch (opcionRegistros) {
				case 0: // Volver al menú principal.
					break;
				case 1: // Registar estudiantes
					System.out.printf("\nRegistar estudiantes.\n");
					estudiantes.add(registrarEstudiante());
					break;
				case 2: // Registrar docentes
					System.out.printf("\nRegistrar docentes.\n");
					registrarDocente();
					break;
				case 3: // Registrar cursos
					System.out.printf("\nRegistrar cursos.\n");
					cursos.add(crearCurso());
					break;
				default:
					System.out
							.printf("Opción no válida, intente nuevamente.\n");
					break;
				}
			} while (opcionRegistros != 0);
			break;
		case 2: // GESTIONAR
			int opcionGestionar = -1;
			do {
				menu.mostrarSubmenuGestiones();
				opcionGestionar = menu.opcion();
				switch (opcionGestionar) {
				case 0: // Volver al menú principal.
					break;
				case 1: // Ingresar inscripción a curso
					inscribirEstudianteEnCurso();
					break;
				case 2: // Gestionar evaluaciones
					registrarEvaluacion();
					break;
				default:
					System.out
							.printf("Opción no válida, intente nuevamente.\n");
					break;
				}
			} while (opcionGestionar != 0);
			break;
		case 3:
			int opcionConsultas = -1;
			do {
				menu.mostrarSubmenuConsultas();
				opcionConsultas = menu.opcion();
				switch (opcionConsultas) {
				case 0: // Volver al menú principal.
					break;
				case 1: // Listar todos los estudiantes del curso
					listarEstudiantesCurso();
					break;
				case 2: // Mostrar calificaciones del alumno
					listarCalificacionesAlumno();
					break;
				case 3: // Mostrar cursos con promedios más altos
					System.out.printf(
							"Mostrar cursos con promedios más altos...\n");
					reportarCursosPromediosMasAltos();
					break;
				case 4: // Mostrar docentes con mayor carga académica
					listarDocentesMayorCarga();
					break;
				case 5: // Mostrar todos los cursos disponibles
					listarCursos();
					break;
				case 6: // Mostrar todos los estudiantes inscritos
					mostrarTodosEstudiantes();
					break;
				case 7: // Mostrar todos los profesores
					mostrarTodosDocentes();
					break;
				default:
					System.out
							.printf("Opción no válida, intente nuevamente.\n");
					break;
				}
			} while (opcionConsultas != 0);
			break;
		case 4: // SALIR
			continuarMain = false;
			System.out.printf("El programa ha finalizado.\n");
			break;
		default:
			System.out.printf("Opción no válida, intente nuevamente.\n");
			break;
		}
	}

	/**
	 * Registra un nuevo docente solicitando sus datos por consola.
	 * 
	 * @return El objeto Docente creado, o null si el RUT no es válido.
	 */
	public static Estudiante registrarEstudiante() {
		try {
			System.out.println("Ingrese el RUT del estudiante (11222333-4): ");
			String rut = sc.nextLine();
			if (!validarRut(rut)) {
				System.out.println("⚠️ RUT ingresado es invalido.");
				return null;
			}
			System.out.println("Ingrese el nombre del estudiante: ");
			String nombre = sc.nextLine();
			System.out.println("Ingrese carrera del estudiante: ");
			String carrera = sc.nextLine();
			System.out.println("Ingrese el año de ingreso: ");
			int anioIngreso = sc.nextInt();
			sc.nextLine();
			Estudiante estudiante = new Estudiante(rut, nombre, carrera,
					anioIngreso);

			System.out.println("Estudiante registrado con éxito.");
			return estudiante;
		} catch (InputMismatchException e) {
			System.out.println("⚠️ Entrada inválida. Debe ingresar un número.");
			sc.nextLine();
			return null;
		}
	}

	/**
	 * Registra un nuevo docente solicitando sus datos por consola.
	 * 
	 * @return El objeto Docente creado, o null si el RUT no es válido.
	 */
	public static Docente registrarDocente() {
		System.out.println("Ingrese el nombre del docente: ");
		String nombre = sc.nextLine();
		System.out.println("Ingrese el RUT del docente: ");
		String rut = SistemaAcademico.sc.nextLine();
		if (!validarRut(rut)) {
			System.out.println("⚠️ RUT ingresado es invalido.");
			return null;
		}
		System.out.println("Ingrese el área de especialización del docente: ");
		String areaEspecializacion = sc.nextLine();
		Docente docente = new Docente(rut, nombre, areaEspecializacion);
		docentes.add(docente);
		System.out.println("Docente agregado con exito.");
		return docente;
	}

	/**
	 * Crea un nuevo curso solicitando los datos por consola. Verifica que el
	 * docente exista o permite registrarlo en el momento.
	 * 
	 * @return El objeto Curso creado, o null si hubo error de entrada.
	 */
	public static Curso crearCurso() {
		try {
			Curso nuevoCurso = null;
			System.out.println("Ingrese el nombre del curso: ");
			String nombre = sc.nextLine();
			System.out.println("Ingrese el codigo del curso: ");
			String codigo = sc.nextLine();
			System.out.println("Ingrese el número de créditos del curso: ");
			int numCreditos = sc.nextInt();
			sc.nextLine();
			System.out.println(
					"Ingrese el nombre del docente asignado al curso: ");
			String nombreDocente = sc.nextLine();

			boolean docenteEncontrado = false;

			for (Docente docente : docentes) {
				if (docente.getNombre().equals(nombreDocente)) {
					nuevoCurso = new Curso(codigo, nombre, numCreditos,
							docente);
					docente.agregarCurso(nuevoCurso);
					System.out.println("Curso creado exitosamente: " + nombre);
					docenteEncontrado = true;
					break;
				}
			}

			if (!docenteEncontrado) {
				System.out.println(
						"El docente ingresado no se encuentra ingresado. ¿Desea crearlo? (S/N)");
				String respuesta = sc.nextLine();
				if (respuesta.equalsIgnoreCase("S")) {
					Docente nuevoDocente = registrarDocente();
					if (nuevoDocente != null) {
						nuevoCurso = new Curso(codigo, nombre, numCreditos,
								nuevoDocente);
						nuevoDocente.agregarCurso(nuevoCurso);
						System.out.println(
								"Curso creado exitosamente: " + nombre);
					}
				}
			}
			return nuevoCurso;
		} catch (InputMismatchException e) {
			System.out.println("⚠️ Entrada inválida. Debe ingresar un número.");
			sc.nextLine();
			return null;
		}
	}

	/**
	 * Inscribe un estudiante en un curso, validando RUT y disponibilidad. Crea
	 * una instancia de inscripción y la agrega a las listas correspondientes.
	 */
//	public static void inscribirEstudianteEnCurso() {
//
//		System.out.printf("Ingresar inscripción.\n");
//		String cursoIngresado = seleccionarCurso();
//		System.out.println("Ingrese el RUT del estudiante: ");
//		String rutEstudiante = sc.nextLine();
//		if (!validarRut(rutEstudiante)) {
//			System.out.println("⚠️ RUT ingresado es invalido.");
//			return;
//		}
//		boolean estudianteEncontrado = false;
//		Estudiante estudiante = new Estudiante();
//		for (Estudiante estudiante1 : estudiantes) {
//			if (estudiante1.getRut().equalsIgnoreCase(rutEstudiante)) {
//				estudianteEncontrado = true;
//				estudiante = estudiante1;
//			}
//		}
//		if (!estudianteEncontrado) {
//			System.out.println("Estudiantes no encontrado. Debe registrarse.");
//			return;
//		}
//
//		if (estudiante == null || cursoIngresado == null
//				|| cursoIngresado.isEmpty()) {
//			System.out.println(
//					"Estudiante o curso no válidos. Intente nuevamente.");
//			return;
//		}
//		final String cursoFinal = cursoIngresado; // Lambda pedia una constante
//		if (estudiante.getCursos().stream()
//				.anyMatch(e -> e.getNombre().equals(cursoFinal))) {
//			System.out.println(
//					"Estudiante ya inscrito en el curso: " + cursoIngresado);
//			return;
//		} else {
//			boolean cursoEncontrado = false;
//			for (Curso curso : cursos) {
//				if (curso.getNombre().equals(cursoIngresado)) {
//					curso.inscribirEstudiante(estudiante);
//					estudiante.getCursos().add(curso);
//					Inscripcion nuevaInscripcion = new Inscripcion(estudiante,
//							curso, LocalDate.now().toString());
//					inscripciones.add(nuevaInscripcion);
//					curso.inscribirEstudiante(estudiante);
//					estudiante.agregarInscripcion(nuevaInscripcion);
//					cursoEncontrado = true;
//					System.out.println("Inscripción exitosa en el curso: "
//							+ cursoIngresado);
//					return;
//				}
//			}
//		}
//
//	}
	public static void inscribirEstudianteEnCurso() {

		System.out.printf("Ingresar inscripción.\n");
		String cursoIngresado = seleccionarCurso();

		System.out.println("Ingrese el RUT del estudiante: ");
		String rutEstudiante = sc.nextLine();

		if (!validarRut(rutEstudiante)) {
			System.out.println("⚠️ RUT ingresado es invalido.");
			return;
		}

		Estudiante estudiante = null;
		for (Estudiante est : estudiantes) {
			if (est.getRut().equalsIgnoreCase(rutEstudiante)) {
				estudiante = est;
				break;
			}
		}

		if (estudiante == null) {
			System.out.println("Estudiante no encontrado. Debe registrarse.");
			return;
		}

		if (cursoIngresado == null || cursoIngresado.isEmpty()) {
			System.out.println("Curso no válido. Intente nuevamente.");
			return;
		}

		if (estudiante.getCursos().stream().anyMatch(
				c -> c.getNombre().equalsIgnoreCase(cursoIngresado))) {
			System.out.println(
					"Estudiante ya inscrito en el curso: " + cursoIngresado);
			return;
		}

		for (Curso curso : cursos) {
			if (curso.getNombre().equalsIgnoreCase(cursoIngresado)) {
				curso.inscribirEstudiante(estudiante);
				estudiante.getCursos().add(curso);

				Inscripcion nuevaInscripcion = new Inscripcion(estudiante,
						curso, LocalDate.now().toString());
				inscripciones.add(nuevaInscripcion);
				estudiante.agregarInscripcion(nuevaInscripcion); // si lo tienes

				System.out.println("Inscripción exitosa en el curso: "
						+ curso.getNombre());
				return;
			}
		}

		System.out.println("Curso no encontrado.");
	}

	/**
	 * Muestra las calificaciones de un estudiante en todas las evaluaciones,
	 * buscándolo por RUT.
	 */
	public static void listarCalificacionesAlumno() {
		System.out.println("Ingrese el RUT del estudiante:");
		String rut = sc.nextLine();
		Estudiante estudiante = buscarEstudiantePorRut(rut);

		if (estudiante == null) {
			System.out.println("Estudiante no encontrado.");
			return;
		}

		boolean tieneCalificaciones = false;
		boolean mostrarTitulo = true;
		for (Evaluacion evaluacion : evaluaciones) {
			HashMap<Estudiante, Double> notas = evaluacion.getCalificaciones();

			if (notas.containsKey(estudiante)) {
				double nota = notas.get(estudiante);
				if (mostrarTitulo) {
					System.out.println("Las notas del estudiantes "
							+ estudiante.getNombre() + " son:");
					mostrarTitulo = false;
				}
				System.out.println("Tipo: " + evaluacion.getTipo() + ", Fecha: "
						+ evaluacion.getFecha() + ", Puntaje máximo: "
						+ evaluacion.getPuntajeMaximo() + ", Nota obtenida: "
						+ nota);
				tieneCalificaciones = true;
			}
		}

		if (!tieneCalificaciones) {
			System.out.println(
					"El estudiante no tiene calificaciones registradas.");
		}
	}

	/**
	 * Ordena y muestra los cursos según su promedio general, desde el más alto
	 * al más bajo.
	 */
	public static void reportarCursosPromediosMasAltos() {
		if (cursos.isEmpty()) {
			System.out.println("No hay cursos creados.");
			return;
		}
		cursos.sort((c1, c2) -> Double.compare(c2.getPromedioGeneralDelCurso(),
				c1.getPromedioGeneralDelCurso()));
		System.out.println("Listado de cursos con mayor promedio general:");
		System.out.printf("%-40s\t%s\n", "Nombre", "Promedio");
		for (Curso curso : cursos) {
			System.out.printf("%-40s\t%.1f\n", curso.getNombre(),
					curso.getPromedioGeneralDelCurso());
		}

	}

	/**
	 * Muestra por consola la lista de todos los cursos disponibles registrados
	 * en el sistema. Si no hay cursos, lo informa al usuario.
	 */
	public static void listarCursos() {
		if (cursos.isEmpty()) {
			System.out.println("No existen cursos");
		} else {
			System.out.println("Listado de cursos disponibles:");
			for (Curso curso : cursos) {
				if (curso != null) {
					System.out.println("- " + curso.getNombre());
				}

			}
		}
	}

	/**
	 * Solicita al usuario un curso y muestra todos los estudiantes inscritos en
	 * él. Si el curso no existe, muestra un mensaje de error.
	 */
	public static void listarEstudiantesCurso() {
		String cursoIngresado = seleccionarCurso();
		boolean encontrado = false;
		boolean imprimirTitulo = true;
		for (Curso curso : cursos) {
			if (curso.getNombre().equalsIgnoreCase(cursoIngresado)) {
				encontrado = true;
				if (curso.getEstudiantes().isEmpty()) {
					System.out.println(
							"No hay estudiantes inscritos en el curso.");
				}
				for (Estudiante estudiante : curso.getEstudiantes()) {
					if (imprimirTitulo) {
						System.out.println("Estudiantes del curso "
								+ curso.getNombre() + ":\n");
						imprimirTitulo = false;
					}
					System.out.println(estudiante.toString());
				}
			}
		}

		if (!encontrado) {
			System.out.println("No se encontró el curso ingresado.");
		}
	}

	/**
	 * Busca un estudiante por su RUT en la lista de estudiantes registrados.
	 *
	 * @param rut RUT del estudiante.
	 * @return Estudiante si lo encuentra, null si no.
	 */
	public static Estudiante buscarEstudiantePorRut(String rut) {
		boolean encontrado = false;
		for (Estudiante estudiante : estudiantes) {
			if (estudiante.getRut().equals(rut)) {
				encontrado = true;
				return estudiante;
			}
		}
		if (!encontrado) {
			System.out
					.println("No se encontró un estudiante con el RUT: " + rut);
		}
		return null;
	}

	/**
	 * Busca un docente por su RUT en la lista de docentes registrados.
	 * 
	 * @param rut RUT del docente
	 * @return Docente si lo encuentra, null si no.
	 */
	public static Docente buscarDocentePorRut(String rut) {
		int contador = 0;
		for (Docente docente : docentes) {
			if (docente.getRut().equals(rut)) {
				return docente;
			}
			contador++;
		}

		if (contador == docentes.size()) {
			System.out.println("No se encontró un docente con el RUT: " + rut);
		}

		return null;
	}

	/**
	 * Busca un curso por su código en la lista de cursos registrados.
	 *
	 * @param codigo Código del curso a buscar.
	 * @return Curso si lo encuentra, null si no.
	 */
	public static Curso buscarCursoPorCodigo(String codigo) {
		int contador = 0;
		for (Curso curso : cursos) {
			if (curso.getCodigo().equals(codigo)) {
				return curso;
			}
			contador++;
		}
		if (contador == cursos.size()) {
			System.out.println(
					"No se encontró un curso con el código: " + codigo);
		}
		return null;
	}

	/**
	 * Permite al usuario seleccionar un curso desde consola, con opción de
	 * mostrar la lista si no lo recuerda.
	 *
	 * @return El nombre del curso seleccionado, o null si falla.
	 */
	public static String seleccionarCurso() {
		String cursoIngresado;
		boolean continuar = true;
		int intentos = 0;
		do {
			System.out.println(
					"Ingrese un curso (Ingrese 0 si desea ver la lista de "
							+ "cursos): ");
			cursoIngresado = sc.nextLine();
			if (cursoIngresado.equals("0")) {
				listarCursos();
				System.out.println("Ingrese un curso");
				cursoIngresado = sc.nextLine();
			}
			// Busca el curso en la lista de cursos.

			for (Curso curso : cursos) {
				if (curso.getNombre().equalsIgnoreCase(cursoIngresado)) {
					continuar = false;
					return cursoIngresado;
				}
			}
			if (continuar) {
				System.out.println("Curso no encontrado.");
				intentos++;
			}
			if (intentos == 3) {
				System.out.println("Alcanzó el máximo número de intentos.");
				continuar = false;
			}

		} while (continuar);
		return null;
	}

	/**
	 * Registra una evaluación asociada a un curso, solicitando datos como tipo,
	 * puntaje máximo y notas para estudiantes desde consola.
	 */
	private static void registrarEvaluacion() {
		try {
			Curso curso = new Curso();

			System.out.printf("Registrar evaluación.\n");

			String cursoSeleccionado = seleccionarCurso();

			for (Curso curso1 : cursos) {
				if (curso1.getNombre().equalsIgnoreCase(cursoSeleccionado)) {
					curso = curso1;
					break;
				}
			}

			System.out.println("Ingrese el tipo de evaluación: ");
			String tipoEvaluacion = sc.nextLine();

			System.out.println("Ingrese el puntaje maximo: ");
			int puntajeMaximo = sc.nextInt();
			sc.nextLine();

			boolean continuar = true;
			do {
				System.out.println("Ingrese el RUT del estudiante: ");
				String rutEstudiante = sc.nextLine();

				System.out.println("Ingrese la nota: ");
				double nota = sc.nextDouble();
				sc.nextLine(); // Limpiar el buffer

				asignarCalificacionEvaluacion(rutEstudiante, curso,
						tipoEvaluacion, puntajeMaximo, nota);

				System.out.println(
						"¿Desea ingresar la nota de otro estudiante? (S/N)");
				String respuesta = sc.nextLine();
				if (respuesta.equalsIgnoreCase("N")) {
					continuar = false;
					return;
				}

			} while (continuar);
		} catch (InputMismatchException e) {
			System.out.println("⚠️ Entrada inválida. Debe ingresar un número.");
			sc.nextLine();
		}
	}

	/**
	 * Asocia una nota a un estudiante dentro de una evaluación en un curso
	 * determinado.
	 *
	 * @param rutEstudiante  RUT del estudiante.
	 * @param curso          Curso al que pertenece la evaluación.
	 * @param tipoEvaluacion Tipo de evaluación (Ej: Examen, Control).
	 * @param puntajeMaximo  Puntaje máximo de la evaluación.
	 * @param nota           Nota obtenida por el estudiante.
	 */
//	public static Inscripcion inscribirEstudianteEnCurso(Estudiante estudiante,
//			String cursoIngresado) {
//
//		return nuevaInscripcion;
//	}

	public static void asignarCalificacionEvaluacion(String rutEstudiante,
			Curso curso, String tipoEvaluacion, double puntajeMaximo,
			double nota) {

		Estudiante estudianteEvaluado = null;
		boolean estudianteEncontrado = false;
		for (Estudiante estudiante : estudiantes) {
			if (estudiante.getRut().equals(rutEstudiante)) {
				estudianteEvaluado = estudiante;
				estudianteEncontrado = true;
				break;
			}
		}
		if (!estudianteEncontrado) {
			System.out.println("Estudiante no encontrado");
			return;
		}
		LocalDate fechaActual = LocalDate.now();
		Evaluacion evaluacion = new Evaluacion(tipoEvaluacion,
				fechaActual.toString(), puntajeMaximo);

		boolean notaValida = evaluacion.asignarCalificacion(estudianteEvaluado,
				nota);
		if (notaValida) {
			curso.agregarEvaluacion(evaluacion);
			estudianteEvaluado.agregarEvaluacion(evaluacion);
			evaluaciones.add(evaluacion);

			System.out.println("Se ha registrado la evaluacion del estudiante "
					+ estudianteEvaluado.getNombre());
		}

	}

	/**
	 * Muestra la lista de todos los estudiantes registrados en el sistema.
	 */
	public static void mostrarTodosEstudiantes() {
		if (estudiantes.isEmpty()) {
			System.out.println("No hay estudiantes registrados.");
			return;
		}
		System.out.println("Lista de estudiantes:");
		for (Estudiante estudiante : estudiantes) {
			System.out.println(estudiante.toString());
		}
	}

	/**
	 * Muestra la lista de todos los docentes registrados en el sistema.
	 */
	public static void mostrarTodosDocentes() {
		if (docentes.isEmpty()) {
			System.out.println("No hay docentes registrados.");
			return;
		}
		System.out.println("Lista de docentes:");
		for (Docente docente : docentes) {
			System.out.println(docente.toString());
		}
	}

	/**
	 * Muestra la información del estudiante con el RUT dado.
	 *
	 * @param rutEstudiante RUT del estudiante.
	 */
	public static void mostrarCalificacionesDeEstudianteEnTodosSusCursos(
			String rutEstudiante) {

		for (Estudiante estudiante : SistemaAcademico.estudiantes) {

			if (estudiante.getRut().equals(rutEstudiante)) {
				System.out.println(estudiante.toString());
			}
		}
	}

	/**
	 * Ordena y muestra los docentes según la cantidad de cursos que dictan, del
	 * que más cursos tiene al que menos.
	 */
	public static void listarDocentesMayorCarga() {
		if (docentes.isEmpty()) {
			System.out.println("No hay docentes creados.");
			return;
		}
		docentes.sort((d1, d2) -> Integer.compare(d2.getCursosDictados().size(),
				d1.getCursosDictados().size()));

		System.out.println("Docentes con mas cursos dictados:");
		System.out.printf("%-15s\t%s\n", "Nombre", "Cantidad");
		for (Docente docente : docentes) {
			System.out.printf("%-15s\t%d\n", docente.getNombre(),
					docente.getCursosDictados().size());
		}
	}

	/**
	 * Valida un RUT chileno utilizando el algoritmo del Módulo 11.
	 * 
	 * @param rut RUT en formato 11222333-K
	 * @return true si es válido, false si no.
	 */
	public static boolean validarRut(String rut) {

		if (rut == null || !rut.matches("\\d{7,8}-[0-9Kk]")) {
			return false;
		}
		// =====================================================
		// PASO 1: MULTIPLICACIÓN CON SECUENCIA 2,3,4,5,6,7
		// =====================================================

		int[] multiplicadores = { 2, 3, 4, 5, 6, 7 };
		int suma = 0;
		int j = 0;
		String digitoVerificadorUsuario = null;

		// Recorremos el RUT de derecha a izquierda
		for (int i = rut.length() - 1; i >= 0; i--) {

			if (i == rut.length() - 1) {
				digitoVerificadorUsuario = String.valueOf(rut.charAt(i));

				// Aca se salta el digito verificador y el guión
			} else if (i < rut.length() - 2) {

				int digito = Character.getNumericValue(rut.charAt(i));
				int producto = digito * multiplicadores[j];
				suma += producto;

				// Avanzar al siguiente multiplicador
				j++;
				if (j >= multiplicadores.length) {
					j = 0; // Reiniciar secuencia
				}
			}
		}

		// =====================================================
		// PASO 2: CÁLCULO DEL MÓDULO 11
		// =====================================================

		int resto = suma % 11;
		int resultado = 11 - resto;

		// =====================================================
		// PASO 3: APLICACIÓN DE REGLAS ESPECIALES
		// =====================================================

		String digitoVerificador;

		if (resultado == 11) {
			digitoVerificador = "0";
//			System.out.println("Caso especial: 11 → 0");
		} else if (resultado == 10) {
			digitoVerificador = "K";
//			System.out.println("Caso especial: 10 → K");
		} else {
			digitoVerificador = String.valueOf(resultado);
//			System.out.println("Caso normal: " + resultado);
		}

		if (digitoVerificadorUsuario.equalsIgnoreCase(digitoVerificador)) {

			return true;
		} else {
			return false;
		}
	}

}