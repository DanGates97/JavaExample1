package com.pluralsight.coursecatalog.server;

import com.pluralsight.coursecatalog.repository.CourseRepository;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.bridge.SLF4JBridgeHandler;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Properties;
import java.util.logging.LogManager;

public class CourseServer {
    private static final Logger LOG = LoggerFactory.getLogger(CourseServer.class);
    private static final String BASE_URL = "http://localhost:8080/";

    public static void main(String... args) {
        LOG.info("Starting the HTTP server");
        CourseRepository courseRepository = CourseRepository.openCourseRepository("./courses.db");
        ResourceConfig config = new ResourceConfig().register(new CourseResources(courseRepository));

        GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URL), config);
    }
}
