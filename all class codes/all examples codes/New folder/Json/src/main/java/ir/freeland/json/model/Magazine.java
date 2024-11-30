package ir.freeland.json.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties ({"numInStock"})
public record Magazine(
    String title,
    String author,
    int publishedYear,
    List<Review> reviews
) {

}