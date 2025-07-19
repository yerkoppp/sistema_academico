package sistema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// Clase SistemaAcademico (Clase principal para la gestión)
public class SistemaAcademico {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Estudiante> estudiantes = new ArrayList<>();
	static ArrayList<Docente> docentes = new ArrayList<>();
	static ArrayList<Curso> cursos = new ArrayList<>();
	static ArrayList<Inscripcion> inscripciones = new ArrayList<>();
	static ArrayList<Evaluacion> evaluaciones = new ArrayList<>();

	static Menu menu = new Menu();
	static boolean continuar = true;

	public static void main(String[] args) {

		mostrarBienvenida();

		do {
			menu.mostrarMenu();
			ejecutarOpcion(menu.opcion());
		} while (continuar);

		sc.close();
	}

	public static void mostrarBienvenida() {
		System.out.println("=".repeat(50));
		System.out.println("-".repeat(6) + " BIENVENIDO AL SISTEMA ACADÉMICO " + "-".repeat(6));
		System.out.println("=".repeat(50));
	}

	public static void ejecutarOpcion(int opcion) {

		switch (opcion) {
		case 0:
			DatosPrueba datosPrueba = new DatosPrueba(cursos, docentes, estudiantes, inscripciones);
			break;
		case 1:
			menu.mostrarSubmenuRegistros();
			break;
		case 2:
			menu.mostrarSubmenuGestiones();
			break;
		case 3:
			menu.mostrarSubmenuConsultas();
			break;
		case 5:
			System.out.printf("\nRegistar estudiantes.\n");
			estudiantes.add(registrarEstudiante(cursos));
			break;
		case 6:
			System.out.printf("\nRegistrar docentes.\n");
			docentes.add(registrarDocente());
			break;
		case 7:
			System.out.printf("\nRegistrar cursos.\n");
			cursos.add(crearCurso(cursos, docentes));
			break;
		case 8:
			inscribirEstudianteEnCurso();
			break;
		case 9:
			System.out.printf("Registrar evaluación.\n");
			System.out.println("Ingrese el RUT del estudiante: ");
			String rutEstudiante = sc.nextLine();
			System.out.println("Ingrese el código del curso: ");
			String codigoCurso = sc.nextLine();
			System.out.println("Ingrese el tipo de evaluación: ");
			String tipoEvaluacion = sc.nextLine();
			System.out.println("Ingrese la nota: ");
			double nota = sc.nextDouble();
			sc.nextLine(); // Limpiar el buffer
			asignarCalificacionEvaluacion(rutEstudiante, codigoCurso, tipoEvaluacion, nota);
			System.out.println("Calificación asignada exitosamente.");
			break;
		case 10:
			System.out.printf("Listar todos los estudiantes del curso...\n");
			listarEstudiantesCurso();
			break;
		case 11:
			System.out.printf("Mostrar calificaciones del alumno...\n");
			listarCalificacionesAlumno();
			break;
		case 12:
			System.out.printf("Mostrar cursos con promedios más altos...\n");
			// mostrarCursoPromediosMasAltos();
			break;
		case 13:
			System.out.printf("Mostrar docentes con mayor carga académica...\n");
			break;
		case 14:
			System.out.printf("Mostrar todos los cursos disponibles...\n");
			listarCursos();
			break;
		case 15:
			System.out.printf("Mostrar todos los estudiantes...\n");
			mostrarTodosEstudiantes();
			break;
		case 16:
			System.out.printf("Mostrar todos los docentes...\n");
			mostrarTodosDocentes();
			break;
		case 4:
			continuar = false;
			System.out.printf("El programa ha finalizado.\n");
			break;
		default:
			System.out.printf("Opción no válida, intente nuevamente.\n");
			break;

		}

	}

	public static void inscribirEstudianteEnCurso() {
		System.out.printf("Ingresar inscripción.\n");
		System.out.println("Ingrese el nombre del curso al que desea inscribir al estudiante: ");
		String curso = sc.nextLine();
		System.out.println("Ingrese el RUT del estudiante: ");
		String rutEstudiante = sc.nextLine();
		for (Estudiante estudiante : estudiantes) {
			if (estudiante.getRut().equalsIgnoreCase(rutEstudiante)) {
				inscripciones.add(inscribirEstudianteEnCurso(estudiante, curso));
				break;
			}
		}
		System.out.println("Inscripción realizada con éxito.");

	}

