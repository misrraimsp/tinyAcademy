package es.uned.lsi.eped.pract2016;
import es.uned.lsi.eped.DataStructures.*;


public class DoctorS implements DoctorIF {
	
	private int id; //Identificador unívoco del Doctor
	private AcademiaS academia; // Academia a la que pertenece el Doctor
	private DoctorS supervisor; // Supervisor de tesis
	
	
	/////////////////////////     CONSTRUCTORES    ////////////////////////////////
	
	/* Constructor por defecto */
	public DoctorS() {}
	
	/* Constructor por parametro ID */
	public DoctorS(int id) {
		this.id = id;
	}
	
	/* Constructor por parametro ID, Academia y Supervisor */
	public DoctorS(int id, AcademiaIF academia, DoctorIF supervisor) {
		this.id = id;
		this.academia = (AcademiaS) academia;
		this.supervisor = (DoctorS) supervisor;
	}


	
	////////////////////////     GETTERS     ///////////////////////////////////////

	/* Consulta el id de identificacion del doctor 								*
	 * @returns el id del doctor 												*/
	public int getId() {
		return id;
	}
	
	/* Consulta la academia a la que pertenece el doctor 						*
	 * @returns la academia del doctor 											*/
	public AcademiaS getAcademia() {
		return academia;
	}
	
	/* Consulta el director de Tesis del doctor 								*
	 * @returns el Doctor que fue su director de Tesis. null en caso de que		*
	 * sea el fundador de la Academia 											*/
	public DoctorS getSupervisor() {
		return supervisor;
	}

	
	
	//////////////////////////      SETTERS     ////////////////////////////////////
	
	/* Establece la academia del doctor */
	public void setAcademia(AcademiaS academia) {
		this.academia = academia;
	}

	/* Establece el supervisor del doctor */
	public void setSupervisor(DoctorIF supervisor) {
		this.supervisor = (DoctorS) supervisor;
	}
	
	

	//////////////////////       IMPLEMENTACION DOCTORIF      //////////////////////	

	/* Consulta los ancestros académicos del doctor, limitándose al número de 	*
	 * generaciones indicado por el parámetro. 									*
	 * @returns la colección de ancestros académicos del doctor limitada al 	*
	 * número de generaciones indicado o hasta llegar al fundador de la 		*
	 * Academia. No deberá contener repeticiones. 								*
	 * @param número de generaciones a considerar 								*
	 * @pre generations > 0 													*/
	public CollectionIF<DoctorIF> getAncestors(int generations) {
		//PRE
		if (generations <= 0) {return null;}
		
		//Variables locales
		List<DoctorIF> salida = new List<DoctorIF>();
		int control = 1;
		DoctorS ancestro = supervisor;
		
		//Cuerpo
		while (!(ancestro == null) && !(control > generations)){
			salida.insert(ancestro, 1);
			ancestro = ancestro.getSupervisor();
			control ++;
		}
		return salida;
	}

	/* Consulta los doctores a quienes el doctor ha dirigido sus Tesis. 		*
	 * @returns la colección de doctores cuyo director de tesis es el doctor. 	*/
	public CollectionIF<DoctorIF> getStudents() {
		ListIF<DoctorIF> students = new List<DoctorIF>();
		TreeIF<DoctorIF> subTree = academia.getAcademia().getSubTree(this);
		IteratorIF<TreeIF<DoctorIF>> ite = subTree.getChildren().iterator();
		while (ite.hasNext()){
			students.insert(ite.getNext().getRoot(), 1);
		}
		return students;
	}

	/* Consulta los descendientes académicos del doctor, limitándose al número 	*
	 * de generaciones indicado por el parámetro. 								*
	 * @returns la colección de descendientes académicos del doctor limitada 	*
	 * al número de generaciones indicado o hasta llegar a Doctores que no 		*
	 * hayan dirigido ninguna Tesis. No deberá contener repeticiones. 			*
	 * @param número de generaciones a considerar 								*
	 * @pre generations > 0 													*/
	public CollectionIF<DoctorIF> getDescendants(int generations) {
		//PRE
		if (generations <= 0) {return null;}
		
		//Variables locales
		StackIF<TreeIF<DoctorIF>> llenado = new Stack<TreeIF<DoctorIF>>();
		StackIF<TreeIF<DoctorIF>> vaciado = new Stack<TreeIF<DoctorIF>>();
		StackIF<TreeIF<DoctorIF>> aux;
		StackIF<DoctorIF> salida = new Stack<DoctorIF>();
		int control = 0;
		TreeIF<DoctorIF> auxTree;
		IteratorIF<TreeIF<DoctorIF>> ite;
		
		//Cuerpo
		llenado.push(academia.getAcademia().getSubTree(this));
		while(control < generations){
			aux = llenado;
			llenado = vaciado;
			vaciado = aux;
			while (!vaciado.isEmpty()){
				ite = vaciado.getTop().getChildren().iterator();
				vaciado.pop();
				while (ite.hasNext()){
					auxTree = ite.getNext();
					llenado.push(auxTree);
					salida.push(auxTree.getRoot());
				}
			}
			control ++;
		}
		return salida;
	}

	/* Consulta los doctores que comparten director de tesis con el doctor. 	*
	 * @returns la colección de hermanos académicos del doctor. No deberá 		*
	 * contener repeticiones ni al doctor llamante 								*/
	public CollectionIF<DoctorIF> getSiblings() {
		List<DoctorIF> salida = new List<DoctorIF>();
		if(supervisor == null){ //fundador
			return salida;
		}
		IteratorIF<DoctorIF> ite = supervisor.getStudents().iterator();
		DoctorS hermano;
		while(ite.hasNext()){
			hermano = (DoctorS) ite.getNext();
			if (!hermano.equals(this)){
				salida.insert(hermano, 1);
			}
		}
		return salida;
	}

	
	
	//////////////////////       UTILIDADES      //////////////////////	
	
	/* Redefinición de equals */
	public boolean equals(DoctorIF elem){
		if ( ((DoctorS)elem).getId() == id ){
			return true;
		}
		return false;
	}

	/* Redefinición de toString */
	public String toString(){
		return String.valueOf(id);
	}


}


