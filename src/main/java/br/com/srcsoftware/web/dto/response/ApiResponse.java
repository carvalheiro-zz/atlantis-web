package br.com.srcsoftware.web.dto.response;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse<T>(
    Instant timestamp,
    int status,
    boolean success,
    String message,
    T data,
    String path
) {
    public static <T> ApiResponse<T> success(int status, String message, T data, String path) {
        return new ApiResponse<>(Instant.now(), status, true, message, data, path);
    }

    public static <T> ApiResponse<T> success(int status, String message, String path) {
        return new ApiResponse<>(Instant.now(), status, true, message, null, path);
    }
}