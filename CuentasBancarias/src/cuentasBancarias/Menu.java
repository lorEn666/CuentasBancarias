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
			System.out.println("[[[***      3- Ver c�digo de la entidad    ***]]]");
			System.out.println("[[[***      4- Ver c�digo de la oficina    ***]]]");
			System.out.println("[[[***      5- Ver n�mero de cuenta        ***]]]");
			System.out.println("[[[***      6- Ver d�gitos de control      ***]]]");
			System.out.println("[[[***      7- Realizar ingreso            ***]]]");
			System.out.println("[[[***      8- Retirar efectivo            ***]]]");
			System.out.println("[[[***      9- Consultar saldo             ***]]]");
			System.out.println("[[[***     10- Salir de la aplicaci�n      ***]]]");
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
