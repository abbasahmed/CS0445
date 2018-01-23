
public class StringArrayList implements StringList {

	protected String[] strList;
	protected int size;

	public StringArrayList() { // Constructor
		strList = new String[0];
		size = 0;
	}

	@Override

	public int add(String s) {
		increaseCap(); // increasing the capacity of the string array
		int index = size++;
		strList[index] = s;
		return index;
	}

	@Override
	public String get(int i) {
		if (i > size || i < 0) {
			throw new IndexOutOfBoundsException();
		}

		return strList[i];
	}

	@Override
	public boolean contains(String s) {
		if (indexOf(s) != -1) {
			return true;
		}
		return false;
	}

	@Override
	public int indexOf(String s) {
		for (int i = 0; i <= size - 1; i++) {
			if (strList[i] == s) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int size() {
		if (size > 0) {
			return size;
		}
		return 0;
	}

	@Override
	public int add(int index, String s) {

		increaseCap();
		if (index < size || index > 0) {

			for (int i = strList.length - 1; i > index; i--) {
				strList[i] = strList[i - 1];
			}

			strList[index] = s;
			size++;

		} else {
			throw new IndexOutOfBoundsException();
		}
		return index;
	}

	@Override
	public void clear() {
		for (int i = 0; i <= strList.length - 1; i++) {
			strList[i] = null; // setting all items to null / deleting
		}
		String[] tempList = new String[0];
		this.strList = tempList;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public String remove(int i) {
		String kickOut = strList[i];
		if (i < size && i >= 0) {
			for (int k = i; k < size; k++) {
				strList[k] = strList[k + 1];
			}
		} else {
			throw new IndexOutOfBoundsException();
		}
		size--;
		return kickOut;
	}

	@Override
	public void set(int index, String s) {
		if (index <= size && index >= 0) {
			strList[index] = s;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public String[] toArray() {
		String[] result = new String[size];
		System.arraycopy(strList, 0, result, 0, size);
		return result;
	}

	private void increaseCap() { // method to increase the capacity of the
									// string array
		if (size == strList.length) {
			String[] temp = new String[strList.length * 2 + 1];
			System.arraycopy(strList, 0, temp, 0, size);
			this.strList = temp;
		}
	}

}
