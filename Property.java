
public class Property {

	private java.lang.String city;
	private java.lang.String owner;
	private java.lang.String propertyName;
	private double rentAmount;
	private Plot plot;
	
	// Constructor
	public Property() {
		city = "";
		owner = "";
		propertyName = "";
		rentAmount = 0;
		plot = new Plot();
	}
	
	public Property(Property p) {
		city = p.city;
		owner = p.owner;
		propertyName = p.propertyName;
		rentAmount = p.rentAmount;
		plot = new Plot(p.plot);
	}
	
	public Property(java.lang.String propertyName, java.lang.String city, double rentAmount, java.lang.String owner) {
	   this.propertyName = propertyName;
	   this.city = city;
	   this.owner = owner;
	   this.rentAmount = rentAmount;
	   plot = new Plot();
	}
	
	public Property(java.lang.String propertyName, java.lang.String city, double rentAmount, java.lang.String owner, int x, int y, int width, int depth ) {
		this.propertyName = propertyName;
		this.city = city;
		this.owner = owner;
		this.rentAmount = rentAmount;
		plot = new Plot(x,y,width,depth);
	}
	
	public java.lang.String getCity(){
		return city;
	}
	public java.lang.String getOwner(){
		return owner;
	}
	public java.lang.String getPropertyName(){
		return propertyName;
	}	
	public double getRentAmount() {
		return rentAmount;
	}
	
	public Plot setPlot(int x, int y, int width, int depth) {
		plot = new Plot(x,y,width,depth);
		return plot;
	}
	
	public Plot getPlot() {
		return plot;
	}
	
	public void setOwner(java.lang.String owner) {
		this.owner = owner;
	}
	
	public void setPropertyName(java.lang.String propertyName) {
		this.propertyName = propertyName;
	}
	
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	
	public java.lang.String toString(){
		return (" Property Name: " + propertyName + "\n  Located in " +
         city + "\n  Belonging to: " + owner + "\n  Rent Amount: " + rentAmount);
	}
}
