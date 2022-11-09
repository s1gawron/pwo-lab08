import pwo.lab08.engine.Engine;
import pwo.seq.SeqType;
import pwo.utils.SequenceTools;

import javax.swing.*;
import java.awt.*;

public class Lab08Gui extends JFrame {

    private static final String APP_NAME = "Lab08 GUI Application ";

    private static final int DEFAULT_WIDTH = 800;

    private static final int DEFAULT_HEIGHT = 600;

    public static void main(String[] args) {
        final Lab08Gui gui = new Lab08Gui();

        gui.init();
        gui.start();
    }

    private void init() {
        setTitle(APP_NAME + Engine.getVersion());
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final GridLayout layout = new GridLayout(9, 2);

        setLayout(layout);

        final JTextField fromField = buildField();
        final JTextField resultField = buildField();
        final JTextField toField = buildField();

        final String[] types = {
            "fib",
            "luc",
            "tri"
        };
        final JComboBox<String> comboBox = new JComboBox<>(types);
        ((JLabel) comboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        final JButton button = new JButton();
        button.setText("Calculate:");
        button.setBackground(Color.RED);
        button.setOpaque(true);
        button.addActionListener(e -> {
            final SeqType type = SeqType.fromString((String) comboBox.getSelectedItem());
            final int from = Integer.parseInt(fromField.getText());
            final int to = Integer.parseInt(toField.getText());
            final String result = SequenceTools.getTermsAsColumn(type.getGenerator(), from, to);

            resultField.setText(result);
        });

        add(buildLabel("From:"));
        add(fromField);
        add(buildLabel("To:"));
        add(toField);
        add(buildLabel("Type:"));
        add(comboBox);
        add(button);
        add(buildLabel("Result:"));
        add(resultField);
    }

    private JTextField buildField() {
        final JTextField textField = new JTextField();

        textField.setSize(100, 60);
        textField.setHorizontalAlignment(SwingConstants.CENTER);

        return textField;
    }

    private JLabel buildLabel(String text) {
        final JLabel label = new JLabel();

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setText(text);
        label.setSize(100, 60);

        return label;
    }

    private void start() {
        setVisible(true);
    }
}
