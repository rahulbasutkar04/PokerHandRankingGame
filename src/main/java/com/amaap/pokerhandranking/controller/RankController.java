package com.amaap.pokerhandranking.controller;

import com.amaap.pokerhandranking.controller.dto.Http;
import com.amaap.pokerhandranking.controller.dto.Response;
import com.amaap.pokerhandranking.domain.service.exception.InvalidCardNameException;
import com.amaap.pokerhandranking.repository.impl.InMemoryHandRepository;
import com.amaap.pokerhandranking.domain.service.HandEvaluator;
import com.amaap.pokerhandranking.service.RankEvaluatorService;
import com.amaap.pokerhandranking.service.exception.CardsNotFoundException;

public class RankController {
    RankEvaluatorService rankEvaluatorService=new RankEvaluatorService(InMemoryHandRepository.getInstance(),new HandEvaluator());

        public Response getHandRank() throws CardsNotFoundException, InvalidCardNameException {
            rankEvaluatorService.getRank();
            return new Response(Http.OK, "Request Submitted");
        }
    }

