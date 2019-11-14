package cuentasBancarias;

public class CuentaBancaria {
	private String nombreTitular;
	private String ccc;
	private double saldoActual;

	public CuentaBancaria(String nombreTitular, String ccc) {
		this.nombreTitular = nombreTitular;
		this.ccc = ccc;
		saldoActual = 0;
	}

	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public String getCcc() {
		return ccc;
	}

	public void setCcc(String ccc) {
		this.ccc = ccc;
	}

	public double getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(double saldoActual) {
		this.saldoActual = saldoActual;
	}

}
