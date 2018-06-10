package com.harrys;

import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public final class HomeServerSwaggerBundle extends SwaggerBundle<Configuration> {
    @Override
    protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(Configuration unused) {
        SwaggerBundleConfiguration swaggerConfig = new SwaggerBundleConfiguration();
        swaggerConfig.setTitle("Home server");
        swaggerConfig.setResourcePackage("com.harrys.resources");
        swaggerConfig.setSchemes(new String[]{});
        swaggerConfig.setDescription("A home server built for fun");
        return swaggerConfig;
    }
}