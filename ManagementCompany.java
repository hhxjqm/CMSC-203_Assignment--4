public class ManagementCompany {
	
    private final int MAX_PROPERTY = 5;
    private double mgmFeePer;
    private java.lang.String name;
    private java.lang.String taxID;
    private final int MAX_WIDTH = 10;
    private final int MAX_DEPTH = 10;
    private Property[] properties;
    private Plot plot;

    public ManagementCompany() {
        name = "";
        taxID = "";
        mgmFeePer = 0;
        plot = new Plot();
        properties = new Property[MAX_PROPERTY];
    }

    public ManagementCompany(java.lang.String name, java.lang.String taxID, double mgmFee) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFee;
        this.plot = new Plot(0,0,MAX_WIDTH, MAX_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
    }

    public ManagementCompany(java.lang.String name, java.lang.String taxID, double mgmFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFee;
        this.plot = new Plot(x,y,width,depth);
        this.properties = new Property[MAX_PROPERTY];
    }

    public ManagementCompany(ManagementCompany otherCompany) {
        name = otherCompany.name;
	    taxID = otherCompany.taxID;
	    mgmFeePer = otherCompany.mgmFeePer;
	    plot = otherCompany.plot;
	    properties = new Property[MAX_PROPERTY];
    }
    public int addProperty(Property property) {
        if (property == null)
            return -2;
      
        else if (!plot.encompasses(property.getPlot()))
            return -3;
    
        for (int i = 0;i < MAX_PROPERTY;i++) {
            if (properties[i] != null) {
                if (properties[i].getPlot().overlaps(property.getPlot()))
                    return -4;
            } 
            else{
                properties[i] = property;
                return i;
            } 
        }
        return -1;
    }
  
    public int addProperty(String name,String city,double rent,String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }
  
    public int addProperty( String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }
  
    public java.lang.String displayPropertyAtIndex(int i){
	    return properties[i].toString();
    }
  
    public int getMAX_PROPERTY() {
	    return MAX_PROPERTY;
    }
  
    public double maxRentProp() {
	    double max = 0;
	    for (int i = 0;i<MAX_PROPERTY;i++) {
	        if (properties[i]==null)
	            break;	
	        if (properties[i].getRentAmount() > max) {
	            max = properties[i].getRentAmount();
	        }
	    }
	    return max;
	
    }
 
    public int maxRentPropertyIndex() {
        int index = 0;
        double max = 0;
        for (int i = 0;i<MAX_PROPERTY;i++) {
            if (properties[i] == null)  
                break;
            if (max < properties[i].getRentAmount()) {
                max = properties[i].getRentAmount();
                index = i;
            }
        }
        return index;
    }

    public java.lang.String toString() {
        String str = "";
        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i]==null)
                break; 
            str += properties[i] + "\n"; 
        }
        return "List of the properties for " + name + ", taxID: " + taxID
        + "\n______________________________________________________\n" + str 
        +  "______________________________________________________\n"
        + "total management Fee: " + (totalRent() * mgmFeePer / 100);
    }

    public double totalRent() {
	    double total = 0;
	    for (int i=0;i<MAX_PROPERTY;i++) {
	        if (properties[i]==null)
	            break;
	        total += properties[i].getRentAmount();
	    }
	    return total;
    }
    
    public String getName() {
    	return name;
    }
    
    public Plot getPlot() {
    	return plot;
    }
}

