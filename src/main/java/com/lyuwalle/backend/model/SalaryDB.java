package com.lyuwalle.backend.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "salary")
public class SalaryDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 基本工资
     */
    @Column(name = "basic_salary")
    private Integer basicSalary;

    /**
     * 奖金
     */
    private Integer bonus;

    /**
     * 午餐补助
     */
    @Column(name = "lunch_salary")
    private Integer lunchSalary;

    /**
     * 交通补助
     */
    @Column(name = "traffic_salary")
    private Integer trafficSalary;

    /**
     * 应发工资
     */
    @Column(name = "all_salary")
    private Integer allSalary;

    /**
     * 养老金基数
     */
    @Column(name = "pension_base")
    private Integer pensionBase;

    /**
     * 养老金比率
     */
    @Column(name = "pension_per")
    private Float pensionPer;

    /**
     * 启用时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 医疗基数
     */
    @Column(name = "medical_base")
    private Integer medicalBase;

    /**
     * 医疗保险比率
     */
    @Column(name = "medical_per")
    private Float medicalPer;

    /**
     * 公积金基数
     */
    @Column(name = "accumulation_fund_base")
    private Integer accumulationFundBase;

    /**
     * 公积金比率
     */
    @Column(name = "accumulation_fund_per")
    private Float accumulationFundPer;

    private String name;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取基本工资
     *
     * @return basic_salary - 基本工资
     */
    public Integer getBasicSalary() {
        return basicSalary;
    }

    /**
     * 设置基本工资
     *
     * @param basicSalary 基本工资
     */
    public void setBasicSalary(Integer basicSalary) {
        this.basicSalary = basicSalary;
    }

    /**
     * 获取奖金
     *
     * @return bonus - 奖金
     */
    public Integer getBonus() {
        return bonus;
    }

    /**
     * 设置奖金
     *
     * @param bonus 奖金
     */
    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    /**
     * 获取午餐补助
     *
     * @return lunch_salary - 午餐补助
     */
    public Integer getLunchSalary() {
        return lunchSalary;
    }

    /**
     * 设置午餐补助
     *
     * @param lunchSalary 午餐补助
     */
    public void setLunchSalary(Integer lunchSalary) {
        this.lunchSalary = lunchSalary;
    }

    /**
     * 获取交通补助
     *
     * @return traffic_salary - 交通补助
     */
    public Integer getTrafficSalary() {
        return trafficSalary;
    }

    /**
     * 设置交通补助
     *
     * @param trafficSalary 交通补助
     */
    public void setTrafficSalary(Integer trafficSalary) {
        this.trafficSalary = trafficSalary;
    }

    /**
     * 获取应发工资
     *
     * @return all_salary - 应发工资
     */
    public Integer getAllSalary() {
        return allSalary;
    }

    /**
     * 设置应发工资
     *
     * @param allSalary 应发工资
     */
    public void setAllSalary(Integer allSalary) {
        this.allSalary = allSalary;
    }

    /**
     * 获取养老金基数
     *
     * @return pension_base - 养老金基数
     */
    public Integer getPensionBase() {
        return pensionBase;
    }

    /**
     * 设置养老金基数
     *
     * @param pensionBase 养老金基数
     */
    public void setPensionBase(Integer pensionBase) {
        this.pensionBase = pensionBase;
    }

    /**
     * 获取养老金比率
     *
     * @return pension_per - 养老金比率
     */
    public Float getPensionPer() {
        return pensionPer;
    }

    /**
     * 设置养老金比率
     *
     * @param pensionPer 养老金比率
     */
    public void setPensionPer(Float pensionPer) {
        this.pensionPer = pensionPer;
    }

    /**
     * 获取启用时间
     *
     * @return create_date - 启用时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置启用时间
     *
     * @param createDate 启用时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取医疗基数
     *
     * @return medical_base - 医疗基数
     */
    public Integer getMedicalBase() {
        return medicalBase;
    }

    /**
     * 设置医疗基数
     *
     * @param medicalBase 医疗基数
     */
    public void setMedicalBase(Integer medicalBase) {
        this.medicalBase = medicalBase;
    }

    /**
     * 获取医疗保险比率
     *
     * @return medical_per - 医疗保险比率
     */
    public Float getMedicalPer() {
        return medicalPer;
    }

    /**
     * 设置医疗保险比率
     *
     * @param medicalPer 医疗保险比率
     */
    public void setMedicalPer(Float medicalPer) {
        this.medicalPer = medicalPer;
    }

    /**
     * 获取公积金基数
     *
     * @return accumulation_fund_base - 公积金基数
     */
    public Integer getAccumulationFundBase() {
        return accumulationFundBase;
    }

    /**
     * 设置公积金基数
     *
     * @param accumulationFundBase 公积金基数
     */
    public void setAccumulationFundBase(Integer accumulationFundBase) {
        this.accumulationFundBase = accumulationFundBase;
    }

    /**
     * 获取公积金比率
     *
     * @return accumulation_fund_per - 公积金比率
     */
    public Float getAccumulationFundPer() {
        return accumulationFundPer;
    }

    /**
     * 设置公积金比率
     *
     * @param accumulationFundPer 公积金比率
     */
    public void setAccumulationFundPer(Float accumulationFundPer) {
        this.accumulationFundPer = accumulationFundPer;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}