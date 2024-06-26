package learn.field_agent.data;

import learn.field_agent.models.AgencyAgent;
import learn.field_agent.models.SecurityClearance;

import java.util.List;

public interface SecurityClearanceRepository {
    List<SecurityClearance> findAll();

    SecurityClearance findById(int securityClearanceId);

    SecurityClearance add(SecurityClearance clearance);

    boolean update(SecurityClearance clearance);

    boolean deleteById(int securityClearanceId);

    int countInstancesOfId(int securityClearanceId);
}
