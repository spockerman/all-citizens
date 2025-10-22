package br.com.all.citizens.infrastructure.adapter.inbound.rest.dto;

public record CreateTopicRequest(
        String description,
        boolean active
) {}