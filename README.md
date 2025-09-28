Assignment 1 Report
Learning Goals

Implement classic divide-and-conquer algorithms.

Use safe recursion patterns to control stack depth.

Apply Master Theorem and Akra–Bazzi for recurrence analysis.

Collect metrics (execution time, recursion depth, number of comparisons/allocations) and compare theoretical results with practical measurements.

Algorithms
1. MergeSort (D&C, Master Case 2)

Uses linear merging of two sorted subarrays.

Employs a reusable buffer to avoid repeated allocations.

Applies a cut-off for small subarrays (Insertion Sort for ≤16 elements).

Analysis:

Recurrence: T(n) = 2T(n/2) + Θ(n).

By Master Theorem, Case 2: T(n) = Θ(n log n).

Recursion depth: O(log n).

In practice, the cut-off reduces constant factors for small input sizes.

2. QuickSort (robust)

Pivot is chosen randomly to avoid worst-case behavior.

Recursion proceeds on the smaller partition; iteration is used for the larger one (tail recursion optimization).

This ensures bounded stack depth of O(log n).

Analysis:

Expected recurrence: T(n) = T(k) + T(n-k-1) + Θ(n), where k is random.

Average case: T(n) = Θ(n log n).

Worst case (unlucky pivots): O(n²), but randomization makes this unlikely.

Recursion depth: at most 2·⌊log₂n⌋ + O(1).

3. Deterministic Select (Median-of-Medians)

Array is divided into groups of 5.

Medians of these groups are computed, and the median of medians is used as pivot.

Partitioning is done in-place.

Recursion continues only into the relevant side, always preferring the smaller part.

Analysis:

Recurrence: T(n) = T(n/5) + T(7n/10) + Θ(n).

By Akra–Bazzi: T(n) = Θ(n).

Guarantees linear runtime in all cases, unlike randomized QuickSelect.

4. Closest Pair of Points (2D)

Points are sorted by x-coordinate.

Recursive division into halves.

A strip of width 2δ around the dividing line is checked, sorted by y.

For each point, only 7–8 neighbors need to be examined.

Analysis:

Recurrence: T(n) = 2T(n/2) + Θ(n).

By Master Theorem, Case 2: T(n) = Θ(n log n).

In practice, efficient y-sorting makes the strip check fast.

Metrics
Collected data

Execution time (milliseconds).

Maximum recursion depth.

Number of comparisons.

Number of memory allocations.

Observations

MergeSort has more stable performance across inputs than QuickSort.

QuickSort is typically faster due to better cache locality and fewer copies.

Deterministic Select is slower in practice than randomized QuickSelect, but provides worst-case O(n).

Closest Pair algorithm matches the predicted n log n growth.

Plots

Time vs n: growth aligns with theory (MergeSort/QuickSort ~ n log n, Select ~ n).

Depth vs n: MergeSort depth ~ log n, QuickSort depth ~ 2 log n.

Comparisons/allocations: QuickSort performs fewer allocations; MergeSort relies on buffer use.

Summary

Theoretical analysis using Master Theorem and Akra–Bazzi matches empirical results.

Minor deviations explained by cache effects, allocation costs, and garbage collection.

MergeSort is stable and predictable.

QuickSort is fast in practice but relies on randomization.

Deterministic Select is essential when guaranteed O(n) is required.

Closest Pair of Points illustrates divide-and-conquer efficiency in geometry.

