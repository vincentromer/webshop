package se.iths.vincent.webshop;

import javax.swing.JOptionPane;

public class SwingOutInputHandler implements OutInputHandler {

    public String prompt(String message) {
        String input = JOptionPane.showInputDialog(JOptionPane.getRootFrame(), message, "Input", JOptionPane.QUESTION_MESSAGE);
        return input;
    }

    public void info(String message) {
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), message);
    }

    public String menu() {
        String choice = JOptionPane.showInputDialog("""
                1. Add a product
                2. List all products
                3. View information about a product
                4. Quit program""");
        return choice;
    }


}
