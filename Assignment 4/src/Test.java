
public class Test {

	public static void main(String[] args) {
		
			Circle m1 = new Circle(34.2, 42.5, 21);
			Circle m2 = new Circle(29.2, 11, 3);
			Circle m3 = new Circle(12.6, 3, 28.2);
			Circle m4 = new Circle(11, 29.2, 3);
			Circle m5 = new Circle(42.5, 34.2, 21);
			
			DataReading d1 = new DataReading(23489L, 2133L, 3421L, 90L, 2392L, 29999L);
			DataReading d2 = new DataReading(2133L, 23489L, 29999L, 3421L, 2392L, 90L);
			DataReading d3 = new DataReading(90L, 23489L, 29999L, 2392L, 3421L, 2133L);
			
			ProductRecord p1 = new ProductRecord("Tesla", 34.2,  10005, 11, 510, 3);
			ProductRecord p2 = new ProductRecord("Abbas", 12.2,  10005, 11, 510, 3);
			
			Student s1 = new Student("Abbas", "Ahmed", 4165368);
			Student s2 = new Student("Dominick", "Gurnari", 4165368);
			Student s3 = new Student("Abbas", "Gurnari", 348902);
			
			System.out.println(m1.hashCode());
			System.out.println(m2.hashCode());
			System.out.println(m3.hashCode());
			System.out.println(m4.hashCode());
			System.out.println(m5.hashCode());
			
			
			System.out.println();
			
			
			System.out.println(d1.hashCode());
			System.out.println(d2.hashCode());
			System.out.println(d3.hashCode());
			
			System.out.println();
			
			System.out.println(p1.hashCode());
			System.out.println(p2.hashCode());
			
			System.out.println();
			
			System.out.println(s1.hashCode());
			System.out.println(s2.hashCode());
			System.out.println(s3.hashCode());

	}

}
