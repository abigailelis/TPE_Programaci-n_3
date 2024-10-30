package tpe;

import java.util.ArrayList;

public class Procesador {

    private ArrayList<Task> tareas;
    private boolean refrigerado;
    private String idProcesador;
    private String codigo;
    private int anioFuncionamiento;
    private int tiempoEjecucion;//ultimos 2 atributos ver de actualizarlos en el add
    private int cantCriticas;

    public Procesador(boolean refrigerado, String idProcesador, String codigo, int anioFuncionamiento) {
        this.tareas = new ArrayList<Task>();
        this.refrigerado = refrigerado;
        this.idProcesador = idProcesador;
        this.codigo = codigo;
        this.anioFuncionamiento = anioFuncionamiento;
        this.tiempoEjecucion = 0;
        this.cantCriticas = 0;
    }

    public Procesador copy(){
        Procesador copia = new Procesador(this.refrigerado, this.idProcesador, this.codigo, this.anioFuncionamiento);
        for(Task t : this.tareas){
            copia.addTarea(t);//hacer add tarea
        }
        return copia;
    }
}
