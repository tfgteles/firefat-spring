package com.firefat.backend.services;

import com.firefat.backend.domain.AppUser;
import com.firefat.backend.domain.AppRole;
import com.firefat.backend.repo.RoleRepo;
import com.firefat.backend.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = userRepo.findByEmail(email);
        if (appUser == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", email);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        appUser.getAppRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(appUser.getEmail(), appUser.getPassword(), authorities);
    }

    @Override
    public AppUser saveAppUser(AppUser appUser) {
        log.info("Saving new user {} to the database", appUser.getFirstName());
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return userRepo.save(appUser);
    }

    @Override
    public AppRole saveRole(AppRole appRole) {
        log.info("Saving new role {} to the database", appRole.getName());
        return roleRepo.save(appRole);
    }

    @Override
    public void addRoleToAppUser(String email, String roleName) {
        log.info("Adding role {} to user {}", roleName, email);
        AppUser appUser = userRepo.findByEmail(email);
        AppRole appRole = roleRepo.findByName(roleName);
        appUser.getAppRoles().add(appRole);
    }

    @Override
    public AppUser getAppUser(String email) {
        log.info("Fetching user {}", email);
        return userRepo.findByEmail(email);
    }

    @Override
    public List<AppUser> getAppUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }


}
