package sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class TestMessageSender {
    @Test
    public void testSenderRu() {
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("172.12.96.15")).thenReturn(new Location(null, Country.RUSSIA, null, 0));

        LocalizationServiceImpl localService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.12.96.15");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localService);

        Assertions.assertEquals("Добро пожаловать", messageSender.send(headers));
    }
    @Test
    public void testSenderUSA() {
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("96.96.135.138")).thenReturn(new Location("Texas", Country.USA, null, 0));

        LocalizationServiceImpl localService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localService.locale(Country.USA)).thenReturn("Welcome");

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.96.135.138");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localService);

        Assertions.assertEquals("Welcome", messageSender.send(headers));
    }
}
