package by.darozhka.ReslivTelegramBot.controller.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class SpringWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();

        applicationContext.register(ControllerConfig.class);

        ServletRegistration.Dynamic dispatcher = servletContext
                .addServlet("SpringDispatcher", new DispatcherServlet(applicationContext));

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        FilterRegistration.Dynamic filterRegistration = servletContext
                .addFilter("encodingFilter", CharacterEncodingFilter.class);

        filterRegistration.setInitParameter("encoding", "UTF-8");
        filterRegistration.setInitParameter("forseEncoding", "true");
        filterRegistration.addMappingForUrlPatterns(null, true, "/*");
    }
}
