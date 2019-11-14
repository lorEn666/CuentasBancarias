package cuentasBancarias;

import java.util.Scanner;

public class Menu {

	public static int despliegaMenu() {
		Scanner leer = new Scanner(System.in);
		int opc;

		do {
			System.out.println("[[[*******************************************]]]");
			System.out.println("[[[*******************************************]]]");
			System.out.println("[[[*******************************************]]]");
			System.out.println("[[[*******************************************]]]");
			System.out.println("[[[*******************************************]]]");
			System.out.println("[[[***                                     ***]]]");
			System.out.println("[[[***                                     ***]]]");
			System.out.println("[[[***      1- Ver CCC                     ***]]]");
			System.out.println("[[[***      2- Ver titular de la cuenta    ***]]]");
			System.out.println("[[[***      3- Ver código de la entidad    ***]]]");
			System.out.println("[[[***      4- Ver código de la oficina    ***]]]");
			System.out.println("[[[***      5- Ver número de cuenta        ***]]]");
			System.out.println("[[[***      6- Ver dígitos de control      ***]]]");
			System.out.println("[[[***      7- Realizar ingreso            ***]]]");
			System.out.println("[[[***      8- Retirar efectivo            ***]]]");
			System.out.println("[[[***      9- Consultar saldo             ***]]]");
			System.out.println("[[[***     10- Salir de la aplicación      ***]]]");
			System.out.println("[[[***                                     ***]]]");
			System.out.println("[[[***                                     ***]]]");
			System.out.println("[[[*******************************************]]]");
			System.out.println("[[[*******************************************]]]");
			System.out.println("[[[*******************************************]]]");
			System.out.println("[[[*******************************************]]]");
			System.out.println("[[[*******************************************]]]");
			opc = leer.nextInt();
		} while (opc != 10);
		return opc;
	}

}
