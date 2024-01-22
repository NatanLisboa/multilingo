package com.nncorp.multilingo.infrastructure.controllers;

import com.nncorp.multilingo.app.usecases.interactors.CreateQuestionUseCaseInteractor;
import com.nncorp.multilingo.domain.model.Question;
import com.nncorp.multilingo.infrastructure.controllers.dtos.CreateQuestionRequest;
import com.nncorp.multilingo.infrastructure.controllers.dtos.CreateQuestionResponse;
import com.nncorp.multilingo.infrastructure.controllers.mappers.QuestionDTOMapper;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;

@Path("/api/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final CreateQuestionUseCaseInteractor createQuestionUseCaseInteractor;
    private final QuestionDTOMapper questionDTOMapper;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public CreateQuestionResponse createQuestion(CreateQuestionRequest createQuestionRequest) {
        Question question = questionDTOMapper.toQuestion(createQuestionRequest);
        Question createdQuestion = createQuestionUseCaseInteractor.createQuestion(question);
        return questionDTOMapper.toCreateQuestionResponse(createdQuestion);
    }

}

