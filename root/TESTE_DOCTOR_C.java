import es.uned.lsi.eped.DataStructures.*;
import es.uned.lsi.eped.pract2016.*;


public class TESTE_DOCTOR_C {

public static void main(String[] args) {
		
		IteratorIF<DoctorIF> ite;
		
		System.out.println("Empezamos");
		
		AcademiaC academia = new AcademiaC();
		DoctorC doctor1 = new DoctorC(1, academia, null);//fundador
		academia.setFounder(doctor1);
		
		DoctorC doctor2 = new DoctorC(2);
		DoctorC doctor3 = new DoctorC(3);
		DoctorC doctor4 = new DoctorC(4);
		DoctorC doctor5 = new DoctorC(5);
		DoctorC doctor6 = new DoctorC(6);
		DoctorC doctor7 = new DoctorC(7);
		DoctorC doctor8 = new DoctorC(8);
		DoctorC doctor9 = new DoctorC(9);
		DoctorC doctor10 = new DoctorC(10);
		DoctorC doctor11 = new DoctorC(11);
		DoctorC doctor12 = new DoctorC(12);
		DoctorC doctor13 = new DoctorC(13);
		DoctorC doctor14 = new DoctorC(14);
		DoctorC doctor15 = new DoctorC(15);
		DoctorC doctor16 = new DoctorC(16);
		DoctorC doctor17 = new DoctorC(17);
		DoctorC doctor18 = new DoctorC(18);
		DoctorC doctor19 = new DoctorC(19);
		DoctorC doctor20 = new DoctorC(20);
		DoctorC doctor21 = new DoctorC(21);
		DoctorC doctor22 = new DoctorC(22);
		DoctorC doctor23 = new DoctorC(23);
		DoctorC doctor24 = new DoctorC(24);
		DoctorC doctor25 = new DoctorC(25);

		
		System.out.println("Size");
		System.out.println(academia.size());

		
		System.out.println("Founder");
		System.out.println(((DoctorC) academia.getFounder()).getId());
		
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
		
		academia.addSupervision(doctor6, doctor1);
		academia.addSupervision(doctor14, doctor5);
		academia.addSupervision(doctor8, doctor1);
		academia.addSupervision(doctor24, doctor9);
		academia.addSupervision(doctor25, doctor17);
		academia.addSupervision(doctor18, doctor16);
		academia.addSupervision(doctor18, doctor15);
		
		
		System.out.println("Size");
		System.out.println(academia.size());
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		System.out.println("Recorrido");
		ite = academia.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorC)ite.getNext()).getId());
		}

	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("Supervisores");
		ite = academia.iterator();
		DoctorC alumno;
		CollectionIF<DoctorC> supervisores;
		while (ite.hasNext()){
			alumno = (DoctorC) ite.getNext();
			System.out.println("doctor"+" "+alumno.getId()+" "+"supervisores:");
			supervisores = alumno.getSupervisors();
			IteratorIF<DoctorC> ite2 = supervisores.iterator();
			while(ite2.hasNext()){
				System.out.println(ite2.getNext().getId());
			}
		}

			
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("Ancestros");
		Stack<DoctorIF> ancestros;
		
		System.out.println("ancestros(3) de 23:");
		ancestros = (Stack<DoctorIF>) doctor23.getAncestors(3);
		ite = ancestros.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorC) ite.getNext()).getId());
		}
		
		System.out.println("ancestros(1) de 14:");
		ancestros = (Stack<DoctorIF>) doctor14.getAncestors(1);
		ite = ancestros.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorC) ite.getNext()).getId());
		}
		
		System.out.println("ancestros(2) de 14:");
		ancestros = (Stack<DoctorIF>) doctor14.getAncestors(2);
		ite = ancestros.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorC) ite.getNext()).getId());
		}
		
		System.out.println("ancestros(2) de 25:");
		ancestros = (Stack<DoctorIF>) doctor25.getAncestors(2);
		ite = ancestros.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorC) ite.getNext()).getId());
		}
		
		System.out.println("ancestros(3) de 1:");
		ancestros = (Stack<DoctorIF>) doctor1.getAncestors(3);
		ite = ancestros.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorC) ite.getNext()).getId());
		}
		
		
		
		

