package com.sugan.tasks.doman.dto;

public record ErrorResponse(
        int status,
        String message,
        String details
) {}
