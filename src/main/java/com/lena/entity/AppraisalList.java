package com.lena.entity;


import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName Appraisalitem
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/9/11 7:36
 * @Version 1.0
 */

//考核项目初始化表
@Entity
@Table
public class AppraisalList implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //月份
    private String kaoheyuefen;
    //部门分厂
    private String beikaohedanwei;
    //项目
    private String kaohexiangmu;
    //标准
    private String biaozhun;
    //周期
    private String zhouqi;
    //单位
    private String danwei;
    //目标值
    private Double mubiaozhi;
    //实际值
    private Double shijishi;
    //考核结果
    private Double kaohejieguo;
    //考核单位
    private String kaohedanwei;
    //操作符
    private String caozuofu;
    //备注
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private String beizhu;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKaoheyuefen() {
        return kaoheyuefen;
    }

    public void setKaoheyuefen(String kaoheyuefen) {
        this.kaoheyuefen = kaoheyuefen;
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
                ", kaohezhouqi='" + kaoheyuefen + '\'' +
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
