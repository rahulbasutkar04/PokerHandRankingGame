package com.amaap.pokerhandranking.controller.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ResponseTest {

    @Test
    public void shouldBeAbleToCreateResponse() {
        Http http = Http.OK;
        String message = "Success";
        Response response = new Response(http, message);
        assertNotNull(response);
        assertEquals(http, response.getHttp());
        assertEquals(message, response.getMessage());
    }

    @Test
    public void shouldBeAbleToCheckEquality() {
        Http http1 = Http.OK;
        String message1 = "Success";
        Response response1 = new Response(http1, message1);

        Http http2 = Http.OK;
        String message2 = "Success";
        Response response2 = new Response(http2, message2);

        Http http3 = Http.BAD_REQUEST;
        String message3 = "Failure";
        Response response3 = new Response(http3, message3);

        assertEquals(response1, response2);
        assertNotEquals(response1, response3);
    }

    @Test
    public void shouldBeAbleToGenerateHashCode() {
        Http http1 = Http.OK;
        String message1 = "Success";
        Response response1 = new Response(http1, message1);

        Http http2 = Http.OK;
        String message2 = "Success";
        Response response2 = new Response(http2, message2);

        Http http3 = Http.BAD_REQUEST;
        String message3 = "Failure";
        Response response3 = new Response(http3, message3);

        assertEquals(response1.hashCode(), response2.hashCode());
        assertNotEquals(response1.hashCode(), response3.hashCode());
    }

    @Test
    public void shouldHandleNullMessage() {
        Http http = Http.OK;
        Response response = new Response(http, null);
        assertNotNull(response);
        assertEquals(http, response.getHttp());
        assertNull(response.getMessage());
    }
}
