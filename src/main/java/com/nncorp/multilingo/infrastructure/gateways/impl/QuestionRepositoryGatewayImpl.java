package com.nncorp.multilingo.infrastructure.gateways.impl;

import com.nncorp.multilingo.app.gateways.QuestionRepositoryGateway;
import com.nncorp.multilingo.domain.model.Question;
import com.nncorp.multilingo.infrastructure.persistence.QuestionEntity;
import com.nncorp.multilingo.infrastructure.persistence.QuestionRepository;
import com.nncorp.multilingo.infrastructure.persistence.mappers.QuestionMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class QuestionRepositoryGatewayImpl implements QuestionRepositoryGateway {

    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    @Override
    @Transactional
    public Question createQuestion(Question question) {
        QuestionEntity questionEntity = questionMapper.toQuestionEntity(question);
        questionRepository.persist(questionEntity);
        return questionMapper.toQuestion(questionEntity);
    }

}
