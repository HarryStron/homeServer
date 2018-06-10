package com.harrys.resources;

import io.dropwizard.testing.junit.ResourceTestRule;
import javax.ws.rs.client.WebTarget;
import org.assertj.core.api.Assertions;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class AdminResourceTest {
    private WebTarget target;

    @Rule
    public final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new AdminResource())
            .addProvider(MultiPartFeature.class)
            .build();

    @Before
    public void setup() {
        target = resources.client().target("/adminTools").path("echo");
    }

    @Test
    public void canGetBackEchoedString() {
        Assertions.assertThat(target.queryParam("echo", "test echo").request().get().readEntity(String.class))
                .isEqualTo("test echo");
    }
}
