package com.hupu.controller;

import com.hupu.pojo.VersionInfo;
import com.hupu.service.Impl.VersionInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/version")
public class VersionController {
    @Autowired
    private VersionInfoServiceImpl versionInfoService;
    
    @RequestMapping("/addVersion")
    public int addVersionInfo(@RequestBody VersionInfo versionInfo) {
        return versionInfoService.insert(versionInfo);
    }
    
    @RequestMapping("/getLatestVersion")
    public VersionInfo getLatestVersion() {
        return versionInfoService.getMaxVersionCode();
    }
    
    @RequestMapping("/update")
    public int updateVersion(VersionInfo versionInfo) {
        return versionInfoService.update(versionInfo);
    }
}
