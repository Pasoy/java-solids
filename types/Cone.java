import Solid;

public class Cone extends Solid {

	private double radius, height;
	
	public Cone(double radius, double height) {
		super(radius, height);
	}
	
	@Override
	public double getRadius() {
		return this.radius;
	}
	
	@Override
	public void setRadius(double radius) {
		if(radius <= 0.0) throw new IllegalArgumentException("Radius [" + radius + "] not valid!");
		this.radius = radius;
	}
	
	@Override
	public double getHeight() {
		return this.height;
	}
	
	@Override
	public void setHeight(double height) {
		if(height <= 0.0) throw new IllegalArgumentException("Height [" + radius + "] not valid!");
		this.height = height;
	}
	
	@Override
	public String toString() {
		return "CONE, Radius: " + getRadius() + "; Height: " + getHeight() + "; Volume: " + calculateVolume() + "; Surface: " + calculateSurface();
	}

	@Override
	public double calculateVolume() {
		double result = 0.0;
		result = ((1.0/3.0) * (Math.pow(getRadius(), 2)) * Math.PI * getHeight());
		return result;
	}

	@Override
	public double calculateSurface() {
		double result = 0.0;
		result = (Math.pow(getRadius(), 2) * Math.PI + getRadius() * Math.PI * Math.sqrt(Math.pow(getRadius(), 2) + Math.pow(getHeight(), 2)));
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cone other = (Cone) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Solid s) {
		if(this.calculateVolume() > s.calculateVolume()) {
			return -1;
		} else if(this.calculateVolume() == s.calculateVolume()) {
			return 0;
		} else {
			return 1;
		}
	}

}
