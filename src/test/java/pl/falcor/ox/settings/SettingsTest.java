package pl.falcor.ox.settings;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class SettingsTest {

    public void shouldReturnDefaultLanguageOfGameSettings(){

        Settings settings = new Settings();

        String language = settings.getGameLocale().getDisplayLanguage();

        assertEquals(language, "English");
    }
}