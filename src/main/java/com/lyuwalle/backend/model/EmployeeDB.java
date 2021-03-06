package com.lyuwalle.backend.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "employee")
public class EmployeeDB {
    /**
     * 员工编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 身份证号
     */
    @Column(name = "id_card")
    private String idCard;

    /**
     * 婚姻状况
     */
    private String wedlock;

    /**
     * 民族
     */
    @Column(name = "nation_id")
    private Integer nationId;

    /**
     * 籍贯
     */
    @Column(name = "native_place")
    private String nativePlace;

    /**
     * 政治面貌
     */
    @Column(name = "politic_id")
    private Integer politicId;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 所属部门
     */
    @Column(name = "department_id")
    private Integer departmentId;

    /**
     * 职称ID
     */
    @Column(name = "job_level_id")
    private Integer jobLevelId;

    /**
     * 职位ID
     */
    @Column(name = "pos_id")
    private Integer posId;

    /**
     * 聘用形式
     */
    @Column(name = "engage_form")
    private String engageForm;

    /**
     * 最高学历
     */
    @Column(name = "tiptop_degree")
    private String tiptopDegree;

    /**
     * 所属专业
     */
    private String specialty;

    /**
     * 毕业院校
     */
    private String school;

    /**
     * 入职日期
     */
    @Column(name = "begin_date")
    private Date beginDate;

    /**
     * 在职状态
     */
    @Column(name = "work_state")
    private String workState;

    /**
     * 工号
     */
    @Column(name = "work_id")
    private String workId;

    /**
     * 合同期限
     */
    @Column(name = "contract_term")
    private Double contractTerm;

    /**
     * 转正日期
     */
    @Column(name = "conversion_time")
    private Date conversionTime;

    /**
     * 离职日期
     */
    @Column(name = "not_work_date")
    private Date notWorkDate;

    /**
     * 合同起始日期
     */
    @Column(name = "begin_contract")
    private Date beginContract;

    /**
     * 合同终止日期
     */
    @Column(name = "end_contract")
    private Date endContract;

    /**
     * 工龄
     */
    @Column(name = "work_age")
    private Integer workAge;

    /**
     * 获取员工编号
     *
     * @return id - 员工编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置员工编号
     *
     * @param id 员工编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取员工姓名
     *
     * @return name - 员工姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置员工姓名
     *
     * @param name 员工姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取性别
     *
     * @return gender - 性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别
     *
     * @param gender 性别
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取出生日期
     *
     * @return birthday - 出生日期
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置出生日期
     *
     * @param birthday 出生日期
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取身份证号
     *
     * @return id_card - 身份证号
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置身份证号
     *
     * @param idCard 身份证号
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * 获取婚姻状况
     *
     * @return wedlock - 婚姻状况
     */
    public String getWedlock() {
        return wedlock;
    }

    /**
     * 设置婚姻状况
     *
     * @param wedlock 婚姻状况
     */
    public void setWedlock(String wedlock) {
        this.wedlock = wedlock;
    }

    /**
     * 获取民族
     *
     * @return nation_id - 民族
     */
    public Integer getNationId() {
        return nationId;
    }

    /**
     * 设置民族
     *
     * @param nationId 民族
     */
    public void setNationId(Integer nationId) {
        this.nationId = nationId;
    }

    /**
     * 获取籍贯
     *
     * @return native_place - 籍贯
     */
    public String getNativePlace() {
        return nativePlace;
    }

    /**
     * 设置籍贯
     *
     * @param nativePlace 籍贯
     */
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    /**
     * 获取政治面貌
     *
     * @return politic_id - 政治面貌
     */
    public Integer getPoliticId() {
        return politicId;
    }

