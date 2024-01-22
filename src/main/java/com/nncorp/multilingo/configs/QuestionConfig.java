package com.nncorp.multilingo.configs;

import com.nncorp.multilingo.app.gateways.QuestionRepositoryGateway;
import com.nncorp.multilingo.app.usecases.interactors.CreateQuestionUseCaseInteractor;
import com.nncorp.multilingo.infrastructure.controllers.mappers.QuestionDTOMapper;
import com.nncorp.multilingo.infrastructure.gateways.impl.QuestionRepositoryGatewayImpl;
import com.nncorp.multilingo.infrastructure.persistence.QuestionRepository;
import com.nncorp.multilingo.infrastructure.persistence.mappers.QuestionMapper;
import io.quarkus.arc.DefaultBean;
import io.quarkus.runtime.Startup;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@Startup
@ApplicationScoped
public class QuestionConfig {

    @Produces
    @DefaultBean
    QuestionDTOMapper questionDTOMapper() {
        return new QuestionDTOMapper();
    }

    @Produces
    @DefaultBean
    QuestionMapper questionMapper() {
        return new QuestionMapper();
    }

    @Produces
    @DefaultBean
    QuestionRepository questionRepository() {
        return new QuestionRepository();
    }

    @Produces
    @DefaultBean
    QuestionRepositoryGateway questionRepositoryGateway(QuestionRepository questionRepository,
                                                               QuestionMapper questionMapper) {
        return new QuestionRepositoryGatewayImpl(questionRepository, questionMapper);
    }

    @Produces
    @DefaultBean
    CreateQuestionUseCaseInteractor createQuestionUseCaseInteractor(QuestionRepositoryGateway questionRepositoryGateway) {
        return new CreateQuestionUseCaseInteractor(questionRepositoryGateway);
    }

}
