package webservices;

import org.hibernate.validator.constraints.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CountryRepo {
    private static final Map<String, Countries> countries = new HashMap<>();

    @PostConstruct
    public void inData(){

        Country england = new Countries();
        england.setName("England");
        england.setCapital("London");
        england.setCaurrency(Currency.GBP);
        englnad.setPopulation(50932786);

        countries.put(england.getName(),england);


        Country japan = new Countries();
        japan.setName("Japan");
        japan.setCapital("Tokyo");
        japan.setCurrency(Currency.JPY);
        japan.setPopulation(708932145);

        countries.put(japan.getName(),japan);

        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(458789312);

        countries.put(spain.getName(), spain);
    }

    public Countries findCountries(String name){
        Assert.notNull(name,"Country Name Should Not be Null");
        return countries.get(name);
    }
    public Countries getCurrency(String currency){
        Assert.notNull(currency,"Currency Should Not Be Null");
        return countries.get(currency);
    }
}
