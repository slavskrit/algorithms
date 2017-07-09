public class Solution {
    
    static class Interval {
        private int start;
        private int end;

        Interval (int start) {
            this.start = start;
            this.end = start;
        }

        public int getStart() {
            return this.start;
        }

        public int getEnd() {
            return this.end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public void setStart(int start) {
            this.start = start;
        }

    }
    
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;
        if (nums.length == 1) {
            result.add(String.valueOf(nums[0]));
            return result;
        }
        Interval interval = new Interval(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (interval.getEnd() == nums[i] - 1) {
                interval.setEnd(nums[i]);
            } else {
                if (interval.getEnd() == interval.getStart()) {
                    result.add(String.valueOf(interval.getEnd()));
                } else {
                    result.add(interval.getStart() + "->" + interval.getEnd());
                }
                interval.setStart(nums[i]);
                interval.setEnd(nums[i]);
            }
        }
        if (interval.getStart() == interval.getEnd()) {
            result.add(String.valueOf(interval.getEnd()));
        } else {
            result.add(interval.getStart() + "->" + interval.getEnd());
        }

        return result;
    }
}
