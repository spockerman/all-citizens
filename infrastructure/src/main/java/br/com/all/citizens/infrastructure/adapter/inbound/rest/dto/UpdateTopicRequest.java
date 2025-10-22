package br.com.all.citizens.infrastructure.adapter.inbound.rest.dto;

public record UpdateTopicRequest(
        String description,
        boolean active
) {}