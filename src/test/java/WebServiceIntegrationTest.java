import com.fasterxml.jackson.databind.util.ClassUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ClassUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import static com.fasterxml.jackson.databind.util.ClassUtil.getPackageName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.platform.commons.util.ClassUtils.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WebServiceIntegrationTest {

    private Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

    @LocalServerPort
    private int port = 0;

    @BeforeEach
    public void init()  throws Exception{
        marshaller.setPackagesToScan(ClassUtils.getPackageName(GetCountryRequest.class));
        marshaller.afterPropertiesSet();
    }

    @Test
    public void testSendAndReceive(){
        WebServiceTemplate ws = new WebServiceTemplate(marshaller);
        GetCountryRequest request = new GetCountryRequest();
        request.setName("Spain");

        assertThat(ws.marshalSendAndReceive("http://localhost:" + port + "/ws", request) != null);
    }
}
