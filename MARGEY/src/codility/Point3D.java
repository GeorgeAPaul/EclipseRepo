package codility;

public class Point3D {
	
	int x;
	int y;
	int z;
	
	public String toString() 
	{
		return "X:" + x + " Y:" + y + " Z:" + z;
	}
	
	public Point3D()
	{
		
	}
	
	public Point3D(int i)
	{
		
	}
	
	public static void main(String[] args)
	{
		Point3D test = new Point3D();
		
		test.x = 5;
		test.y = 10;
		test.z = 8;
		
		System.out.println(test.toString());
	}

}
