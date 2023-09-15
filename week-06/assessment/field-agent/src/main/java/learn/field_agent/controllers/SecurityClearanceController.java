package learn.field_agent.controllers;

import learn.field_agent.domain.SecurityClearanceService;
import learn.field_agent.models.SecurityClearance;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/security-clearance")
public class SecurityClearanceController {

    private final SecurityClearanceService service;

    public SecurityClearanceController(SecurityClearanceService service) {
        this.service = service;
    }

    @GetMapping("/{securityClearanceId}")
    public SecurityClearance findById(@PathVariable int securityClearanceId) {
        return service.findById(securityClearanceId);
    }

}
