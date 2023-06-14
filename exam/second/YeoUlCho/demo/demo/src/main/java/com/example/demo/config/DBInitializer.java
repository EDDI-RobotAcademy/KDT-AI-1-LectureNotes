package com.example.demo.config;


import com.example.demo.problem10_14.entity.Role;
import com.example.demo.problem10_14.entity.RoleType;
import com.example.demo.problem10_14.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class DBInitializer {

    private final RoleRepository roleRepository;

    @PostConstruct
    private void init(){
        log.debug("initializer 시작");

        initAccountRoleTypes();

        log.debug("initializer 종료");

    }

    private void initAccountRoleTypes(){
        try{
            final Set<RoleType> roles=
                    roleRepository.findAll().stream()
                            .map(Role::getRoleType)
                            .collect(Collectors.toSet());
            for(RoleType type: RoleType.values()){
                if(!roles.contains(type)){
                    final Role role = new Role(type);
                    roleRepository.save(role);
                }
            }
        }
        catch (Exception e){
            log.error(e.getMessage(), e);
        }
    }
}
