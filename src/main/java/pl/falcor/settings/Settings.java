package pl.falcor.settings;

import java.util.Locale;

public class Settings {

    private final Locale aLocale;

    public Settings() {
        aLocale = new Locale("en", "US");
        Locale.setDefault(aLocale);
    }

    public Locale getaLocale() {
        return aLocale;
    }
}