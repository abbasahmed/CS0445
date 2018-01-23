
public class BubbleSorter implements IntSorter {

	private int[] array = null;
	private int moves = 0;
	private long startTime = 0;
	private long endTime = 0;

	@Override
	public void init(int[] a) {
		this.array = a;
		moves = 0;
	}

	private static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

	@Override
	public void sort() {
		boolean sorted = false;
		int endOffset = 0;
		startTime = System.nanoTime();
		while (!sorted) {
			sorted = true;
			for (int i = 1; i < array.length - endOffset; i++) {
				if (array[i] < array[i - 1]) {
					sorted = false;
					swap(array, i, i - 1);
				}
				moves++;
			}
		}
		endOffset++;
		endTime = System.nanoTime();
	}

	@Override
	public int getMoves() {
		return moves;
	}

	@Override
	public long getSortTime() {
		return endTime - startTime;
	}

	public int[] toArray() {
		int[] result = new int[array.length];
		System.arraycopy(array, 0, result, 0, array.length);
		return result;
	}

}
