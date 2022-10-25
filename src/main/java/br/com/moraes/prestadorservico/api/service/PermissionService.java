package br.com.moraes.prestadorservico.api.service;

import br.com.moraes.prestadorservico.api.interfaces.ICrudPatternService;
import br.com.moraes.prestadorservico.api.model.Permission;

public interface PermissionService extends ICrudPatternService<Permission> {

    Permission findTopByAuthority(String authority);
}
