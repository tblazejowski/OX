package pl.falcor.ox.settings;

import org.testng.annotations.Test;
import pl.falcor.ox.domain.BoardDimension;
import pl.falcor.ox.domain.Player;
import pl.falcor.ox.domain.Sign;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

import static org.testng.Assert.assertEquals;

@Test
public class SettingsReaderTest {

    public void shouldReturnEnglishLanguageSettingOfTheGameAsChosenByUser() {

        ByteArrayInputStream inputStream = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(inputStream);
        SettingsReader settingsReader = new SettingsReader();

        Locale.setDefault(settingsReader.setLanguage());
        String language = Locale.getDefault().getDisplayLanguage();

        assertEquals(language, "English");
    }

    public void shouldReturnPolishLanguageSettingOfTheGameAsChosenByUser() {

        ByteArrayInputStream inputStream = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(inputStream);
        SettingsReader settingsReader = new SettingsReader();

        Locale.setDefault(settingsReader.setLanguage());
        String language = Locale.getDefault().getDisplayLanguage();

        assertEquals(language, "polski");
    }

    public void shouldReturnSpecificMessageWhileOptionBeyondListFirstChosenByUSer() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream("0\n2\n".getBytes());
        System.setOut(new PrintStream(outputStream));
        System.setIn(inputStream);
        SettingsReader settingsReader = new SettingsReader();

        String language = settingsReader.setLanguage().getDisplayLanguage();
        String[] result = outputStream.toString().split("\n");

        assertEquals(language, "polski");
        assertEquals(result[result.length - 1], "Please chose option number from the list");
    }

    public void shouldReturnSpecificMessageWhileTextInputFirstByUser() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream("some text\n2\n".getBytes());
        System.setOut(new PrintStream(outputStream));
        System.setIn(inputStream);
        SettingsReader settingsReader = new SettingsReader();

        String language = settingsReader.setLanguage().getDisplayLanguage();
        String[] result = outputStream.toString().split("\n");

        assertEquals(language, "polski");
        assertEquals(result[result.length - 1], "Please provide a number.");
    }

    public void shouldReturnMatchingPlayersNameAfterBeingSetByUser() {

        ByteArrayInputStream inputStream = new ByteArrayInputStream("Johnny\nSara\n".getBytes());
        System.setIn(inputStream);
        SettingsReader settingsReader = new SettingsReader();

        String[] playerNames = settingsReader.setPlayerNames();

        assertEquals(playerNames[0], "Johnny");
        assertEquals(playerNames[1], "Sara");
    }

    public void shouldReturnArrayOfPlayerNamesWithFirstNameChosenToStartGame() {

        ByteArrayInputStream inputStream = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(inputStream);
        SettingsReader settingsReader = new SettingsReader();
        String[] playerNames = new String[]{"Johnny", "Sara"};

        settingsReader.requestWhoStarts(playerNames);

        assertEquals(playerNames[0], "Sara");
    }

    public void shouldReturnLastOptionIndicatedByUserAsPreviousBeyondSet() {

        ByteArrayInputStream inputStream = new ByteArrayInputStream("3\n0\n2\n".getBytes());
        System.setIn(inputStream);
        SettingsReader settingsReader = new SettingsReader();

        int chosenOption = settingsReader.validateOptionChosen(2);

        assertEquals(chosenOption, 2);
    }

    public void shouldReturnPlayersArrayWithFirstPlayerHavingIndicatedSignSet() {

        ByteArrayInputStream inputStream = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(inputStream);
        SettingsReader settingsReader = new SettingsReader();
        String[] playerNames = new String[]{"Johnny", "Sara"};

        Player[] players = settingsReader.requestStartingSign(playerNames);

        assertEquals(players[0].getSign(), Sign.O);
    }

    public void shouldReturnDimensionChosenByUser() {

        ByteArrayInputStream inputStream = new ByteArrayInputStream("9\n".getBytes());
        System.setIn(inputStream);
        SettingsReader settingsReader = new SettingsReader();

        BoardDimension boardDimension = settingsReader.requestBoardDimension();

        assertEquals(boardDimension.getBoardDimension(), 9);
    }

    public void shouldReturnRequestForPlayersNameInChosenPolishLanguage() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream("2\nStaś\nGrażyna\n".getBytes());
        System.setOut(new PrintStream(outputStream));
        System.setIn(inputStream);
        SettingsReader settingsReader = new SettingsReader();

        Locale.setDefault(settingsReader.setLanguage());
        settingsReader.setPlayerNames();
        String[] result = outputStream.toString().split("\n");

        assertEquals(result[result.length - 1], "Please provide a number.");
    }
}