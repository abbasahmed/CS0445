import java.awt.geom.Point2D;

public class Circle {

	private double x;
	private double y;
	private double radius;


	public Circle(double x, double y, double radius) {
		this.radius = radius;
		this.x = x;
		this.y = y;
	}

	public Point2D.Double getLocation() {
		return new Point2D.Double(x, y);
	}

	public double getRadius() {
		return radius;
	}

	public int hashCode() {

		String rStr = Double.toString(radius);
		String xStr = Double.toString(x);
		String yStr = Double.toString(y);
		String finStr = xStr + "_" + yStr + "_" + rStr;

		// Horner's Method

		int hash = 0;
		int n = finStr.length();
		for (int i = 0; i < n; i++) {
			hash = 31 * hash + finStr.charAt(i);
		}
		return hash;
	}
}