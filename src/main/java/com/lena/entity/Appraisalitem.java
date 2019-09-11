package com.lena.entity;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName Appraisalitem
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/9/11 7:36
 * @Version 1.0
 */


@Entity
@Table
public class Appraisalitem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String kaohezhouqi;
    private String beikaohedanwei;
    private String kaohexiangmu;

    private String biaozhun;
    private String zhouqi;
    private String danwei;
    private Double mubiaozhi;

    private Double shijishi;
    private Double kaohejieguo;
    private String kaohedanwei;
    private String caozuofu;

    private String beizhu;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKaohezhouqi() {
        return kaohezhouqi;
    }

    public void setKaohezhouqi(String kaohezhouqi) {
        this.kaohezhouqi = kaohezhouqi;
    }

    public String getBeikaohedanwei() {
        return beikaohedanwei;
    }

    public void setBeikaohedanwei(String beikaohedanwei) {
        this.beikaohedanwei = beikaohedanwei;
    }

    public String getKaohexiangmu() {
        return kaohexiangmu;
    }

    public void setKaohexiangmu(String kaohexiangmu) {
        this.kaohexiangmu = kaohexiangmu;
    }

    public String getBiaozhun() {
        return biaozhun;
    }

    public void setBiaozhun(String biaozhun) {
        this.biaozhun = biaozhun;
    }

    public String getZhouqi() {
        return zhouqi;
    }

    public void setZhouqi(String zhouqi) {
        this.zhouqi = zhouqi;
    }

    public String getDanwei() {
        return danwei;
    }

    public void setDanwei(String danwei) {
        this.danwei = danwei;
    }

    public Double getMubiaozhi() {
        return mubiaozhi;
    }

    public void setMubiaozhi(Double mubiaozhi) {
        this.mubiaozhi = mubiaozhi;
    }

    public Double getShijishi() {
        return shijishi;
    }

    public void setShijishi(Double shijishi) {
        this.shijishi = shijishi;
    }

    public Double getKaohejieguo() {
        return kaohejieguo;
    }

    public void setKaohejieguo(Double kaohejieguo) {
        this.kaohejieguo = kaohejieguo;
    }

    public String getKaohedanwei() {
        return kaohedanwei;
    }

    public void setKaohedanwei(String kaohedanwei) {
        this.kaohedanwei = kaohedanwei;
    }

    public String getCaozuofu() {
        return caozuofu;
    }

    public void setCaozuofu(String caozuofu) {
        this.caozuofu = caozuofu;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    @Override
    public String toString() {
        return "Appraisalitem{" +
                "id=" + id +
                ", kaohezhouqi='" + kaohezhouqi + '\'' +
                ", beikaohedanwei='" + beikaohedanwei + '\'' +
                ", kaohexiangmu='" + kaohexiangmu + '\'' +
                ", biaozhun='" + biaozhun + '\'' +
                ", zhouqi='" + zhouqi + '\'' +
                ", danwei=" + danwei +
                ", mubiaozhi=" + mubiaozhi +
                ", shijishi=" + shijishi +
                ", kaohejieguo=" + kaohejieguo +
                ", kaohedanwei='" + kaohedanwei + '\'' +
                ", caozuofu='" + caozuofu + '\'' +
                ", beizhu='" + beizhu + '\'' +
                '}';
    }
}
