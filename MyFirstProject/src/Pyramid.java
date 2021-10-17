
public class Pyramid {
	
	private double height;
	private double baseLength;

	public Pyramid(double height, double baseLength) {
		this.height = height;
		this.baseLength = baseLength;
		
		System.out.println("Creating a pyramid of height: " + height + " and baseLength: " + baseLength);
		
	}
	
	public double getVolume() {
		
		return (baseLength * baseLength * height)/3;
	}
	public double getSurfaceArea() {
		
		return Math.pow(baseLength, 2) + 2 * baseLength* Math.sqrt(Math.pow(baseLength,2)/4+Math.pow(height,2));
		
	}
	
	public static void main(String[] args) {
		
		Pyramid p = new Pyramid(4,4);
		
		System.out.println("Volume: " + p.getVolume());
		System.out.println("Surface area: " + p.getSurfaceArea());

	}

}
