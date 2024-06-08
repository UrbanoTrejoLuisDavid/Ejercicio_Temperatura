package com.tesji.modelo;

public class TemperaturaModelo {
	public int grados;
	public int tipoGrado;
	
	public String tipoGrados() {
		String resultados="";
		double C, F, K, a;
		if (tipoGrado == 1) {
			F = (grados * 1.80) + 32;
			K = (grados + 273.15);
			resultados = "Grados Celcius: " + grados + "°\nGrados Fahrenheit: " + F + "°\nGrados Kelvin: " + K + "°";
		}else if (tipoGrado == 2) {
			C= (grados - 32) / 1.8;
			K = ((grados - 32) * 5/9) + 273.15;
			resultados = "Grados Fahrenheit: " + grados + "°\nGrados Celsius: " + C + "°\nGrados Kelvin: " + K + "°";
		}else if (tipoGrado == 3) {
			F= 1.8 * (grados - 273.15) + 32;
			C = grados - 273.15;
			resultados = "Grados Kelvin: " + grados + "°\nGrados Celsius: " + C + "°\nGrados Fahrenheit: " + F + "°";
		}
		return resultados;
	}
}
