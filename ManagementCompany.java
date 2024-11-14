
public class ManagementCompany {

	private String name;
	private String taxID;
	private int managementFee;
	private static int MAX_PROPERTY = 5;
	private static int MGMT_WIDTH = 10;
	private static int MGMT_DEPTH = 10;
	private Property[] properties;
	private Plot plot;
	private int numberOfProperties;
	
	//constructors
	public ManagementCompany() {
		
		name = "";
		taxID = "";
		managementFee = 0;
		properties = new Property[MAX_PROPERTY];
		plot = new Plot();
		numberOfProperties = 0;
		
	}
	
	public ManagementCompany(String name, String taxID, int fee) {
		
		this.name = name;
		this.taxID = taxID;
		managementFee = fee;
		properties = new Property[MAX_PROPERTY];
		plot = new Plot();
		numberOfProperties = 0;
		
	}
	
	public ManagementCompany(String name, String taxID, int fee, int x, int y, int depth, int width) {
		
		this.name = name;
		this.taxID = taxID;
		managementFee = fee;
		properties = new Property[MAX_PROPERTY];
		plot = new Plot(x, y, depth, width);
		numberOfProperties = 0;
		
	}
	
	//copy constructor
	public ManagementCompany(ManagementCompany other) {
		
		this(other.name, other.taxID, other.managementFee, other.plot.getX(), other.plot.getY(), other.plot.getDepth(), other.plot.getWidth());
		
	}
	
	//getters
	public String getName() {
		
		return name;
		
	}
	
	public String getTaxID() {
		
		return taxID;
		
	}
	
	public double getManagementFee() {
		
		return managementFee;
		
	}
	
	public int getNumberOfProperties() {
		
		return numberOfProperties;
		
	}
	
	public Plot getPlot() {
		
		return plot;
		
	}
	
	
	//setters
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public void setTaxID(String taxID) {
		
		this.taxID = taxID;
		
	}
	
	public void setManagementFee(int managementFee) {
		
		this.managementFee = managementFee;
		
	}
	
	public void setNumberOfProperties(int numberOfProperties) {
		
		this.numberOfProperties = numberOfProperties;
		
	}
	
	public int addProperty(Property property) {
		
		if(numberOfProperties >= MAX_PROPERTY) {
			
			return -1;
			
		}
		else if(property == null) {
			
			return -2;
			
		}
		else if(!plot.encompasses(property.getPlot())){
			
			return -3;
			
		}
		
		for(int i = 0; i < numberOfProperties; i++) {
			if(properties[i] == null && property.getPlot().overlaps(properties[i].getPlot())) {
				
				return -4;
				
			}
		}
		
		
		properties[numberOfProperties] = property;
		numberOfProperties ++;
		
		return numberOfProperties-1;
	}
	
	public double getTotalRent() {
		
		double total = 0.0;
		
		for(int i = 0; i < numberOfProperties; i++) {
			
			total += properties[i].getRentAmount();
			
		}
		
		return total;
		
	}
	
	public Property getHighestRentProperty() {
		
		Property highest = properties[0];
		
		for(int i = 1; i < numberOfProperties; i++) {
			
			if(highest.getRentAmount() < properties[i].getRentAmount()) {
				
				highest = properties[i];
				
			}
			
		}
		
		return highest;
		
	}
	
	public void romoveLastProperty() {
		
		if(numberOfProperties > 0) {
			
			properties[numberOfProperties-1] = null;
			numberOfProperties --;
			
		}
		
	}
	
	public boolean isPropertiesFull() {
		
		return numberOfProperties >= MAX_PROPERTY;
		
	}
	
	public int getPropertiesCount() {
		
		return numberOfProperties;
		
	}
	
	public boolean isManagementFeeValid() {
		
		return managementFee >= 0 && managementFee <= 100;
		
	}
	
	public String toString() {
		
		String text = "This list of the properties for " + name + ", taxID: " + taxID + "\n";
	    text += "______________________________________________________\n";

	    for (int i = 0; i < numberOfProperties; i++) {
	        if (properties[i] != null) {
	            text += properties[i].toString() + "\n";
	        }
	    }

	    text += "______________________________________________________\n";
	   
	    double totalFee = (getTotalRent()*managementFee)*.01;

	    text += "Total management Fee: " + String.format("%.2f", totalFee);
	    return text;
		
	}
}
