package cuentasBancarias;

import java.util.Scanner;

public class Validacion {

	public static CuentaBancaria validaNombreYcccTitular() {
		Scanner leer = new Scanner(System.in);
		String nombre, codigoCuenta;
		boolean despliegaMenu = false;

		do {
			nombre = validaNombre();

			nombre = letraCapital(nombre);

			codigoCuenta = validaEstructuraCcc();

			despliegaMenu = comprobacionDigitosDeControl(codigoCuenta);

		} while (!despliegaMenu);

		CuentaBancaria cuenta = new CuentaBancaria(nombre, codigoCuenta);
		return cuenta;

	}

	private static String validaNombre() {
		Scanner leer = new Scanner(System.in);
		String nombreValidacion;
		String comprobacionNombre = " 1234567890ªº!|·@#$%&¬/()=?'¿¡`^*+][¨´}{Ç-_.:,;<>\\";

		do {
			System.out.println("Introduzca nombre del titular de la cuenta (máximo 8 carácteres):");
			nombreValidacion = leer.nextLine();
			if (nombreValidacion.length() > 8) {
				System.err.println(
						"Error. El nombre del titular de la cuenta no puede exceder los 8 carácteres. Inserte un dato válido.");
				continue;
			}
			if (nombreValidacion.equalsIgnoreCase("")) {
				System.err.println(
						"Error. La inserción de datos debe contener al menos un carácter. Inserte un dato válido.");
				continue;
			}

			for (int i = 0; i < nombreValidacion.length(); i++) {
				for (int j = 0; j < comprobacionNombre.length(); j++) {
					if (nombreValidacion.substring(i, i + 1).equalsIgnoreCase(comprobacionNombre.substring(j, j + 1))) {
						System.err.println(
								"Error. El nombre del titular de la cuenta no puede contener datos numéricos, carácteres especiales ni espacios. Sea más preciso.");
						nombreValidacion = "";
						break;
					}
				}
			}
		} while ((nombreValidacion.length() > 8) || (nombreValidacion.equalsIgnoreCase("")));

		return nombreValidacion;
	}

	private static String letraCapital(String nombreCapital) {

		nombreCapital = (nombreCapital.substring(0, 1).toUpperCase()
				+ nombreCapital.substring(1, nombreCapital.length()).toLowerCase());
		return nombreCapital;
	}

	private static int controlDeBloque(String cccComprobar) {
		int contadorHayNumero = 0;
		String comprobacionNumerica = "1234567890";

		for (int i = 0; i < cccComprobar.length(); i++) {
			for (int j = 0; j < comprobacionNumerica.length(); j++) {
				if (cccComprobar.substring(i, i + 1).equalsIgnoreCase(comprobacionNumerica.substring(j, j + 1))) {
					contadorHayNumero++;
				}
			}
		}

		return contadorHayNumero;
	}

	private static String validaEstructuraCcc() {
		Scanner leer = new Scanner(System.in);
		String codigoCuentaValidable;
		String comprobacionNumerica = "1234567890";
		boolean estructuraDeDatosCorrecta = false;

		do {
			int contadorControlDeBloque = 0;
			System.out.println(
					"Inserte el código de cuenta cliente asociado a su nombre, debidamente espaciado (estructura: XXXX XXXX XX XXXXXXXXXX):");
			codigoCuentaValidable = leer.nextLine();

			if ((((codigoCuentaValidable.length() != 23)
					|| (!codigoCuentaValidable.substring(4, 5).equalsIgnoreCase(" "))
					|| (!codigoCuentaValidable.substring(9, 10).equalsIgnoreCase(" "))
					|| (!codigoCuentaValidable.substring(12, 13).equalsIgnoreCase(" "))))) {
				System.err.println(
						"Inserción de datos no válida. Inserte valores numéricos respetando la estructura XXXX XXXX XX XXXXXXXXXX.");
				continue;
			}

			contadorControlDeBloque = controlDeBloque(codigoCuentaValidable.substring(0, 4));

			if (contadorControlDeBloque != 4) {
				System.err.println(
						"Error. Los 4 primeros dígitos referentes al Código de entidad no pueden contener datos no numéricos. Inserte datos válidos.");
				continue;
			}

			contadorControlDeBloque = controlDeBloque(codigoCuentaValidable.substring(5, 9));

			if (contadorControlDeBloque != 4) {
				System.err.println(
						"Error. Los 4 dígitos referentes al Código de oficina no pueden contener datos no numéricos. Inserte datos válidos.");
				continue;
			}

			contadorControlDeBloque = controlDeBloque(codigoCuentaValidable.substring(10, 12));

			if (contadorControlDeBloque != 2) {
				System.err.println(
						"Error. Los 2 dígitos referentes a los dígitos de control no pueden contener datos no numéricos. Inserte datos válidos.");
				continue;
			}

			contadorControlDeBloque = controlDeBloque(codigoCuentaValidable.substring(13, 23));

			if (contadorControlDeBloque != 10) {
				System.err.println(
						"Error. Los 10 dígitos referentes al número de cuenta no pueden contener datos no numéricos. Inserte datos válidos.");
				continue;
			}

			estructuraDeDatosCorrecta = true;

		} while (!estructuraDeDatosCorrecta);

		return codigoCuentaValidable;
	}

