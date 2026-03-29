package br.com.all.citizens.infrastructure.configuration.handler;

import br.com.all.citizens.domain.exception.DepartmentNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ExceptionProbeController {

    @GetMapping("/probe/department-not-found")
    void triggerDepartmentNotFound() {
        throw new DepartmentNotFoundException(99);
    }
}
