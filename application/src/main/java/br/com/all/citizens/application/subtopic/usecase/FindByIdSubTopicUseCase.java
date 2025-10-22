package br.com.all.citizens.application.subtopic.usecase;

import br.com.all.citizens.domain.subtopic.SubTopic;

public interface FindByIdSubTopicUseCase {
    SubTopic execute(Integer id);
}