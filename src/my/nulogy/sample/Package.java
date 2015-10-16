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
		
		materials (double value) {
			this.dMaterialMarkup = value;
		}
		
		public double getMaterialMarkup() {
			return this.dMaterialMarkup;
		}
	
	}
	
	private double dBasePrice;
	private String sMaterial;
	private int intNumPeople;
	
	
	//Package Constructor
	public Package() {
		
		availableMaterials.add("drugs");
		availableMaterials.add("food");
		availableMaterials.add("electronics");
		
	}
	
	// Set member variables.
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
	
	public double calculateQuote() {
		
		double dTotalCost = 0;
		double dMarkup = 0;
		double dMaterialRate = 0; //Initialize material markup to 0 for misc material.
		
		//If the material is available set fixed markup. 
		if (availableMaterials.contains(sMaterial)) {
			dMaterialRate = materials.valueOf(sMaterial.toUpperCase()).getMaterialMarkup();
		} 
		
		dTotalCost = dBasePrice;
		dTotalCost += dFlatRate * dBasePrice;
		
		dMarkup = dTotalCost + (dLabourRate * intNumPeople * dTotalCost);
		dMarkup += dMaterialRate * dTotalCost;
		
		dTotalCost = dMarkup; 
		
		//Round to 2 decimal places.
		dTotalCost = Double.valueOf(String.format("%.2f", dTotalCost));
		
		return dTotalCost;
	}
}
