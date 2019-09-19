package es.uned.lsi.eped.pract2016;
import es.uned.lsi.eped.DataStructures.*;


public class AcademiaS implements AcademiaIF {
	
	private Tree<DoctorIF> academia; // Una AcademiaS es un n-Arbol

	
	
	/////////////////////////     CONSTRUCTORES    ////////////////////
	
	/* Constructor por defecto */
	public AcademiaS() {
		academia = new Tree<DoctorIF>();
	}
	

	
	////////////////////////     GETTERS     ////////////////////////
	
	/* Devuelve la academia de doctores 
	 * @returns la academia */
	public Tree<DoctorIF> getAcademia() {
		return academia;
	}
	
	
	
	////////////////////////////////    SETTERS   //////////////////////////////
	
	/* Añade un Doctor fundador de la Academia 	*
	 * @param el nuevo fundador					*
	 * @pre el nuevo doctor no debe pertenecer	*
	 * a la Academia 							*/
	public void setFounder(DoctorIF founder) {
		// PRE
		if (academia.contains(founder)) {return;}
		
		// Cuerpo
		academia.setRoot(founder);
	}
	
	
	
	//////////////////////////    INTERFAZ COLLECTIONIF    /////////////////////

	/* Devuelve true si la coleccion (academia) no contiene elementos (doctores).	*/
	public boolean isEmpty() {
		return academia.isEmpty();
	}
	
	/* Devuelve true si e esta en la coleccion (academia) */
	public boolean contains(DoctorIF e) {
		DoctorS doctor;
		IteratorIF<DoctorIF> ite = academia.iterator();
		while (ite.hasNext()){
			doctor = (DoctorS) ite.getNext();
			if (doctor.equals(e)) {
				return true;
			}
		}
		return false;
	}

	/* Elimina todos los elementos (doctores) de la coleccion (academia) */
	public void clear() {
		academia.clear();
	}
	
	/* Consulta el número de Doctores que pertenecen a la Academia 	*
	 * @returns el número de Doctores pertenecientes a la Academia 	*/
	public int size() {
		return academia.size();
	}

	/* Devuelve un iterador sobre la coleccion (academia) */
	public IteratorIF<DoctorIF> iterator() {
		return academia.iterator();
	}

	
	
	/////////////////////////    INTERFAZ ACADEMIAIF   /////////////////
	
	/* Consulta el Doctor que fundó la Academia 								*
	 * @returns el Doctor fundador de la Academia 								*/
	public DoctorIF getFounder() {
		return academia.getRoot();
	}

	/* Busca un Doctor dentro de la Academia a partir de su identificador 		*
	 * @pre el doctor pertenece a la Academia && id > 0 						*
	 * @param el identificador del Doctor a buscar 								*
	 * @returns el Doctor buscado 												*/
	public DoctorIF getDoctor(int id) {
		// PRE
		if (id < 0) {return null;}
		
		// Cuerpo
		DoctorS doctor;
		IteratorIF<DoctorIF> ite = academia.iterator();
		while (ite.hasNext()) {
			doctor = (DoctorS) ite.getNext();
			if (doctor.getId() == id) {
				return doctor;
			}
		}
		return null; //El doctor no esta en la academia
	}
	
	/* Añade un nuevo Doctor a la Academia a partir de la lectura de su Tesis 	*
	 * @param el nuevo Doctor y su primer director de Tesis 					*
	 * @pre el nuevo doctor no debe pertenecer a la Academia && el supervisor	*
	 * sí debe pertenecer a la Academia 										*/
	public void addDoctor(DoctorIF newDoctor, DoctorIF supervisor) {
		// PRE
		if (academia.contains(newDoctor) || !academia.contains(supervisor)) {return;}
		
		// Cuerpo
		((DoctorS)newDoctor).setAcademia(this);
		((DoctorS)newDoctor).setSupervisor(supervisor);
		academia.getSubTree(supervisor).addChild(1, new Tree<DoctorIF>(newDoctor));
	}

	/* Añade una relación de dirección al Árbol Genealógico de la Academia 		*
	 * @param el nuevo Doctor y uno de sus codirectores de Tesis 				*
	 * @pre ambos doctores deben pertenecer a la Academia && no existe una		*
	 * relación de supervisión previa entre ambos 								*/
	public void addSupervision(DoctorIF student, DoctorIF supervisor) {}

	
}
