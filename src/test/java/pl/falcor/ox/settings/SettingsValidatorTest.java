package pl.falcor.ox.settings;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.*;

@Test
public class SettingsValidatorTest {

    public void shouldReturnRespectiveMessageWhileOptionBeyondListFirstChosenByUSer() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream("0\n2\n".getBytes());
        System.setOut(new PrintStream(outputStream));
        System.setIn(inputStream);
        SettingsReader settingsReader = new SettingsReader();
        Settings settings = new Settings(settingsReader.setLanguage());

        String language = settings.getGameLocale().getDisplayLanguage();
        String[] result = outputStream.toString().split("\n");

        assertEquals(language, "polski");
        assertEquals(result[result.length - 1], "Please chose option number from the list");
    }

    public void shouldReturnSpecificMessageAndPolishLanguageWhileTextInputFirstByUser() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream("some text\n2\n".getBytes());
        System.setOut(new PrintStream(outputStream));
        System.setIn(inputStream);
        SettingsReader settingsReader = new SettingsReader();
        Settings settings = new Settings(settingsReader.setLanguage());

        String language = settings.getGameLocale().getDisplayLanguage();
        String[] result = outputStream.toString().split("\n");

        assertEquals(language, "polski");
        assertEquals(result[result.length - 1], "Please provide a number.");
    }
}