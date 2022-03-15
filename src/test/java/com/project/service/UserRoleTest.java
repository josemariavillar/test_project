package com.project.service;

import com.project.model.Role;
import com.project.model.User;
import com.project.model.UserRole;
import com.project.model.id.UserRoleKey;
import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.mockito.Mockito;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class UserRoleTest {

    private User user;
    private Role role;
    private UserRoleKey userRoleKey;
    private UserRole userRole;
    private Timestamp timestamp;

    private final String CTE_CO_USER = "CTE_CO_USER";
    private final String CTE_CO_ROLE = "CTE_CO_ROLE";

    @Before
    void setUp() {
        timestamp = Mockito.mock(Timestamp.class);

        user = User.builder().coUser(CTE_CO_USER)
                .coUserModification("codification")
                .tsModification(timestamp)
                .build();
        role = Role.builder().coRole(CTE_CO_ROLE)
                .coUserModification("codification")
                .tsModification(timestamp)
                .build();

        userRoleKey = UserRoleKey.builder().coUser(CTE_CO_USER).coRole(CTE_CO_ROLE)
                .build();

        userRole = UserRole.builder()
                .id(userRoleKey)
                .user(user)
                .role(role)
                .tsDelete(timestamp)
                .coUserModification("codification")
                .tsModification(timestamp)
                .build();
    }

    @Test
    void assertionsTest() {
        assertNotNull(userRole.getId());
        assertEquals(role, userRole.getRole());
        assertEquals(user, userRole.getUser());

        Exception exception = assertThrows(NumberFormatException.class, new ThrowingRunnable() {
            public void run() throws Throwable {
                Integer.parseInt("1a");
            }
        });

        String expectedMessage = "For input string";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        assertThat(actualMessage).isEqualTo(expectedMessage);
    }
}