	private static boolean comprobacionDigitosDeControl(String codigoCcc) {
		int primerDigitoDeControl = 0;

		primerDigitoDeControl += Integer.valueOf(codigoCcc.substring(0, 1)) * 4;
		primerDigitoDeControl += Integer.valueOf(codigoCcc.substring(1, 2)) * 8;
		primerDigitoDeControl += Integer.valueOf(codigoCcc.substring(2, 3)) * 5;
		primerDigitoDeControl += Integer.valueOf(codigoCcc.substring(3, 4)) * 10;

		primerDigitoDeControl += Integer.valueOf(codigoCcc.substring(5, 6)) * 9;
		primerDigitoDeControl += Integer.valueOf(codigoCcc.substring(6, 7)) * 7;
		primerDigitoDeControl += Integer.valueOf(codigoCcc.substring(7, 8)) * 3;
		primerDigitoDeControl += Integer.valueOf(codigoCcc.substring(8, 9)) * 6;

		primerDigitoDeControl = 11 - (primerDigitoDeControl % 11);

		if (primerDigitoDeControl == 10)
			primerDigitoDeControl = 1;

		if (primerDigitoDeControl == 11)
			primerDigitoDeControl = 0;

		int segundoDigitoDeControl = 0;

		segundoDigitoDeControl += Integer.valueOf(codigoCcc.substring(13, 14)) * 1;
		segundoDigitoDeControl += Integer.valueOf(codigoCcc.substring(14, 15)) * 2;
		segundoDigitoDeControl += Integer.valueOf(codigoCcc.substring(15, 16)) * 4;
		segundoDigitoDeControl += Integer.valueOf(codigoCcc.substring(16, 17)) * 8;
		segundoDigitoDeControl += Integer.valueOf(codigoCcc.substring(17, 18)) * 5;
		segundoDigitoDeControl += Integer.valueOf(codigoCcc.substring(18, 19)) * 10;
		segundoDigitoDeControl += Integer.valueOf(codigoCcc.substring(19, 20)) * 9;
		segundoDigitoDeControl += Integer.valueOf(codigoCcc.substring(20, 21)) * 7;
		segundoDigitoDeControl += Integer.valueOf(codigoCcc.substring(21, 22)) * 3;
		segundoDigitoDeControl += Integer.valueOf(codigoCcc.substring(22, 23)) * 6;

		segundoDigitoDeControl = 11 - (segundoDigitoDeControl % 11);

		if (segundoDigitoDeControl == 10)
			segundoDigitoDeControl = 1;

		if (segundoDigitoDeControl == 11)
			segundoDigitoDeControl = 0;

		if (((Integer.toString(primerDigitoDeControl).substring(0, 1)).equalsIgnoreCase(codigoCcc.substring(10, 11))
				&& ((Integer.toString(segundoDigitoDeControl).substring(0, 1))
						.equalsIgnoreCase(codigoCcc.substring(11, 12))))) {
			System.out.println("Validación terminada. El número de cuenta es correcto, puede continuar.");
			return true;
		} else {
			System.err.println(
					"Validación terminada. Los dígitos de control introducidos no van asociados al número de cuenta proporcionado. Inténtelo de nuevo.");
			return false;
		}
	}
}
