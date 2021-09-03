package Model;

public class CardPhoneInternational extends CardPhone{

	private double VALUE_MINUT=60;
	private double discount;

	
	
	public CardPhoneInternational(String idCard, double residue, double discount) {
		super(idCard, residue);
		this.discount = discount;
	}

	


	public double getDiscount() {
		return discount;
	}




	public void setDiscount(double discount) {
		this.discount = discount;
	}




	public boolean callingPhone(byte x) {
		
		return true;
	}
	
}
