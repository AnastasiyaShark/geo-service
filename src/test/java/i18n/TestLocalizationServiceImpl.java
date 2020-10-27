package i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import ru.netology.i18n.LocalizationServiceImpl;

public class TestLocalizationServiceImpl {
    private static LocalizationServiceImpl localizationService = null;

    @BeforeEach
    public void tearUp () {
        System.out.println("BeforeAll tearUp() method called");
        localizationService = new LocalizationServiceImpl();
    }
    @Test
    public void testLocale_Russia (){
        final Country country = Country.RUSSIA;

        String actualGreetings = localizationService.locale(country);

        final String expectedGreetings = "Добро пожаловать";

        Assertions.assertEquals(expectedGreetings,actualGreetings);

    }

    @Test
    public void testLocale_USA (){
        final Country country = Country.USA;

        String actualGreetings = localizationService.locale(country);

        final String expectedGreetings = "Welcome";

        Assertions.assertEquals(expectedGreetings,actualGreetings);

    }


    @Test
    public void testLocale_Germany (){
        final Country country = Country.GERMANY;

        String actualGreetings = localizationService.locale(country);

        final String expectedGreetings = "Welcome";

        Assertions.assertEquals(expectedGreetings,actualGreetings);

    }


}
