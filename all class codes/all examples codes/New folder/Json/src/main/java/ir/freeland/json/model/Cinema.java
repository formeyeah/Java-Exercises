package ir.freeland.json.model;


public record Cinema(
    String cinemaName,
    String location,
    int numberOfScreens,
    CinemaType cinemaType) {

}