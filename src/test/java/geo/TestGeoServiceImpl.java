package geo;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;


public class TestGeoServiceImpl {
    private static GeoServiceImpl geoService = null;

    @BeforeEach
    public void tearUp (){
        System.out.println("BeforeAll tearUp() method called");
        geoService = new GeoServiceImpl();
    }

    @Test
    public void testByIp_LOCALHOST (){
        final String ip = GeoServiceImpl.LOCALHOST;

        final Location expectedlocation = new Location(null, null, null, 0);

        Location actualLocation = geoService.byIp(ip);

        Assertions.assertEquals(expectedlocation.getCountry(),actualLocation.getCountry());

    }

    @Test
    public void testByIp_MOSCOW_IP (){
        final String ip = GeoServiceImpl.MOSCOW_IP;

        final Location expectedlocation = new Location("Moscow", Country.RUSSIA, "Lenina", 15);

        Location actualLocation = geoService.byIp(ip);

        Assertions.assertEquals(expectedlocation.getCountry(),actualLocation.getCountry());

    }

    @Test
    public void testByIp_Russian_IP (){
        final String ip = "172.50.100.56";

        final Location expectedlocation = new Location("Moscow", Country.RUSSIA, "Lenina", 15);

        Location actualLocation = geoService.byIp(ip);

        Assertions.assertEquals(expectedlocation.getCountry(),actualLocation.getCountry());

    }

    @Test
    public void testByIp_USA_IP (){
        final String ip = "96.44.183.149";

        final Location expectedlocation = new Location(null, Country.USA, null, 15);

        Location actualLocation = geoService.byIp(ip);

        Assertions.assertEquals(expectedlocation.getCountry(),actualLocation.getCountry());

    }


}
