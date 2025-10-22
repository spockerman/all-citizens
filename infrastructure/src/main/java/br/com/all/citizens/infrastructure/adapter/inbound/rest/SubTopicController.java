package br.com.all.citizens.infrastructure.adapter.inbound.rest;

import br.com.all.citizens.application.subtopic.usecase.*;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.CreateSubTopicRequest;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.SubTopicResponse;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.dto.UpdateSubTopicRequest;
import br.com.all.citizens.infrastructure.adapter.inbound.rest.mapper.SubTopicMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sub-topic")
public class SubTopicController {

    private final CreateSubTopicUseCase createSubTopicUseCase;
    private final FindAllSubTopicsUseCase findAllSubTopicsUseCase;
    private final FindByIdSubTopicUseCase findByIdSubTopicUseCase;
    private final UpdateSubTopicUseCase updateSubTopicUseCase;
    private final DeleteSubTopicUseCase deleteSubTopicUseCase;
    private final FindByTopicIdSubTopicUseCase findByTopicIdSubTopicUseCase;
    private final FindByDepartmentIdSubTopicUseCase findByDepartmentIdSubTopicUseCase;

    public SubTopicController(
            CreateSubTopicUseCase createSubTopicUseCase,
            FindAllSubTopicsUseCase findAllSubTopicsUseCase,
            FindByIdSubTopicUseCase findByIdSubTopicUseCase,
            UpdateSubTopicUseCase updateSubTopicUseCase,
            DeleteSubTopicUseCase deleteSubTopicUseCase,
            FindByTopicIdSubTopicUseCase findByTopicIdSubTopicUseCase,
            FindByDepartmentIdSubTopicUseCase findByDepartmentIdSubTopicUseCase) {
        this.createSubTopicUseCase = createSubTopicUseCase;
        this.findAllSubTopicsUseCase = findAllSubTopicsUseCase;
        this.findByIdSubTopicUseCase = findByIdSubTopicUseCase;
        this.updateSubTopicUseCase = updateSubTopicUseCase;
        this.deleteSubTopicUseCase = deleteSubTopicUseCase;
        this.findByTopicIdSubTopicUseCase = findByTopicIdSubTopicUseCase;
        this.findByDepartmentIdSubTopicUseCase = findByDepartmentIdSubTopicUseCase;
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody CreateSubTopicRequest request) {
        var command = SubTopicMapper.toCommand(request);
        Integer id = createSubTopicUseCase.execute(command);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public ResponseEntity<List<SubTopicResponse>> findAll() {
        var response = findAllSubTopicsUseCase.execute().stream()
                .map(SubTopicMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubTopicResponse> findById(@PathVariable("id") Integer id) {
        var subTopic = findByIdSubTopicUseCase.execute(id);
        return ResponseEntity.ok(SubTopicMapper.toResponse(subTopic));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Integer id, @RequestBody UpdateSubTopicRequest request) {
        var command = SubTopicMapper.toCommand(id, request);
        updateSubTopicUseCase.execute(command);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        deleteSubTopicUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-topic/{topicId}")
    public ResponseEntity<List<SubTopicResponse>> findByTopicId(@PathVariable("topicId") Integer topicId) {
        var response = findByTopicIdSubTopicUseCase.execute(topicId).stream()
                .map(SubTopicMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/by-department/{departmentId}")
    public ResponseEntity<List<SubTopicResponse>> findByDepartmentId(@PathVariable("departmentId") Integer departmentId) {
        var response = findByDepartmentIdSubTopicUseCase.execute(departmentId).stream()
                .map(SubTopicMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }
}