import java.util.Scanner;

public class MorseCodeMain {
        public static void main(String[] args) {
            Scanner myScanner = new Scanner(System.in);

            String option;
            do {
                System.out.println("Pick an option:");
                System.out.println("1 - Text to morse");
                System.out.println("2 - Morse to text");
                System.out.println("0 - Exit program");
                System.out.print("Option: ");
                option = myScanner.nextLine();
                if ("1".equals(option)) {
                    System.out.println("Write your text or letter that needs translating to morse: ");
                    String text = myScanner.nextLine();

                    try {
                        String morse = Morsecode.textToMorse(text);
                        System.out.println("Morsecode: " + morse);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error, you've done something wrong! " + e.getMessage());
                    }
                } else if ("2".equals(option)) {
                    System.out.println("Type in your morse code to translate: ");
                    String morse = myScanner.nextLine();

                    try {
                        String text = Morsecode.morseToText(morse);
                        System.out.println("Text: " + text);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error, you've done something wrong! " + e.getMessage());
                    }
                } else if (!"0".equals(option)) {
                    System.out.println("That is not a valid option!");
                }
            } while(!"0".equals(option));

            System.out.println("Good bye, please come again!");
        }
    }
}
