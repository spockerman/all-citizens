package br.com.all.citizens.domain.exception;

public class SubTopicTopicMismatchException extends RuntimeException {
    public SubTopicTopicMismatchException(Integer subTopicId, Integer topicId) {
        super("Sub-topic " + subTopicId + " does not belong to topic " + topicId + ".");
    }
}
