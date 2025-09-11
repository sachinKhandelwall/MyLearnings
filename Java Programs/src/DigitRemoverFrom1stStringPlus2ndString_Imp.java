
public class DigitRemoverFrom1stStringPlus2ndString_Imp {
    public static boolean sumIfTrue(String first, String second, String third) {
    	
        int num2 = Integer.parseInt(second);
        int target = Integer.parseInt(third);

        // Check without removing any digit
        try {
            int originalNum1 = Integer.parseInt(first);
            if (originalNum1 + num2 == target) {
                System.out.println("No digit needs to be removed from first string.");
                return true;
            }
        } catch (NumberFormatException e) {
            // Skip if first is invalid number
        }

        // Try removing each digit one at a time
        for (int i = 0; i < first.length(); i++) {
            StringBuilder modified = new StringBuilder(first);
            modified.deleteCharAt(i);

            // Skip if empty or invalid (e.g., leading 0 like "0123")
            if (modified.length() == 0 || (modified.charAt(0) == '0' && modified.length() > 1)) {
                continue;
            }

            try {
                int num1 = Integer.parseInt(modified.toString());
                if (num1 + num2 == target) {
                    System.out.println("Remove digit at index " + i + " ('" + first.charAt(i) + "') from first string.");
                    return true;
                }
            } catch (NumberFormatException e) {
                // Skip invalid parse
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Example 1: Remove a digit
        boolean result1 = sumIfTrue("10585", "45", "1100");
        System.out.println("Result: " + result1); // true

        // Example 2: No removal needed
        boolean result2 = sumIfTrue("1055", "45", "1100");
        System.out.println("Result: " + result2); // true

        // Example 3: Not possible
        boolean result3 = sumIfTrue("10585", "45", "2000");
        System.out.println("Result: " + result3); // false
    }
}