	/**
	 * @return the estudiantes
	 */
	public static ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	/**
	 * @param estudiantes the estudiantes to set
	 */
	public static void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		SistemaAcademico.estudiantes = estudiantes;
	}

	public static void listarCalificacionesAlumno() {
		System.out.println("Ingrese el RUT del estudiante:");
		String rut = sc.nextLine();
		Estudiante estudiante = buscarEstudiantePorRut(rut);

		if (estudiante == null) {
			System.out.println("Estudiante no encontrado.");
			return;
		}

		boolean tieneCalificaciones = false;

		for (Evaluacion evaluacion : evaluaciones) {
			HashMap<Estudiante, Double> notas = evaluacion.getCalificaciones();

			if (notas.containsKey(estudiante)) {
				double nota = notas.get(estudiante);
				System.out.println("Tipo: " + evaluacion.getTipo() + ", Fecha: " + evaluacion.getFecha()
						+ ", Puntaje máximo: " + evaluacion.getPuntajeMaximo() + ", Nota obtenida: " + nota);
				tieneCalificaciones = true;
			}
		}

		if (!tieneCalificaciones) {
			System.out.println("El estudiante no tiene calificaciones registradas.");
		}
	}

	public static void listarCursos() {
		for (Curso curso : cursos) {
			System.out.println(curso.toString());
		}
	}

	public static void mostrarCursoPromediosMasAltos() {

	}

	public static void listarEstudiantesCurso() {
		listarCursos();
		System.out.println("Ingrese el nombre del curso que quiere listar los estudiantes: ");
		String cursoIngresado = sc.nextLine();
		boolean encontrado = false;

		for (Curso curso : cursos) {
			if (curso.getNombre().equalsIgnoreCase(cursoIngresado)) {
				encontrado = true;
				System.out.println("Estudiantes del curso " + curso.getNombre() + ":");
				for (Estudiante estudiante : curso.getEstudiantes()) {
					System.out.println(estudiante.toString());
				}
			}
		}

		if (!encontrado) {
			System.out.println("No se encontró el curso ingresado.");
		}
	}

	// Métodos auxiliares para buscar objetos por ID
	public static Estudiante buscarEstudiantePorRut(String rut) {
		int contador = 0;
		for (Estudiante estudiante : estudiantes) {
			if (estudiante.getRut().equals(rut)) {
				return estudiante;
			}
			contador++;
		}
		if (contador == estudiantes.size()) {
			System.out.println("No se encontró un estudiante con el RUT: " + rut);
		}
		return null;
	}

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

	public static Curso buscarCursoPorCodigo(String codigo) {
		int contador = 0;
		for (Curso curso : cursos) {
			if (curso.getCodigo().equals(codigo)) {
				return curso;
			}
			contador++;
		}
		if (contador == cursos.size()) {
			System.out.println("No se encontró un curso con el código: " + codigo);
		}
		return null;
	}

	public static Estudiante registrarEstudiante(ArrayList<Curso> cursos) {

		System.out.println("Ingrese el RUT del estudiante: ");
		String rut = sc.nextLine();
		System.out.println("Ingrese el nombre del estudiante: ");
		String nombre = sc.nextLine();
		System.out.println("Ingrese carrera del estudiante: ");
		String carrera = sc.nextLine();
		System.out.println("Ingrese el año de ingreso: ");
		int anioIngreso = sc.nextInt();
		sc.nextLine();
		Estudiante estudiante = new Estudiante(rut, nombre, carrera, anioIngreso);

		ArrayList<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
		boolean continuar = true;
		do {
			System.out.println("Ingrese un curso (Ingrese 0 si desea ver la lista de cursos): ");
			String nombreCurso = sc.nextLine();
			if (nombreCurso.equals("0")) {
				listarCursos();
				System.out.println("Ingrese un curso");
				nombreCurso = sc.nextLine();
			}
			// Busca el curso en la lista de cursos.
			for (Curso curso : cursos) {

				if (curso.getNombre().equalsIgnoreCase(nombreCurso)) {
					estudiante.agregarInscripcion(new Inscripcion(estudiante, curso, LocalDate.now().toString()));
					System.out.println("Inscripción exitosa en el curso: " + curso.getNombre());
					continuar = false;
					break;
				}
			}

		} while (continuar);

		return estudiante;
	}

	public static Docente registrarDocente(String nombre) {

		System.out.println("Ingrese el RUT del docente: ");
		String rut = SistemaAcademico.sc.nextLine();
		System.out.println("Ingrese el área de especialización del docente: ");
		String areaEspecializacion = sc.nextLine();
		return new Docente(rut, nombre, areaEspecializacion);

	}

	public static Docente registrarDocente() {
		System.out.println("Ingrese el nombre del docente: ");
		String nombre = sc.nextLine();
		return registrarDocente(nombre);
	}

	public static Curso crearCurso(ArrayList<Curso> cursos, ArrayList<Docente> docentes) {
		Curso nuevoCurso = null;
		System.out.println("Ingrese el nombre del curso: ");
		String nombre = sc.nextLine();
		System.out.println("Ingrese el codigo del curso: ");
		String codigo = sc.nextLine();
		System.out.println("Ingrese el número de créditos del curso: ");
		int numCreditos = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese el nombre del docente asignado al curso: ");
		String nombreDocente = sc.nextLine();

		int contadorDocentes = 0;

		for (Docente docente : docentes) {
			if (docente.getNombre().equals(nombreDocente)) {
				nuevoCurso = new Curso(codigo, nombre, numCreditos, docente);
			} else {
				contadorDocentes++;
			}
		}

		if (contadorDocentes == docentes.size()) {
			System.out.println("El docente ingresado no se encuentra ingresado. ¿Desea crearlo? (S/N)");
			String respuesta = sc.nextLine();
			if (respuesta.equalsIgnoreCase("S")) {
				Docente nuevoDocente = registrarDocente(nombreDocente);
				nuevoCurso = new Curso(codigo, nombre, numCreditos, nuevoDocente);
			}
		}
		System.out.println("Curso creado exitosamente: " + nombre);
		return nuevoCurso;
	}

	public static Inscripcion inscribirEstudianteEnCurso(Estudiante estudiante, String curso) {

		Inscripcion nuevaInscripcion = null;
		if (estudiante == null || curso == null || curso.isEmpty()) {
			System.out.println("Estudiante o curso no válidos. Intente nuevamente.");
			return nuevaInscripcion;
		}
		if (estudiante.getCursos().stream().anyMatch(e -> e.getNombre().equals(curso))) {
			System.out.println("Estudiante ya inscrito en el curso: " + curso);
			return nuevaInscripcion;
		} else {
			int contador = 0;
			for (Curso c : cursos) {
				if (c.getNombre().equals(curso)) {
					c.inscribirEstudiante(estudiante);
					estudiante.getCursos().add(c);
					nuevaInscripcion = new Inscripcion(estudiante, c, LocalDate.now().toString());
					System.out.println("Inscripción exitosa en el curso: " + curso);
					return nuevaInscripcion;
				}
				contador++;
			}
			if (contador == cursos.size()) {
				System.out.println("Curso no disponible: " + curso);
			}
		}

		return nuevaInscripcion;
	}

	public static void asignarCalificacionEvaluacion(String rutEstudiante, String codigoCurso, String tipoEvaluacion,
			double nota) {

		Curso curso = buscarCursoPorCodigo(codigoCurso);
		Estudiante estudianteEvaluado = null;
		for (Estudiante estudiante : estudiantes) {
			if (estudiante.getRut().equals(rutEstudiante)) {
				estudianteEvaluado = estudiante;
				break;
			}
		}
		LocalDate fechaActual = LocalDate.now();
		System.out.println("Ingrese el puntaje maximo: ");
		int puntajeMaximo = sc.nextInt();
		sc.nextLine();
		Evaluacion evaluacion = new Evaluacion(tipoEvaluacion, fechaActual.toString(), puntajeMaximo);
		evaluacion.asignarCalificacion(estudianteEvaluado, nota);
	}

	// Funciona
	public static void mostrarTodosEstudiantes() {
		if (estudiantes.isEmpty()) {
			System.out.println("No hay estudiantes registrados.");
			return;
		}
		System.out.println("Lista de estudiantes:");
		for (Estudiante estudiante : estudiantes) {
			System.out.println(estudiante);
		}
	}

	// Funciona
	public static void mostrarTodosDocentes() {
		if (docentes.isEmpty()) {
			System.out.println("No hay docentes registrados.");
			return;
		}
		System.out.println("Lista de docentes:");
		for (Docente docente : docentes) {
			System.out.println(docente);
		}
	}

	public static void mostrarCursosDisponibles() {

		for (Curso curso : SistemaAcademico.cursos) {
			System.out.println(curso.getNombre());
		}

	}

	public static void listarEstudiantesInscritosEnCurso(String curso) {

		for (Estudiante estudiante : SistemaAcademico.estudiantes) {

			if (estudiante.getCursos().stream().anyMatch(c -> c.getNombre().equals(curso))) {
				System.out.println(estudiante.toString());
			}
		}

	}

	public static void mostrarCalificacionesDeEstudianteEnTodosSusCursos(String rutEstudiante) {

		for (Estudiante estudiante : SistemaAcademico.estudiantes) {

			if (estudiante.getRut().equals(rutEstudiante)) {
				System.out.println(estudiante.toString());
			}
		}

	}

	public static void reportarCursosConPromediosMasAltos() {

	}

	public static void mostrarDocentesConMayorCargaAcademica() {

	}

}