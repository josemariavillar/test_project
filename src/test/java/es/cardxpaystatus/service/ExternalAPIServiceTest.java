package es.cardxpaystatus.service;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.HttpClientErrorException;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.okJson;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.status;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ExternalAPIServiceTest {


    @Rule
    public WireMockRule solicitudes = new WireMockRule(8082);

    private String urlBase;

    private String endpoint;

    private String endpointGet;

    private String endpointQuery;

    private String doPostResponse = "";


    @Before
    public void setup() {

        urlBase = "http://localhost:8082";
        endpoint = "/path";

        endpointGet = "/path/{id}";
        endpointQuery = "/path";

    }

    @Test(expected = HttpClientErrorException.class)
    public void doPostErrorTest() {
        stubFor(post(endpoint).willReturn(status(400)));
    }

    @Test
    public void doGetTest() {
        stubFor(get("/path/F128166009").willReturn(okJson(doPostResponse)));
    }
}
