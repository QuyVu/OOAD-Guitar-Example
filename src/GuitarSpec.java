import enumarate.Builder;
import enumarate.Type;
import enumarate.Wood;


/* This object include all the general properties of a guitar
 */
public class GuitarSpec {

	private Builder builder;
	private Type type;
	private int numStrings;
	private Wood backWood, topWood;
	private String model;

	public GuitarSpec(Builder builder, String model, Type type, int numStrings, Wood backWood, Wood topWood) {
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.numStrings = numStrings;
		this.backWood = backWood;
		this.topWood = topWood;
	}

	public Builder getBuilder() {
		return builder;
	}

	public String getModel() {
		return model;
	}

	public Type getType() {
		return type;
	}

	public Wood getBackWood() {
		return backWood;
	}

	public Wood getTopWood() {
		return topWood;
	}
	
	public int getNumStrings() {
		return numStrings;
	}

	//this method will handle the function of search()
	public boolean matches(GuitarSpec customerSpec) {
		if (this.builder != customerSpec.builder)
			return false;
		if ((this.model != null) && (!this.model.equals("")) && (!this.model.equals(customerSpec.model)))
			return false;
		if (this.type != customerSpec.type)
			return false;
		if (this.numStrings != customerSpec.numStrings)
			return false;
		if (backWood != customerSpec.backWood)
			return false;
		if (topWood != customerSpec.topWood)
			return false;
		return true;
	}

}
