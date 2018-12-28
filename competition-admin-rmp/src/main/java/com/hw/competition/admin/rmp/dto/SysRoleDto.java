package com.hw.competition.admin.rmp.dto;


import com.hw.competition.admin.rmp.model.SysRole;

import java.util.List;

public class SysRoleDto extends SysRole {
    private List<SysModuleCategoryDto> sysModuleCategoryDtoList;

    public List<SysModuleCategoryDto> getSysModuleCategoryDtoList() {
        return sysModuleCategoryDtoList;
    }

    public void setSysModuleCategoryDtoList(List<SysModuleCategoryDto> sysModuleCategoryDtoList) {
        this.sysModuleCategoryDtoList = sysModuleCategoryDtoList;
    }
}
