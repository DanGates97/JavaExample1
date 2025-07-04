package com.pluralsight.coursecatalog.server;

import com.pluralsight.coursecatalog.domain.Course;
import com.pluralsight.coursecatalog.repository.CourseRepository;
import com.pluralsight.coursecatalog.repository.RepositoryException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Path("/courses")
public class CourseResources {
    private static final Logger LOG = LoggerFactory.getLogger(CourseResources.class);

    private CourseRepository courseRepository;

    public CourseResources(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getCourses() {
        try {
            return courseRepository
                    .getAllCourses()
                    .stream()
                    .sorted(Comparator.comparing(Course::id))
                    .toList();
        } catch (RepositoryException e) {
            LOG.error("Could not retrieve courses from the database", e);
            throw new NotFoundException();
        }
    }


    @POST
    @Path("/{id}/notes")
    @Consumes(MediaType.TEXT_PLAIN)
    public void addNotes(@PathParam("id") String id, String notes) {
        courseRepository.addNotes(id, notes);
    }

}
