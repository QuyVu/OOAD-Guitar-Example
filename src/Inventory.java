import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import enumarate.Builder;
import enumarate.Type;
import enumarate.Wood;

public class Inventory {
	private List<Guitar> guitars;

	public Inventory() {
		guitars = new LinkedList<Guitar>();
	}

	public void addGuitar(String serialNumber, double price, Builder builder, String model, Type type, int numStrings, Wood backWood,
			Wood topWood) {
		// add guitar attributes using GuitarSpec object
		GuitarSpec spec = new GuitarSpec(builder, model, type, numStrings, backWood, topWood);
		Guitar guitar = new Guitar(serialNumber, price, spec);
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

	/*
	 * Return only one first matching guitar in the inventory 
	 */
	// public Guitar searchForFirstMatching(GuitarSpec searchGuitar) {
	// for (Iterator<Guitar> i = guitars.iterator(); i.hasNext();) {
	// Guitar guitar = (Guitar) i.next();
	// // Ignore serial number since that’s unique
	// // Ignore price since that’s unique
	//
	// // String builder = searchGuitar.getBuilder();
	// // if ((builder != null) && (!builder.equals("")) &&
	// // (!builder.equals(guitar.getBuilder())))
	// if (searchGuitar.getBuilder() != guitar.getBuilder())
	// continue;
	//
	// String model = searchGuitar.getModel().toLowerCase();
	// if ((model != null) && (!model.equals("")) &&
	// (!model.equals(guitar.getModel().toLowerCase())))
	// continue;
	//
	// // String type = searchGuitar.getType();
	// // if ((type != null) && (!searchGuitar.equals("")) &&
	// // (!type.equals(guitar.getType())))
	// if (searchGuitar.getType() != guitar.getType())
	// continue;
	//
	// // String backWood = searchGuitar.getBackWood();
	// // if ((backWood != null) && (!backWood.equals("")) &&
	// // (!backWood.equals(guitar.getBackWood())))
	// if (searchGuitar.getBackWood() != guitar.getBackWood())
	// continue;
	//
	// // String topWood = searchGuitar.getTopWood();
	// // if ((topWood != null) && (!topWood.equals("")) &&
	// // (!topWood.equals(guitar.getTopWood())))
	// if (searchGuitar.getTopWood() != guitar.getTopWood())
	// continue;
	// return guitar;
	// }
	// return null;
	// }

	/*
	 * Use to return all matching guitar in the inventory 
	 */
	// public List<Guitar> searchAllInventory(Guitar searchGuitar) {
	// List<Guitar> matchingGuitars = new LinkedList<Guitar>(); // ArrayList is
	// ok
	// for (Iterator<Guitar> i = guitars.iterator(); i.hasNext();) {
	// Guitar guitar = (Guitar) i.next();
	// // Ignore serial number since that’s unique
	// // Ignore price since that’s unique
	// if (searchGuitar.getBuilder() != guitar.getBuilder())
	// continue;
	// String model = searchGuitar.getModel().toLowerCase();
	// if ((model != null) && (!model.equals("")) &&
	// (!model.equals(guitar.getModel().toLowerCase())))
	// continue;
	// if (searchGuitar.getType() != guitar.getType())
	// continue;
	// if (searchGuitar.getBackWood() != guitar.getBackWood())
	// continue;
	// if (searchGuitar.getTopWood() != guitar.getTopWood())
	// continue;
	// matchingGuitars.add(guitar);
	// }
	// return matchingGuitars;
	// }

	/* 
	 * Upgrade above method to search with GuitarSpec
	 */
	public List<Guitar> searchAllInventory(GuitarSpec searchSpec) {
		List<Guitar> matchingGuitars = new LinkedList<Guitar>(); // ArrayList is
																	// ok
		for (Iterator<Guitar> i = guitars.iterator(); i.hasNext();) {
			Guitar guitar = (Guitar) i.next();

			/* compare two GuitarSpec object instead of 
			 * compare every single Spec's property.
			 * GuitarSpec's matches() method will handle the comparision.
			 * So you can easily add new property for guitar 
			 * without paying attention to Inventory class anymore.
			*/
			// GuitarSpec guitarSpec = guitar.getSpec();
			if (guitar.getSpec().matches(searchSpec))
				matchingGuitars.add(guitar);
		}
		return matchingGuitars;
	}

}
