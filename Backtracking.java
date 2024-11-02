package tpe;

import java.util.ArrayList;

public class Backtracking {

    private Solution sol;
    private ArrayList<Processor> procesadores;
    private ArrayList<Task> tareasCriticas;
    private ArrayList<Task> tareas;
    private int tiempoEjecucion;//cambiar nombre patram ostrar que es el de la refrigeraciones

    public Backtracking(ArrayList<Processor> procesadores, ArrayList<Task> tareasCriticas, ArrayList<Task> tareasNoCriticas) {
        this.sol = null;
        this.procesadores = procesadores;
        this.tareasCriticas = tareasCriticas; // se puede pasar todo por el main
        this.tareas = this.tareasCriticas.addAll(tareasNoCriticas);
        this.tiempoEjecucion = 0;
    }

    public Solution asignarTareasBack(int tiempoEjecucion){
        if(procesadores.size()*2<this.tareasCriticas.size() || procesadores.isEmpty() || tareas.isEmpty()){
            return null;
        }else{
            this.tiempoEjecucion = tiempoEjecucion;
            Solution solParcial = new Solution();
            sol=null; //reiniciamos la variable
            int index=0;
            return asignarTareasBack(solParcial, index);
        }
    }

    private Solution asignarTareasBack(Solution solParcial, int index){
        if(tareas.size()==index){
            if(this.sol == null || solParcial.getTiempoEjecucion()<sol.getTiempoEjecucion()){
                sol = solParcial.copy();// borrar la solucion anterior y copiar la nueva
                return sol;
            }
        }else{
            Iterator<Processor> it = solParcial.getProcesadores().iterator();
            Task t = tareas.get(index);
            while(it.hasNext()){
                Processor p = it.next();
                if(t.getCritica() && p.getCantCriticas()<2 &&
                        (!p.isRefrigerado() || (p.isRefrigerado() && p.getTiempoEjecucion()+t.getTiempo()<=this.tiempoEjecucion))){
                    if(p.getTiempoEjecucion()+t.getTiempo()< this.sol.getTiempoEjecucion()){
                        p.addTask(t);
                        return asignarTareasBack(solParcial, index+1);
                        p.deleteTask(t);
                    }
                }
            } if(!solParcial.containsTask(t)){
                return null;
            }
        }
        return null;
    }


}
