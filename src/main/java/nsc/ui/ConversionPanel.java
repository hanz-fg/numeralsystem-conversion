package nsc.ui;

import nsc.function.CalculatorFunction;
import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.*;

public class ConversionPanel extends JPanel {
    private final JLabel decValue;
    private final JLabel hexValue;

    public ConversionPanel(CalculatorFunction calculatorFunction) {
        setLayout(new MigLayout("fillx, wrap 2", "[][grow]", "[][]"));
        setOpaque(false);

        String[] numberSystems = {"Decimal DEC", "Binary BIN", "Octal OCT", "Hexadecimal HEX"};
        JComboBox<String> fromSystem = new JComboBox<>(numberSystems);
        JComboBox<String> toSystem = new JComboBox<>(numberSystems);
        toSystem.setSelectedItem("Hexadecimal HEX");

        fromSystem.addActionListener(e -> {
            calculatorFunction.setFromSystem((String) fromSystem.getSelectedItem());
            updateDisplay(calculatorFunction);
        });

        toSystem.addActionListener(e -> {
            calculatorFunction.setToSystem((String) toSystem.getSelectedItem());
            updateDisplay(calculatorFunction);
        });

        decValue = new JLabel("0");
        hexValue = new JLabel("0");

        decValue.setForeground(Color.WHITE);
        hexValue.setForeground(new Color(255, 140, 0));

        add(fromSystem, "growx");
        add(decValue, "right, wrap");
        add(toSystem, "growx");
        add(hexValue, "right");
    }

    public void updateDisplay(CalculatorFunction calculatorFunction) {
        decValue.setText(calculatorFunction.getInputValue());
        hexValue.setText(calculatorFunction.getConvertedValue());
    }
}
