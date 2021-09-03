package Model;

public class CardPhoneNational extends CardPhone {

	private double VALUE_MINUT=35;

	public CardPhoneNational(String idCard, double residue) {
		super(idCard, residue);
	}
	
	public boolean callingPhone(byte x) {
		return true;
	}
	
}
