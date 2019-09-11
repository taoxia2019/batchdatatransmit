package com.lena.vo;

import com.lena.entity.Appraisalitem;


import java.util.List;

/**
 * @ClassName AppraisalVo
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/9/11 11:12
 * @Version 1.0
 */

public class AppraisalVo {
    private List<Appraisalitem> apps;

    public List<Appraisalitem> getApps() {
        return apps;
    }

    public void setApps(List<Appraisalitem> apps) {
        this.apps = apps;
    }
}
