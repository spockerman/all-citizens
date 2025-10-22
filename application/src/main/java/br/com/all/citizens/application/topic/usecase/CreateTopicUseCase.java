package br.com.all.citizens.application.topic.usecase;

import br.com.all.citizens.application.topic.command.CreateTopicCommand;

public interface CreateTopicUseCase {
    Integer execute(CreateTopicCommand command);
}