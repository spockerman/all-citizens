package br.com.all.citizens.application.citizen.service;

import br.com.all.citizens.application.citizen.usecase.FindBySocialIdUseCase;
import br.com.all.citizens.domain.citizen.CitizenRepository;
import br.com.all.citizens.domain.exception.CitizenSocialIdNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FindBySocialIdService implements FindBySocialIdUseCase {

    private final CitizenRepository repository;

    public FindBySocialIdService(CitizenRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public String execute(String socialId) {
        repository.findBySocialId(socialId).orElseThrow(() -> new CitizenSocialIdNotFoundException(socialId));
         return socialId;
    }
}
