package com.nncorp.multilingo.app.gateways;

import com.nncorp.multilingo.domain.model.Question;

public interface QuestionRepositoryGateway {

    Question createQuestion(Question question);

}
