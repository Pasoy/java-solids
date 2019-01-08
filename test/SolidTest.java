import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Solid;
import SolidGeometry;
import types.Cone;
import types.Cylinder;
import types.Sphere;

public class SolidTest {
	
	private SolidGeometry sg;
	private Solid sphere1, sphere2, cylinder, cone;
	
	@Before
	public void setUp() {
		sphere1 = new Sphere(5.0);
		sphere2 = new Sphere(5.0);
		cylinder = new Cylinder(5.0, 10.0);
		cone = new Cone(5.0, 10.0);
		
		sg = new SolidGeometry();
		sg.add(sphere1);
		sg.add(sphere2);
		sg.add(cone);
		sg.add(cylinder);
		
	}

	@Test
	public void testVolume() {
		assertEquals(523.5987755982989d, sphere1.calculateVolume(), 0.01);
		assertEquals(523.5987755982989d, sphere2.calculateVolume(), 0.01);
		assertEquals(785.3981633974483d, cylinder.calculateVolume(), 0.01);
		assertEquals(261.7993877991494d, cone.calculateVolume(), 0.01);
	}

	@Test
	public void testSurface() {
		assertEquals(314.1592653589793d, sphere1.calculateSurface(), 0.01);
		assertEquals(314.1592653589793d, sphere2.calculateSurface(), 0.01);
		assertEquals(471.23889803846896d, cylinder.calculateSurface(), 0.01);
		assertEquals(254.160184615763d, cone.calculateSurface(), 0.01);
	}
	
	@Test
	public void testAdd() {
		sg.add(sphere1);
		sg.add(sphere2);
		sg.add(cone);
		sg.add(cylinder);
		assertEquals(3, sg.size());
	}
	
	@Test
	public void testSmallestSolid() {
		assertEquals(cone, sg.smallestSolid());
	}
	
	@Test
	public void testSolidsWithAreaBetween() {
		assertEquals(2, sg.solidsWithAreaBetween(400.0, 800.0).size());
	}

}
