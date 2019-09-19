package es.uned.lsi.eped.pract2016;

import es.uned.lsi.eped.DataStructures.*;

/* Representaci�n de una Academia formada por una colecci�n de Doctores */
public interface AcademiaIF extends CollectionIF<DoctorIF> {
	
	/* Consulta el Doctor que fund� la Academia */
	/* @returns el Doctor fundador de la Academia */
	public DoctorIF getFounder();
	
	/* Busca un Doctor dentro de la Academia a partir de su identificador */
	/* @pre el doctor pertenece a la Academia && id > 0 */
	/* @param el identificador del Doctor a buscar */
	/* @returns el Doctor buscado */
	public DoctorIF getDoctor(int id);
	
	/* Consulta el n�mero de Doctores que pertenecen a la Academia */
	/* @returns el n�mero de Doctores pertenecientes a la Academia */
	public int size();
	
	/* A�ade un nuevo Doctor a la Academia a partir de la lectura de su Tesis */
	/* @param el nuevo Doctor y su primer director de Tesis */
	/* @pre el nuevo doctor no debe pertenecer a la Academia && */
	/* el supervisor s� debe pertenecer a la Academia */
	public void addDoctor (DoctorIF newDoctor, DoctorIF supervisor);
	
	/* A�ade una relaci�n de direcci�n al �rbol Geneal�gico de la Academia */
	/* @param el nuevo Doctor y uno de sus codirectores de Tesis */
	/* @pre ambos doctores deben pertenecer a la Academia && */
	/* no existe una relaci�n de supervisi�n previa entre ambos */
	public void addSupervision (DoctorIF student, DoctorIF supervisor);
}
