public class StringHashSet {
  
  private static final int DEFAULT_CAPACITY = 23;
  private static final double LOAD_FACTOR = 0.5;
  private Node[] table;
  private int size = 0;
  
  public StringHashSet() {
    table = new Node[DEFAULT_CAPACITY];
  }
  
  public StringHashSet(int initialCapacity) {
    table = new Node[initialCapacity];
  }
  
  public int size() {
    return size;
  }
  
  public StringIterator iterator() {
    return new HashIterator();
  }
  
  private class HashIterator implements StringIterator {
    //
    //TODO your goal is to implement this StringIterator.  It should return values from the table.
    //
	int index = 0;
	Node current = null;
	
    public void advance() {
    	while(index<table.length && table[index]==null){
    		index++;
    	}
    	if(index < table.length){
    		current = table[index];
    		index++;
    	}
    }
    public String next(){
    	if(current!=null){
    		String result = current.value;
    		current = current.next;
    		return result;
    	} else {
    		advance();
    	}
		return null;
    }
    
    public boolean hasNext() {
    	return index < table.length ||current!=null;
    }
    

  }
  
  public boolean contains(String value) {
    int position = getPosition(value);
    Node current = table[position];
    while (current != null) {
      int c = value.compareTo(current.value);
      if (c == 0) {
        return true;
      } else if (c < 0) {
        // if value is less than the current node, we've moved past where it should be.
        break;
      }
      current = current.next;
    }
    return false;
  }
  
  public String remove(String value) {
    int position = getPosition(value);
    Node current = table[position];
    int c = value.compareTo(table[position].value);
    if (c == 0) {
      String result = table[position].value;
      table[position] = table[position].next;
      size--;
      return result;
    } else if (c > 0) {
      while (current.hasNext()) {
        c = value.compareTo(current.next.value);
        if (c < 0) {
          // if value is less than the current node, we've moved past where it should be.
          break;
        } else if (c == 0) {
          String result = current.next.value;
          current.next = current.next.next;
          size--;
          return result;
        }
        current = current.next;
      }
    }
    return null;
  }

  public void add(String value) {
    if (size > table.length * LOAD_FACTOR) {
      // if we have more things here than the LOAD_FACTOR allows, let's rehash everything.
      rehash();
    }
    int position = getPosition(value);
    if (table[position] == null) {
      // if nothing is there, put this there.
      table[position] = new Node(value);
      size++;
    } else {
      int c = value.compareTo(table[position].value);
      if (c < 0) {
        // it's smaller than the first thing; insert before table[position]
        table[position] = new Node(value, table[position]);
        size++;
      } else if (c == 0) {
        table[position].value = value;
      } else {
        // we know that the node in the first position is greater than value.
        Node current = table[position];
        while (current.hasNext()) {
          c = value.compareTo(current.next.value);
          if (c < 0) {
            break;
          } else if (c == 0) {
            current.next.value = value;
            return;
          }
          current = current.next;
        }
        // insert between table[position] and next
        // => NOTE: if current is the end of the chain, this still works.  Make sure you know why.
        current.next = new Node(value, current.next);
        size++;
      }
    }
  }
  
  private int getPosition(String value) {
    return Math.abs(value.hashCode()) % table.length;
  }
  
  private void rehash() {
    // create a new array, and re-add everything from the old array.
    Node[] temp = table;
    table = new Node[table.length * 2 + 1];
    size = 0;
    for (int i = 0; i < temp.length; i++) {
      Node current = temp[i];
      while (current != null) {
        this.add(current.value);
        current = current.next;
      }
    }
  }
  
  private class Node {
    Node next;
    String value;
    
    public Node(String value) {
      this.value = value;
    }
    
    public Node(String value, Node next) {
      this(value);
      this.next = next;
    }
    
    public boolean hasNext() {
      return next != null;
    }
  }
}