package com.yggdrasil.Entity;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Yggdrasil on 16/12/8.
 */
@Entity(name = "Users") //指定表名
@DynamicInsert     //可以让为空的属性使用默认值
public class User {
    @Id
    private String id;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String sex;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String acc_point;

    @Column
    private String group_id;

    @Column
    private String authority_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAcc_point() {
        return acc_point;
    }

    public void setAcc_point(String acc_point) {
        this.acc_point = acc_point;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getAuthority_id() {
        return authority_id;
    }

    public void setAuthority_id(String authority_id) {
        this.authority_id = authority_id;
    }
}
