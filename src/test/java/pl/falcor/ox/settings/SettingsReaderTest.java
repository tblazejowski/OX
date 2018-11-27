package pl.falcor.ox.settings;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.assertEquals;

@Test
public class SettingsReaderTest {

    public void shouldReturnEnglishLanguageSettingOfTheGameAsChosenByUser(){

        ByteArrayInputStream inputStream = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(inputStream);
        SettingsReader settingsReader = new SettingsReader();
        Settings settings = new Settings(settingsReader.setLanguage());

        String language = settings.getGameLocale().getDisplayLanguage();

        assertEquals(language, "English");
    }

    public void shouldReturnPolishLanguageSettingOfTheGameAsChosenByUser(){

        ByteArrayInputStream inputStream = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(inputStream);
        SettingsReader settingsReader = new SettingsReader();
        Settings settings = new Settings(settingsReader.setLanguage());

        String language = settings.getGameLocale().getDisplayLanguage();

        assertEquals(language, "polski");
    }
}