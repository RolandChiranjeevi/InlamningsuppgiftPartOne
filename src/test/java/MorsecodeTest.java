import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MorsecodeTest {
    @Test
    public void englishToMorse_Test() {
        Assertions.assertEquals(".-", Morsecode.textToMorse("A"));
        Assertions.assertEquals("--..", Morsecode.textToMorse("Z"));
        Assertions.assertEquals("...", Morsecode.textToMorse("S"));
        Assertions.assertEquals(".", Morsecode.textToMorse("E"));
        Assertions.assertEquals("... --- ...", Morsecode.textToMorse("SOS"));
        Assertions.assertEquals(".... . .-.. .-.. ---", Morsecode.textToMorse("HELLO"));
        Assertions.assertEquals(".... . .-.. .-.. --- / .-- --- .-. .-.. -..", Morsecode.textToMorse("HELLO WORLD"));
    }

    @Test
    public void showError_Test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Morsecode.textToMorse("HEJ!"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Morsecode.textToMorse((String)null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Morsecode.textToMorse(""));
    }

    @Test
    public void morseToText_Test() {
        Assertions.assertEquals("A", Morsecode.morseToText(".-"));
        Assertions.assertEquals("SOS", Morsecode.morseToText("... --- ..."));
        Assertions.assertEquals("HELLO", Morsecode.morseToText(".... . .-.. .-.. ---"));
    }

    @Test
    public void morseToText_throwsOnInvalidToken() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Morsecode.morseToText("... --- ..-.-"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Morsecode.morseToText((String)null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Morsecode.morseToText(""));
    }
}