package com.vcoderlog.lab01.controller;


import com.vcoderlog.lab01.reponsitory.models.RoleClaims;
import com.vcoderlog.lab01.reponsitory.models.request.RoleClaimRequest.RoleClaimRequest;
import com.vcoderlog.lab01.reponsitory.models.response.RoleClamsRespsponseDTO;
import com.vcoderlog.lab01.reponsitory.RoleClaimRepository;
import com.vcoderlog.lab01.services.RoleClaimService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/RoleClaim")
public class RoleclaimController {

    @Autowired
    RoleClaimService roleClaimService;

    @Autowired
    RoleClaimRepository roleClaimRepository;

    @Autowired
    ModelMapper modelMapper;
//    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/createRoleClaim")
    RoleClaims addRoleClaim(@RequestBody RoleClaimRequest request){
        return roleClaimService.addRoleClaim(request);
    }

//    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/getlistRolclaim")
    List<RoleClamsRespsponseDTO> getlistRoleClaim(){
        return roleClaimRepository.findAll().stream().map(roleClaims -> modelMapper.map(roleClaims , RoleClamsRespsponseDTO.class)).collect(Collectors.toList());
    }
}
