package br.com.all.citizens.domain.exception;

public class TopicNotFoundException extends RuntimeException {
    public TopicNotFoundException(Integer id) {
        super("Topic with id " + id + " not found.");
    }
}