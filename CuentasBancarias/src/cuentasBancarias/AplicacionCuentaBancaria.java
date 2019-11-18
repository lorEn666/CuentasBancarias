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
				cuenta.muestraCcc();
				break;
			case 2:
				cuenta.muestraNombreTitular();
				break;
			case 3:
				cuenta.muestraCodigoEntidad();
				break;
			case 4:
				cuenta.muestraCodigoSucursal();
				break;
			case 5:
				cuenta.muestraNumeroDeCuenta();
				break;
			case 6:
				cuenta.muestraDigitosDeControl();
				break;
			case 7:
				cuenta.realizarIngreso();
				break;
			case 8:
				cuenta.retirarEfectivo();
				break;
			case 9:
				cuenta.muestraSaldo();
				break;
			}
		} while (opcionEscogida != 10);

	}

}
