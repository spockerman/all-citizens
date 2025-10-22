package br.com.all.citizens.application.subtopic.service;

import br.com.all.citizens.application.subtopic.usecase.FindByDepartmentIdSubTopicUseCase;
import br.com.all.citizens.domain.department.DepartmentRepository;
import br.com.all.citizens.domain.exception.DepartmentNotFoundException;
import br.com.all.citizens.domain.subtopic.SubTopic;
import br.com.all.citizens.domain.subtopic.SubTopicRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FindByDepartmentIdSubTopicService implements FindByDepartmentIdSubTopicUseCase {

    private final SubTopicRepository subTopicRepository;
    private final DepartmentRepository departmentRepository;

    public FindByDepartmentIdSubTopicService(
            SubTopicRepository subTopicRepository,
            DepartmentRepository departmentRepository) {
        this.subTopicRepository = subTopicRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SubTopic> execute(Integer departmentId) {
        // Verify that the department exists
        departmentRepository.findById(departmentId)
                .orElseThrow(() -> new DepartmentNotFoundException(departmentId));

        // Return all subtopics for the department
        return subTopicRepository.findByDepartmentId(departmentId);
    }
}