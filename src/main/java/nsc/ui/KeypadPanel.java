package nsc.ui;

import nsc.function.CalculatorFunction;
import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeypadPanel extends JPanel {
    public KeypadPanel(CalculatorFunction calculatorFunction, ConversionPanel conversionPanel) {
        setLayout(new MigLayout("wrap 4, gap 9, insets 9", "[grow,fill][grow,fill][grow,fill][grow,fill]"));
        setOpaque(false);

        String[][] buttons = {
                {"c", "⌫", "F", "E"},
                {"7", "8", "9", "D"},
                {"4", "5", "6", "C"},
                {"1", "2", "3", "B"},
                {"00", "0", ".", "A"}
        };

        Dimension buttonSize = new Dimension(71, 60);

        for (String[] row : buttons) {
            for (String label : row) {
                JButton btn = new JButton(label);
                btn.setFont(new Font("Roboto", Font.PLAIN, 16));

                if (label.equals("c") || label.equals("⌫")) {
                    btn.setForeground(new Color(255, 140, 0));
                } else {
                    btn.setForeground(Color.WHITE);
                }

                btn.setMinimumSize(buttonSize);
                btn.setMaximumSize(buttonSize);

                btn.setPreferredSize(buttonSize);
                btn.addActionListener(new ButtonClickListener(label, calculatorFunction, conversionPanel));
                add(btn);
            }
        }
    }

    private static class ButtonClickListener implements ActionListener {
        private final String label;
        private final CalculatorFunction calculatorFunction;
        private final ConversionPanel conversionPanel;

        public ButtonClickListener(String label, CalculatorFunction calculatorFunction, ConversionPanel conversionPanel) {
            this.label = label;
            this.calculatorFunction = calculatorFunction;
            this.conversionPanel = conversionPanel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (label) {
                case "c":
                    calculatorFunction.clear();
                    break;
                case "⌫":
                    calculatorFunction.backspace();
                    break;
                case ".":
                    break;
                default:
                    calculatorFunction.addInput(label);
                    break;
            }
            conversionPanel.updateDisplay(calculatorFunction);
        }
    }
}
