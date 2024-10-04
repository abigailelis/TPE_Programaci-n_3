package ProgramacionIII.tpe;

import java.util.HashMap;
import java.util.LinkedList;
import ProgramacionIII.tpe.utils.CSVReader;


/**
 * NO modificar la interfaz de esta clase ni sus métodos públicos.
 * Sólo se podrá adaptar el nombre de la clase "Tarea" según sus decisiones
 * de implementación.
 */
public class Servicios {

	//Estructuras donde se van a guardar las tareas y los servicios

	private final HashMap<String, Task> tasksHash;
	private final LinkedList<Task> criticalTasks;
	private final LinkedList<Task> NonCriticalTasks;
	private final Tree priorityTaskTree;


	/*
     * Expresar la complejidad temporal del constructor.
     * O(1) agregar tareas al hash
     * O(1) agregar tareas a las listas
     * O(h) agregar tareas al árbol, donde "h" es la altura del mismo.
     */
	public Servicios(String pathProcesadores, String pathTareas){
		this.tasksHash = new HashMap<String, Task>();
		this.criticalTasks = new LinkedList<Task>();
		this.NonCriticalTasks = new LinkedList<Task>();
		this.priorityTaskTree = new Tree();

		CSVReader reader = new CSVReader();
		reader.readProcessors(pathProcesadores);
		reader.readTasks(pathTareas, this.tasksHash, this.criticalTasks, this.NonCriticalTasks, this.priorityTaskTree);
	}
	
	/*
     * Expresar la complejidad temporal del servicio 1.
     * O(1) Constante ????
     */
	public Task servicio1(String ID) {
		if(this.tasksHash.containsKey(ID))
			return this.tasksHash.get(ID);
		return null;
	}

    /*
     * Expresar la complejidad temporal del servicio 2.
     * O(1) Constante ????
     */
	public LinkedList<Task> servicio2(boolean esCritica) {
		if(esCritica)
			return this.criticalTasks;
		return this.NonCriticalTasks;
	}

    /*
     * Expresar la complejidad temporal del servicio 3.
     * n es la cantidad de nodos del árbol
     * O(n) en el peor de los casos que todas las prioridades
     * del arbol esten entre el intervalo dado.
     * Segun la consigna el peor de los casos seria O(100)
     */
	public LinkedList<Task> servicio3(int prioridadInferior, int prioridadSuperior) {
		return this.priorityTaskTree.getElemBetween(prioridadInferior, prioridadSuperior);
	}

}
