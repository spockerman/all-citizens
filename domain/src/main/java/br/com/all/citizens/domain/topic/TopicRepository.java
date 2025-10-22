package br.com.all.citizens.domain.topic;

import java.util.List;
import java.util.Optional;

public interface TopicRepository {
    Topic save(Topic topic);
    Optional<Topic> findById(Integer id);
    List<Topic> findAll();
    void deleteById(Integer id);
}