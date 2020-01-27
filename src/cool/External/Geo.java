package cool.External;

import java.util.Optional;

import com.github.tornaia.geoip;

public class Geo {
    public static void main(String[] args) {
        Optional<String> optionalCountryName = geoIP.getCountryName("50.63.202.32");
    }
}