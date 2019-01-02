package rsn170330.sp11;

/**
 * CS 5V81.001: Implementation of Data Structures and Algorithms 
 * Short Project SP11: K Largest Elements Implementation
 * Team: SP11 33
 * @author Rahul Nalawade (rsn170330)
 * @author Pooja Srinivasan (pxs176230)
 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class SP11 {
	public static Random random = new Random();
	
	public static int numTrials = 100;
	public final static int T = 75;
	
	// ------------------------------- MAIN ----------------------------------
	public static void main(String[] args) {
		int Million = 1000000;
		
		int n = 1 * Million;
		int choice = 1 + random.nextInt(2);
		choice = 1;
		
		if (args.length > 0) { 
			n = Integer.parseInt(args[0]); 
		} 
		if (args.length > 1) { 
			choice = Integer.parseInt(args[1]);
		}
		int k = n / 2;
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i;
		}
		Timer timer = new Timer();
		switch (choice) {
		// K largest using Quick Select Algorithm
		case 1:
			for (int i = 0; i < numTrials; i++) {
				Shuffle.shuffle(arr);
				quickSelect(arr, k);
			}
			break;
			
		// K Largest using Min-Heap Algorithm 
		case 2:
			for (int i = 0; i < numTrials; i++) {
				Shuffle.shuffle(arr);
				findKLargestPQ(arr, k);	
			}
			break;
		}
		timer.end();
		timer.scale(numTrials);
		
		System.out.println("n: " + n);
		
		if (choice == 1) {
			System.out.println("Choice: " + choice + 
					": K Largest using quick select");	
		}
		else {
			System.out.println("Choice: " + choice + 
					": K Largest using min-heap");
		}
		System.out.println(timer);
	}
	
	// --------------------------- Quick Select ------------------------------
	/**
	 * Rearranges k largest elements in an array to the last.
	 * @param arr the input array
	 * @param k the 'k' elements.
	 */
	public static void quickSelect(int[] arr, int k) {
		select(arr, 0, arr.length - 1, k);
		
		// UNCOMMENT TO VERIFY OUTPUTS*
		// int[] result = new int[k]; 
		// int i = 0; while (i < k) 
		// { result[i] = arr[arr.length - 1 - i]; i++; } 
		// Arrays.sort(result);
		// System.out.println(Arrays.toString(result));
	}

	/**
	 * Recursive method to rearrange k elements in the input[low..high]
	 * @param input the input array
	 * @param low the starting index
	 * @param high the last index
	 * @param k the 'k' elements to be rearranged
	 * @return index from which to last contains the k largest element
	 */
	
	private static int select(int[] input, int low, int high, int k) {
		// total number of elements in array from index low to high
		int n = high - low + 1;
		
		if (n < T) {
			// for n less than threshold, performs insertionSort
			insertionSort(input, low, high) ;  
		}
		
		// NOTE: the snapshot of the array at some point:
		// [elements <= X] [X] [X < elements]
		// left: no of elements which are <= X
		// X: input[pivotIndex]
		// right: no of elements which are > X + pivot* 
		
		// Runs randomized partition algorithm and returns index of pivot 
		// around which array is to be partitioned
		int pivotIndex = randomizedPartition(input, low, high); 
		int right = high - pivotIndex + 1; // NOTE: + 1*
		
		// When pivotIndex partitioned exact k elements,
		if (right == k) { // same as right + 1 == k from notes
			return pivotIndex;
		}
		// When right < k, find (k - right) elements in left
		else if (right < k) { 
			// by changing high pointer and updated k value
			return select(input, low, pivotIndex - 1, k - right);
		}
		// When k < right
		else { // same as right >= k from notes
			// update low <- (pivotIndex + 1) and call select in right side
			return select(input, pivotIndex + 1, high, k);
		}
	}

	/**
	 * Selects an index (pivot) uniformly in [low..high].
	 * @param arr the input array
	 * @param low indicates startIndex of array for the search
	 * @param high indicates startIndex of array for the search
	 * @return index of element around which array is partitioned
	 */
	private static int randomizedPartition(int[] arr, int low, int high) {
		
		int n = high - low + 1; // total elements
		
		// picks random index between [0 to n-1] and adds to low
		int randomIndex = low + random.nextInt(n); 
		
		swap(arr, randomIndex, high); // swaps with high
		
		// partition array with high value as pivot
		int partitionIndex = partition(arr, low, high); 
		
		// returns its correct index in partitioned array
		return partitionIndex;
	}

	private static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	/**
	 * Partitions a part of an array arr[low...high] 
	 * around the pivot = arr[high]
	 * 
	 * @param arr the input array
	 * @param low the start index
	 * @param high the end index
	 * @return pivot index around which array is partitioned
	 */
	private static int partition(int[] arr, int low, int high) {
		
		int marker = low - 1;  
		int pivot = arr[high];
		int currPtr = low;
		
		// LI: arr[low...marker] ≤ pivot, 
		// arr[(marker + 1)...(currPtr − 1)] > pivot,
		// arr[currPtr...(high - 1)] is unprocessed, arr[high] = x.
		while (currPtr < high) {
			if (arr[currPtr] <= pivot) {
				marker++;
				swap(arr, marker, currPtr);
			}
			currPtr++;
		}
		// Bringing pivot back to the middle
		swap(arr, marker, high);
		// arr[low...marker] ≤ pivot, arr[marker + 1] = pivot, 
		// arr[marker + 2...high] > pivot
		return marker + 1;
	}

	// from class notes:
	public static void insertionSort(int[] arr) {
		insertionSort(arr, 0, arr.length - 1);
	}
	
	// Helper Insertion Sort: sorts an array arr[p...r]
	private static void insertionSort(int[] arr, int p, int r) {
		
		for (int i = p + 1; i <= r; i++) {
			int key = arr[i];
			
			int j = i - 1; 
			// Find place for arr[i] in sorted subarray arr[p...i-1].
			while (j >= p && key < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}
	
	// ----------------------------- Min Heap --------------------------------
	/**
	 * Rearranges an array to place K largest elements in the end.
	 * @param arr the input array
	 * @param k the 'k' elements
	 */
	public static void findKLargestPQ(int[] arr, int k) {

		// pq: minHeap to keep track of k largest elements
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int i = 0;
		// adding first k elements in our minHeap
		while (i < k) {
			pq.add(arr[i++]);
		}

		i = k;
		// Now, for each new element X = arr[i]:
		while (i < arr.length) {
			int x = arr[i++];
			// when X > the smallest element in our priority queue
			if (pq.peek().compareTo(x) < 0) {
				pq.remove(); // remove the smallest element
				pq.add(x); // add x
			}
		}
		
		// UNCOMMENT TO VERIFY RESULTS*
		// int[] result = new int[k];
		
		// i = 0; while (i < k) { result[i++] = pq.poll(); }
		// System.out.println(Arrays.toString(result));
	}

	/**
	 * Timer class for roughly calculating running time of programs
	 * @author rbk 
	 * Usage: Timer timer = new Timer(); timer.start(); timer.end();
	 * System.out.println(timer); // output statistics
	 */
	public static class Timer {
		long startTime, endTime, elapsedTime, memAvailable, memUsed;
		boolean ready;

		public Timer() {
			startTime = System.currentTimeMillis();
			ready = false;
		}

		public void start() {
			startTime = System.currentTimeMillis();
			ready = false;
		}

		public Timer end() {
			endTime = System.currentTimeMillis();
			elapsedTime = endTime - startTime;
			memAvailable = Runtime.getRuntime().totalMemory();
			memUsed = memAvailable - Runtime.getRuntime().freeMemory();
			ready = true;
			return this;
		}

		public long duration() {
			if (!ready) {
				end();
			}
			return elapsedTime;
		}

		public long memory() {
			if (!ready) {
				end();
			}
			return memUsed;
		}

		public void scale(int num) {
			elapsedTime /= num;
		}

		public String toString() {
			if (!ready) {
				end();
			}
			return "Time: " + elapsedTime + " msec.\n" + "Memory: " + 
			(memUsed / 1048576)+ " MB / " + (memAvailable / 1048576) + " MB.";
		}
	}

	/**
	 * Shuffle the elements of an array arr[from..to] randomly
	 * @author rbk : based on algorithm described in a book
	 */
	public static class Shuffle {

		public static void shuffle(int[] arr) {
			shuffle(arr, 0, arr.length - 1);
		}

		public static <T> void shuffle(T[] arr) {
			shuffle(arr, 0, arr.length - 1);
		}

		public static void shuffle(int[] arr, int from, int to) {
			int n = to - from + 1;
			for (int i = 1; i < n; i++) {
				int j = random.nextInt(i);
				swap(arr, i + from, j + from);
			}
		}

		public static <T> void shuffle(T[] arr, int from, int to) {
			int n = to - from + 1;
			Random random = new Random();
			for (int i = 1; i < n; i++) {
				int j = random.nextInt(i);
				swap(arr, i + from, j + from);
			}
		}

		static void swap(int[] arr, int x, int y) {
			int tmp = arr[x];
			arr[x] = arr[y];
			arr[y] = tmp;
		}

		static <T> void swap(T[] arr, int x, int y) {
			T tmp = arr[x];
			arr[x] = arr[y];
			arr[y] = tmp;
		}

		public static <T> void printArray(T[] arr, String message) {
			printArray(arr, 0, arr.length - 1, message);
		}

		public static <T> void printArray(T[] arr, int from, int to, String message) {
			System.out.print(message);
			for (int i = from; i <= to; i++) {
				System.out.print(" " + arr[i]);
			}
			System.out.println();
		}
	}
}