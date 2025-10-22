package br.com.all.citizens.domain.exception;

public class SubTopicNotFoundException extends RuntimeException {
    public SubTopicNotFoundException(Integer id) {
        super("SubTopic with id " + id + " not found.");
    }
}