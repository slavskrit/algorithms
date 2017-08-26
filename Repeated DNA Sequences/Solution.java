// https://leetcode.com/problems/repeated-dna-sequences
// 
// 
// All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
// Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
// 
// For example,
// 
// Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
// 
// Return:
// ["AAAAACCCCC", "CCCCCAAAAA"].
// 
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> toResult = new HashSet<>();
        int left = 0;
        int right = 10;
        while (right <= s.length()) {
            String t = s.substring(left, right);
            if (!set.add(t)) {
                toResult.add(t);
            }
            left++;
            right++;
        }
        return new ArrayList<>(toResult);
    }
}
