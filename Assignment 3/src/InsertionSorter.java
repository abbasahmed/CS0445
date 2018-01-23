public class InsertionSorter implements IntSorter {

	private int[] array = null;
	private int moves = 0;
	private long startTime = 0;
	private long endTime = 0;

	public void init(int[] a) {
		this.array = a;
		moves = 0;
	}

	public void sort() {
		startTime = System.nanoTime();
		for (int i = 1; i < array.length; i++) {
			int k = i;
			while (k > 0 && array[k] < array[k - 1]) {
				int temp = array[k];
				array[k] = array[k - 1];
				array[k - 1] = temp;
				k--;
				moves++;
			}
		}
		endTime = System.nanoTime();
	}

	public long getSortTime() {
		return endTime - startTime;
	}

	public int getMoves() {
		return moves;
	}
}
