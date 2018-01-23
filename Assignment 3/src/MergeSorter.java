
public class MergeSorter implements IntSorter {

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
		int[] temp = new int[array.length];
		mergeSort(array, temp, 0, array.length / 2, array.length);
		endTime = System.nanoTime();

	}

	private void mergeSort(int[] array, int[] temp, int begin, int mid, int interval) {
		if (interval - mid > 1 || mid - begin > 1) {
			mergeSort(array, temp, begin, (mid + begin) / 2, mid);
			mergeSort(array, temp, mid, (interval + mid) / 2, interval);
		}
		merge(array, temp, begin, mid, interval);
	}

	private void merge(int[] array, int[] temp, int begin, int mid, int end) {
		int index = 0;
		int b1 = begin;
		int b2 = mid;
		
		while (b1 < mid && b2 < end) {
			if (array[b1] < array[b2]) {
				temp[index] = array[b1];
				index++;
				b1++;
			} else {
				temp[index] = array[b2];
				index++;
				b2++;
			}
			moves++;
		}
		for (int i = b1; i < mid; i++) {
			temp[index] = array[i];
			index++;
			b1++;
		}
		System.arraycopy(temp, 0, array, begin, index);
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
