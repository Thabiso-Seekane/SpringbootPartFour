package webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndPoint {
    private static final String URI = "http://spring.io/guides/gs-producing-web-service";

    private CountryRepo countryRepo;

    @Autowired
    public void CountryEndpoint(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    @PayloadRoot(namespace = URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountriesResponse getCountries(@RequestPayload GetCountriesRequest request) {
        GetCountriesResponse response = new GetCountriesResponse();
        response.setCountries(countriesRepository.findCountry(request.getName()));

        return response;
    }
}
