package ds.heap;

import sorting.Utils;

/**
 * Creating Max Heap
 * @since 04/08/20
 */

public class Heap {
	private int capacity = 2;
	private int size = 0;
	private int[] arr = new int[capacity];
	
	public void insert(int data) {
		
		if(isFull()) resize();
		
		arr[this.size] = data;		//Insert at the end
		size++;
		
		percolateUp(this.size-1);
		
		Utils.printMsg("Heap (Inserted - " + data + ") :");
		Utils.printArray(this.arr, 0, this.size-1);
	}
	
	public void percolateUp(int index) {
		
		int data = this.arr[index]; //Data to percolate up.
		int parentIndex = (index-1)/2;
		
		while(index > 0 && this.arr[parentIndex] < this.arr[index]) {
			this.arr[index] = this.arr[parentIndex];
			index = parentIndex;
		}
		
		this.arr[index] = data;
	}
	
	public boolean isFull() { return this.size == this.capacity; }
	
	public void resize() {
		capacity = capacity<<1;
		int[] newArr = new int[capacity];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		arr = newArr;
	}
}
