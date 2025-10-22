package br.com.all.citizens.application.subtopic.usecase;

import br.com.all.citizens.application.subtopic.command.CreateSubTopicCommand;

public interface CreateSubTopicUseCase {
    Integer execute(CreateSubTopicCommand command);
}