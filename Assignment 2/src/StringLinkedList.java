public class StringLinkedList implements StringList {

	private StringNode head;
	private StringNode tail;

	private int size;

	public int add(String s) {
		StringNode newNode = new StringNode(s);
		if (head == null){
			head = newNode;
		} else if (tail != null) {
			tail.next = newNode;
		}
		tail = newNode;
		return size++;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (size ==0){
			return true;
		}
		return false;
		
	}

	public void clear() {
		size =0;
		head = null;
		tail = null;
	}

	public void set(int i, String s) {
		getNodeAt(i).value = s;
	}

	public String remove(int i) {
		checkBounds(i);
		if (i == 0) {
			String result = head.value;
			head = head.next;
			if(head == null){
				tail = null;
			}
			size--;
			return result;
		}else{
			StringNode before = getNodeAt(i-1);
			String result = before.next.value;
			if(before.next == tail){
				tail = before;
			}
			before.next = before.next.next;
			size--;
			return result;
		}
	}

	public int add(int i, String s) {
		checkBounds(i);
		if(i==0){
			head = new StringNode(s,head);
		} else {
			StringNode before = getNodeAt(i-1);
			StringNode inserted = new StringNode(s,before.next);
			before.next = inserted;
		}
		size++;
		return i;
	}

	public int indexOf(String s) {
		StringNode current = head;
		for (int i = 0; current != null; i++) {
			if ((current.value == null && s == null) || (current.value != null && current.value.equals(s))) {
				return i;
			} else {
				current = current.next;
			}
		}
		return -1;
	}
	
	private StringNode getNodeAt(int i){
		checkBounds(i);
		StringNode current = head;
		for(int k =0;k<i;k++){
			current = current.next;
		}
		return current;
	}

	private IndexOutOfBoundsException checkBounds(int i) {
		if(i>size){
			return new IndexOutOfBoundsException();
		}
		return null;
	}

	public String get(int i) {
		return getNodeAt(i).value;
	}

	public boolean contains(String s) {
		StringNode current = head;
		while (true){
			if(current.value.equals(s)){
				return true;
			} else{
				current = current.next;
			}
			return false;
		}
	}

	public String[] toArray() {
		String[] result = new String[size];
		StringNode current = head;
		for (int i = 0; current != null; i++) {
			result[i] = current.value;
			current = current.next;
		}
		return result;
	}

	public StringListIterator iterator() {
		return new StringLinkedListIterator();
	}

	private static void SOP(String s) {
		// Simple shortcut method; mostly because I like to abbreviate
		// System.out.println to SOP when I write on the board.
		System.out.println(s);
	}

	public void printList() {
		// you could use a method like this for debugging purposes.
		System.out.print("[");
		String separator = "";
		for (StringNode current = head; current != null; current = current.next) {
			System.out.print(separator);
			System.out.print("\"" + current.value + "\"");
			separator = " => ";
		}
		SOP("]\n");
		
	}
	
	

	private class StringLinkedListIterator implements StringListIterator {
		
		private StringNode current = head;
		
		public String next() {
			String result = current.value;
			current = current.next;
			return result;
		}

		public boolean hasNext() {
			return current!=null;
		}
	}

	

	private class StringNode {
		private String value;
		private StringNode next;

		public StringNode(String s, StringNode n) {
			this.value = s;
			this.next = n;
		}

		public StringNode(String s) {
			this(s, null);
		}
	}
	
	
}