    /**
     * 设置政治面貌
     *
     * @param politicId 政治面貌
     */
    public void setPoliticId(Integer politicId) {
        this.politicId = politicId;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取电话号码
     *
     * @return phone - 电话号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话号码
     *
     * @param phone 电话号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取联系地址
     *
     * @return address - 联系地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置联系地址
     *
     * @param address 联系地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取所属部门
     *
     * @return department_id - 所属部门
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * 设置所属部门
     *
     * @param departmentId 所属部门
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 获取职称ID
     *
     * @return job_level_id - 职称ID
     */
    public Integer getJobLevelId() {
        return jobLevelId;
    }

    /**
     * 设置职称ID
     *
     * @param jobLevelId 职称ID
     */
    public void setJobLevelId(Integer jobLevelId) {
        this.jobLevelId = jobLevelId;
    }

    /**
     * 获取职位ID
     *
     * @return pos_id - 职位ID
     */
    public Integer getPosId() {
        return posId;
    }

    /**
     * 设置职位ID
     *
     * @param posId 职位ID
     */
    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    /**
     * 获取聘用形式
     *
     * @return engage_form - 聘用形式
     */
    public String getEngageForm() {
        return engageForm;
    }

    /**
     * 设置聘用形式
     *
     * @param engageForm 聘用形式
     */
    public void setEngageForm(String engageForm) {
        this.engageForm = engageForm;
    }

    /**
     * 获取最高学历
     *
     * @return tiptop_degree - 最高学历
     */
    public String getTiptopDegree() {
        return tiptopDegree;
    }

    /**
     * 设置最高学历
     *
     * @param tiptopDegree 最高学历
     */
    public void setTiptopDegree(String tiptopDegree) {
        this.tiptopDegree = tiptopDegree;
    }

    /**
     * 获取所属专业
     *
     * @return specialty - 所属专业
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * 设置所属专业
     *
     * @param specialty 所属专业
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    /**
     * 获取毕业院校
     *
     * @return school - 毕业院校
     */
    public String getSchool() {
        return school;
    }

    /**
     * 设置毕业院校
     *
     * @param school 毕业院校
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * 获取入职日期
     *
     * @return begin_date - 入职日期
     */
    public Date getBeginDate() {
        return beginDate;
    }

    /**
     * 设置入职日期
     *
     * @param beginDate 入职日期
     */
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    /**
     * 获取在职状态
     *
     * @return work_state - 在职状态
     */
    public String getWorkState() {
        return workState;
    }

    /**
     * 设置在职状态
     *
     * @param workState 在职状态
     */
    public void setWorkState(String workState) {
        this.workState = workState;
    }

    /**
     * 获取工号
     *
     * @return work_id - 工号
     */
    public String getWorkId() {
        return workId;
    }

    /**
     * 设置工号
     *
     * @param workId 工号
     */
    public void setWorkId(String workId) {
        this.workId = workId;
    }

    /**
     * 获取合同期限
     *
     * @return contract_term - 合同期限
     */
    public Double getContractTerm() {
        return contractTerm;
    }

    /**
     * 设置合同期限
     *
     * @param contractTerm 合同期限
     */
    public void setContractTerm(Double contractTerm) {
        this.contractTerm = contractTerm;
    }

    /**
     * 获取转正日期
     *
     * @return conversion_time - 转正日期
     */
    public Date getConversionTime() {
        return conversionTime;
    }

    /**
     * 设置转正日期
     *
     * @param conversionTime 转正日期
     */
    public void setConversionTime(Date conversionTime) {
        this.conversionTime = conversionTime;
    }

    /**
     * 获取离职日期
     *
     * @return not_work_date - 离职日期
     */
    public Date getNotWorkDate() {
        return notWorkDate;
    }

    /**
     * 设置离职日期
     *
     * @param notWorkDate 离职日期
     */
    public void setNotWorkDate(Date notWorkDate) {
        this.notWorkDate = notWorkDate;
    }

    /**
     * 获取合同起始日期
     *
     * @return begin_contract - 合同起始日期
     */
    public Date getBeginContract() {
        return beginContract;
    }

    /**
     * 设置合同起始日期
     *
     * @param beginContract 合同起始日期
     */
    public void setBeginContract(Date beginContract) {
        this.beginContract = beginContract;
    }

    /**
     * 获取合同终止日期
     *
     * @return end_contract - 合同终止日期
     */
    public Date getEndContract() {
        return endContract;
    }

    /**
     * 设置合同终止日期
     *
     * @param endContract 合同终止日期
     */
    public void setEndContract(Date endContract) {
        this.endContract = endContract;
    }

    /**
     * 获取工龄
     *
     * @return work_age - 工龄
     */
    public Integer getWorkAge() {
        return workAge;
    }

    /**
     * 设置工龄
     *
     * @param workAge 工龄
     */
    public void setWorkAge(Integer workAge) {
        this.workAge = workAge;
    }
}