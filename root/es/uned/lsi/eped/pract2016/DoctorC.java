package es.uned.lsi.eped.pract2016;
import es.uned.lsi.eped.DataStructures.*;


public class DoctorC implements DoctorIF {

	private int id; // Identificador unívoco del doctor
	private AcademiaC academia; // Academia a la que pertenece el doctor
	private CollectionIF<DoctorIF> students; // A quienes ha dirigido la tesis
	private CollectionIF<DoctorC> supervisors; // Sus supervisores de tesis

	
	/////////////////////////     CONSTRUCTORES    ////////////////////
	
	/* Constructor por defecto */
	public DoctorC() {}
	
	/* Constructor por parametro ID */
	public DoctorC(int id) {
		this.id = id;
		students = new List<DoctorIF>();
		supervisors = new List<DoctorC>();
	}
	
	/* Constructor por parametro ID, Academia y Supervisores */
	public DoctorC(int id, AcademiaIF academia, List<DoctorIF> supervisors) {
		this.id = id;
		this.academia = (AcademiaC) academia;
		students = new List<DoctorIF>();
		this.supervisors = new List<DoctorC>();
		if (supervisors != null){
			IteratorIF<DoctorIF> ite = supervisors.iterator();
			while(ite.hasNext()){
				((List<DoctorC>)this.supervisors).insert((DoctorC) ite.getNext(), 1);
			}
		}	
	}
	
	
	
	////////////////////////     GETTERS     ///////////////////////////////////////

	/* Devuelve el identificador del doctor llamante 
	 * @returns el id del doctor */
	public int getId() {
		return id;
	}
	
	/* Devuelve la academia del doctor llamante
	 * @returns la academia del doctor */
	public AcademiaC getAcademia() {
		return academia;
	}

	/* Devuelve la lista de doctores que han supervisado
	 * la tesis del doctor llamante
	 * @returns los supervisores del doctor  */
	public CollectionIF<DoctorC> getSupervisors() {
		return supervisors;
	}
	
	
	
	//////////////////////////      SETTERS     ////////////////////////////////////
	
	/* Establece la academia del doctor */
	public void setAcademia(AcademiaC academia) {
		this.academia = academia;
	}
	
	/* Introduce un nuevo doctor a la lista de estudiantes del doctor llamante */
	/* @pre el doctor a introducir no debe estar ya en la lista */
	public void setStudent(DoctorC student){
		// PRE
		if (students.contains(student)) {return;}
		//
		((List<DoctorIF>)students).insert(student, 1);
	}
	
	/* Introduce un nuevo doctor a la lista de supervisores del doctor llamante */
	/* @pre el doctor a introducir no debe estar ya en la lista */
	public void setSupervisor(DoctorC supervisor){
		// PRE
		if (((ListIF<DoctorC>)supervisors).contains(supervisor)) {return;}
		//
		((ListIF<DoctorC>)supervisors).insert(supervisor, 1);
	}
	
	
	
	//////////////////////       IMPLEMENTACION DOCTORIF      //////////////////////
	
	/* Consulta los ancestros académicos del doctor, limitándose al número de 		*
	* generaciones indicado por el parámetro. 										*
	* @returns la colección de ancestros académicos del doctor limitada al 			*
	* número de generaciones indicado o hasta llegar al fundador de la 				*
	* Academia. No deberá contener repeticiones. 									*
	* @param número de generaciones a considerar 									*
	* @pre generations > 0 															*/
	public CollectionIF<DoctorIF> getAncestors(int generations) {
		// PRE
		if (generations <= 0) {return null;}
		
		//Variables locales
		StackIF<ListIF<DoctorC>> llenado = new Stack<ListIF<DoctorC>>();
		StackIF<ListIF<DoctorC>> vaciado = new Stack<ListIF<DoctorC>>();
		StackIF<ListIF<DoctorC>> aux;
		StackIF<DoctorIF> salida = new Stack<DoctorIF>();
		DoctorIF doctor;
		int control = 0;
		ListIF<DoctorC> auxList;
		IteratorIF<DoctorC> ite;
		
		//Cuerpo
		llenado.push((ListIF<DoctorC>)this.getSupervisors());
		while(control < generations){
			aux = llenado;
			llenado = vaciado;
			vaciado = aux;
			while (!vaciado.isEmpty()){
				auxList = vaciado.getTop();
				vaciado.pop();
				ite = auxList.iterator();
				while (ite.hasNext()){
					doctor = ite.getNext();
					llenado.push( (ListIF<DoctorC>)((DoctorC)doctor).getSupervisors());
					if (!salida.contains(doctor)){
						salida.push(doctor);
					}
				}
			}
			control ++;
		}
		return salida;
	}
	
