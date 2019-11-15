package cuentasBancarias;

import java.util.Scanner;

public class Validacion {

	public static CuentaBancaria validaNombreYcccTitular() {
		Scanner leer = new Scanner(System.in);
		String nombre;
		String codigoCuenta;
		String comprobacionNumerica = "1234567890";
		boolean estructuraDeDatosCorrecta = false;

		do {
			System.out.println("Introduzca nombre del titular de la cuenta (m�ximo 8 car�cteres):");
			nombre = leer.nextLine();
			if (nombre.length() > 8) {
				System.err.println(
						"Error. El nombre del titular no puede exceder los 8 car�cteres. Inserte un dato v�lido.");
			}
			if (nombre.equalsIgnoreCase("")) {
				System.err.println(
						"Error. La inserci�n de datos debe contener al menos un car�cter. Inserte un dato v�lido.");
			}
		} while ((nombre.length() > 8) || (nombre.equalsIgnoreCase("")));

		reiniciaValidacion: // resetea validaci�n si estructura no es correcta, obligando a la reinserci�n
							// de datos.

		do {
			System.out.println(
					"Inserte el c�digo de cuenta cliente asociado a su nombre, debidamente espaciado (estructura: XXXX XXXX XX XXXXXXXXXX:");
			codigoCuenta = leer.nextLine();

			if ((((codigoCuenta.length() != 23) || (!codigoCuenta.substring(4, 5).equalsIgnoreCase(" "))
					|| (!codigoCuenta.substring(9, 10).equalsIgnoreCase(" "))
					|| (!codigoCuenta.substring(12, 13).equalsIgnoreCase(" "))))) {
				System.err.println(
						"Inserci�n de datos no v�lida. Inserte valores respetando la estructura XXXX XXXX XX XXXXXXXXXX.");
				continue reiniciaValidacion;
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < comprobacionNumerica.length(); j++) {
					if (!codigoCuenta.substring(i, i + 1).equalsIgnoreCase(comprobacionNumerica.substring(j, j + 1))) {
						System.err.println(
								"Error. Los 4 primeros d�gitos referentes al C�digo de entidad no pueden contener datos no num�ricos. Inserte datos v�lidos.");
						continue reiniciaValidacion;
					}
				}
			}

			for (int i = 5; i < 9; i++) {
				for (int j = 0; j < comprobacionNumerica.length(); j++) {
					if (!codigoCuenta.substring(i, i + 1).equalsIgnoreCase(comprobacionNumerica.substring(j, j + 1))) {
						System.err.println(
								"Error. Los 4 d�gitos referentes al C�digo de oficina no pueden contener datos no num�ricos. Inserte datos v�lidos.");
						continue reiniciaValidacion;
					}
				}
			}

			for (int i = 10; i < 12; i++) {
				for (int j = 0; j < comprobacionNumerica.length(); j++) {
					if (!codigoCuenta.substring(i, i + 1).equalsIgnoreCase(comprobacionNumerica.substring(j, j + 1))) {
						System.err.println(
								"Error. Los 2 d�gitos referentes a los d�gitos de control no pueden contener datos no num�ricos. Inserte datos v�lidos.");
						continue reiniciaValidacion;
					}
				}
			}

			for (int i = 13; i < 23; i++) {
				for (int j = 0; j < comprobacionNumerica.length(); j++) {
					if (!codigoCuenta.substring(i, i + 1).equalsIgnoreCase(comprobacionNumerica.substring(j, j + 1))) {
						System.err.println(
								"Error. Los 10 d�gitos referentes al n�mero de cuenta no pueden contener datos no num�ricos. Inserte datos v�lidos.");
						continue reiniciaValidacion;
					}
				}
			}

			estructuraDeDatosCorrecta = true;

		} while (!estructuraDeDatosCorrecta);

		CuentaBancaria cuenta = new CuentaBancaria(nombre, codigoCuenta);
		return cuenta;
	}

}
