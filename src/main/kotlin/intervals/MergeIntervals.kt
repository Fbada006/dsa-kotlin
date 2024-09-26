package org.example.intervals

// Given a list of intervals, merge all the overlapping intervals and return a list of non-overlapping intervals
// Example given [{2,6},{1,3},{8,10}] then return [{1,6},{8,10}]

data class Interval(val start: Int, val end: Int) {
    override fun toString(): String {
        return "{$start,$end}"
    }
}

fun merge(intervals: List<Interval>): List<Interval> {
    // Zero or 1 elements means there is no work to be done
    if (intervals.size < 2) return intervals
    val sortedIntervals = intervals.sortedBy { it.start }

    val mergedIntervals = mutableListOf<Interval>()
    val firstInterval = sortedIntervals.first()
    var start = firstInterval.start
    var end = firstInterval.end

    sortedIntervals.forEach {current ->
        // Check if this interval's start is overlapping with the previous interval's end
        if (current.start <= end) {
            // This means there are overlapping intervals so we need to adjust the end
            end = maxOf(current.end, end)
        } else {
            // The current start and end here represent the merged interval
            mergedIntervals.add(Interval(start, end))
            // Move start and end to the next gap/interval
            start = current.start
            end = current.end
        }
    }
    // Once we break out of the loop, we need to add the interval held by start and end
    mergedIntervals.add(Interval(start, end))

    return mergedIntervals
}

fun main() {
    val intervals = listOf(Interval(2, 6), Interval(1, 3), Interval(8, 10), Interval(9, 12))
    println(merge(intervals)) // [{1,6}, {8,12}]
}
