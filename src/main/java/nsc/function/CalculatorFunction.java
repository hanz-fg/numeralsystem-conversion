package nsc.function;

import nsc.conversion.Conversion;

public class CalculatorFunction {
    private final StringBuilder input = new StringBuilder();
    private String fromSystem = "Decimal DEC";
    private String toSystem = "Hexadecimal HEX";

    public void setFromSystem(String system) {
        this.fromSystem = system;
    }

    public void setToSystem(String system) {
        this.toSystem = system;
    }

    public void addInput(String value) {
        input.append(value);
    }

    public void backspace() {
        if (input.length() > 0) {
            input.deleteCharAt(input.length() - 1);
        }
    }

    public void clear() {
        input.setLength(0);
    }

    public String getInputValue() {
        return input.length() == 0 ? "0" : input.toString();
    }

    public String getConvertedValue() {
        if (input.length() == 0) {
            return "0";
        }
        return Conversion.convert(input.toString(), fromSystem, toSystem);
    }
}
