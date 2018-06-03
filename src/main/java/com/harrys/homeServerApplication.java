package com.harrys;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class homeServerApplication extends Application<homeServerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new homeServerApplication().run(args);
    }

    @Override
    public String getName() {
        return "homeServer";
    }

    @Override
    public void initialize(final Bootstrap<homeServerConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final homeServerConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
