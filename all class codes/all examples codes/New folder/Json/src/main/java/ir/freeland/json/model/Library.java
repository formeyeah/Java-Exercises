package ir.freeland.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Library(
    @JsonProperty("libName") String libraryName,
     String location,
     List<Magazine> magazines) {

}