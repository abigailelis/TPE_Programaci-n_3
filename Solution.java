package tpe;

import java.util.ArrayList;

public class Solution {

    private ArrayList<Processor> procesadores;
    private int tiempoEjecucion;
    private int contadorEstados;

    public Solution(ArrayList<Processor> procesadores) {
        this.procesadores = new ArrayList<>(procesadores);
        this.tiempoEjecucion = 0;
        this.contadorEstados = 0; // preguntar si esta bien tomarlo como 0 o -1
    }

    public Solution copy(){ // si agregamos atributos tenerlo en cuenta
        Solution sol = new Solution(new ArrayList<>());
        sol.setTiempoEjecucion(this.tiempoEjecucion);
        sol.setContadorEstados(this.contadorEstados);
        for (Processor p : this.procesadores){
            sol.addProcesador(p.copy());
        }
        return sol;
    }

    public int getContadorEstados() {
        return contadorEstados;
    }

    public void setContadorEstados(int contadorEstados) {
        this.contadorEstados = contadorEstados;
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
        if(p.getTiempoEjecucion()>this.tiempoEjecucion){
            this.tiempoEjecucion = p.getTiempoEjecucion();
        }
    }

    public boolean containsTask(Task t) {
        for (Processor p : procesadores) {
            if(p.containsTask(t)){
                return true;
            }
        }
        return false;
    }

    public void incrementarContadorEstados() {
        this.contadorEstados++;
    }

    public String toString(){
        String texto =" Procesadores: ";
        for(Processor p: this.procesadores){
            texto = texto + p.toString() + " - ";
        }
        texto = texto + " Tiempo de ejecucion = " + this.tiempoEjecucion;
        texto = texto + " Contador de estados: " + this.contadorEstados;
        return texto;
    }
}