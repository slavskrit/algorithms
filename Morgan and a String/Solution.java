// https://www.hackerrank.com/challenges/morgan-and-a-string
// 
// Jack and Daniel are friends. Both of them like letters, especially upper-case ones. 
// They are cutting upper-case letters from newspapers, and each one of them has their collection of letters stored in separate stacks. 
// One beautiful day, Morgan visited Jack and Daniel. He saw their collections. Morgan wondered what is the lexicographically minimal string, made of that two collections. He can take a letter from a collection when it is on the top of the stack. 
// Also, Morgan wants to use all the letters in the boys' collections.
// 
// Input Format
// 
// The first line contains the number of test cases, . 
// Every next two lines have such format: the first line contains string , and the second line contains string .
// 
// 
// Output the lexicographically minimal string  for each test case in new line.
// Sample Input
// 
// 2
// JACK
// DANIEL
// ABACABA
// ABACABA
// Sample Output
// 
// DAJACKNIEL
// AABABACABACABA
// Explanation
// 
// The first letters to choose from were J and D since they were at the top of the stack. D was chosen, the options then were J and A. A chosen. Then the two stacks have J and N, so J is chosen. (Current string is DAJ) Continuing this way till the end gives us the resulting string.
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String morganAndString(String aa, String bb) {
        StringBuilder sb = new StringBuilder();
        char[] a = aa.toCharArray();
        char[] b = bb.toCharArray();
        int f = 0;
        int s = 0;
        while (f < a.length || s < b.length) {
            char ac = f >= a.length ? 'Z' + 1 : a[f];
            char fc = s >= b.length ? 'Z' + 1 : b[s];
            if (ac == fc) {
                int tf = f;
                int ts = s;
                while (tf < a.length && ts < b.length && a[tf] == b[ts]) {
                    if (a[tf] > a[f]) {
                        while (f < tf) sb.append(a[f++]);
                        while (s < ts) sb.append(a[s++]);
                        f = tf;
                        s = ts;
                    }
                    tf++;
                    ts++;
                }
                if (ts == b.length) {
                    sb.append(a[f]);
                    f++;
                } else if (tf == a.length) {
                    sb.append(b[s]);
                    s++;
                } else {
                    if (a[tf] < b[ts]) {
                        sb.append(a[f]);
                        f++;
                    } else {
                        sb.append(b[s]);
                        s++;
                    }
                }
            } else {
                if (ac < fc) {
                    sb.append(ac);
                    f++;
                } else {
                    sb.append(fc);
                    s++;
                }
            }
        }
        return sb.toString();
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String a = in.next();
            String b = in.next();
            String result = morganAndString(a, b);
            System.out.println(result);
        }
        in.close();
    }
}
