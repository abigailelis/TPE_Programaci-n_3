package tpe.utils;

import tpe.Processor;
import tpe.Task;
import tpe.Tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class CSVReader {

	public CSVReader() {
	}
	
	public void readTasks(String taskPath, HashMap<String, Task> taskHashMap, LinkedList<Task> criticas, LinkedList<Task> noCriticas, Tree priorityTaskTree) {
		ArrayList<String[]> lines = this.readContent(taskPath);
		
		// Cada linea es un arreglo de Strings, donde cada posicion guarda un elemento
		for (String[] line: lines) {
			String id = line[0].trim();
			String nombre = line[1].trim();
			Integer tiempo = Integer.parseInt(line[2].trim());
			Boolean critica = Boolean.parseBoolean(line[3].trim());
			Integer prioridad = Integer.parseInt(line[4].trim());
			
			Task task = new Task(id, nombre, tiempo, critica, prioridad);
			
			addTaskHash(task, taskHashMap);
			addTasksCriticals(task, criticas, noCriticas);
			addTaskTree(task, priorityTaskTree);
		}
		
	}
	
	private void addTaskHash(Task task, HashMap<String, Task> taskHashMap){
		String id = task.getId();
		taskHashMap.put(id, task);
	}
	
	private void addTasksCriticals(Task task, LinkedList<Task> criticas, LinkedList<Task> noCriticas){
		if(task.getCritica())
			criticas.addFirst(task);
		else 
			noCriticas.addFirst(task);
	}

	private void addTaskTree(Task task, Tree tree){
		tree.add(task.getPrioridad(), task);
	}
	
	public void readProcessors(String processorPath, ArrayList<Processor> procesadores) {
		
		ArrayList<String[]> lines = this.readContent(processorPath);
		
		for (String[] line: lines) {
			String id = line[0].trim();
			String codigo = line[1].trim();
			Boolean refrigerado = Boolean.parseBoolean(line[2].trim());
			Integer anio = Integer.parseInt(line[3].trim());
			Processor p = new Processor(refrigerado, id, codigo, anio);
			if(!procesadores.contains(p)){
				procesadores.add(p);
			}

		}
		
	}

	private ArrayList<String[]> readContent(String path) {
		ArrayList<String[]> lines = new ArrayList<String[]>();

		File file = new File(path);
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				line = line.trim();
				lines.add(line.split(";"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (bufferedReader != null)
				try {
					bufferedReader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}
		
		return lines;
	}
	
}
