package com.hupu.pojo;

public class VersionInfo {
    
    
    //版本号
    
    private Integer versionCode;
    
    private String versionName;
    //是否强制更新 
    private Object forceUpdate;
    //版本的url连接 
    private String updateUrl;
    //更新信息
    
    private String updateInfo;
    
    @Override
    public String toString() {
        return "VersionInfo{" +
                "versionCode=" + versionCode +
                ", versionName='" + versionName + '\'' +
                ", forceUpdate=" + forceUpdate +
                ", updateUrl='" + updateUrl + '\'' +
                ", updateInfo='" + updateInfo + '\'' +
                '}';
    }
    
    public VersionInfo() {
    }
    
    public VersionInfo(Integer versionCode, String versionName, Object forceUpdate, String updateUrl, String updateInfo) {
        this.versionCode = versionCode;
        this.versionName = versionName;
        this.forceUpdate = forceUpdate;
        this.updateUrl = updateUrl;
        this.updateInfo = updateInfo;
    }
    
    public Integer getVersionCode() {
        return versionCode;
    }
    
    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }
    
    public String getVersionName() {
        return versionName;
    }
    
    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }
    
    public Object getForceUpdate() {
        return forceUpdate;
    }
    
    public void setForceUpdate(Object forceUpdate) {
        this.forceUpdate = forceUpdate;
    }
    
    public String getUpdateUrl() {
        return updateUrl;
    }
    
    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }
    
    public String getUpdateInfo() {
        return updateInfo;
    }
    
    public void setUpdateInfo(String updateInfo) {
        this.updateInfo = updateInfo;
    }
    
}