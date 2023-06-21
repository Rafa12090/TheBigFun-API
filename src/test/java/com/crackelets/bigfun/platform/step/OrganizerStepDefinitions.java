package com.crackelets.bigfun.platform.step;

import com.crackelets.bigfun.platform.profile.resource.CreateOrganizerResource;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@CucumberContextConfiguration
public class OrganizerStepDefinitions {

    private final TestRestTemplate testRestTemplate = new TestRestTemplate();

    @LocalServerPort
    private int randomServerPort;
    private String endpointPath;
    private ResponseEntity<String> responseEntity;

    @Given("The Endpoint {string} is available")
    public void theEndpointIsAvailable(String endpointPath) {
        this.endpointPath = String.format(endpointPath, randomServerPort);
    }

    @When("A Post Request is sent with values {string}, {string}, {string}")
    public void aPostRequestIsSentWithValues(String name, String userName, String email) {
        CreateOrganizerResource resource = new CreateOrganizerResource()
                .withName(name)
                .withUserName(userName)
                .withEmail(email);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CreateOrganizerResource> request = new HttpEntity<>(resource, headers);
        responseEntity = testRestTemplate.postForEntity(endpointPath, request, String.class);
    }
}
