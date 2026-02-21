import java.util.Scanner;

public class MorseCodeMain {

    public static void main(String[] args) {
// För att ta in input så skapar vi en Scanner.
        Scanner myScanner = new Scanner(System.in);
// Stringvariabel kallad option
        String option;

// En do-loop för att hantera de olika valen. Gör detta, annars detta osv.
// Do-whileloop. Gör detta medans nedan val är korrekta.
        do {
            System.out.println("Pick an option:");
            System.out.println("1 - Text to morse");
            System.out.println("2 - Morse to text");
            System.out.println("0 - Exit program");
            System.out.print("Option: ");
// Vi sparar nästa inputsträng i variabeln option, som vi skapat.
            option = myScanner.nextLine();
// Om valet är 1, så visa nedan text och sen sparar vi nästa inputsträng i variabeln text.
            if ("1".equals(option)) {
                System.out.println("Write your text or letter that needs translating to morse: ");
                String text = myScanner.nextLine();
// Try/catch för att hantera de fel som kan komma ifall användaren skriver nått fel.
                try {
                    String morse = Morsecode.textToMorse(text);
                    System.out.println("Morsecode: " + morse);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error, you've done something wrong! " + e.getMessage());
                }
// Om användaren väljer 2, så uppmanas användaren skriva in morsekoden för att översättas.
            } else if ("2".equals(option)) {
                System.out.println("Type in your morse code to translate: ");
// Vi sparar nästa inputsträng i en ny Stringvariabel morse.
                String morse = myScanner.nextLine();
// Try/catch för att hantera de fel som kan komma ifall användaren skriver nått fel.
                try {
                    String text = Morsecode.morseToText(morse);
                    System.out.println("Text: " + text);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error, you've done something wrong! " + e.getMessage());
                }
// Om användaren väljer annat än de valen som presenteras så visas nedan "felmeddelande"
            } else if (!"0".equals(option)) {
                System.out.println("That is not a valid option!");
            }
        }
// Om användaren skriver 0 så avslutas programmet och vi skriver ut ett hejdå-meddelande.
        while (!"0".equals(option)) ;
        System.out.println("Good bye, please come again!");
    }
}