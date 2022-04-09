package sce.cz2002.project;

/* Implementation of each individual menu item with variables 
   1. Name 
   2. Price
   3. Description of item
 */

public class menuItem{ 

	public menuItem(String name, String description, float price) {
		this.price = price;
		this.name = name;
		this.description = description;
	}

	private float price;
    private String name;
    private String description;

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    // returns the variables of each menu item as a string 
    @Override 
    public String toString() {
    	return " " + name + " " + description + " " + price + " ";
    }
}
