public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] bucketSecret = new int[10];
        int[] bucketGuess = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                bucketSecret[secret.charAt(i) - '0']++;
                bucketGuess[guess.charAt(i) - '0']++;

            }
        }
        for (int i = 0; i < bucketGuess.length; i++) {
            if (bucketGuess[i] != 0 && bucketSecret[i] != 0) {
                cows += Math.min(bucketGuess[i], bucketSecret[i]);
            }
        }
        return bulls + "A" + cows + "B";
    }
}
