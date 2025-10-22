package br.com.all.citizens.application.topic.usecase;

import br.com.all.citizens.domain.topic.Topic;

import java.util.List;

public interface FindAllTopicsUseCase {
    List<Topic> execute();
}