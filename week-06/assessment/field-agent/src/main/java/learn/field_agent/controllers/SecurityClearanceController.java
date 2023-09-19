package learn.field_agent.controllers;

import learn.field_agent.domain.Result;
import learn.field_agent.domain.SecurityClearanceService;
import learn.field_agent.models.Agency;
import learn.field_agent.models.SecurityClearance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/security-clearance")
public class SecurityClearanceController {

    private final SecurityClearanceService service;

    public SecurityClearanceController(SecurityClearanceService service) {
        this.service = service;
    }

    @GetMapping
    public List<SecurityClearance> findAll() {
        return service.findAll();
    }

    @GetMapping("/{securityClearanceId}")
    public ResponseEntity<SecurityClearance> findById(@PathVariable int securityClearanceId) {
        SecurityClearance clearance = service.findById(securityClearanceId);
        if (clearance == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(clearance);
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody SecurityClearance clearance) {
        int count = service.countInstanceOfId(clearance.getSecurityClearanceId());
        if (count > 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Result<SecurityClearance> result = service.add(clearance);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
        }
        return ErrorResponse.build(result);
    }

    @PutMapping("/{securityClearanceId}")
    public ResponseEntity<Object> update(@PathVariable int securityClearanceId, @RequestBody SecurityClearance clearance) {
        if (securityClearanceId != clearance.getSecurityClearanceId()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Result<SecurityClearance> result = service.update(clearance);
        if (result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ErrorResponse.build(result);
    }

    @DeleteMapping("/{securityClearanceId}")
    public ResponseEntity<Void> deleteById(@PathVariable int securityClearanceId) {
      
        Result<?> result = service.deleteById(securityClearanceId);
        if(result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        if(result.getType() == ResultType.INVALID) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
      
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
