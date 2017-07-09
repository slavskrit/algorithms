public class Solution {
    public String reverseVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        int left = 0;
        int right = s.length() - 1;
        char a[] = s.toCharArray();
        while (left < right) {
            if (!vowels.contains(a[left])) {
                left++;
            } else if (!vowels.contains(a[right])) {
                right--;
            } else if(vowels.contains(a[left]) && vowels.contains(a[right])) {
                char temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(a);
    }
}
