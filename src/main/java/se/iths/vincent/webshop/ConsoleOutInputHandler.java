package se.iths.vincent.webshop;

public class ConsoleOutInputHandler implements OutInputHandler {


    public String prompt(String message) {
        String input = IO.readln(message);
        return input;
    }

    public void info(String message) {
        IO.println(message);
    }


    public String menu() {
        String choice = IO.readln("""
                1. Add a product
                2. List all products
                3. View information about a product
                4. Quit program
                Choice?
                """);
        return choice;
    }

}
