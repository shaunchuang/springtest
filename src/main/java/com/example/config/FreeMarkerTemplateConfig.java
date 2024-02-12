package com.example.config;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

@Configuration
public class FreeMarkerTemplateConfig {
    private static final Logger logger = LoggerFactory.getLogger(FreeMarkerTemplateConfig.class);

    @Autowired
    public void configureFreeMarkerConfigurer(FreeMarkerConfigurer configurer){

        logger.info("Configuring FreeMarker template loader");
        TemplateLoader loader1 = new ClassTemplateLoader(getClass(), "/templates/");
        TemplateLoader loader2 = new ClassTemplateLoader(getClass(), "/freemarker/");

        MultiTemplateLoader multiTemplateLoader = new MultiTemplateLoader(new TemplateLoader[] { loader1, loader2 } );

        configurer.getConfiguration().setTemplateLoader(multiTemplateLoader);
    }
}
