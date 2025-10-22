package br.com.all.citizens.domain.subtopic;

import java.util.List;
import java.util.Optional;

public interface SubTopicRepository {
    SubTopic save(SubTopic subTopic);
    Optional<SubTopic> findById(Integer id);
    List<SubTopic> findAll();
    List<SubTopic> findByTopicId(Integer topicId);
    List<SubTopic> findByDepartmentId(Integer departmentId);
    void deleteById(Integer id);
}