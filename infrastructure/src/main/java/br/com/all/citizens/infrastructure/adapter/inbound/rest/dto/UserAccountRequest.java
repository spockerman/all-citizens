package br.com.all.citizens.infrastructure.adapter.inbound.rest.dto;


public record UserAccountRequest(
        Integer personId,
        String authProvider,
        String authSubject,
        String mobile,
        String email,
        Boolean isActive
) {
}
