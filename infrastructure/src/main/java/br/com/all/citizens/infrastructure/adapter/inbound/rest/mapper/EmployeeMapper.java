package br.com.all.citizens.infrastructure.adapter.inbound.rest.mapper;

import br.com.all.citizens.application.citizen.command.CreateCitizenCommand;
import br.com.all.citizens.domain.citizen.Citizen;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.CitizenResponse;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.CreateCitizenRequest;

public class EmployeeMapper {

    public static CreateCitizenCommand toCommand(CreateCitizenRequest request) {
        return new CreateCitizenCommand(
                request.fullName(),
                request.cpfNumber(),
                request.birthDate(),
                request.socialId(),
                request.type()
        );
    }

    public static CitizenResponse toResponse(Citizen citizen) {
        return new CitizenResponse(
                citizen.getPersonId(),
                citizen.getPerson().getFullName(),
                citizen.getPerson().getCpfNumber(),
                citizen.getPerson().getBirthDate(),
                citizen.getSocialId(),
                citizen.getType()
        );
    }
}