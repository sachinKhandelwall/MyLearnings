
public class InterleaveCharacters_Imp {

    public static String interleaveChars(String[] strings) {
        if (strings == null || strings.length == 0) return "";

        // Step 1: Find the longest string length
        int maxLength = 0;
        for (String s : strings) {
            maxLength = Math.max(maxLength, s.length());
        }

        // Step 2: Build result character by character
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < maxLength; i++) {
            for (String s : strings) {
                if (i < s.length()) {
                    result.append(s.charAt(i));  // Add character only if it exists
                }
            }
        }

        return result.toString();
    }

    // Example usage
    public static void main(String[] args) {
        String[] input = {"abc", "de", "fghi"};
        String output = interleaveChars(input);
        System.out.println(output);  // Output: adfbegchi
    }
}