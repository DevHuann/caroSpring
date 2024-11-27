package com.vcoderlog.lab01.controller;

import com.vcoderlog.lab01.reponsitory.models.Role;
import com.vcoderlog.lab01.reponsitory.models.request.RoleRequest.RoleRequest;
import com.vcoderlog.lab01.reponsitory.models.response.RoleResponseDTO;
import com.vcoderlog.lab01.reponsitory.RoleRepository;
import com.vcoderlog.lab01.services.RoleSevice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/Role")
public class RoleController {

    @Autowired
    RoleSevice roleSevice;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ModelMapper modelMapper;

//    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/createRole")
    Role create(@RequestBody RoleRequest request){
        return roleSevice.addRole(request);
    }

//    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/getlistRole")
    List<RoleResponseDTO> getlistRole(){
        return roleSevice.getlistRole().stream().map(role -> modelMapper.map(role, RoleResponseDTO.class))
                .collect(Collectors.toList());
    }
}
