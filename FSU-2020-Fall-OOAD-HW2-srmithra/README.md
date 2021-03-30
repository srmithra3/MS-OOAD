# FSU-2020-Fall-OOAD-HW2

Here are the things you need to do for homework 2
1. Make sure that you can return multiple guitars from the inventory, if you haven't already
2. Create 3 enums named GuitarManufacturer, GuitarType, and GuitarWood that includes all 
   the values for each. Used this as a template. Please not that any ... means you must
   change the code or add documentation. Also change Enum to Manufacturer, Type, etc.

    ... headers ...
    public enum GuitarEnum {
      VALUE1("stringvalue"),
      ...
      VALUE2("stringvalue2);

      /**
	   * Return the GuitarManufacturer enum value for a given display name
	   * 
	   * @param displayName the display name of the manufacturer
	   * 
	   * @return the enum value
	   */
      public static GuitarEnum forDislayName(string displayName) {...}

      ... method doc
      private GuitarEnum(String displayName) {...}
    
      ... method doc
      private String getDisplayName() {...}
    
      ... method doc
      private STring toString() { return this.getDisplayName(); }
    
      ... variable doc
      private final String displayName;
    }
3. Create a GuitarSpecInterface interface that has the following getters for manufacturer, model, 
   type, backwood, and topwood and a matches(GuitarSpecInterface) method
4. The creation of the guitar spec should used the enums, additionally, it should specify (as a 
   precondition) that model should either be null, or an none empty string
5. Create a GuitarSpec the implements the GuitarSpecInterface with manufacturer, model, type, and 
   the two woods, plus the matches should use null as a wildcard
6. Make sure you have the proper asserts for checking preconditions
7. Create a GuitarInteface that extends GuitarSpecInterface. In this case, specify (as a post 
   condition) that no value returned will ever be null. Also add a getter for serial number, and a 
   getter/setter for price. Price >= 0, and serial number cannot be empty.
8. The GuitarInterface should have a
      matches(GuitarSpecInterface guitarSpec, Double lowestPrice, Double higestPrice)
   and an equals(Guitar). You can specify that the guitarSpec cannot be null.   
9. Change the Guitar class to implement GuitarInterface
10. Fix inventory to work with the new classes
11. Create tests for GuitarSpec
12. Make sure all documentation is written.
