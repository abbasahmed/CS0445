
public class SelectionSorter implements IntSorter {

	private int[] array = null;
	private int moves = 0;
	private long startTime = 0;
	private long endTime = 0;

	@Override
	public void init(int[] a) {
		this.array = a;
		moves = 0;
	}

	@Override
	public void sort() {
		startTime = System.nanoTime();
		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = getMinIndex(array, i);
			swap(array, i, minIndex);
			moves++;
		}
		endTime = System.nanoTime();
	}

	private int getMinIndex(int[] array, int i) {
		int result = i;
		for (int k = i + 1; k < array.length; k++) {
			if (array[k] < array[result]) {
				result = k;
			}
		}
		return result;
	}

	private static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
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
