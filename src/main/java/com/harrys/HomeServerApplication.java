package com.harrys;

import com.harrys.health.SimpleHealthCheck;
import com.harrys.resources.AdminResource;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import io.swagger.config.ConfigFactory;
import io.swagger.config.ScannerFactory;
import io.swagger.config.SwaggerConfig;
import io.swagger.jaxrs.config.DefaultJaxrsScanner;
import io.swagger.jersey.listing.ApiListingResourceJSON;
import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import org.eclipse.jetty.servlets.CrossOriginFilter;

public class HomeServerApplication extends Application<HomeServerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HomeServerApplication().run(args);
    }

    @Override
    public String getName() {
        return "homeServer";
    }

    @Override
    public void initialize(final Bootstrap<HomeServerConfiguration> bootstrap) {
        bootstrap.addBundle(new HomeServerSwaggerBundle());
    }

    @Override
    public void run(final HomeServerConfiguration configuration, final Environment environment) {
        environment.healthChecks().register("healthCheck", new SimpleHealthCheck());
        environment.jersey().register(AdminResource.class);
    }
}
