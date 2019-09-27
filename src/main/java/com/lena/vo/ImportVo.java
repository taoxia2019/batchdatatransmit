package com.lena.vo;

import com.lena.entity.Appraisalitem;

import java.util.List;

/**
 * @ClassName ImportVo
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/9/24 8:04
 * @Version 1.0
 */
public class ImportVo {
    private Integer code;
    private String msg;

    private List<Appraisalitem> data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Appraisalitem> getData() {
        return data;
    }

    public void setData(List<Appraisalitem> data) {
        this.data = data;
    }
}
