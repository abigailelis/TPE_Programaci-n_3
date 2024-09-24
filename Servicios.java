package tpe;

import java.util.List;

import tpe.utils.CSVReader;

/**
 * NO modificar la interfaz de esta clase ni sus métodos públicos.
 * Sólo se podrá adaptar el nombre de la clase "Tarea" según sus decisiones
 * de implementación.
 */
public class Servicios {

	/*atributos posibles

		list criticas y no criticas

		hash para realizar la busqueda individual


	*/
	//private componentes donde se van a guardar las tareas y los servicios

	//Una estructura de guardado en memoria y otras de acceso.. (TODAS APUNTAN AL MISMO OBJETO)
	/*
     * Expresar la complejidad temporal del constructor.
     */
	public Servicios(String pathProcesadores, String pathTareas)
	{
		CSVReader reader = new CSVReader();
		reader.readProcessors(pathProcesadores);
		reader.readTasks(pathTareas);
		//reader.readTasks(pathTareas, listTareas, hashTareas, etc); puedo pasarle las 
		//estructuras por párametro donde quiero que vaya almacenando las tareas 
	}
	
	/*
     * Expresar la complejidad temporal del servicio 1.
     * Encontrar la tarea con id dado.
     * utilizar hash.
     */
	public Tarea servicio1(String ID) {	}
    
    /*
     * Expresar la complejidad temporal del servicio 2.
     * lista de tareas que cumplen con esa condicion
     */
	public List<Tarea> servicio2(boolean esCritica) {}

    /*
     * Expresar la complejidad temporal del servicio 3.
     * lisat de tareas que tiene prioridad entre 2 valores
     * posiblemente una lista si es que es la mejor para trabajar entre rangos.
     */
	public List<Tarea> servicio3(int prioridadInferior, int prioridadSuperior) {
		//usar un arbol, si se repiten prioridades hacemos una lista que las contenga en ese orden
	}

	//entre

}
