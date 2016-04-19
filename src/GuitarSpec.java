import enumarate.Builder;
import enumarate.Type;
import enumarate.Wood;

public class GuitarSpec {

	private Builder builder;
	private Type type;
	private Wood backWood, topWood;
	private String model;
	
	public GuitarSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood) {
		this.builder= builder;
		this.model = model;
		this.type = type;
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

}
