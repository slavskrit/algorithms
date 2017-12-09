// https://leetcode.com/problems/minimum-genetic-mutation
// 
// A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".
// 
// Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.
// 
// For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
// 
// Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.
// 
// Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.
// 
// Note:
// 
// Starting point is assumed to be valid, so it might not be included in the bank.
// If multiple mutations are needed, all mutations during in the sequence must be valid.
// You may assume start and end string is not the same.
// Example 1:
// 
// start: "AACCGGTT"
// end:   "AACCGGTA"
// bank: ["AACCGGTA"]
// 
// return: 1
// Example 2:
// 
// start: "AACCGGTT"
// end:   "AAACGGTA"
// bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
// 
// return: 2
// Example 3:
// 
// start: "AAAAACCC"
// end:   "AACCCCCC"
// bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
// 
// return: 3
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> all = new HashSet<>();
        all.addAll(Arrays.asList(bank));
        int result = 1;
        Set<String> parced = new HashSet<>();
        all.remove(start);
        parced.add(start);
        while (!all.isEmpty() && result <= bank.length) {
            Set<String> t = new HashSet<>();
            for (String gene : parced) {
                for (int i = 0; i < 8; i++) {
                    char[] array = gene.toCharArray();
                    for (char c : new char[] {'A', 'C', 'G', 'T'}) {
                        array[i] = c;
                        String temp = new String(array);
                        if (all.contains(temp)) {
                            if (end.equals(temp)) {
                                return result;
                            }
                            t.add(temp);
                            all.remove(temp);
                        }
                    }
                }
            }
            result++;
            parced.addAll(t);
        }
        return -1;
    }
}
