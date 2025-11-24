package br.com.all.citizens.infrastructure.adapter.inbound.rest;

import br.com.all.citizens.application.userAccount.service.FindUserAccountByIdService;
import br.com.all.citizens.application.userAccount.usecase.CreateUserAccountUseCase;
import br.com.all.citizens.application.userAccount.usecase.FindUserAccountByEmailUseCase;
import br.com.all.citizens.application.userAccount.usecase.FindUserAccountByMobileUseCase;
import br.com.all.citizens.application.userAccount.usecase.FindUserAccountByPersonUseCase;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.UserAccountRequest;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.UserAccountResponse;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.mapper.UserAccountMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userAccount")
public class UserAccountController {

    private final CreateUserAccountUseCase createUserAccountUseCase;
    private final FindUserAccountByIdService findUserAccountByIdService;
    private final FindUserAccountByEmailUseCase findUserAccountByEmailUseCase;
    private final FindUserAccountByMobileUseCase findUserAccountByMobileUseCase;
    private final FindUserAccountByPersonUseCase  findUserAccountByPersonUseCase;


    public UserAccountController(
            CreateUserAccountUseCase createUserAccountUseCase,
            FindUserAccountByIdService findUserAccountByIdService,
            FindUserAccountByEmailUseCase findUserAccountByEmailUseCase,
            FindUserAccountByMobileUseCase findUserAccountByMobileUseCase,
            FindUserAccountByPersonUseCase findUserAccountByPersonUseCase)
    {
        this.createUserAccountUseCase = createUserAccountUseCase;
        this.findUserAccountByIdService = findUserAccountByIdService;
        this.findUserAccountByEmailUseCase = findUserAccountByEmailUseCase;
        this.findUserAccountByMobileUseCase = findUserAccountByMobileUseCase;
        this.findUserAccountByPersonUseCase = findUserAccountByPersonUseCase;
    }

    @PostMapping
    public ResponseEntity<Integer> save(@RequestBody UserAccountRequest request) {
        var command = UserAccountMapper.toCommand(request);
        Integer Id = createUserAccountUseCase.execute(command);
        return ResponseEntity.ok(Id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAccountResponse> findById(@PathVariable("id") Integer id) {
       var userAccount = findUserAccountByIdService.execute(id);
       return ResponseEntity.ok(UserAccountMapper.toResponse(userAccount));
    }

    @GetMapping("/email")
    public ResponseEntity<UserAccountResponse> findByEmail(@RequestParam("email") String email) {
        var userAccount = findUserAccountByEmailUseCase.execute(email);
        return ResponseEntity.ok(UserAccountMapper.toResponse(userAccount));
    }

    @GetMapping("/mobile")
    public ResponseEntity<UserAccountResponse> findByMobile(@RequestParam("mobile") String mobile) {
        var userAccount = findUserAccountByMobileUseCase.execute(mobile);
        return ResponseEntity.ok(UserAccountMapper.toResponse(userAccount));

    }

    @GetMapping("/personId")
    public ResponseEntity<UserAccountResponse> findByPerson(@RequestParam("personId") Integer personId) {
        var userAccount = findUserAccountByPersonUseCase.execute(personId);
        return ResponseEntity.ok(UserAccountMapper.toResponse(userAccount));
    }
}
