package ir.freeland.json.model;

public enum CinemaType {
    MULTIPLEX("Multiplex", "A cinema with multiple screens showing different films."),
    IMAX("IMAX", "A cinema that features IMAX technology for enhanced viewing."),
    DRIVE_IN("Drive-In", "An outdoor cinema where viewers watch from their cars."),
    ART_HOUSE("Art House", "A cinema that specializes in independent and foreign films."),
    DOME("Dome", "A cinema with a domed screen for immersive viewing experiences.");

    private final String name;
    private final String description;

    CinemaType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}