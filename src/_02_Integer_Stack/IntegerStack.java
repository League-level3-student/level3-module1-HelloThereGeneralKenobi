package _02_Integer_Stack;

import java.sql.Array;
import java.util.ArrayList;

public class IntegerStack {
	//1. create a private array of integers
	private int[] intArray = new int[0];
	//2. complete the constructor by initializing the member array
	//   to a new array of length 0. This prevents null pointer exceptions.
	
	
	public IntegerStack() {
	}
	
	//3. Complete the steps in the push method.
	public void push(int v) {
		//A. create a new array that is one element larger than the member array
		int[] newArray = new int[intArray.length + 1];
		//B. set the last element of the new array equal to the integer passed into the method
		newArray[intArray.length + 1] = v;
		//C. iterate through the member array and copy all the elements into the new array
		for(int i = 0; i < intArray.length; i++) {
			newArray[i] = intArray[i];
		}
		//D. set the member array equal to the new array.
		intArray = newArray;
	}
	
	//4. Complete the steps in the pop method.
	public int pop() {
		//A. create an integer variable and initialize it to the
		//   last element of the member array.
		int lastNum = intArray[intArray.length];
		//B. create a new array that is one element smaller than the member array
		int[] smallArray = new int[intArray.length - 1];
		//C. iterate through the new array and copy every element from the
		//   member array to the new array
		for(int n = 0; n < intArray.length; n++) {
			smallArray[n] = intArray[n];
		}
		//D. set the member array equal to the new array
		intArray = smallArray;
		//E. return the variable you created in step A
		return lastNum;
	}
	
	//5. Complete the clear method to set the
	//   member array to a new array of length 0
	public void clear() {
		int[] intArray = new int[0];
	}
	
	//6. Complete the size method to return 
	//   the length of the member array
	public int size() {
		return intArray.length;
	}
}
