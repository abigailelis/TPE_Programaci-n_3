package tpe;

import java.util.ArrayList;
import java.util.LinkedList;

public class Backtracking {

    private Solution sol;
    private ArrayList<Processor> procesadores;
    private LinkedList<Task> tareasCriticas;
    private LinkedList<Task> tareas;
    private int tiempoEjecucion;//cambiar nombre patram ostrar que es el de la refrigeraciones

    public Backtracking(ArrayList<Processor> procesadores, LinkedList<Task> tareasCriticas, LinkedList<Task> tareasNoCriticas) {
        this.sol = null;
        this.procesadores = procesadores;
        this.tareasCriticas = tareasCriticas; // se puede pasar todo por el main
        this.tareas = tareasNoCriticas;//es necesario preguntar si viene vacio?
        this.tareas.addAll(this.tareasCriticas);
        this.tiempoEjecucion = 0;
    }

    public Solution asignarTareasBack(int tiempoEjecucion){
        if(procesadores.size()*2<this.tareasCriticas.size() || procesadores.isEmpty() || tareas.isEmpty()){
            return null;
        }else{
            this.tiempoEjecucion = tiempoEjecucion;
            Solution solParcial = new Solution(this.procesadores);
            sol=null; //reiniciamos la variable
            return this.sol;
        }
    }

    private void asignarTareasBack(Solution solParcial){
        solParcial.incrementarContadorEstados();
        if(tareas.isEmpty()){
            if(this.sol == null || solParcial.getTiempoEjecucion()<sol.getTiempoEjecucion()){
                sol = solParcial.copy();// borrar la solucion anterior y copiar la nueva
            }
        }else{
            IteratorProcesadores<Processor> it = new IteratorProcesadores<>(solParcial.getProcesadores().iterator());
            Task t = tareas.getFirst();
            while(it.hasNext()){
                Processor p = it.next();
                if(t.getCritica() && p.getCantCriticas()<2 &&
                        (!p.isRefrigerado() || (p.isRefrigerado() && p.getTiempoEjecucion()+t.getTiempo()<=this.tiempoEjecucion))){
                    if(p.getTiempoEjecucion()+t.getTiempo()< this.sol.getTiempoEjecucion()){
                        p.addTask(t);
                        tareas.removeFirst();
                        asignarTareasBack(solParcial);
                        tareas.addFirst(t);
                        p.deleteTask(t);
                    }
                }
            }
        }
    }
}
