package tpe;

import java.util.ArrayList;

public class Backtracking {

    private Solucion sol;
    private List<Procesador> procesadores;
    private List<Tarea> tareasCriticas;
    private List<Tarea> tareas;
    private int tiempoEjecucion;//cambiar nombre patram ostrar que es el de la refrigeraciones

    public Backtracking(List<Procesador> procesadores, List<Tarea> tareasCriticas, List<Tarea> tareasNoCriticas) {
        this.sol = null;
        this.procesadores = procesadores;
        this.tareasCriticas = tareasCriticas; // se puede pasar todo por el main
        this.tareas = this.tareasCriticas.addAll(tareasNoCriticas);
        this.tiempoEjecucion = 0;
    }

    public Solucion asignarTareasBack(int tiempoEjecucion){
        if(procesadores.size()*2<this.tareasCriticas.size() || procesadores.size()==0 || tareas.size()==0){
            return null;
        }else{
            this.tiempoEjecucion = tiempoEjecucion;
            Solucion solParcial = new Solucion(this.procesadores);
            sol=null; //reiniciamos la variable
            int index=0;
            return asignarTareasBack(solParcial, index);
        }
    }

    private Solucion asignarTareasBack(Solucion solParcial, int index){
        if(tareas.size()==index){
            if(this.sol == null || solParcial.getTiempoEjecucion()<sol.getTiempoEjecucion()){
                sol = solParcial.copy();// borrar la solucion anterior y copiar la nueva
                return sol;
            }
        }else{
            Iterator<Procesador> it = solParcial.getProcesadores().iterator();
            Tarea t = tareas[index];
            while(it.hasNext()){
                Procesador p = it.next();
                if(t.esCritica() && p.getTareasCriticas().size()<2 &&
                        (!p.esRefrigerado() || (p.esRefrigerado() && p.getTiempoEjecucion()+t.getTiempoEjecucion()<=this.tiempoEjecucion))){
                    if(p.getTiempoEjecucion()+t.getTiempoEjecucion()< this.sol.getTiempoEjecucion()){
                        p.add(t);
                        return asignarTareasBack(solParcial, index+1);
                        p.delete(t);
                    }
                }
            } if(!solParcial.contieneTarea(t[index])){
                return null;
            }
        }
        return null;
    }


}
