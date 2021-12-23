package com.light.mng.controller;

import com.light.mng.api.BandInfoClient;
import com.light.mng.entity.BandInfo;
import com.light.mng.utils.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BandInfoController {

    @Autowired
    BandInfoClient bandInfoClient;

    @PostMapping("/bandInfo")
    public Result insert(@RequestBody BandInfo bandInfo){
        return bandInfoClient.insert(bandInfo);
    }





}
