package org.example.intervals

//You are given an array of non-overlapping intervals where intervals[i] = [starti, endi] represent the start and the
// end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval
// newInterval = [start, end] that represents the start and end of another interval.
//
//Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals
// still does not have any overlapping intervals (merge overlapping intervals if necessary).
//
//Return intervals after the insertion.
//
//Note that you don't need to modify intervals in-place. You can make a new array and return it.
//
//
//
//Example 1:
//
//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//Output: [[1,5],[6,9]]
//Example 2:
//
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//Output: [[1,2],[3,10],[12,16]]
//Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

fun insertInterval(intervals: Array<Interval>, newInterval: Interval): List<Interval> {
    val result = mutableListOf<Interval>()
    var start = newInterval.start
    var end = newInterval.end
    var i = 0

    // Add intervals completely before the new interval
    while (i < intervals.size && intervals[i].end < start) {
        result.add(intervals[i++])
    }

    // Merge overlapping intervals
    while (i < intervals.size && intervals[i].start <= end) {
        start = minOf(intervals[i].start, start)
        end = maxOf(intervals[i++].end, end)
    }

    // Add merged interval
    result.add(Interval(start, end))

    // Add remaining intervals
    while (i < intervals.size) {
        result.add(intervals[i++])
    }

    return result
}

fun main() {
//    val intervals1 = arrayOf(Interval(1,3),Interval(6,9))
//    val newInterval1 = Interval(2,5)
//    println(insertInterval(intervals1, newInterval1)) //[{1,5}, {6,9}]

    val intervals2 = arrayOf(Interval(1,2),Interval(3,5),Interval(6,7), Interval(8,10), Interval(12,16))
    val newInterval2 = Interval(4,8)
    println(insertInterval(intervals2, newInterval2)) //[{1,2}, {3,10}, {12,16}]
}
