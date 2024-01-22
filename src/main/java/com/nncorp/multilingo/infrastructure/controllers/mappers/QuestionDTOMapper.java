package com.nncorp.multilingo.infrastructure.controllers.mappers;

import com.nncorp.multilingo.domain.model.Question;
import com.nncorp.multilingo.infrastructure.controllers.dtos.CreateQuestionRequest;
import com.nncorp.multilingo.infrastructure.controllers.dtos.CreateQuestionResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class QuestionDTOMapper {

    public Question toQuestion(CreateQuestionRequest requestObj) {
        return Question.builder()
                .statement(requestObj.statement())
                .build();
    }

    public CreateQuestionResponse toCreateQuestionResponse(Question question) {
        return new CreateQuestionResponse(question.getId(), question.getStatement());
    }

}
