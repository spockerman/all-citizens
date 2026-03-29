package br.com.all.citizens.domain;

import br.com.all.citizens.domain.userAccount.UserAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserAccountTest {

    @Test
    public void whenNewUserAccount_thenIdIsNull() {
        UserAccount ua = UserAccount.newUserAccount(
                10,
                "oauth",
                "sub-1",
                "+5511987654321",
                "u@mail.com",
                true
        );

        assertNull(ua.getId());
        assertEquals(10, ua.getPersonId());
        assertEquals("oauth", ua.getAuthProvider());
        assertEquals("sub-1", ua.getAuthSubject());
        assertEquals("+5511987654321", ua.getMobile());
        assertEquals("u@mail.com", ua.getEmail());
        assertTrue(ua.isActive());
    }

    @Test
    public void whenWith_thenExposesAllFields() {
        UserAccount ua = UserAccount.with(7, 3, "local", "abc", null, "e@e.com", false);

        assertEquals(7, ua.getId());
        assertEquals(3, ua.getPersonId());
        assertEquals("local", ua.getAuthProvider());
        assertEquals("abc", ua.getAuthSubject());
        assertNull(ua.getMobile());
        assertEquals("e@e.com", ua.getEmail());
        assertFalse(ua.isActive());
    }
}
