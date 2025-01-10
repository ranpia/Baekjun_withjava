package q10828ver2;

import java.util.Vector;

public class myStack {
	private Vector<Integer> list = new Vector<Integer>();
	
	public void push(Integer insert) {
		list.add(insert);
	}

	public int pop() {
		if (list.size()>0)
			return list.remove(list.size()-1);
		else
			return -1;
	}
	
	public int size() {
		return list.size();
	}
	
	public int isEmpty() {
		if (list.isEmpty()==true)
			return 1;
		else
			return 0;
	}
	
	public int top() {
		if (list.size()>0)
			return list.lastElement();
		else
			return -1;
	}

}
