package tpe;

import java.util.ArrayList;

public class Solution {

    private ArrayList<Processor> procesadores;
    private int tiempoEjecucion;

    public Solution() {
        this.procesadores = new ArrayList<Processor>();
        this.tiempoEjecucion = 0;
    }

    public Solution copy(){ // si agregamos atributos tenerlo en cuenta
        Solution sol = new Solution();
        for (Processor p : procesadores){
            sol.addProcesador(p.copy());
        }
        return sol;
    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(int tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public ArrayList<Processor> getProcesadores() {
        return new ArrayList<Processor>(procesadores);
    }

    public void addProcesador(Processor p) {
        this.procesadores.add(p);
        this.tiempoEjecucion = this.tiempoEjecucion+p.getTiempoEjecucion();
    }

    public void deleteProcesador(Processor p) {
        this.procesadores.remove(p);
        this.tiempoEjecucion = this.tiempoEjecucion-p.getTiempoEjecucion();
    }

    public boolean containsTask(Task t) {
        for (Processor p : procesadores) {
            if(p.containsTask(t)){
                return true;
            }
        }
        return false;
    }
}
