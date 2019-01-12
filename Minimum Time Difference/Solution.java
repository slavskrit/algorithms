// https://leetcode.com/problems/minimum-time-difference/
// 
// Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
// Example 1:
// Input: ["23:59","00:00"]
// Output: 1
// Note:
// The number of time points in the given list is at least 2 and won't exceed 20000.
// The input time is legal and ranges from 00:00 to 23:59.
class Solution {
    public int findMinDifference(List<String> timePoints) {
		List<Integer> times = new ArrayList<>();
		for (String time : timePoints) {
			times.add(toInt(time));
		}
		Collections.sort(times);
		int result = Integer.MAX_VALUE;
		for (int i = 1; i < times.size(); i++) {
			result = Math.min(times.get(i) - times.get(i - 1), result);
		}
		return Math.min(result, times.get(0) + (1440 - times.get(times.size() - 1)));
	}

	private int toInt(String time) {
		return ((time.charAt(0) - '0')* 10 + (time.charAt(1) - '0')) * 60 + (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
	}
}
