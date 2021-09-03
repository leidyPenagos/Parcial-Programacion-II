package Model;

public abstract class CardPhone {

	protected String idCard;
	protected double residue;
	protected short totalMinutes;
	
	
	public CardPhone(String idCard, double residue) {
		super();
		this.idCard = idCard;
		this.residue = residue;
	}


	public String getIdCard() {
		return idCard;
	}


	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}


	public double getResidue() {
		return residue;
	}


	public void setResidue(double residue) {
		this.residue = residue;
	}


	public short getTotalMinutes() {
		return totalMinutes;
	}


	public void setTotalMinutes(short totalMinutes) {
		this.totalMinutes = totalMinutes;
	}
	
	public void rechargingCard(double residue) {
		
	}
	
	public boolean callingPhone(byte b) {
		return true;
	}
	
	
	
}
