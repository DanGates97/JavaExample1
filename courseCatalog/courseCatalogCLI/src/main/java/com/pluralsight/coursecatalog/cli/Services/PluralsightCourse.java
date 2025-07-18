package com.pluralsight.coursecatalog.cli.Services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.time.Duration;
import java.time.LocalTime;

@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
public record PluralsightCourse(String id, String title, String duration, String contentUrl, boolean isRetired) {
    // duration = "00:05:37"
    public long durationInMinutes() {
        return Duration.between(
                LocalTime.MIN,
                LocalTime.parse(duration())
        ).toMinutes();
    }
}
