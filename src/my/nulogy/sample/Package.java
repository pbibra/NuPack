package my.nulogy.sample;

import java.util.ArrayList;

public class Package {
	
	private final double dFlatRate = 0.05; 
	private final double dLabourRate = 0.012;	
	private ArrayList<String> availableMaterials = new ArrayList<String>();

	private enum materials {
		
		DRUGS(0.075),
		FOOD(0.13),
		ELECTRONICS(0.02);
		
		private final double dMaterialMarkup;
		
		//Set fixed value for each. 
		materials (double value) {
			this.dMaterialMarkup = value;
		}
		
		//Get fixed value for each.
		public double getMaterialMarkup() {
			return this.dMaterialMarkup;
		}
	
	}
	
	private double dBasePrice;
	private String sMaterial;
	private int intNumPeople;
	
	
	//Package Constructor
	public Package() {
		//Populate list of available materials with constant markups.
		availableMaterials.add("drugs");
		availableMaterials.add("food");
		availableMaterials.add("electronics");
		
	}
	
	//Setter methods to define package properties.
	public void setBasePrice(double basePrice) {
		assert basePrice >= 0 : "Base price cannot be negative.";
		this.dBasePrice = basePrice;
	}
	
	public void setMaterial(String material) {
		this.sMaterial = material;
	}
	
	public void setNumPeople(int numPeople) {
		assert numPeople > 0 : "There must be at least 1 person working on the job.";
		this.intNumPeople = numPeople;
	}
	
	//Calculates total cost for the project.
	public double calculateQuote() throws Exception {
		
		double dTotalCost = 0;
		double dMarkup = 0;
		double dMaterialRate = 0; //Initialize material markup to 0 for misc material.
	
		try {
			
			//If the material is available set fixed markup. 
			if (availableMaterials.contains(sMaterial)) {
				//Get fixed rate from materials enum.
				dMaterialRate = materials.valueOf(sMaterial.toUpperCase()).getMaterialMarkup();
			} 
			
			//Store the base price and add the flat rate. Every markup is applied to this new base price.
			dTotalCost = dBasePrice;
			dTotalCost += dFlatRate * dBasePrice;
			
			//Add cost of labour
			dMarkup = dTotalCost + (dLabourRate * intNumPeople * dTotalCost);
			
			//Add cost to pack specific material.
			dMarkup += dMaterialRate * dTotalCost;
			
			dTotalCost = dMarkup; 
			
			//Round to 2 decimal places.
			dTotalCost = Double.valueOf(String.format("%.2f", dTotalCost));
			
			return dTotalCost;
			
			
		} catch(Exception e) {
			
			throw new Exception("Error in calculateQuote: " );
			
		}
		
	}
}
