package com.client.newsBlog.controller;

import com.client.newsBlog.model.RolePermission;
import com.client.newsBlog.model.User;
import com.client.newsBlog.repository.RolePermissionRepository;
import com.client.newsBlog.repository.UserRepository;
import com.client.newsBlog.service.adminPanel.AdminPanelRolePermissionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class GlobalController {
    private final UserRepository UserRepository;
    private final RolePermissionRepository rolePermissionRepository;
    private final AdminPanelRolePermissionServiceImpl adminPanelRolePermission;
    @ModelAttribute("PermissionList")
    public List<String> permissionListOfLoggedInUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String userEmail = ((UserDetails) principal).getUsername();
            User user = UserRepository.findByEmail(userEmail);
            if (user != null) {
//                List<RolePermission> rolePermission = rolePermissionRepository.findByRole_RoleName(user.getRoleName());
//                return adminPanelRolePermission.getPermissionName(rolePermission);
            }
        }
        return new ArrayList<>();
    }
}
