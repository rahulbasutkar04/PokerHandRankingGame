package com.amaap.pokerhandranking.controller;

import com.amaap.pokerhandranking.controller.dto.Http;
import com.amaap.pokerhandranking.controller.dto.Response;
import com.amaap.pokerhandranking.service.HandService;

import java.util.List;

public class HandController {
    private final HandService handService;

    public HandController(HandService handService) {
        this.handService = handService;
    }

    public Response receiveCards(List<String> Cards) {

        if (handService.receiveCards(Cards)) {
            return new Response(Http.OK, "Cards Submitted");
        }

        return new Response(Http.BAD_REQUEST, "Cards Not Submitted");
    }

}