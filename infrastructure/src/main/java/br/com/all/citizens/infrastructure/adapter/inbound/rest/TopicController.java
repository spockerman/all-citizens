package br.com.all.citizens.infrastructure.adapter.inbound.rest;

import br.com.all.citizens.application.topic.command.CreateTopicCommand;
import br.com.all.citizens.application.topic.command.UpdateTopicCommand;
import br.com.all.citizens.application.topic.usecase.*;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.CreateTopicRequest;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.TopicResponse;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.UpdateTopicRequest;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.mapper.TopicMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicController {

    private final CreateTopicUseCase createTopicUseCase;
    private final FindAllTopicsUseCase findAllTopicsUseCase;
    private final FindByIdTopicUseCase findByIdTopicUseCase;
    private final DeleteTopicUseCase deleteTopicUseCase;
    private final UpdateTopicUseCase updateTopicUseCase;

    public TopicController(
            CreateTopicUseCase createTopicUseCase,
            FindAllTopicsUseCase findAllTopicsUseCase,
            FindByIdTopicUseCase findByIdTopicUseCase,
            DeleteTopicUseCase deleteTopicUseCase,
            UpdateTopicUseCase updateTopicUseCase
    ) {
        this.createTopicUseCase = createTopicUseCase;
        this.findAllTopicsUseCase = findAllTopicsUseCase;
        this.findByIdTopicUseCase = findByIdTopicUseCase;
        this.deleteTopicUseCase = deleteTopicUseCase;
        this.updateTopicUseCase = updateTopicUseCase;
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody CreateTopicRequest request) {
        var command = new CreateTopicCommand(
                request.description(),
                request.active()
        );
        Integer id = createTopicUseCase.execute(command);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public ResponseEntity<List<TopicResponse>> findAll() {
        var response = findAllTopicsUseCase.execute().stream()
                .map(TopicMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicResponse> findById(@PathVariable("id") Integer id) {
        var topic = findByIdTopicUseCase.execute(id);
        return ResponseEntity.ok(TopicMapper.toResponse(topic));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        deleteTopicUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Integer id, @RequestBody UpdateTopicRequest request) {
        var command = new UpdateTopicCommand(
                id,
                request.description(),
                request.active()
        );
        updateTopicUseCase.execute(command);
        return ResponseEntity.noContent().build();
    }
}