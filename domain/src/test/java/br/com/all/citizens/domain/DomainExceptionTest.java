package br.com.all.citizens.domain;

import br.com.all.citizens.domain.exception.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DomainExceptionTest {

    @Test
    public void personNotFoundException_messageContainsId() {
        var ex = new PersonNotFoundException(12);
        assertEquals("Person with id 12 not found.", ex.getMessage());
    }

    @Test
    public void personCpfNotFoundException_messageContainsCpf() {
        var ex = new PersonCpfNotFoundException("123");
        assertTrue(ex.getMessage().contains("123"));
    }

    @Test
    public void personFullNameNotFoundException_messageContainsName() {
        var ex = new PersonFullNameNotFoundException("Ann");
        assertTrue(ex.getMessage().contains("Ann"));
    }

    @Test
    public void employeeDocumentNotFoundException_messageContainsDocument() {
        var ex = new EmployeeDocumentNotFoundException("DOC-1");
        assertTrue(ex.getMessage().contains("DOC-1"));
    }

    @Test
    public void userAccountNotFoundException_preservesMessage() {
        var ex = new UserAccountNotFoundException("missing");
        assertEquals("missing", ex.getMessage());
    }

    @Test
    public void departmentNotFoundException_messageContainsId() {
        var ex = new DepartmentNotFoundException(5);
        assertTrue(ex.getMessage().contains("5"));
    }

    @Test
    public void citizenExceptions_messageFormat() {
        assertTrue(new CitizenNotFoundException(1).getMessage().contains("1"));
        assertTrue(new CitizenSocialIdNotFoundException("soc").getMessage().contains("soc"));
    }

    @Test
    public void topicAndSubTopicExceptions_messageFormat() {
        assertTrue(new TopicNotFoundException(2).getMessage().contains("2"));
        assertTrue(new SubTopicNotFoundException(3).getMessage().contains("3"));
    }
}
