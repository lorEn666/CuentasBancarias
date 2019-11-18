package cuentasBancarias;

import java.util.Scanner;

public class Validacion {

	public static CuentaBancaria validaNombreYcccTitular() {
		Scanner leer = new Scanner(System.in);
		String nombre;
		String codigoCuenta;
		String comprobacionNumerica = "1234567890";
		String comprobacionNombre = " 1234567890ªº!|·@#$%&¬/()=?'¿¡`^*+][¨´}{Ç-_.:,;<>\\";
		boolean estructuraDeDatosCorrecta = false;

		do {
			System.out.println("Introduzca nombre del titular de la cuenta (máximo 8 carácteres):");
			nombre = leer.nextLine();
			if (nombre.length() > 8) {
				System.err.println(
						"Error. El nombre del titular de la cuenta no puede exceder los 8 carácteres. Inserte un dato válido.");
			}
			if (nombre.equalsIgnoreCase("")) {
				System.err.println(
						"Error. La inserción de datos debe contener al menos un carácter. Inserte un dato válido.");
			}
			for (int i = 0; i < nombre.length(); i++) {
				for (int j = 0; j < comprobacionNombre.length(); j++) {
					if (nombre.substring(i, i + 1).equalsIgnoreCase(comprobacionNombre.substring(j, j + 1))) {
						System.err.println(
								"Error. El nombre del titular de la cuenta no puede contener datos numéricos, carácteres especiales ni espacios. Sea más preciso.");
						nombre = "";
						break;
					}
				}
			}
		} while ((nombre.length() > 8) || (nombre.equalsIgnoreCase("")));

		nombre = (nombre.substring(0, 1).toUpperCase() + nombre.substring(1, nombre.length()).toLowerCase());

		reiniciaValidacion: // resetea validación si estructura no es correcta, obligando a la reinserción
							// de datos.
		do {
			int contadorControlDeBloque = 0;
			System.out.println(
					"Inserte el código de cuenta cliente asociado a su nombre, debidamente espaciado (estructura: XXXX XXXX XX XXXXXXXXXX):");
			codigoCuenta = leer.nextLine();

			if ((((codigoCuenta.length() != 23) || (!codigoCuenta.substring(4, 5).equalsIgnoreCase(" "))
					|| (!codigoCuenta.substring(9, 10).equalsIgnoreCase(" "))
					|| (!codigoCuenta.substring(12, 13).equalsIgnoreCase(" "))))) {
				System.err.println(
						"Inserción de datos no válida. Inserte valores numéricos respetando la estructura XXXX XXXX XX XXXXXXXXXX.");
				continue reiniciaValidacion;
			}

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < comprobacionNumerica.length(); j++) {
					if (codigoCuenta.substring(i, i + 1).equalsIgnoreCase(comprobacionNumerica.substring(j, j + 1))) {
						contadorControlDeBloque++;
					}
				}
			}

			if (contadorControlDeBloque != 4) {
				System.err.println(
						"Error. Los 4 primeros dígitos referentes al Código de entidad no pueden contener datos no numéricos. Inserte datos válidos.");
				continue reiniciaValidacion;
			}

			contadorControlDeBloque = 0;
			for (int i = 5; i < 9; i++) {
				for (int j = 0; j < comprobacionNumerica.length(); j++) {
					if (codigoCuenta.substring(i, i + 1).equalsIgnoreCase(comprobacionNumerica.substring(j, j + 1))) {
						contadorControlDeBloque++;
					}
				}
			}

			if (contadorControlDeBloque != 4) {
				System.err.println(
						"Error. Los 4 dígitos referentes al Código de oficina no pueden contener datos no numéricos. Inserte datos válidos.");
				continue reiniciaValidacion;
			}

			contadorControlDeBloque = 0;
			for (int i = 10; i < 12; i++) {
				for (int j = 0; j < comprobacionNumerica.length(); j++) {
					if (codigoCuenta.substring(i, i + 1).equalsIgnoreCase(comprobacionNumerica.substring(j, j + 1))) {
						contadorControlDeBloque++;
					}
				}
			}

