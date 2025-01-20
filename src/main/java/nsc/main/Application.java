package nsc.main;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import nsc.ui.ConversionPanel;
import nsc.ui.KeypadPanel;
import nsc.function.CalculatorFunction;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {
    private final CalculatorFunction calculatorFunction;

    public Application() {
        calculatorFunction = new CalculatorFunction();
        init();
    }

    private void init() {
        setTitle("Numeral System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(335, 550);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new MigLayout("insets 10, fill", "[grow]", "[][][grow][]"));
        mainPanel.setBackground(new Color(18, 18, 18));

        // Add components
        ConversionPanel conversionPanel = new ConversionPanel(calculatorFunction);
        KeypadPanel keypadPanel = new KeypadPanel(calculatorFunction, conversionPanel);

        mainPanel.add(conversionPanel, "growx");
        mainPanel.add(keypadPanel, "dock south");

        setContentPane(mainPanel);
    }

    public static void main(String[] args) {
        FlatMacDarkLaf.setup();

        UIManager.put("Button.arc", 20);
        UIManager.put("ComboBox.arc", 10);
        FlatLaf.registerCustomDefaultsSource("com.formdev.flatlaf.fonts.roboto");
        UIManager.put("defaultFont", new Font("Roboto", Font.PLAIN, 13));
        UIManager.put("ComboBox.selectionBackground", new Color(255, 140, 0));


        EventQueue.invokeLater(() -> new Application().setVisible(true));
    }
}
