
public class Test {

	public static void main(String[] args) {
		int [] array1 = {2,4,5,1,0,3,7,6,9,8};
		int [] array2 = {20,40,50,10,0,30,70,60,90,80};
		int [] array3 = {200,40,50,10,0,3,70,6,90,80};
		
		IntDataGenerator intArray = new IntDataGenerator();
		
		int [] randomArray1 = intArray.randomIntArray(0, 2700);
		int [] randomArray2 = intArray.randomIntArray(0, 2700);
		int [] randomArray3 = intArray.randomIntArray(0, 2700);
		
		
		MergeSorter mSort1 = new MergeSorter();
		MergeSorter mSort2 = new MergeSorter();
		mSort1.init(array1);
		mSort2.init(randomArray1);
		mSort1.sort();
		mSort2.sort();
		System.out.println("Merge Sorter for Array 1:");
		System.out.println(array1[0]);
		System.out.println(array1[1]);
		System.out.println(array1[2]);
		System.out.println(array1[3]);
		System.out.println(array1[4]);
		System.out.println(array1[5]);
		System.out.println(array1[6]);
		System.out.println(array1[7]);
		System.out.println(array1[8]);
		System.out.println(array1[9]);
		System.out.println();
		System.out.println("Moves: "+mSort1.getMoves());
		System.out.println("Time: "+mSort1.getSortTime());
		System.out.println();
		System.out.println("Merge Sorter for Randomized Array: [First 10 values only.] ");
		System.out.println(randomArray1[0]);
		System.out.println(randomArray1[1]);
		System.out.println(randomArray1[2]);
		System.out.println(randomArray1[3]);
		System.out.println(randomArray1[4]);
		System.out.println(randomArray1[5]);
		System.out.println(randomArray1[6]);
		System.out.println(randomArray1[7]);
		System.out.println(randomArray1[8]);
		System.out.println(randomArray1[9]);
		System.out.println();
		System.out.println("Moves: "+mSort2.getMoves());
		System.out.println("Time: "+mSort2.getSortTime());
		System.out.println();
		
		
		BubbleSorter bSort1 = new BubbleSorter();
		BubbleSorter bSort2 = new BubbleSorter();
		bSort1.init(array2);
		bSort1.sort();
		bSort2.init(randomArray2);
		bSort2.sort();

		System.out.println("Bubble Sorter for Array 2:");
		System.out.println(array2[0]);
		System.out.println(array2[1]);
		System.out.println(array2[2]);
		System.out.println(array2[3]);
		System.out.println(array2[4]);
		System.out.println(array2[5]);
		System.out.println(array2[6]);
		System.out.println(array2[7]);
		System.out.println(array2[8]);
		System.out.println(array2[9]);
		System.out.println();
		System.out.println("Moves: "+bSort1.getMoves());
		System.out.println("Time: "+bSort1.getSortTime());
		System.out.println();
		
		System.out.println("Bubble Sorter for Randomized Array: [First 10 values only.] ");
		System.out.println(randomArray2[0]);
		System.out.println(randomArray2[1]);
		System.out.println(randomArray2[2]);
		System.out.println(randomArray2[3]);
		System.out.println(randomArray2[4]);
		System.out.println(randomArray2[5]);
		System.out.println(randomArray2[6]);
		System.out.println(randomArray2[7]);
		System.out.println(randomArray2[8]);
		System.out.println(randomArray2[9]);
		System.out.println();
		System.out.println("Moves: "+bSort2.getMoves());
		System.out.println("Time: "+bSort2.getSortTime());
		System.out.println();
		
		SelectionSorter sSort1 = new SelectionSorter();
		SelectionSorter sSort2 = new SelectionSorter();
		
		sSort1.init(array3);
		sSort1.sort();
		sSort2.init(randomArray3);
		sSort2.sort();
		
		System.out.println("Selection Sorter for Array 3: ");
		System.out.println(array3[0]);
		System.out.println(array3[1]);
		System.out.println(array3[2]);
		System.out.println(array3[3]);
		System.out.println(array3[4]);
		System.out.println(array3[5]);
		System.out.println(array3[6]);
		System.out.println(array3[7]);
		System.out.println(array3[8]);
		System.out.println(array3[9]);
		System.out.println();
		System.out.println("Moves: "+sSort1.getMoves());
		System.out.println("Time: "+sSort1.getSortTime());
		System.out.println();		
		
		System.out.println("Selection Sorter for Randomized Array: [First 10 values only.] ");
		System.out.println(randomArray3[0]);
		System.out.println(randomArray3[1]);
		System.out.println(randomArray3[2]);
		System.out.println(randomArray3[3]);
		System.out.println(randomArray3[4]);
		System.out.println(randomArray3[5]);
		System.out.println(randomArray3[6]);
		System.out.println(randomArray3[7]);
		System.out.println(randomArray3[8]);
		System.out.println(randomArray3[9]);
		System.out.println();
		System.out.println("Moves: "+sSort2.getMoves());
		System.out.println("Time: "+sSort2.getSortTime());
		System.out.println();		
	}

}
