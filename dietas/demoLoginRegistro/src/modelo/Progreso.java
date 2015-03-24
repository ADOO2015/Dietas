package modelo;

import java.io.Serializable;

public class Progreso{

	private String fecha;
	private Float altura;
	private Float peso;
	private float cintura;
	private float cadera;
	private float imc;
	private float icc;
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Float getAltura() {
		return altura;
	}
	public void setAltura(Float altura) {
		this.altura = altura;
	}
	public Float getPeso() {
		return peso;
	}
	public void setPeso(Float peso) {
		this.peso = peso;
	}
	public float getCintura() {
		return cintura;
	}
	public void setCintura(float cintura) {
		this.cintura = cintura;
	}
	public float getCadera() {
		return cadera;
	}
	public void setCadera(float cadera) {
		this.cadera = cadera;
	}
	public float getImc() {
		return imc;
	}
	public void setImc(float imc) {
		this.imc = imc;
	}
	public float getIcc() {
		return icc;
	}
	public void setIcc(float icc) {
		this.icc = icc;
	}
}
