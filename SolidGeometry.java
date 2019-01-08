import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import types.Cone;
import types.Cylinder;
import types.Sphere;

public class SolidGeometry {
	
	private HashSet<Solid> solids;
	
	/**
	 * Constructor
	 */
	public SolidGeometry() {
		solids = new HashSet<>();
	}
	
	/**
	 * Adds a solid to the set
	 * @param solid
	 */
	public void add(Solid solid) {
		if(solid == null) throw new IllegalArgumentException("Solid is null");
		solids.add(solid);
	}
	
	public int size() {
		return this.solids.size();
	}

	/**
	 * Prints all solids stored in the HashSet
	 */
	public void print() {
		solids.forEach(x -> System.out.println(x.toString()));
	}
	
	/**
	 * Returns smallest solid, i.e. the solid with the smallest value
	 */
	public Solid smallestSolid() {
		Solid result = null;
		double tmp = Integer.MAX_VALUE;
		for(Solid s : solids) {
			double v = s.calculateVolume();
			if(v < tmp) {
				tmp = v;
				result = s;
			}
		}
		return result;
	}
	
	/**
	 * Returns a list of all solids with a surface area between the 2 parameters
	 * @param area1
	 * @param area2
	 * @return
	 */
	public ArrayList<Solid> solidsWithAreaBetween(double area1, double area2) {
		ArrayList<Solid> result = new ArrayList<>();
		for(Solid s : solids) {
			double v = s.calculateVolume();
			if(v > area1 && v < area2) {
				result.add(s);
			}
		}
		return (result);
	}
	
	/**
	 * simple main method
	 * @param args
	 */
	public static void main(String[] args) {
		SolidGeometry sg = new SolidGeometry();
		sg.add(new Sphere(5.0));
		sg.add(new Cylinder(5.0, 10.0));
		sg.add(new Cone(5.0, 10.0));
		sg.add(new Sphere(5.0));
		sg.print();
		
		ArrayList<Solid> s =sg.solidsWithAreaBetween(400.0, 800.0);
		Collections.sort(s);
		System.out.println(s);
	}

}
