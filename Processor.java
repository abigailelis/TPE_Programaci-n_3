package tpe;

import java.util.ArrayList;

public class Processor {

    private ArrayList<Task> tareas;
    private boolean refrigerado;
    private String idProcesador;
    private String codigo;
    private int anioFuncionamiento;
    private int tiempoEjecucion;//ultimos 2 atributos ver de actualizarlos en el add
    private int cantCriticas;

    public Processor(boolean refrigerado, String idProcesador, String codigo, int anioFuncionamiento) {
        this.tareas = new ArrayList<Task>();
        this.refrigerado = refrigerado;
        this.idProcesador = idProcesador;
        this.codigo = codigo;
        this.anioFuncionamiento = anioFuncionamiento;
        this.tiempoEjecucion = 0;
        this.cantCriticas = 0;
    }

    public Processor copy(){
        Processor copia = new Processor(this.refrigerado, this.idProcesador, this.codigo, this.anioFuncionamiento);
        for(Task t : this.tareas){
            copia.addTask(t);//hacer add tarea
        }
        return copia;
    }

    public int size(){
        return this.tareas.size();
    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(int tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public void addTask(Task t){
        this.tareas.add(t);
        this.tiempoEjecucion = this.tiempoEjecucion + t.getTiempo();
        if(t.getCritica()){
            this.cantCriticas++;
        }
    }

    public void deleteTask(Task t){
        this.tareas.remove(t);
        this.tiempoEjecucion = this.tiempoEjecucion - t.getTiempo();
        if(t.getCritica()){
            this.cantCriticas--;
        }
    }

    public boolean containsTask(Task t){
        return this.tareas.contains(t);
    }

    public boolean isRefrigerado() {
        return refrigerado;
    }

    public int getCantCriticas() {
        return cantCriticas;
    }
}
