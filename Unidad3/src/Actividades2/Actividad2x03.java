package Actividades2;

public class Actividad2x03 {

	public static void main(String[] args) {
		Tiempo t1 = new Tiempo(20, 14, 56);
		Tiempo t2 = new Tiempo(22, 14, 56);
		
		t1.restar(t2);
		System.out.println(t1.obtenerEstado());

	}

}
