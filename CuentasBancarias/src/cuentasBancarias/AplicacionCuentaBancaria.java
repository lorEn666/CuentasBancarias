package cuentasBancarias;

import java.util.Scanner;

public class AplicacionCuentaBancaria {

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int opcionEscogida;
		CuentaBancaria cuenta = Validacion.validaNombreYcccTitular();
		do {
			switch (opcionEscogida = Menu.despliegaMenu()) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			}
		} while (opcionEscogida != 10);

	}

}
