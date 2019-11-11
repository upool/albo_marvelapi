package com.albo.enums;

/***
 * Character enumeration
 * @author PaulM
 *
 */
public enum CharacterEnum {

	ironman(1009368),
	capamerica(1009220);	

	int valor;
	
	CharacterEnum(int valor) {
		this.valor = valor;		
	}
	
	public int getValor() {
		return this.valor;
	}
}
