package br.com.all.citizens.application.subtopic.usecase;

import br.com.all.citizens.application.subtopic.command.UpdateSubTopicCommand;

public interface UpdateSubTopicUseCase {
    void execute(UpdateSubTopicCommand command);
}