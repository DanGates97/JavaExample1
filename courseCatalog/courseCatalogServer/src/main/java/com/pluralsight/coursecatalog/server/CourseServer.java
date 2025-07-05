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
//import java.util.logging.LogManager;

public class CourseServer {

    // Ensure calls to j.u.logging API are redirected to SLF4J.
    //static {
    //    LogManager.getLogManager().reset();
    //    SLF4JBridgeHandler.install();
    //}

    private static final Logger LOG = LoggerFactory.getLogger(CourseServer.class);
    private static final String BASE_URL = "http://localhost:4000/";

    public static void main(String... args) {
        String databaseFilename = loadDatabaseFilename();
        LOG.info("Starting the HTTP server with database {}", databaseFilename);
        CourseRepository courseRepository = CourseRepository.openCourseRepository(databaseFilename);
        ResourceConfig config = new ResourceConfig().register(new CourseResources(courseRepository));

        GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URL), config);
    }

    private static String loadDatabaseFilename() {
        try (InputStream propertiesStream =
                     CourseServer.class.getResourceAsStream("/server.properties")) {
            Properties properties = new Properties();
            properties.load(propertiesStream);
            return properties.getProperty("courseCatalog.database");
        } catch (IOException e) {
            throw new IllegalStateException("Could not load database filename");
        }
    }
}
