package learn.field_agent.domain;

import learn.field_agent.data.SecurityClearanceRepository;
import learn.field_agent.models.SecurityClearance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class SecurityClearanceServiceTest {

    @Autowired
    SecurityClearanceService service;

    @MockBean
    SecurityClearanceRepository repository;

    @Test
    void x() {
    }
    
    @Test
    void shouldAdd() {
        SecurityClearance clearance = new SecurityClearance(0, "TEST");
        SecurityClearance mockOut = new SecurityClearance(5, "TEST");

        when(repository.add(clearance)).thenReturn(mockOut);

        Result<SecurityClearance> actual = service.add(clearance);
        assertEquals(ResultType.SUCCESS, actual.getType());
        assertEquals(mockOut, actual.getPayload());
    }

    @Test
    void shouldNotAdd() {
        SecurityClearance invalidClearance = null;
        Result<SecurityClearance> actual = service.add(invalidClearance);
        assertEquals(ResultType.INVALID, actual.getType());

        invalidClearance = new SecurityClearance(0, null);
        actual = service.add(invalidClearance);
        assertEquals(ResultType.INVALID, actual.getType());

        invalidClearance = new SecurityClearance(0, "Secret");
        when(service.findAll()).thenReturn(List.of(new SecurityClearance(0, "Secret")));
        actual = service.add(invalidClearance);
        assertEquals(ResultType.INVALID, actual.getType());
    }
    
}
