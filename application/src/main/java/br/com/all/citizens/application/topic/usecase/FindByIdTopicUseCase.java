package br.com.all.citizens.application.topic.usecase;

import br.com.all.citizens.domain.topic.Topic;

public interface FindByIdTopicUseCase {
    Topic execute(Integer id);
}