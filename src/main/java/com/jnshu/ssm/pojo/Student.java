package com.jnshu.ssm.pojo;

import com.jnshu.ssm.utils.DateUtil;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author : baiyunzhong
 * created time : 2019/7/22
 */
public class Student {
    //主键ID
    private Integer ID;
    @NotBlank(message="{stu.notnull}")
    private String onlineId;
    @NotBlank(message="{stu.notnull}")
    @Size(min=2,max=20,message="{stu.sizelimit}")
    private String name;
    private String qq;
    private String carrer;
    private Date enterDate;
    private String school;
    private String dailyLinks;
    private String slogan;
    private String senior;
    private String source;
    private Long createAt;
    private Long updateAt;
    private Integer page;

    private String enterDateString;
    private String createAtString;
    private String updateAtString;

    public Integer getID() {
    return ID;
}

    public void setID(Integer ID) {
    this.ID = ID;
}

    public String getOnlineId() {
    return onlineId;
}

    public void setOnlineId(String onlineId) {
    this.onlineId = onlineId;
}

    public String getName() {
    return name;
}

    public void setName(String name) {
    this.name = name;
}

    public String getQq() {
    return qq;
}

    public void setQq(String qq) {
    this.qq = qq;
}

    public String getCarrer() {
    return carrer;
}

    public void setCarrer(String carrer) {
    this.carrer = carrer;
}

    public Date getEnterDate() {
    return enterDate;
}

    public void setEnterDate(Date enterDate) {
    this.enterDate = enterDate;
}

    public String getSchool() {
    return school;
}

    public void setSchool(String school) {
    this.school = school;
}

    public String getDailyLinks() {
    return dailyLinks;
}

    public void setDailyLinks(String dailyLinks) {
    this.dailyLinks = dailyLinks;
}

    public String getSlogan() {
    return slogan;
}

    public void setSlogan(String slogan) {
    this.slogan = slogan;
}

    public String getSenior() {
    return senior;
}

    public void setSenior(String senior) {
    this.senior = senior;
}

    public String getSource() {
    return source;
}

    public void setSource(String source) {
    this.source = source;
}

    public Long getCreateAt() {
    return createAt;
}

    public void setCreateAt(Long createAt) {
    this.createAt = createAt;
}

    public Long getUpdateAt() {
    return updateAt;
}

    public void setUpdateAt(Long updateAt) {
    this.updateAt = updateAt;
}

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getEnterDateString() {
        return DateUtil.dateToString(enterDate);
    }

    public String getCreateAtString() {
        return DateUtil.longToString(createAt);
    }

    public String getUpdateAtString() {
        return DateUtil.longToString(updateAt);
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", onlineId='" + onlineId + '\'' +
                ", name='" + name + '\'' +
                ", qq='" + qq + '\'' +
                ", carrer='" + carrer + '\'' +
                ", enterDate=" + enterDate +
                ", school='" + school + '\'' +
                ", dailyLinks='" + dailyLinks + '\'' +
                ", slogan='" + slogan + '\'' +
                ", senior='" + senior + '\'' +
                ", source='" + source + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", page=" + page+
                '}';
    }
}
