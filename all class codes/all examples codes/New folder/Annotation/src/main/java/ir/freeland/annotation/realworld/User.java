package ir.freeland.annotation.realworld;

import javax.validation.constraints.*;

public class User {

    @NotNull
    private String username;

    @Email
    private String email;

    // Getters and setters
}