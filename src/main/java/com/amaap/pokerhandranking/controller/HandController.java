package com.amaap.pokerhandranking.controller;

import com.amaap.pokerhandranking.controller.dto.Http;
import com.amaap.pokerhandranking.controller.dto.Response;
import com.amaap.pokerhandranking.service.HandService;
import com.amaap.pokerhandranking.service.exception.DuplicateCardException;

import java.util.List;

public class HandController {
    private final HandService handService;

    public HandController(HandService handService) {
        this.handService = handService;
    }

    public Response getCards(List<String> Cards) {
        try {
            if (handService.receiveCards(Cards)) {
                return new Response(Http.OK, "Cards Submitted");
            } else {
                return new Response(Http.BAD_REQUEST, "Cards Not Submitted");
            }
        } catch (DuplicateCardException | Exception ex) {
            return new Response(Http.BAD_REQUEST, ex.getMessage());
        }
    }

}
