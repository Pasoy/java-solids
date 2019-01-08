import Solid;

public class Sphere extends Solid {
	
	private double radius;

	public Sphere(double radius) {
		super(radius);
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
	public double getHeight() {return 0;}
	
	@Override
	public void setHeight(double height) {}
	
	@Override
	public String toString() {
		return "SPHERE, Radius: " + getRadius() + "; Volume: " + calculateVolume() + "; Surface: " + calculateSurface();
	}

	@Override
	public double calculateVolume() {
		double result = 0.0;
		result = ((4.0/3.0) * Math.PI * (Math.pow(getRadius(), 3)));
		return result;
	}

	@Override
	public double calculateSurface() {
		double result = 0.0;
		result = (4.0 * Math.PI * (Math.pow(getRadius(), 2)));
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Sphere other = (Sphere) obj;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius)) {
			return false;
		}
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
