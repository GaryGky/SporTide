package com.hupu.service;

import com.hupu.dao.AdminMapper;
import com.hupu.pojo.Admin;

import java.util.List;

public class AdminServiceImpl extends ConstantService implements AdminService {
    private AdminMapper adminMapper;
    
    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }
    
    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }
    
    public AdminServiceImpl() {
    }
    
    public int createAdmin(int id, String name, String pwd) {
        return adminMapper.createAdmin(id, name, pwd);
    }
    
    public int updateAdminPwd(int id, String oldPwd, String newPwd) {
        if (oldPwd.equals(queryAdminPwdById(id))) {
            return adminMapper.updateAdminPwd(id, newPwd);
        } else {
            return ErrorCodeForPwd;
        }
    }
    
    public int updateAdminName(int id, String newName) {
        return adminMapper.updateAdminName(id, newName);
    }
    
    public List<Admin> queryAllAdmins() {
        return adminMapper.queryAllAdmins();
    }
    
    public String queryAdminPwdById(int id) {
        return adminMapper.queryAdminPwdById(id);
    }
    
    public Admin queryAdminById(int id) {
        return adminMapper.queryAdminById(id);
    }
    
    public int deleteAdminById(int id) {
        return adminMapper.deleteAdminById(id);
    }
}
