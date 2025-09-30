__Assignment 1 Report__
__Learning Goals__

- Implement classic divide-and-conquer algorithms.

- Use safe recursion patterns to control stack depth.

- Apply Master Theorem and Akra–Bazzi for recurrence analysis.

- Collect metrics (execution time, recursion depth, number of comparisons/allocations) and compare theoretical results with practical measurements.

__Graphic__
![Graph] (images/Graph.png)

__Algorithms__
1. __MergeSort (D&C, Master Case 2)__

- Uses linear merging of two sorted subarrays.

- Employs a reusable buffer to avoid repeated allocations.

- Applies a cut-off for small subarrays (Insertion Sort for ≤16 elements).

__Analysis:__

- Recurrence: T(n) = 2T(n/2) + Θ(n).

- By Master Theorem, Case 2: T(n) = Θ(n log n).

- Recursion depth: O(log n).

- In practice, the cut-off reduces constant factors for small input sizes.

2. __QuickSort (robust)__

- Pivot is chosen randomly to avoid worst-case behavior.

- Recursion proceeds on the smaller partition; iteration is used for the larger one (tail recursion optimization).

- This ensures bounded stack depth of O(log n).

__Analysis:__

- Expected recurrence: T(n) = T(k) + T(n-k-1) + Θ(n), where k is random.

- Average case: T(n) = Θ(n log n).

- Worst case (unlucky pivots): O(n²), but randomization makes this unlikely.

- Recursion depth: at most 2·⌊log₂n⌋ + O(1).

3. __Deterministic Select (Median-of-Medians)__

- Array is divided into groups of 5.

- Medians of these groups are computed, and the median of medians is used as pivot.

- Partitioning is done in-place.

- Recursion continues only into the relevant side, always preferring the smaller part.

__Analysis:__

- Recurrence: T(n) = T(n/5) + T(7n/10) + Θ(n).

- By Akra–Bazzi: T(n) = Θ(n).

- Guarantees linear runtime in all cases, unlike randomized QuickSelect.

4. __Closest Pair of Points (2D)__

- Points are sorted by x-coordinate.

- Recursive division into halves.

- A strip of width 2δ around the dividing line is checked, sorted by y.

- For each point, only 7–8 neighbors need to be examined.

__Analysis:__

- Recurrence: T(n) = 2T(n/2) + Θ(n).

- By Master Theorem, Case 2: T(n) = Θ(n log n).

- In practice, efficient y-sorting makes the strip check fast.

__Metrics__
__Collected data__

- Execution time (milliseconds).

- Maximum recursion depth.

- Number of comparisons.

- Number of memory allocations.

__Observations__

- MergeSort has more stable performance across inputs than QuickSort.

- QuickSort is typically faster due to better cache locality and fewer copies.

- Deterministic Select is slower in practice than randomized QuickSelect, but provides worst-case O(n).

- Closest Pair algorithm matches the predicted n log n growth.

__Plots__

1. Time vs n: growth aligns with theory (MergeSort/QuickSort ~ n log n, Select ~ n).

2. Depth vs n: MergeSort depth ~ log n, QuickSort depth ~ 2 log n.

3. Comparisons/allocations: QuickSort performs fewer allocations; MergeSort relies on buffer use.

__Summary__

- Theoretical analysis using Master Theorem and Akra–Bazzi matches empirical results.

- Minor deviations explained by cache effects, allocation costs, and garbage collection.

- MergeSort is stable and predictable.

- QuickSort is fast in practice but relies on randomization.

- Deterministic Select is essential when guaranteed O(n) is required.

- Closest Pair of Points illustrates divide-and-conquer efficiency in geometry.

