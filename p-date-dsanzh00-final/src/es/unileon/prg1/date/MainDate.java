package es.unileon.prg1.date;

import java.util.Scanner;

public class MainDate {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		int day, month, year, day2, month2, year2;
		Date today;
		Date tomorrow;

		try{
			System.out.print("Introduce la primera fecha:\nDía: ");
			day = teclado.nextInt();
			System.out.print("Mes: ");
			month = teclado.nextInt();
			System.out.print("Año: ");
			year = teclado.nextInt();
			today = new Date(day, month, year);
			System.out.println("Primera fecha: " + today.toString());
			System.out.print("Introduce la segunda fecha:\nDía: ");
			day2 = teclado.nextInt();
			System.out.print("Mes: ");
			month2 = teclado.nextInt();
			System.out.print("Año: ");
			year2 = teclado.nextInt();
			tomorrow = new Date(day2, month2, year2);
			System.out.println("Segunda fecha: " + tomorrow.toString());
			System.out.println(today.isSameYear(tomorrow));
			System.out.println(today.isSameMonth(tomorrow));
			System.out.println(today.isSameDay(tomorrow));
			System.out.println(today.isSame(tomorrow));
			System.out.println("El nombre del mes de " + today + " es: " + today.getMonthName());
			System.out.println("El nombre del mes de " + tomorrow + " es: " + tomorrow.getMonthName());
			System.out.println("El mes de " + today.getMonthName() + " tiene " + today.daysOfMonth() + " días.");
			System.out.println("El mes de " + tomorrow.getMonthName() + " tiene " + tomorrow.daysOfMonth() + " días.");
			System.out.println("La estación de la primera fecha es: " + today.getSeasonName());
			System.out.println("La estación de la segunda fecha es: " + tomorrow.getSeasonName());
			System.out.println("En la primera fecha quedan los meses " + today.getMonthsLeft() + "para acabar el año.");
			System.out.println("En la segunda fecha quedan los meses " + tomorrow.getMonthsLeft() + " meses para acabar el año.");
			System.out.println("Quedan los días " + today.getDaysLeftOfMonth() + "para acabar el mes en el caso de la primera fecha.");
			System.out.println("Quedan los días " + tomorrow.getDaysLeftOfMonth() + "para acabar el mes en el caso de la segunda fecha.");
			System.out.println("Los meses con los mismos días que la primera fecha son: " + today.getMonthsSameDays());
			System.out.println("Los meses con los mismos días que la segunda fecha son: " + tomorrow.getMonthsSameDays());
			System.out.println("Días desde principio de año hasta " + today + ": " + today.daysPast());
			System.out.println("Días desde principio de año hasta " + tomorrow + ": " + tomorrow.daysPast());
			System.out.println("Intentos de generar la misma fecha 1 con bucle do-while: " + today.numRandomTriesEqualDate());
			System.out.println("Intentos de generar la misma fecha 2 con bucle do-while: " + tomorrow.numRandomTriesEqualDate());

		}catch(DateException e){
			System.out.println(e.getMessage());
		}
		
	}
}
