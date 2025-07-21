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
 * Clase utilizada para cargar datos de prueba en el sistema académico.
 * 
 * Esta clase inicializa y agrega docentes, estudiantes, cursos, inscripciones y
 * evaluaciones con calificaciones de ejemplo.
 * 
 * Se utiliza para poblar el sistema con información inicial útil para pruebas y
 * demostraciones.
 */
public class DatosPrueba {

    /**
     * Constructor que carga datos de prueba en las listas proporcionadas.
     *
     * @param cursos        Lista de cursos del sistema.
     * @param docentes      Lista de docentes del sistema.
     * @param estudiantes   Lista de estudiantes del sistema.
     * @param inscripciones Lista de inscripciones del sistema.
     */
	public DatosPrueba(ArrayList<Curso> cursos, ArrayList<Docente> docentes,
			ArrayList<Estudiante> estudiantes,
			ArrayList<Inscripcion> inscripciones) {

		SistemaAcademico sistemaAcademico = new SistemaAcademico();

		// Crear Docentes
		Docente docente1 = new Docente("11111111-1", "Ana Garcia", "Programación");
		Docente docente2 = new Docente("22222222-2", "Juan Perez", "Bases de Datos");
		Docente docente3 = new Docente("33333333-3", "Maria Lopez", "Redes");

		docentes.add(docente1);
		docentes.add(docente2);
		docentes.add(docente3);

		// Crear Estudiantes
		Estudiante estudiante1 = new Estudiante("111", "Carlos Rojas", "Ingeniería Informática", 2023);
		Estudiante estudiante2 = new Estudiante("1111111-4", "Laura Soto", "Diseño Gráfico", 2024);
		Estudiante estudiante3 = new Estudiante("45678912-3", "Pedro Gómez", "Ingeniería Informática", 2023);
		Estudiante estudiante4 = new Estudiante("78912345-6", "Sofía Diaz", "Contabilidad", 2024);

		estudiantes.add(estudiante1);
		estudiantes.add(estudiante2);
		estudiantes.add(estudiante3);
		estudiantes.add(estudiante4);

		// Crear Cursos
		Curso curso1 = new Curso("PROG101", "Programación Orientada a Objetos", 5, docente1);
		Curso curso2 = new Curso("BD201", "Modelado de Bases de Datos", 4, docente2);
		Curso curso3 = new Curso("RED301", "Redes de Computadoras I", 6, docente3);
		Curso curso4 = new Curso("CONT101", "Contabilidad Básica", 3, docente3);
		Curso curso5 = new Curso("MATT101", "mat", 3, docente2);

		cursos.add(curso1);
		cursos.add(curso2);
		cursos.add(curso3);
		cursos.add(curso4);
		cursos.add(curso5);

		// Agregar cursos a docentes para reflejar carga académica
		docente1.agregarCurso(curso1);
		docente2.agregarCurso(curso2);
		docente2.agregarCurso(curso5);
		docente3.agregarCurso(curso3);
		docente3.agregarCurso(curso4);

		// Crear Evaluaciones y agregar calificaciones
		Evaluacion evalPOO_Parcial1 = new Evaluacion("Control", "15/05/2025", 7.0);
		Evaluacion evalBD_ExamenFinal = new Evaluacion("Examen", "20/07/2025", 100.0);
		Evaluacion evalRedes_Tarea1 = new Evaluacion("Trabajo", "01/06/2025", 10.0);
		Evaluacion evalContabilidad_Parcial = new Evaluacion("Examen", "10/06/2025", 7.0);

		curso1.agregarEvaluacion(evalPOO_Parcial1);
		curso2.agregarEvaluacion(evalBD_ExamenFinal);
		curso3.agregarEvaluacion(evalRedes_Tarea1);
		curso4.agregarEvaluacion(evalContabilidad_Parcial);

		// Asignar calificaciones
		evalPOO_Parcial1.asignarCalificacion(estudiante1, 6.5);
		evalPOO_Parcial1.asignarCalificacion(estudiante2, 5.8);
		evalPOO_Parcial1.asignarCalificacion(estudiante3, 6.0);
		estudiante1.agregarEvaluacion(evalPOO_Parcial1);
		estudiante2.agregarEvaluacion(evalPOO_Parcial1);
		estudiante3.agregarEvaluacion(evalPOO_Parcial1);

		evalBD_ExamenFinal.asignarCalificacion(estudiante1, 85.0);
		estudiante1.agregarEvaluacion(evalBD_ExamenFinal);

		evalRedes_Tarea1.asignarCalificacion(estudiante3, 9.5);
		estudiante3.agregarEvaluacion(evalRedes_Tarea1);

		evalContabilidad_Parcial.asignarCalificacion(estudiante4, 6.8);
		estudiante4.agregarEvaluacion(evalContabilidad_Parcial);

		// Inscribir estudiantes a cursos
		curso1.inscribirEstudiante(estudiante1);
		curso1.inscribirEstudiante(estudiante2);
		curso1.inscribirEstudiante(estudiante3);

		curso2.inscribirEstudiante(estudiante1);

		curso3.inscribirEstudiante(estudiante3);

		curso4.inscribirEstudiante(estudiante4);

		System.out.println("Datos de prueba cargados correctamente.");
	}
}
