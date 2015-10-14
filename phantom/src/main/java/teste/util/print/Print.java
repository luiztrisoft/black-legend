package teste.util.print;

import java.math.BigDecimal;

public class Print {

	public static void value(String titulo, String texto) {
		System.out.println(titulo.toUpperCase() + ": " + texto);
		System.out.println("--------------------------------------------");
	}
	
	public static void value(String titulo, BigDecimal texto) {
		System.out.println(titulo.toUpperCase() + ": " + texto);
		System.out.println("--------------------------------------------");
	}
	
	public static void value(String titulo, Integer texto) {
		System.out.println(titulo.toUpperCase() + ": " + texto);
		System.out.println("--------------------------------------------");
	}
	
	public static void value(String titulo, Long texto) {
		System.out.println(titulo.toUpperCase() + ": " + texto);
		System.out.println("--------------------------------------------");
	}
	
	
	public static void value(String titulo, Boolean texto) {
		System.out.println(titulo.toUpperCase() + ": " + texto);
		System.out.println("--------------------------------------------");
	}
}
