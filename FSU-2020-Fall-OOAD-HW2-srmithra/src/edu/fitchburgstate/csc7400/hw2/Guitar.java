/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 2
 * 
 * Date: 2018-09-03
 */
package edu.fitchburgstate.csc7400.hw2;

import java.util.function.BooleanSupplier;

/**
 * Guitar contains the information needed to keep track of a type of guitar from
 * Rick's music store
 * 
 * It contains Constructors for Guitar and methods to compare guitar information . 
 * 
 * @author HeadFirstOODA
 */
public class Guitar extends GuitarSpec implements GuitarInterface {

	Double lowestPrice;

	Double highestPrice;

	private String model;

	private GuitarManufacturer manufacturer;

	private GuitarType type;

	private GuitarWood backWood;

	private GuitarWood topWood;
	
	
	/**
     * Guitar constructor with all the guitar specifications passed as parameters
  	 * @param serialNumber manufacturer serial number
	 * @param price store price
	 * @param manufacturer the guitar's manufacturer
	 * @param model the manufacturers model
	 * @param type guitar type (electric/acoustic)
	 * @param backWood the wood used for the guitar body
	 * @param topWood the wood used for the guitar's face
	 * 
	 * @precondition serial number cannot be null
	 * @precondition price must be greater than 0.0
	 * 
  	 */
	public Guitar(String serialNumber, double price, GuitarManufacturer manufacturer, String model, GuitarType type, GuitarWood backWood,GuitarWood topWood) {
		super(manufacturer,model,type,backWood,topWood);
		this.serialNumber = serialNumber;
		this.price = price;
		this.manufacturer = manufacturer;
		this.model = model;
		this.type = type;
		this.backWood = backWood;
		this.topWood = topWood;
	}
	
	/**
	 * constructor
	 * @param guitarSpec
	 * @param lowestPrice
	 * @param highestPrice
	 */
	public Guitar(GuitarSpecInterface guitarSpec, Double lowestPrice, Double highestPrice) {
		super(guitarSpec.getGuitarManufacturer(),guitarSpec.getModel(),guitarSpec.getGuitarType(),guitarSpec.getBackGuitarWood(),guitarSpec.getTopGuitarWood());
		this.gspec = guitarSpec;

		this.lowestPrice = lowestPrice;
		this.highestPrice = highestPrice;
	}

	/**
	 * getter for serial number
	 * @return string
	 */
	@Override
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * Return store price of guitar
	 * @return double
	 */
	@Override
	public double getPrice() {
		return price;
	}

	/**
	 * Set the store price of the guitar
	 * @param double
	 */
	@Override
	public void setPrice(double newPrice) {
		this.price = newPrice;
	}

	/**
	 * The guitar manufacturer's serial number
	 */
	private String serialNumber;

	/**
	 * Rick's price for the guitar
	 */
	private double price;
	
	/**
	 * Rick's guitar spec object
	 */
	GuitarSpecInterface gspec;

/**
 * Compares if two guitars are equal , one is the current guitar which calls this method and the other is the guitar passed as parameter
 * The guitar fields comapred if equal are - manufacturer , type , top wood , back wood , price and model
 * 
 * @param Guitar object as input
 * @return boolean value
 * True if the guitar passed as argument and the current loaded guitar are equal - compares manufacturer , type , top wood , back wood , price and model
 * False if any of the above conditions are not equal
 * 
 * @precondition Guitar object must not be null
 */
	@Override
	public boolean equal(Guitar guitar) {
		if(this.manufacturer != guitar.getGuitarManufacturer()) 
		{ 			
			return false; 		
		} 		
		if(this.type != guitar.getGuitarType()) 
		{ 			
			return false; 		
		} 		
		if(this.topWood != guitar.getTopGuitarWood()) 
		{ 			
			return false; 		
		} 		
		if(this.backWood != guitar.getBackGuitarWood()) 
		{ 			
			return false; 		
		} 		
		if(guitar.getPrice() != price) 
		{ 			
			return false; 		
		} 		
		if(!guitar.getModel().equals(this.model) )
		{
			return false; 		
		} 		
		if(!guitar.getSerialNumber().equals(serialNumber)) 
		{ 			
			return false; 		
		} 		
		return true;
	}

	/**
	 * Calls the matches method in GuitarSpec class with additional conditions for comparing the price with lowest and highest prices.
	 * 
	 * @param guitarspec
	 * @param lp - lowest price 
	 * @param hp - highest price
	 * @return boolean 
	 * True if price is between low and high price and if guitar spec matches with existing guitars.
	 * False if price range is not between high and low , and if guitar doesnot match with existing guitars.
	 * 
	 * @precondition guitarspec must not be null 
	 * @precondition lp and hp must be positive values (lower price and higher price ) 
	 */
	public boolean matches(GuitarSpec guitarspec, Double lp, Double hp) {
		if(guitarspec != null) {
			if(matches(guitarspec)) {
				if(lp != null && lp > price) 
					return false;
				if(hp != null && hp < price) 
					return false;
				
				return true;
			}
		}
		return false;
	}

}
