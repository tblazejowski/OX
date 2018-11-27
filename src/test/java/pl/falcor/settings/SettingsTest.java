package pl.falcor.settings;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class SettingsTest {

    public void shouldReturnDefaultLanguageOfGameSettings(){

        Settings settings = new Settings();

        String language = settings.getaLocale().getDisplayLanguage();

        assertEquals(language, "English");
    }
}