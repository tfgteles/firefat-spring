package com.firefat.backend.services;

import com.firefat.backend.domain.AppUser;
import com.firefat.backend.domain.AppRole;

import java.util.List;

public interface UserService {
    AppUser saveAppUser(AppUser appUser);
    AppRole saveRole(AppRole appRole);
    void addRoleToAppUser(String email, String roleName);
    AppUser getAppUser(String email);
    List<AppUser> getAppUsers();
}
