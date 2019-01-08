public abstract class Solid implements Comparable<Solid> {

	public Solid(double radius) {
		setRadius(radius);
	}
	
	public Solid(double radius, double height) {
		setRadius(radius);
		setHeight(height);
	}

	/**
	 * calculates volume of the solid
	 */
	public abstract double calculateVolume();

	/**
	 * calculates surface of the solid
	 */
	public abstract double calculateSurface();

	/**
	 * Returns the radius
	 * @return
	 */
	public abstract double getRadius();

	/**
	 * Set the radius
	 */
	public abstract void setRadius(double radius);

	/**
	 * Returns the height
	 * @return
	 */
	public abstract double getHeight();

	/**
	 * Set the height
	 */
	public abstract void setHeight(double height);

}
