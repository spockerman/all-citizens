package br.com.all.citizens.infrastructure.adapter.inbound.rest.mapper;

import br.com.all.citizens.application.citizen.command.CreateCitizenCommand;
import br.com.all.citizens.application.citizen.command.UpdateCitizenCommand;
import br.com.all.citizens.domain.citizen.Citizen;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.CitizenResponse;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.CreateCitizenRequest;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.UpdateCitizenRequest;

public class CitizenMapper {

    public static CreateCitizenCommand toCommand(CreateCitizenRequest request) {
        return new CreateCitizenCommand(
                request.name(),
                request.cpf(),
                request.mobile(),
                request.email(),
                request.type()
        );
    }

    public static UpdateCitizenCommand toCommand(Integer id, UpdateCitizenRequest request) {
        return new UpdateCitizenCommand(
                id,
                request.name(),
                request.cpf(),
                request.mobile(),
                request.email(),
                request.type()
        );
    }

    public static CitizenResponse toResponse(Citizen citizen) {
        return new CitizenResponse(
                citizen.getId(),
                citizen.getName(),
                citizen.getCpf(),
                citizen.getMobile(),
                citizen.getEmail(),
                citizen.getType(),
                citizen.getCreatedAt(),
                citizen.getUpdatedAt()
        );
    }
}