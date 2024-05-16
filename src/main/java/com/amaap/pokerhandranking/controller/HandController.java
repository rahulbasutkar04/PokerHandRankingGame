package com.amaap.pokerhandranking.controller;

import com.amaap.pokerhandranking.controller.dto.Http;
import com.amaap.pokerhandranking.controller.dto.Response;

import java.util.List;

public class HandController {
    public Response receiveCards(List<String> Cards) {

        return new Response(Http.OK,"Cards Submitted");
    }
}
