package cuentasBancarias;

import java.util.Scanner;

public class Menu {

	public static int despliegaMenu() {
		Scanner leer = new Scanner(System.in);
		String opc;
		String comprobacionNumerica = "1234567890";

		do {
			int contadorDeControl = 0;
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("$$$$$$                                      $$$$$$$$$$$$");
			System.out.println("$$$$$$      1- Ver CCC                      $$$$$$$$$$$$$");
			System.out.println("$$$$$$      2- Ver titular de la cuenta     $$$$$$$$$$$$$$");
			System.out.println("$$$$$$      3- Ver código de la entidad     $$$$$$$$$$$$$$$");
			System.out.println("$$$$$$      4- Ver código de la oficina     $$$$$$$$$$$$$$$$");
			System.out.println("$$$$$$      5- Ver número de cuenta         $$$         $$$$$");
			System.out.println("$$$$$$      6- Ver dígitos de control       $$$    €    $$$$$$");
			System.out.println("$$$$$$      7- Realizar ingreso             $$$         $$$$$");
			System.out.println("$$$$$$      8- Retirar efectivo             $$$$$$$$$$$$$$$$");
			System.out.println("$$$$$$      9- Consultar saldo              $$$$$$$$$$$$$$$");
			System.out.println("$$$$$$     10- Salir de la aplicación       $$$$$$$$$$$$$$");
			System.out.println("$$$$$$                                      $$$$$$$$$$$$$");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("$$$$$$                                      $$$$$$$$$$");
			System.out.println("$$$$$$            ¡Bienvenido!              $$$$$$$$$");
			System.out.println("$$$$$$          Escoja una opción           $$$$$$$$");
			System.out.println("$$$$$$                                      $$$$$$$");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			opc = leer.nextLine();
			
			if (opc.isEmpty())
				opc = "0";

			for (int i = 0; i < opc.length(); i++) {
				for (int j = 0; j < comprobacionNumerica.length(); j++) {
					if (opc.substring(i, i + 1).equalsIgnoreCase(comprobacionNumerica.substring(j, j + 1))) {
						contadorDeControl++;
					}
				}
			}

			if ((contadorDeControl == opc.length()) && (Integer.valueOf(opc) > 0) && (Integer.valueOf(opc) < 11)) {

			} else {
				System.err.println("Error. La opción a escoger debe ser un dígito entre 1 y 10.");
				opc = "0";
			}

			return Integer.valueOf(opc);

		} while (Integer.valueOf(opc) != 10);

	}

}
