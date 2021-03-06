## Short Project SP11: K Largest Elements and Enumeration 

1. Implementation of O(n) Select Algorithm to find K largest elements and 
   it's comparison with another Algorithm to find K largest elements using 
   Priority Queue (Min-Heap). 
2. Implementation of Enumeration algorithms - permutations(), combinations(), 
   heap(), and Knuth's Algorithm L.

#### Author
* [Rahul Nalawade](https://github.com/rahul1947)

#### Date
* Nov 18, 2018

_______________________________________________________________________________
### Problems:

#### A. Team Task - K Largest Elements Algorithms: 

**Problem 1.** 
   Implement the expected O(n) algorithm for the k largest elements (select) 
   of an array, and compare its performance with the algorithm using priority 
   queues that we designed for the same problem on streams.
   Use k = n/2 (median), and try large values of n: 16M, 32M, 64M, 128M, 256M.

**Solution:** [KLargest.java](https://github.com/rahul1947/SP11-Select-Algorithm-for-K-Largest-Elements/blob/master/KLargest.java) 

|  Algorithms  |  O(n) amort |    Select Algorithm |  O(n logk) |      Priority Queue | 
|-------------:|------------:|--------------------:|------------:|--------------------:| 
|      n       | Time (mSec) | Memory (used/avail) | Time (mSec) | Memory (used/avail) | 
|      1000000 |          27 |          5 / 117 MB |         252 |        125 / 208 MB | 
|      2000000 |          69 |          8 / 117 MB |         616 |        197 / 348 MB | 
|      4000000 |         207 |         16 / 117 MB |        1549 |        265 / 340 MB | 
|      8000000 |         521 |         31 / 117 MB |        3690 |        296 / 561 MB | 
|     16000000 |        1170 |        81 / 1963 MB |        8344 |      1144 / 1820 MB | 
|     32000000 |        2568 |       142 / 1963 MB |       21371 |       713 / 1820 MB | 
|     64000000 |        5604 |       274 / 2944 MB |       55206 |      1023 / 2731 MB | 
|    128000000 |       11304 |       519 / 2944 MB |      206062 |      1927 / 2731 MB | 
|    256000000 |       28174 |      1017 / 3925 MB |     1072895 |      3738 / 7851 MB | 

NOTE: 
- For n = 256M and Min-Heap Algorithm, numTrials had to be reduced to 3. 
  Else rest of the files could run for numTrial = 10 or more.
- Please see the results [sp11-script-results.txt](https://github.com/rahul1947/SP11-Select-Algorithm-for-K-Largest-Elements/blob/master/sp11-script-results.txt) for n = 1M - 256M comparing two algorithms:
  1. K Largest using **Select Algorithm with RT = O(n) amortized**
  2. K Largest using **Min-Heap with RT = O(n Log k)**
- Increasing numTrials, the precision of the results could be improved but it would take more
  resources as Time and Memory. 
- Existing Processor: **Intel® Core™ i5-8250U CPU @ 1.60GHz × 8**. 
  Memory: **7.5 GiB**
   
#### B. Optional Task (individual) - Enumeration: 

**Problem 2.** 
   Implement the following methods in Enumerate.java:
   
   - combine(): count/enumerate combinations.
   - heap(): Heap's algorithm for permutations.  

**Solution:** [Enumerate.java](https://github.com/rahul1947/SP11-Select-Algorithm-for-K-Largest-Elements/blob/master/Enumerate.java)

**Problem 3.**
   Implement Knuth's Algorithm L. 

**Solution:** [Enumerate.java](https://github.com/rahul1947/SP11-Select-Algorithm-for-K-Largest-Elements/blob/master/Enumerate.java)
