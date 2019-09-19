package es.uned.lsi.eped.pract2016;

import es.uned.lsi.eped.DataStructures.*;

/* Representaci�n de un Doctor perteneciente a una Academia */
public interface DoctorIF {
	
	/* Consulta los ancestros acad�micos del doctor, limit�ndose al n�mero de */
	/* generaciones indicado por el par�metro. */
	/* @returns la colecci�n de ancestros acad�micos del doctor limitada al */
	/* n�mero de generaciones indicado o hasta llegar al fundador de la */
	/* Academia. No deber� contener repeticiones. */
	/* @param n�mero de generaciones a considerar */
	/* @pre generations > 0 */
	public CollectionIF<DoctorIF> getAncestors(int generations);

	/* Consulta los doctores a quienes el doctor ha dirigido sus Tesis. */
	/* @returns la colecci�n de doctores cuyo director de tesis es el doctor. */
	public CollectionIF<DoctorIF> getStudents();

	/* Consulta los descendientes acad�micos del doctor, limit�ndose al n�mero */
	/* de generaciones indicado por el par�metro. */
	/* @returns la colecci�n de descendientes acad�micos del doctor limitada */
	/* al n�mero de generaciones indicado o hasta llegar a Doctores que no */
	/* hayan dirigido ninguna Tesis. No deber� contener repeticiones. */
	/* @param n�mero de generaciones a considerar */
	/* @pre generations > 0 */
	public CollectionIF<DoctorIF> getDescendants(int generations);

	/* Consulta los doctores que comparten director de tesis con el doctor. */
	/* @returns la colecci�n de hermanos acad�micos del doctor. No deber� */
	/* contener repeticiones ni al doctor llamante */
	public CollectionIF<DoctorIF> getSiblings();
}
