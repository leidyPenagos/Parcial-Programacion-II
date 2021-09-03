package Model;

import java.util.ArrayList;

public class ManagementCardPhone {

	private CardPhone cardPhone;
	ArrayList<CardPhone> cardPhones;
	
	public ManagementCardPhone() {
		
	}
	
	public boolean addCard(String idCard, double SaldoInicial) {
		CardPhoneNational cardPhoneNational=new CardPhoneNational(idCard, SaldoInicial);
		return true;
	}
	
	public boolean addCard(String idCard, double SaldoInicial, double descuento) {
		CardPhoneInternational cardPhoneInternational=new CardPhoneInternational(idCard, descuento, descuento);
		return true;
	}
	
	public String findCard(String idCard) {
		//salida CardPhoner
		return null;
	}
	
	public ArrayList getCardPhones() {
		return cardPhones;
		
	}
	
	public boolean rechargingCard(String idCard, double valorRecarga) {
		if (idCard==cardPhone.getIdCard()) {
			
		return true;
		}else {
			return false;
		}
	}
	
	public String callingPhone(String idCard, byte num) {
		return null;
	}
	
	public double totallingCardPhones() {
		double suma=0;
		//retorna suma de los saldos de todas las tarjetas telefonicas del arreglo
		return suma;
	}
	
	
}
