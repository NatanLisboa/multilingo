package com.nncorp.multilingo.infrastructure.persistence.mappers;

import com.nncorp.multilingo.domain.model.Question;
import com.nncorp.multilingo.infrastructure.persistence.QuestionEntity;

public class QuestionMapper {

    public QuestionEntity toQuestionEntity(Question question) {
        return QuestionEntity.builder()
                .statement(question.getStatement())
                .build();
    }

    public Question toQuestion(QuestionEntity questionEntity) {
        return Question.builder()
                .id(questionEntity.id.toString())
                .statement(questionEntity.getStatement())
                .build();
    }

}
