# Short Project SP11: Select Algorithm for K Largest Elements

1. Implementation of O(n) Select Algorithm to find K largest elements and 
   compare it's performance with an Algorithm to find K largest elements using 
   Priority Queue. 
2. Implementation of Enumeration algorithms - permutations(), combinations(), 
   heap(), and Knuth's Algorithm L.

### Author
* [Rahul Nalawade](https://github.com/rahul1947)

### Date
* Nov 8-18, 2018

_______________________________________________________________________________
## Problems:

#### Team Task - Divide and Conquer: 

**Problem 1.** 
   Implement the expected O(n) algorithm for the k largest elements (select) 
   of an array, and compare its performance with the algorithm using priority 
   queues that we designed for the same problem on streams.
   Use k = n/2 (median), and try large values of n: 16M, 32M, 64M, 128M, 256M.

**Solution:** [KLargest.java](https://github.com/rahul1947/SP11-Select-Algorithm-for-K-Largest-Elements/blob/master/KLargest.java)   
Please see the results for n = 1M - 256M comparing two algorithms -
1. K Largest using Select Algorithm with RT: O(n) amortized
2. K Largest using Min-Heap with RT: O(n Log k)

in the file sp11-script-results.txt

NOTE: 
- For n = 256M and Min-Heap Algorithm, numTrials had to be reduced to 3. 
  Else rest of the files could run for numTrial = 10 or more.
- Increasing numTrials, the result could be improvised but it would take more
  resources as Time and Memory. 
- Existing Processor: Intel® Core™ i5-8250U CPU @ 1.60GHz × 8. 
  Memory: 7.5 GiB
   
#### Optional Task (individual) - Enumeration: 

**Problem 2.** 
   Implement the following methods in Enumerate.java:
   
   combine(): count/enumerate combinations.
   heap(): Heap's algorithm for permutations.  

**Solution:** [Enumerate.java](https://github.com/rahul1947/SP11-Select-Algorithm-for-K-Largest-Elements/blob/master/Enumerate.java)

**Problem 3.**
   Implement Knuth's Algorithm L. 

**Solution:** [Enumerate.java](https://github.com/rahul1947/SP11-Select-Algorithm-for-K-Largest-Elements/blob/master/Enumerate.java)
