package br.com.all.citizens.application.subtopic.usecase;

import br.com.all.citizens.domain.subtopic.SubTopic;

import java.util.List;

public interface FindAllSubTopicsUseCase {
    List<SubTopic> execute();
}