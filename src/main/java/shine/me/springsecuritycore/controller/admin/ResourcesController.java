package shine.me.springsecuritycore.controller.admin;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import shine.me.springsecuritycore.domain.dto.ResourcesDto;
import shine.me.springsecuritycore.domain.entity.Resources;
import shine.me.springsecuritycore.domain.entity.Role;
import shine.me.springsecuritycore.repository.RoleRepository;
import shine.me.springsecuritycore.security.metadatasource.UrlFilterInvocationSecurityMetadataSource;
import shine.me.springsecuritycore.service.ResourcesService;
import shine.me.springsecuritycore.service.RoleService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Controller
public class ResourcesController {

    private final ResourcesService resourcesService;
    private final RoleRepository roleRepository;
    private final RoleService roleService;
    private final UrlFilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;

    @GetMapping(value = "/admin/resources")
    public String getResources(Model model) throws Exception {

        List<Resources> resources = resourcesService.getResources();
        model.addAttribute("resources", resources);

        return "admin/resource/list";
    }

    @PostMapping(value = "/admin/resources")
    public String createResources(ResourcesDto resourcesDto) throws Exception {

        ModelMapper modelMapper = new ModelMapper();
        Role role = roleRepository.findByRoleName(resourcesDto.getRoleName());
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        Resources resources = modelMapper.map(resourcesDto, Resources.class);
        resources.setRoleSet(roles);

        resourcesService.createResources(resources);
        filterInvocationSecurityMetadataSource.reload();

        return "redirect:/admin/resources";
    }

    @GetMapping(value = "/admin/resources/register")
    public String viewRoles(Model model) throws Exception {

        List<Role> roleList = roleService.getRoles();
        model.addAttribute("roleList", roleList);

        ResourcesDto resources = new ResourcesDto();
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(new Role());
        resources.setRoleSet(roleSet);
        model.addAttribute("resources", resources);

        return "admin/resource/detail";
    }

    @GetMapping(value = "/admin/resources/{id}")
    public String getResources(@PathVariable String id, Model model) throws Exception {

        List<Role> roleList = roleService.getRoles();
        model.addAttribute("roleList", roleList);
        Resources resources = resourcesService.getResources(Long.valueOf(id));

        ModelMapper modelMapper = new ModelMapper();
        ResourcesDto resourcesDto = modelMapper.map(resources, ResourcesDto.class);
        model.addAttribute("resources", resourcesDto);

        return "admin/resource/detail";
    }

    @GetMapping(value = "/admin/resources/delete/{id}")
    public String removeResources(@PathVariable String id, Model model) throws Exception {

        Resources resources = resourcesService.getResources(Long.valueOf(id));
        resourcesService.deleteResources(Long.valueOf(id));
        filterInvocationSecurityMetadataSource.reload();

        return "redirect:/admin/resources";
    }
}
