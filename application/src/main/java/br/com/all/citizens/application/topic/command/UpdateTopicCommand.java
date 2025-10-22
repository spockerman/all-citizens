package br.com.all.citizens.application.topic.command;

public record UpdateTopicCommand(
        Integer id,
        String description,
        boolean active
) {}