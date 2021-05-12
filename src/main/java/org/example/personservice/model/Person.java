package org.example.personservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

public class Person {
    private final UUID id;
    //Need to have relevant dep. for ex. spring-boot-starter-validation, to make validation work
    @NotNull(message="First name cannot be missing or empty")
    @Size(min=2, message="First name must not be less than 2 characters")
    private final String name;

    //JsonProperty matches json data to class fields
    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
        this.id = id;       this.name = name;
    }
    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
