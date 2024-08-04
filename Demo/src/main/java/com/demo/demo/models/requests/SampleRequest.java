package com.demo.demo.models.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class SampleRequest {

    @NonNull
    private String firstName;
    @NotNull(message = "First name cannot be empty")
    private String lastName;

}