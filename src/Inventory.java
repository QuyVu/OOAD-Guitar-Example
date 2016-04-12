import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import enumarate.Type;
import enumarate.Wood;

public class Inventory {
	private List<Guitar> guitars;

	public Inventory() {
		guitars = new LinkedList<Guitar>();
	}

	public void addGuitar(String serialNumber, double price, String builder, String model, Type type, Wood backWood,
			Wood topWood) {
		Guitar guitar = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
		guitars.add(guitar);
	}

	public Guitar getGuitar(String serialNumber) {
		for (Iterator<Guitar> i = guitars.iterator(); i.hasNext();) {
			Guitar guitar = (Guitar) i.next();
			if (guitar.getSerialNumber().equals(serialNumber)) {
				return guitar;
			}
		}
		return null;
	}
	
	public Guitar search(Guitar searchGuitar) {
		for (Iterator<Guitar> i = guitars.iterator(); i.hasNext();) {
			Guitar guitar = (Guitar) i.next();
			// Ignore serial number since that’s unique
			// Ignore price since that’s unique
			
			//String builder = searchGuitar.getBuilder();
			//if ((builder != null) && (!builder.equals("")) && (!builder.equals(guitar.getBuilder())))
			if (searchGuitar.getBuilder() != guitar.getBuilder())
				continue;
			String model = searchGuitar.getModel();
			if ((model != null) && (!model.equals("")) && (!model.equals(guitar.getModel())))
				continue;
			//String type = searchGuitar.getType();
			//if ((type != null) && (!searchGuitar.equals("")) && (!type.equals(guitar.getType())))
			if (searchGuitar.getType() != guitar.getType())
				continue;
			//String backWood = searchGuitar.getBackWood();
			//if ((backWood != null) && (!backWood.equals("")) && (!backWood.equals(guitar.getBackWood())))
			if (searchGuitar.getBackWood() != guitar.getBackWood())
				continue;
			//String topWood = searchGuitar.getTopWood();
			//if ((topWood != null) && (!topWood.equals("")) && (!topWood.equals(guitar.getTopWood())))
			if (searchGuitar.getTopWood() != guitar.getTopWood())
				continue;
		}
		return null;
	}
}
