package learn.field_agent.domain;

import learn.field_agent.data.SecurityClearanceRepository;
import learn.field_agent.models.SecurityClearance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SecurityClearanceService {
    private final SecurityClearanceRepository repository;

    public SecurityClearanceService(SecurityClearanceRepository repository) {
        this.repository = repository;
    }

    public SecurityClearance findById(int id) {
        return repository.findById(id);
    }

    public List<SecurityClearance> findAll() {
        return repository.findAll();
    }

    public Result<SecurityClearance> add(SecurityClearance clearance) {
        Result<SecurityClearance> result = validate(clearance);
        if (!result.isSuccess()) {
            return result;
        }

        if (clearance.getSecurityClearanceId() != 0) {
            result.addMessage("clearanceId cannot be set for `add` operation", ResultType.INVALID);
            return result;
        }

        clearance = repository.add(clearance);
        result.setPayload(clearance);
        return result;
    }

    private Result<SecurityClearance> validate(SecurityClearance clearance) {
        Result<SecurityClearance> result = new Result<>();
        if (clearance == null) {
            result.addMessage("clearance cannot be null", ResultType.INVALID);
            return result;
        }

        if (Validations.isNullOrBlank(clearance.getName())) {
            result.addMessage("name is required", ResultType.INVALID);
            return result;
        }

        // TODO: innovating here but there may be pre-existing code I can use
        // TODO: the fancy SecurityClearance::getName is courtesy of ChatGPT
        List<String> names = repository.findAll().stream()
                .map(SecurityClearance::getName)
                .toList();

        if (names.contains(clearance.getName())) {
            result.addMessage("duplicate names are not permitted", ResultType.INVALID);
        }

        return result;
    }

}
