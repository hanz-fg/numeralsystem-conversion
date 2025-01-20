package nsc.conversion;

public class Conversion {

    public static String convert(String input, String fromSystem, String toSystem) {
        try {
            int decimal = convertToDecimal(input, fromSystem);

            return convertFromDecimal(decimal, toSystem);
        } catch (NumberFormatException e) {
            return "Error";
        }
    }

    private static int convertToDecimal(String input, String fromSystem) {
        switch (fromSystem.split(" ")[0]) {
            case "Binary":
                return Integer.parseInt(input, 2);
            case "Octal":
                return Integer.parseInt(input, 8);
            case "Hexadecimal":
                return Integer.parseInt(input, 16);
            default: // Decimal
                return Integer.parseInt(input, 10);
        }
    }

    private static String convertFromDecimal(int decimal, String toSystem) {
        switch (toSystem.split(" ")[0]) {
            case "Binary":
                return Integer.toBinaryString(decimal);
            case "Octal":
                return Integer.toOctalString(decimal);
            case "Hexadecimal":
                return Integer.toHexString(decimal).toUpperCase();
            default: // Decimal
                return String.valueOf(decimal);
        }
    }
}
