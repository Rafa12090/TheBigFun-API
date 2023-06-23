package com.crackelets.bigfun.platform.step;

import com.crackelets.bigfun.platform.profile.resource.CreateOrganizerResource;
import com.crackelets.bigfun.platform.profile.resource.OrganizerResource;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

@CucumberContextConfiguration

//para indicar que se trata de una prueba de integración con Spring Boot.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

//para utilizar el perfil de prueba.
@ActiveProfiles("test")

public class OrganizerStepDefinitions {

    @Autowired
    private final TestRestTemplate testRestTemplate = new TestRestTemplate();

    @LocalServerPort
    private int randomServerPort;
    private String endpointPath;
    private ResponseEntity<String> responseEntity;
    private List<OrganizerResource> organizerResources = new ArrayList<OrganizerResource>();



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


    @Then("A Response is received with Status {int}")
    public void aResponseIsReceivedWithStatus(int expectedStatus) {
        int actualStatus = responseEntity.getStatusCodeValue();
        assertEquals(expectedStatus, actualStatus);
    }

    @And("An Organizer Resource is included in Response Body, with values  {string}, {string}, {string}")
    public void anOrganizerResourceIsIncludedInResponseBodyWithValues(String name, String userName, String email) {

        String responseBody = responseEntity.getBody();

        assertNotNull(responseBody);

        Gson gson = new Gson();
        OrganizerResource organizerResource = gson.fromJson(responseBody, OrganizerResource.class);

        // Verificar los valores del organizador con los valores esperados
        assertEquals(name, organizerResource.getName());
        assertEquals(userName, organizerResource.getUserName());
        assertEquals(email, organizerResource.getEmail());

    }


    @Given("An Organizer Resource with values {string}, {string}, {string} is already stored")
    public void anOrganizerResourceWithValuesIsAlreadyStored(String name, String userName, String email) {

        OrganizerResource organizer = new OrganizerResource()
                .withName(name)
                .withUserName(userName)
                .withEmail(email);
        organizerResources.add(organizer);
    }


    @And("A Message is included in Response Body, with value {string}")
    public void aMessageIsIncludedInResponseBodyWithValue(String expectedMessage) {
        String responseBody = responseEntity.getBody();
        Assert.assertNotNull(responseBody);
        Assert.assertTrue(responseBody.contains(expectedMessage));
    }
}