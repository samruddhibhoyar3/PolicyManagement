package com.policymanagement.profile.service;

import com.policymanagement.profile.entity.UserNominee;
import com.policymanagement.profile.model.UserNomineeDTO;

public interface UserNomineeService {
    void addNominee(UserNominee userNominee);
    UserNomineeDTO getNominee(String username);
    void removeNominee(String username);
    
}
