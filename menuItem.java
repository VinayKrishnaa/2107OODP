package sce.cz2002.project;

/* Implementation of each individual menu item with variables 
   1. Name 
   2. Price
   3. Description of item
   4. Preparation Time (in minutes denoted as int)
 */

public class menuItem{ 

	public menuItem(String name, String description, float price, int preparationTime) {
		this.price = price;
		this.name = name;
		this.description = description;
		this.preparationTime = preparationTime;
	}

	private float price;
    private String name;
    private String description;
    private int preparationTime;

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

    public int getPreparationTime() {
        return this.preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }
    
    // returns the variables of each menu item as a string 
    @Override 
    public String toString() {
    	return "{Name: " + name + '\n' +
    			"Description: " + description + '\n' +
    			"Price: $" + price + '\n' +
    			"Preparation Time: " + preparationTime + "mins}\n"; 
    }
}
