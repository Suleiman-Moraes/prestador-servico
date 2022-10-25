package br.com.moraes.prestadorservico.config;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.moraes.prestadorservico.api.enums.PermissionEnum;
import br.com.moraes.prestadorservico.api.model.Permission;
import br.com.moraes.prestadorservico.api.model.Person;
import br.com.moraes.prestadorservico.api.model.Profile;
import br.com.moraes.prestadorservico.api.model.User;
import br.com.moraes.prestadorservico.api.service.PermissionService;
import br.com.moraes.prestadorservico.api.service.ProfileService;
import br.com.moraes.prestadorservico.api.service.UserService;
import br.com.moraes.prestadorservico.api.util.DateUtil;

// @org.springframework.context.annotation.Profile({ "dev" })
@Configuration
public class Initialize {

    @Bean
    CommandLineRunner init(ProfileService profileService, PermissionService permissionService,
            UserService userService) {
        return args -> initRegisters(profileService, permissionService, userService);
    }

    private void initRegisters(ProfileService profileService, PermissionService permissionService,
            UserService userService) {
        if (userService.existsByUsername("root@root.com")) {
            return;
        }
        List<Permission> permissions = new LinkedList<>();
        List<Permission> permissionsAdm = new LinkedList<>();
        for (PermissionEnum permissionEnum : PermissionEnum.values()) {
            final Permission permission = savePermission(permissionService, permissionEnum.toString());
            permissions.add(permission);
            if (!PermissionEnum.ROLE_ROOT.equals(permissionEnum)) {
                permissionsAdm.add(permission);
            }
        }

        final Profile profile = saveProfile(profileService, "Root", permissions);
        final Profile profileAdm = saveProfile(profileService, "Administrador", permissionsAdm);

        userService.create(User.builder().username("root@root.com").password("123456").profile(profile)
                .person(Person.builder().name("Root").birth(DateUtil.getDateNowAdd(Calendar.YEAR, -25))
                        .cpf("13023092001")
                        .email("suleimanmoraes@gmail.com").build())
                .build());

        userService.create(User.builder().username("adm@adm.com").password("123456").profile(profileAdm)
                .person(Person.builder().name("Administrador").birth(DateUtil.getDateNowAdd(Calendar.YEAR, -25))
                        .cpf("13023092002")
                        .email("suleimanmoraes@gmail.com").build())
                .build());
    }

    private Profile saveProfile(ProfileService profileService, String name, List<Permission> permissions) {
        Profile profile = null;
        Profile findProfile = profileService.findTopByName(name);
        if (findProfile == null) {
            profile = profileService.save(Profile.builder()
                    .authorities(permissions)
                    .name(name)
                    .description(name)
                    .build());
        } else {
            profile = findProfile;
        }
        return profile;
    }

    private Permission savePermission(PermissionService permissionService, String permissionName) {
        Permission permission = null;
        Permission findPermission = permissionService.findTopByAuthority(permissionName);
        if (findPermission == null) {
            permission = new Permission();
            permission.setAuthority(permissionName);
            permission = permissionService.save(permission);
        } else {
            permission = findPermission;
        }
        return permission;
    }
}
