package com.nncorp.multilingo.infrastructure.persistence;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@MongoEntity(collection = "question")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class QuestionEntity extends PanacheMongoEntity {

    private String statement;

}
