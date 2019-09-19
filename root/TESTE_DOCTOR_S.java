import es.uned.lsi.eped.DataStructures.*;
import es.uned.lsi.eped.pract2016.*;

public class TESTE_DOCTOR_S {

	public static void main(String[] args) {
		
		IteratorIF<DoctorIF> ite;
		
		System.out.println("Empezamos");
		
		AcademiaS academia = new AcademiaS();
		DoctorS doctor1 = new DoctorS(1, academia, null);//fundador
		academia.setFounder(doctor1);
		
		DoctorS doctor2 = new DoctorS(2);
		DoctorS doctor3 = new DoctorS(3);
		DoctorS doctor4 = new DoctorS(4);
		DoctorS doctor5 = new DoctorS(5);
		DoctorS doctor6 = new DoctorS(6);
		DoctorS doctor7 = new DoctorS(7);
		DoctorS doctor8 = new DoctorS(8);
		DoctorS doctor9 = new DoctorS(9);
		DoctorS doctor10 = new DoctorS(10);
		DoctorS doctor11 = new DoctorS(11);
		DoctorS doctor12 = new DoctorS(12);
		DoctorS doctor13 = new DoctorS(13);
		DoctorS doctor14 = new DoctorS(14);
		DoctorS doctor15 = new DoctorS(15);
		DoctorS doctor16 = new DoctorS(16);
		DoctorS doctor17 = new DoctorS(17);
		DoctorS doctor18 = new DoctorS(18);
		DoctorS doctor19 = new DoctorS(19);
		DoctorS doctor20 = new DoctorS(20);
		DoctorS doctor21 = new DoctorS(21);
		DoctorS doctor22 = new DoctorS(22);
		DoctorS doctor23 = new DoctorS(23);
		DoctorS doctor24 = new DoctorS(24);
		DoctorS doctor25 = new DoctorS(25);

		
		System.out.println("Size");
		System.out.println(academia.size());

		
		System.out.println("Founder");
		System.out.println(((DoctorS) academia.getFounder()).getId());
		
		System.out.println("Carga Doctores");
		academia.addDoctor(doctor2, doctor1);
		academia.addDoctor(doctor3, doctor1);
		academia.addDoctor(doctor4, doctor1);
		academia.addDoctor(doctor5, doctor2);
		academia.addDoctor(doctor6, doctor2);
		academia.addDoctor(doctor7, doctor3);
		academia.addDoctor(doctor8, doctor4);
		academia.addDoctor(doctor9, doctor4);
		academia.addDoctor(doctor10, doctor8);
		academia.addDoctor(doctor11, doctor5);
		academia.addDoctor(doctor12, doctor11);
		academia.addDoctor(doctor13, doctor12);
		academia.addDoctor(doctor14, doctor11);
		academia.addDoctor(doctor15, doctor5);
		academia.addDoctor(doctor16, doctor5);
		academia.addDoctor(doctor17, doctor6);
		academia.addDoctor(doctor18, doctor17);
		academia.addDoctor(doctor19, doctor17);
		academia.addDoctor(doctor20, doctor19);
		academia.addDoctor(doctor21, doctor9);
		academia.addDoctor(doctor22, doctor21);
		academia.addDoctor(doctor23, doctor10);
		academia.addDoctor(doctor24, doctor10);
		academia.addDoctor(doctor25, doctor20);
		
		
		System.out.println("Size");
		System.out.println(academia.size());
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		System.out.println("Recorrido");
		ite = academia.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS)ite.getNext()).getId());
		}

		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("Supervisores");
		ite = academia.iterator();
		DoctorS alumno;
		while (ite.hasNext()){
			alumno = (DoctorS) ite.getNext();
			if (alumno.getSupervisor() != null){
				System.out.println("alumno"+" "+alumno.getId()+" "+"supervisor"+" "+alumno.getSupervisor().getId());
			}
			else {
				System.out.println("alumno"+" "+alumno.getId()+" "+"Sin supervisor");
			}
		}

		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("Ancestros");
		List<DoctorIF> ancestros;
		
		System.out.println("ancestros(3) de 23:");
		ancestros = (List<DoctorIF>) doctor23.getAncestors(3);
		ite = ancestros.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS) ite.getNext()).getId());
		}
		
		System.out.println("ancestros(2) de 23:");
		ancestros = (List<DoctorIF>) doctor23.getAncestors(2);
		ite = ancestros.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS) ite.getNext()).getId());
		}

		System.out.println("ancestros(2) de 9:");
		ancestros = (List<DoctorIF>) doctor9.getAncestors(2);
		ite = ancestros.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS) ite.getNext()).getId());
		}
		
		System.out.println("ancestros(2) de 2:");
		ancestros = (List<DoctorIF>) doctor2.getAncestors(2);
		ite = ancestros.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS) ite.getNext()).getId());
		}
		
		System.out.println("ancestros(5) de 13:");
		ancestros = (List<DoctorIF>) doctor13.getAncestors(5);
		ite = ancestros.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS) ite.getNext()).getId());
		}
		
		System.out.println("ancestros(2) de 14:");
		ancestros = (List<DoctorIF>) doctor14.getAncestors(2);
		ite = ancestros.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS) ite.getNext()).getId());
		}
		
		System.out.println("ancestros(4) de 20:");
		ancestros = (List<DoctorIF>) doctor20.getAncestors(4);
		ite = ancestros.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS) ite.getNext()).getId());
		}
		
		System.out.println("ancestros(37) de 1:");
		ancestros = (List<DoctorIF>) doctor1.getAncestors(37);
		ite = ancestros.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS) ite.getNext()).getId());
		}
		
		System.out.println("ancestros(1) de 1:");
		ancestros = (List<DoctorIF>) doctor1.getAncestors(1);
		ite = ancestros.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS) ite.getNext()).getId());
		}
		
		System.out.println("ancestros(37) de 8:");
		ancestros = (List<DoctorIF>) doctor8.getAncestors(37);
		ite = ancestros.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS) ite.getNext()).getId());
		}
		
		
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		System.out.println("Estudiantes");
		List<DoctorIF> estudiantes;
		
		System.out.println("estudiantes de 5:");
		estudiantes = (List<DoctorIF>) doctor5.getStudents();
		ite = estudiantes.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS) ite.getNext()).getId());
		}
		
		System.out.println("estudiantes de 11:");
		estudiantes = (List<DoctorIF>) doctor11.getStudents();
		ite = estudiantes.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS) ite.getNext()).getId());
		}
		
		System.out.println("estudiantes de 1:");
		estudiantes = (List<DoctorIF>) doctor1.getStudents();
		ite = estudiantes.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS) ite.getNext()).getId());
		}
		
		System.out.println("estudiantes de 7:");
		estudiantes = (List<DoctorIF>) doctor7.getStudents();
		ite = estudiantes.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS) ite.getNext()).getId());
		}
		
		System.out.println("estudiantes de 10:");
		estudiantes = (List<DoctorIF>) doctor10.getStudents();
		ite = estudiantes.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS) ite.getNext()).getId());
		}
		
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		System.out.println("Descendientes");
		Stack<DoctorIF> descendientes;
		
		System.out.println("descendientes(2) de 6:");
		descendientes = (Stack<DoctorIF>) doctor6.getDescendants(2);
		ite = descendientes.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS) ite.getNext()).getId());
		}
		
		System.out.println("descendientes(4) de 6:");
		descendientes = (Stack<DoctorIF>) doctor6.getDescendants(4);
		ite = descendientes.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS) ite.getNext()).getId());
		}
		
		System.out.println("descendientes(3) de 2:");
		descendientes = (Stack<DoctorIF>) doctor2.getDescendants(3);
		ite = descendientes.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS) ite.getNext()).getId());
		}
		
		System.out.println("descendientes(2) de 1:");
		descendientes = (Stack<DoctorIF>) doctor1.getDescendants(2);
		ite = descendientes.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS) ite.getNext()).getId());
		}
		
		System.out.println("descendientes(5) de 2:");
		descendientes = (Stack<DoctorIF>) doctor2.getDescendants(5);
		ite = descendientes.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS) ite.getNext()).getId());
		}
		
		System.out.println("descendientes(25) de 2:");
		descendientes = (Stack<DoctorIF>) doctor2.getDescendants(25);
		ite = descendientes.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS) ite.getNext()).getId());
		}
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		System.out.println("Siblings");
		List<DoctorIF> siblings;
		
		System.out.println("siblings de 2:");
		siblings = (List<DoctorIF>) doctor2.getSiblings();
		ite = siblings.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS) ite.getNext()).getId());
		}
		
		System.out.println("siblings de 18:");
		siblings = (List<DoctorIF>) doctor18.getSiblings();
		ite = siblings.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS) ite.getNext()).getId());
		}
		
		System.out.println("siblings de 7:");
		siblings = (List<DoctorIF>) doctor7.getSiblings();
		ite = siblings.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS) ite.getNext()).getId());
		}
		
		System.out.println("siblings de 1:");
		siblings = (List<DoctorIF>) doctor1.getSiblings();
		ite = siblings.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorS) ite.getNext()).getId());
		}
		
		
		
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		System.out.println("Fin");
		
		
	}
}
