package com.amaap.pokerhandranking.controller.dto;

import java.util.Objects;

public class Response {
    private Http http;
    private String message;
    public Response(Http http, String message) {
        this.http=http;
        this.message=message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return http == response.http && Objects.equals(message, response.message);
    }


    @Override
    public int hashCode() {
        return Objects.hash(http, message);
    }

}