////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		System.out.println("Estudiantes");
		List<DoctorIF> estudiantes;
		
		System.out.println("estudiantes de 5:");
		estudiantes = (List<DoctorIF>) doctor5.getStudents();
		ite = estudiantes.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorC) ite.getNext()).getId());
		}
		
		System.out.println("estudiantes de 17:");
		estudiantes = (List<DoctorIF>) doctor17.getStudents();
		ite = estudiantes.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorC) ite.getNext()).getId());
		}
		
		System.out.println("estudiantes de 1:");
		estudiantes = (List<DoctorIF>) doctor1.getStudents();
		ite = estudiantes.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorC) ite.getNext()).getId());
		}
		
		System.out.println("estudiantes de 7:");
		estudiantes = (List<DoctorIF>) doctor7.getStudents();
		ite = estudiantes.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorC) ite.getNext()).getId());
		}
		
		System.out.println("estudiantes de 10:");
		estudiantes = (List<DoctorIF>) doctor10.getStudents();
		ite = estudiantes.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorC) ite.getNext()).getId());
		}
		
		System.out.println("estudiantes de 2:");
		estudiantes = (List<DoctorIF>) doctor2.getStudents();
		ite = estudiantes.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorC) ite.getNext()).getId());
		}
		
		System.out.println("estudiantes de 13:");
		estudiantes = (List<DoctorIF>) doctor13.getStudents();
		ite = estudiantes.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorC) ite.getNext()).getId());
		}
		
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		System.out.println("Descendientes");
		Stack<DoctorIF> descendientes;
		
		System.out.println("descendientes(2) de 6:");
		descendientes = (Stack<DoctorIF>) doctor6.getDescendants(2);
		ite = descendientes.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorC) ite.getNext()).getId());
		}
		
		System.out.println("descendientes(2) de 1:");
		descendientes = (Stack<DoctorIF>) doctor1.getDescendants(2);
		ite = descendientes.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorC) ite.getNext()).getId());
		}
		
		System.out.println("descendientes(1) de 1:");
		descendientes = (Stack<DoctorIF>) doctor1.getDescendants(1);
		ite = descendientes.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorC) ite.getNext()).getId());
		}
		
		System.out.println("descendientes(3) de 17:");
		descendientes = (Stack<DoctorIF>) doctor17.getDescendants(3);
		ite = descendientes.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorC) ite.getNext()).getId());
		}
		
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		System.out.println("Siblings");
		List<DoctorIF> siblings;
		
		System.out.println("siblings de 2:");
		siblings = (List<DoctorIF>) doctor2.getSiblings();
		ite = siblings.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorC) ite.getNext()).getId());
		}
		
		System.out.println("siblings de 15:");
		siblings = (List<DoctorIF>) doctor15.getSiblings();
		ite = siblings.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorC) ite.getNext()).getId());
		}
		
		System.out.println("siblings de 24:");
		siblings = (List<DoctorIF>) doctor24.getSiblings();
		ite = siblings.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorC) ite.getNext()).getId());
		}
		
		System.out.println("siblings de 9:");
		siblings = (List<DoctorIF>) doctor9.getSiblings();
		ite = siblings.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorC) ite.getNext()).getId());
		}
		
		System.out.println("siblings de 1:");
		siblings = (List<DoctorIF>) doctor1.getSiblings();
		ite = siblings.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorC) ite.getNext()).getId());
		}
		
		System.out.println("siblings de 13:");
		siblings = (List<DoctorIF>) doctor13.getSiblings();
		ite = siblings.iterator();
		while (ite.hasNext()){
			System.out.println(((DoctorC) ite.getNext()).getId());
		}		
		

////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		System.out.println("Fin");
		
		
	}
	
}
