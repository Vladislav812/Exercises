package Leetcode;

public record BullsAndCows_299() {
    public static void main(String[] args) {
        //String secret = "1807", guess = "7810";
        //String secret = "1123", guess = "0111";
        String secret = "11", guess = "11";
        System.out.println(getHint(secret, guess));
    }

    public static String getHint(String secret, String guess) {
        StringBuilder secretSB = new StringBuilder(secret);
        StringBuilder guessSB = new StringBuilder(guess);
        int bulls = 0;
        for (int i = 0; i < secretSB.length(); i++) {
            if (secretSB.charAt(i) == guessSB.charAt(i)) {
                bulls++;
                secretSB.deleteCharAt(i);
                guessSB.deleteCharAt(i);
                i--;
            }
        }

        int cows = 0;
        for (int i = 0; i < guessSB.length(); i++) {
            for (int j = 0; j < secretSB.length(); j++) {
                if (guessSB.charAt(i) == secretSB.charAt(j)) {
                    cows++;
                    secretSB.deleteCharAt(j);
                    break;
                }
            }
        }
        return bulls + "A" + cows + "B";
    }
}
