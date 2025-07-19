package sistema;

public class Menu {

	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public static int opcion() {

		System.out.println("\nIngrese el número de la opción seleccionada");
		int opcionSeleccionada = SistemaAcademico.sc.nextInt();
		SistemaAcademico.sc.nextLine();
		return opcionSeleccionada;
	}

	public void mostrarMenu() {
		int numeroOpcion = 1;
		System.out.println("\n" + "-".repeat(22) + " Menú " + "-".repeat(22));
		System.out.printf("(%d) Registros.\n", numeroOpcion++);
		System.out.printf("(%d) Gestionar.\n", numeroOpcion++);
		System.out.printf("(%d) Consultas y Reportes.\n", numeroOpcion++);
		System.out.printf("(%d) Salir.\n", numeroOpcion++);

	}

	public void mostrarSubmenuRegistros() {
		int numeroOpcion = 1;
		System.out.println("\n" + "-".repeat(20) + " Registros " + "-".repeat(20));
		System.out.printf("(%d) Registar estudiantes.\n", numeroOpcion++);
		System.out.printf("(%d) Registrar docentes.\n", numeroOpcion++);
		System.out.printf("(%d) Registrar cursos.\n", numeroOpcion++);

		SistemaAcademico.ejecutarOpcion(opcion() + 4);
	}

	public void mostrarSubmenuGestiones() {
		int numeroOpcion = 1;
		System.out.println("\n" + "-".repeat(22) + " Gestionar " + "-".repeat(22));
		System.out.printf("(%d) Ingresar inscripción a curso.\n", numeroOpcion++);
		System.out.printf("(%d) Gestionar evaluaciones.\n", numeroOpcion++);

		SistemaAcademico.ejecutarOpcion(opcion() + 7);
	}

	public void mostrarSubmenuConsultas() {
		int numeroOpcion = 1;
		System.out.println("\n" + "-".repeat(22) + " Consultas y Reportes " + "-".repeat(22));
		System.out.printf("(%d) Listar todos los estudiantes del curso...\n", numeroOpcion++);
		System.out.printf("(%d) Mostrar calificaciones del alumno...\n", numeroOpcion++);
		System.out.printf("(%d) Mostrar cursos con promedios más altos...\n", numeroOpcion++);
		System.out.printf("(%d) Mostrar docentes con mayor carga académica...\n", numeroOpcion++);
		System.out.printf("(%d) Mostrar todos los cursos disponibles...\n", numeroOpcion++);
		System.out.printf("(%d) Mostrar todos los estudiantes inscritos...\n", numeroOpcion++);
		System.out.printf("(%d) Mostrar todos los profesores...\n", numeroOpcion++);

		SistemaAcademico.ejecutarOpcion(opcion() + 9);
	}

}