	/* Consulta los doctores a quienes el doctor ha dirigido sus Tesis. *
	* @returns la colección de doctores cuyo director de tesis es el doctor. */
	public CollectionIF<DoctorIF> getStudents() {
		return students;
	}

	/* Consulta los descendientes académicos del doctor, limitándose al número 		*
	* de generaciones indicado por el parámetro. 									*
	* @returns la colección de descendientes académicos del doctor limitada 		*
	* al número de generaciones indicado o hasta llegar a Doctores que no 			*
	* hayan dirigido ninguna Tesis. No deberá contener repeticiones. 				*
	* @param número de generaciones a considerar 									*
	* @pre generations > 0 															*/
	public CollectionIF<DoctorIF> getDescendants(int generations) {
		// PRE
		if (generations <= 0) {return null;}
		
		//Variables locales
		StackIF<ListIF<DoctorIF>> llenado = new Stack<ListIF<DoctorIF>>();
		StackIF<ListIF<DoctorIF>> vaciado = new Stack<ListIF<DoctorIF>>();
		StackIF<ListIF<DoctorIF>> aux;
		StackIF<DoctorIF> salida = new Stack<DoctorIF>();
		DoctorIF doctor;
		int control = 0;
		ListIF<DoctorIF> auxList;
		IteratorIF<DoctorIF> ite;
		
		//Cuerpo
		llenado.push((ListIF<DoctorIF>) students);
		while(control < generations){
			aux = llenado;
			llenado = vaciado;
			vaciado = aux;
			while (!vaciado.isEmpty()){
				auxList = vaciado.getTop();
				vaciado.pop();
				ite = auxList.iterator();
				while (ite.hasNext()){
					doctor = ite.getNext();
					llenado.push((ListIF<DoctorIF>) doctor.getStudents());
					if (!salida.contains(doctor)){
						salida.push(doctor);
					}
				}
			}
			control ++;
		}
		return salida;
	}

	/* Consulta los doctores que comparten director de tesis con el doctor. 		*
	* @returns la colección de hermanos académicos del doctor. No deberá 			*
	* contener repeticiones ni al doctor llamante 									*/
	public CollectionIF<DoctorIF> getSiblings() {
		
		List<DoctorIF> salida = new List<DoctorIF>();
		DoctorC posibleHermano;
		boolean flag;

		IteratorIF<DoctorIF> ite1;
		IteratorIF<DoctorC> ite2;
		
		ite1 = academia.getAcademia().iterator();
		while(ite1.hasNext()){
			posibleHermano = (DoctorC) ite1.getNext();
			ite2 = posibleHermano.getSupervisors().iterator();
			flag = true;
			while(ite2.hasNext() && flag){
				if(supervisors.contains(ite2.getNext())){
					flag = false;
					if(!posibleHermano.equals(this) && !salida.contains(posibleHermano)){
						salida.insert(posibleHermano, 1);
					}
				}
			}
		}
		return salida;
	}

	
	
	////////////////////////////       UTILIDADES      /////////////////////////////
	
	/* Redefinición de equals */
	public boolean equals(DoctorIF elem){
		if ( ((DoctorC)elem).getId() == id ){
			return true;
		}
		return false;
	}

	/* Redefinición de toString */
	public String toString(){
		return String.valueOf(id);
	}

	
}

