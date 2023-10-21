package com.eTaskifyApi.eTaskify.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class TaskRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    private LocalDate deadline;

    @NotEmpty
    private Set<Long> assigneeIds;
}
