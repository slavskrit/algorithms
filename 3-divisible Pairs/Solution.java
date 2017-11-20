// https://csacademy.com/contest/interview-archive/task/3-divisible-pairs/statement/
// 
// You are given an array of NN positive integers. Compute the number of pairs of integers in the array that have the sum divisible by 33.
// 
// Standard input
// The first line contains one integer NN.
// 
// The second line contains NN integers representing the elements of the array.
// 
// Standard output
// Output a single number representing the number of pairs that have the sum divisible by 33.
// 
// Input	Output
// 5
// 1 4 2 3 3
// 3
// 4
// 3 3 3 6
// 6
// 8
// 1 1 7 2 11 3 6 9 
// 9
// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int values = scan.nextInt();
        long result = 0;
        int[] helper = new int[3];
        while (values-- > 0) {
            int i = scan.nextInt();
            int m = i % 3;
            result += helper[(3 - m) % 3];
            helper[m]++;
        }
        System.out.println(result);
    }
}