			if (contadorControlDeBloque != 2) {
				System.err.println(
						"Error. Los 2 dígitos referentes a los dígitos de control no pueden contener datos no numéricos. Inserte datos válidos.");
				continue reiniciaValidacion;
			}

			contadorControlDeBloque = 0;
			for (int i = 13; i < 23; i++) {
				for (int j = 0; j < comprobacionNumerica.length(); j++) {
					if (codigoCuenta.substring(i, i + 1).equalsIgnoreCase(comprobacionNumerica.substring(j, j + 1))) {
						contadorControlDeBloque++;
					}
				}
			}

			if (contadorControlDeBloque != 10) {
				System.err.println(
						"Error. Los 10 dígitos referentes al número de cuenta no pueden contener datos no numéricos. Inserte datos válidos.");
				continue reiniciaValidacion;
			}

			int primerDigitoDeControl = 0;

			primerDigitoDeControl += Integer.valueOf(codigoCuenta.substring(0, 1)) * 4;
			primerDigitoDeControl += Integer.valueOf(codigoCuenta.substring(1, 2)) * 8;
			primerDigitoDeControl += Integer.valueOf(codigoCuenta.substring(2, 3)) * 5;
			primerDigitoDeControl += Integer.valueOf(codigoCuenta.substring(3, 4)) * 10;

			primerDigitoDeControl += Integer.valueOf(codigoCuenta.substring(5, 6)) * 9;
			primerDigitoDeControl += Integer.valueOf(codigoCuenta.substring(6, 7)) * 7;
			primerDigitoDeControl += Integer.valueOf(codigoCuenta.substring(7, 8)) * 3;
			primerDigitoDeControl += Integer.valueOf(codigoCuenta.substring(8, 9)) * 6;

			primerDigitoDeControl = 11 - (primerDigitoDeControl % 11);

			if (primerDigitoDeControl == 10)
				primerDigitoDeControl = 1;

			if (primerDigitoDeControl == 11)
				primerDigitoDeControl = 0;

			int segundoDigitoDeControl = 0;

			segundoDigitoDeControl += Integer.valueOf(codigoCuenta.substring(13, 14)) * 1;
			segundoDigitoDeControl += Integer.valueOf(codigoCuenta.substring(14, 15)) * 2;
			segundoDigitoDeControl += Integer.valueOf(codigoCuenta.substring(15, 16)) * 4;
			segundoDigitoDeControl += Integer.valueOf(codigoCuenta.substring(16, 17)) * 8;
			segundoDigitoDeControl += Integer.valueOf(codigoCuenta.substring(17, 18)) * 5;
			segundoDigitoDeControl += Integer.valueOf(codigoCuenta.substring(18, 19)) * 10;
			segundoDigitoDeControl += Integer.valueOf(codigoCuenta.substring(19, 20)) * 9;
			segundoDigitoDeControl += Integer.valueOf(codigoCuenta.substring(20, 21)) * 7;
			segundoDigitoDeControl += Integer.valueOf(codigoCuenta.substring(21, 22)) * 3;
			segundoDigitoDeControl += Integer.valueOf(codigoCuenta.substring(22, 23)) * 6;

			segundoDigitoDeControl = 11 - (segundoDigitoDeControl % 11);

			if (segundoDigitoDeControl == 10)
				segundoDigitoDeControl = 1;

			if (segundoDigitoDeControl == 11)
				segundoDigitoDeControl = 0;

			if (((Integer.toString(primerDigitoDeControl).substring(0, 1))
					.equalsIgnoreCase(codigoCuenta.substring(10, 11))
					&& ((Integer.toString(segundoDigitoDeControl).substring(0, 1))
							.equalsIgnoreCase(codigoCuenta.substring(11, 12))))) {
				System.out.println("Validación terminada. El número de cuenta es correcto, puede continuar.");
			} else {
				System.err.println(
						"Validación terminada. Los dígitos de control introducidos no van asociados al número de cuenta proporcionado. Inténtelo de nuevo.");
				continue reiniciaValidacion;
			}

			estructuraDeDatosCorrecta = true;

		} while (!estructuraDeDatosCorrecta);

		CuentaBancaria cuenta = new CuentaBancaria(nombre, codigoCuenta);
		return cuenta;
	}

}
