package similarity;

public class WordSimilarity {
	
    public static boolean isSimilar(String s, String s2){
        if (Math.abs(s.length() - s2.length()) > 1 ) {
            return false;
        }
        return compute(s, s2) == 1;
    }

    public static int compute(String stringOne, String stringTwo) {
        stringOne = stringOne.toLowerCase();
        stringTwo = stringTwo.toLowerCase();
        int[] costs = new int[stringTwo.length() + 1];
        for (int i = 0; i <= stringOne.length(); i++) {
            int lastValue = i;
            for (int j = 0; j <= stringTwo.length(); j++) {
                if (i == 0)
                    costs[j] = j;
                else {
                    if (j > 0) {
                        int newValue = costs[j - 1];
                        if (stringOne.charAt(i - 1) != stringTwo.charAt(j - 1))
                            newValue = Math.min(Math.min(newValue, lastValue),
                                    costs[j]) + 1;
                        costs[j - 1] = lastValue;
                        lastValue = newValue;
                    }
                }
            }
            if (i > 0)
                costs[stringTwo.length()] = lastValue;
        }
        return costs[stringTwo.length()];
    }
}

