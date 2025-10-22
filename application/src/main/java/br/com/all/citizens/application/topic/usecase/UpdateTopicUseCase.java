package br.com.all.citizens.application.topic.usecase;

import br.com.all.citizens.application.topic.command.UpdateTopicCommand;

public interface UpdateTopicUseCase {
    void execute(UpdateTopicCommand command);
}