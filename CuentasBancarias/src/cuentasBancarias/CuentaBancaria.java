package cuentasBancarias;

import java.util.Scanner;

public class CuentaBancaria {
	private String nombreTitular;
	private String ccc;
	private double saldoActual;

	public CuentaBancaria(String nombreTitular, String ccc) {
		this.nombreTitular = nombreTitular;
		this.ccc = ccc;
		saldoActual = 0;
	}

	public void muestraCcc() {
		System.out.println("El código de cuenta cliente(CCC) asociado es: " + ccc);
	}

	public void muestraNombreTitular() {
		System.out.println("El nombre del titular de la cuenta asociado al CCC proporcionado es: " + nombreTitular);
	}

	public void muestraCodigoEntidad() {
		System.out.println("Los 4 dígitos referentes al código de entidad son: " + ccc.substring(0, 4));
	}

	public void muestraCodigoSucursal() {
		System.out.println("Los 4 dígitos referentes al código de sucursal son: " + ccc.substring(5, 9));
	}

	public void muestraNumeroDeCuenta() {
		System.out.println("Los 10 dígitos referentes al número de cuenta son: " + ccc.substring(13, 23));
	}

	public void muestraDigitosDeControl() {
		System.out.println("Los 2 dígitos de control son: " + ccc.substring(10, 12));
	}

	public void muestraSaldo() {
		System.out.println("Saldo actual: " + saldoActual + " €");
	}

	public void realizarIngreso() {
		Scanner leer = new Scanner(System.in);
		String ingreso;
		String comprobacionIngreso = ".1234567890";
		int contadorDeControl;
		int contadorControlDeComas;

		ingresaDeNuevo:

		do {
			contadorDeControl = 0;
			contadorControlDeComas = 0;
			System.out.println("Escriba la cantidad que desea ingresar (pulse ENTER para salir): ");
			ingreso = leer.nextLine();

			if (ingreso.substring(0, 1).equalsIgnoreCase(".")) {
				System.err.println("Error. Sea preciso con el tipo de dato que introduce.");
				continue;
			}

			if (ingreso.isEmpty())
				break;

			for (int i = 0; i < ingreso.length(); i++) {
				if ((ingreso.substring(i, i + 1)).equalsIgnoreCase(".")) {
					contadorControlDeComas++;
					if (contadorControlDeComas == 2) {
						System.err.println("Error. La cantidad ingresada no puede contener múltiples comas.");
						continue ingresaDeNuevo;
					}
				}
			}

			for (int i = 0; i < ingreso.length(); i++) {
				for (int j = 0; j < comprobacionIngreso.length(); j++) {
					if ((ingreso.substring(i, i + 1)).equalsIgnoreCase(comprobacionIngreso.substring(j, j + 1))) {
						contadorDeControl++;
					}
				}
			}

			if (contadorDeControl == ingreso.length()) {

			} else {
				System.err.println(
						"Error. No pueden ingresarse cantidades negativas, con espacios o que contengan carácteres especiales. Si no quiere realizar ningún ingreso, introduzca 0 o pulse ENTER.");
				continue;
			}

			saldoActual += Double.valueOf(ingreso);
			System.out.println("Su ingreso ha sido realizado.");

		} while (contadorDeControl != ingreso.length());

	}

	public void retirarEfectivo() {
		Scanner leer = new Scanner(System.in);
		String efectivoRetirado;
		String comprobacionRetiradaEfectivo = ".1234567890";
		int contadorDeControl;
		int contadorControlDeComas;

		retiraDeNuevo:

		do {
			contadorDeControl = 0;
			contadorControlDeComas = 0;
			System.out.println("Escriba la cantidad que desea retirar (pulse ENTER para salir): ");
			efectivoRetirado = leer.nextLine();
			
			if (efectivoRetirado.substring(0, 1).equalsIgnoreCase(".")) {
				System.err.println("Error. Sea preciso con el tipo de dato que introduce.");
				continue;
			}
			
			if (efectivoRetirado.isEmpty())
				break;

			for (int i = 0; i < efectivoRetirado.length(); i++) {
				if ((efectivoRetirado.substring(i, i + 1)).equalsIgnoreCase(".")) {
					contadorControlDeComas++;
					if (contadorControlDeComas == 2) {
						System.err.println("Error. La cantidad a retirar no puede contener múltiples comas.");
						continue retiraDeNuevo;
					}
				}
			}

			for (int i = 0; i < efectivoRetirado.length(); i++) {
				for (int j = 0; j < comprobacionRetiradaEfectivo.length(); j++) {
					if ((efectivoRetirado.substring(i, i + 1))
							.equalsIgnoreCase(comprobacionRetiradaEfectivo.substring(j, j + 1))) {
						contadorDeControl++;
					}
				}
			}

			if (contadorDeControl == efectivoRetirado.length()) {

			} else {
				System.err.println(
						"Error. No se pueden retirar cantidades de efectivo negativas, con espacios o que contengan carácteres especiales. Si no quiere retirar efectivo, introduzca 0 o pulse ENTER.");
				continue;
			}

			if (Double.valueOf(efectivoRetirado) > saldoActual) {
				System.err.println("Error. Saldo insuficiente.");
				continue;
			}

			saldoActual -= Double.valueOf(efectivoRetirado);
			System.out.println("Su efectivo ha sido retirado.");

		} while (contadorDeControl != efectivoRetirado.length());

	}
	
}
