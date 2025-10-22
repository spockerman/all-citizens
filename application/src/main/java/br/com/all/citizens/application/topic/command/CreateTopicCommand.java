package br.com.all.citizens.application.topic.command;

public record CreateTopicCommand(
        String description,
        boolean active
) {}