package com.nncorp.multilingo.app.usecases.interactors;

import com.nncorp.multilingo.app.gateways.QuestionRepositoryGateway;
import com.nncorp.multilingo.domain.model.Question;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateQuestionUseCaseInteractor {

    private final QuestionRepositoryGateway questionRepositoryGateway;

    public Question createQuestion(Question question) {
        return questionRepositoryGateway.createQuestion(question);
    }

}
