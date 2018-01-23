import java.util.Random;

public class IntDataGenerator {
	private long seed;
	private int size;

	// Constructor
	public IntDataGenerator() {
		seed = 628;
		size = 100;
	}

	public IntDataGenerator(long seed, int size) {
		this.seed = seed;
		this.size = size;
	}

	// Setters and Getters
	public void setSeed(long seed) {
		this.seed = seed;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	// Returns array of random integers
	// Must give min and max
	public int[] randomIntArray(int min, int max) {
		Random rand = new Random(seed);
		int[] randomArray = new int[size];
		int i = 0;
		while (i < size) {
			randomArray[i] = rand.nextInt((max - min) + 1) + min;
			i++;
		}
		return randomArray;
	}

	// Returns reversed array
	public int[] reversedIntArray() {
		int[] reversedArray = new int[size];
		int i = size;
		for (int j = 0; j < size; j++) {
			reversedArray[j] = i;
			i--;
		}
		return reversedArray;
	}

	public int[] sortedIntArray() {
		int[] sortedArray = new int[size];
		for (int i = 0; i < size; i++) {
			sortedArray[i] = i;
		}
		return sortedArray;
	}
}