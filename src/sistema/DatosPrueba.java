package sistema;

import java.util.ArrayList;

public class DatosPrueba {

	public DatosPrueba(ArrayList<Curso> cursos, ArrayList<Docente> docentes, ArrayList<Estudiante> estudiantes,
			ArrayList<Inscripcion> inscripciones) {
		// 1. Crear instancia del SistemaAcademico

		// 2. Crear y registrar Docentes
		Docente docente1 = new Docente("11111111-1", "Ana Garcia", "Programación");
		Docente docente2 = new Docente("22222222-2", "Juan Perez", "Bases de Datos");
		Docente docente3 = new Docente("33333333-3", "Maria Lopez", "Redes");

		docentes.add(docente1);
		docentes.add(docente2);
		docentes.add(docente3);

		// 3. Crear y registrar Estudiantes
		Estudiante estudiante1 = new Estudiante("12345678-9", "Carlos Rojas", "Ingeniería Informática", 2023);
		Estudiante estudiante2 = new Estudiante("98765432-1", "Laura Soto", "Diseño Gráfico", 2024);
		Estudiante estudiante3 = new Estudiante("45678912-3", "Pedro Gómez", "Ingeniería Informática", 2023);
		Estudiante estudiante4 = new Estudiante("78912345-6", "Sofía Diaz", "Contabilidad", 2024);

		estudiantes.add(estudiante1);
		estudiantes.add(estudiante2);
		estudiantes.add(estudiante3);
		estudiantes.add(estudiante4);

		// 4. Crear y registrar Cursos
		Curso curso1 = new Curso("PROG101", "Programación Orientada a Objetos", 5, docente1);
		Curso curso2 = new Curso("BD201", "Modelado de Bases de Datos", 4, docente2);
		Curso curso3 = new Curso("RED301", "Redes de Computadoras I", 6, docente3);
		Curso curso4 = new Curso("CONT101", "Contabilidad Básica", 3, docente3); // Docente 3 también dicta este curso

		cursos.add(curso1);
		cursos.add(curso2);
		cursos.add(curso3);
		cursos.add(curso4);

		// 6. Crear Evaluaciones y asignar calificaciones
		System.out.println("--- Asignación de Calificaciones ---");
		Evaluacion evalPOO_Parcial1 = new Evaluacion("Control", "15/05/2025", 7.0);
		Evaluacion evalBD_ExamenFinal = new Evaluacion("Examen", "20/07/2025", 100.0);
		Evaluacion evalRedes_Tarea1 = new Evaluacion("Trabajo", "01/06/2025", 10.0);
		Evaluacion evalContabilidad_Parcial = new Evaluacion("Examen", "10/06/2025", 7.0);

		curso1.agregarEvaluacion(evalPOO_Parcial1);
		curso2.agregarEvaluacion(evalBD_ExamenFinal);
		curso3.agregarEvaluacion(evalRedes_Tarea1);
		curso4.agregarEvaluacion(evalContabilidad_Parcial);

		// Asignar calificaciones a Carlos en POO
		evalPOO_Parcial1.asignarCalificacion(estudiante1, 6.5);
		// Asignar calificaciones a Laura en POO
		evalPOO_Parcial1.asignarCalificacion(estudiante2, 5.8);
		// Asignar calificaciones a Pedro en POO
		evalPOO_Parcial1.asignarCalificacion(estudiante3, 6.0);

		// Asignar calificaciones a Carlos en BD
		evalBD_ExamenFinal.asignarCalificacion(estudiante1, 85.0);

		// Asignar calificaciones a Pedro en Redes
		evalRedes_Tarea1.asignarCalificacion(estudiante3, 9.5);

		// Asignar calificaciones a Sofía en Contabilidad
		evalContabilidad_Parcial.asignarCalificacion(estudiante4, 6.8);
		System.out.println("Calificaciones asignadas a estudiantes en diversas evaluaciones.");
		System.out.println("\n");

	}
}
