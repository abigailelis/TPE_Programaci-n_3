package tpe;

public class Main {

	public static void main(String[] args) {
		//Servicios servicios = new Servicios("./src/tpe/datasets/Procesadores.csv", "./src/tpe/datasets/Tareas.csv");

		Servicios servicios = new Servicios("./TPE_Programacion_3/datasets/Procesadores.csv", "./TPE_Programacion_3/datasets/Tareas.csv");

		//System.out.println(servicios.servicio1("T1"));
		//System.out.println(servicios.servicio2(true));
		//System.out.print(servicios.servicio3(35,60));
		System.out.print(servicios.asignarTareasBack(70));
	}


}
