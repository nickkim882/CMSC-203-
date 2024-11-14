
public class Property {

	private String propertyName;
	private String city;
	private double rentalAmount;
	private String owner;
	private Plot plot;
	
	//constructors
	public Property() {
		
		propertyName = "";
		city = "";
		rentalAmount = 0.0;
		owner = "";
		plot = new Plot();
		
	}
	
	public Property(String name, String city, double rent, String owner) {
		
		propertyName = name;
		this.city = city;
		rentalAmount = rent;
		this.owner = owner;
		this.plot = new Plot(0,0,1,1);
		
	}
	
	public Property(String name, String city, double rent, String owner, int x, int y, int depth, int width) {
		
		propertyName = name;
		this.city = city;
		rentalAmount = rent;
		this.owner = owner;
		this.plot = new Plot(x, y, depth, width);
		
	}
	
	//copy constructor
	public Property(Property other) {
		
		this(other.propertyName, other.city, other.rentalAmount, other.owner, other.plot.getX(), other.plot.getY(), other.plot.getDepth(), other.plot.getWidth());
		
	}
	
	//getters
	public String getPropertyName() {
		
		return propertyName;
		
	}
	
	public String getCity() {
		
		return city;
		
	}
	
	public double getRentAmount() {
		
		return rentalAmount;
		
	}
	
	public String getOwner() {
		
		return owner;
		
	}
	
	public Plot getPlot() {
		
		return plot;
		
	}
	
	//setters
	public void setPropertyName(String name) {
		
		propertyName = name;
		
	}
	
	public void setCity(String city) {
		
		this.city = city;
		
	}
	
	public void setRentAmount(double amount) {
		
		rentalAmount = amount;
		
	}
	
	public void setOwner(String owner) {
		
		this.owner = owner;
		
	}
	
	public void setPlot(Plot plot) {
		
		this.plot = plot;
		
	}
	
	public String toString() {
		
		return propertyName + "," + city + "," + owner + "," + rentalAmount;
		
	}
	
}
