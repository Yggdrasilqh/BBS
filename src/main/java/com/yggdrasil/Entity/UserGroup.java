package com.yggdrasil.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Yggdrasil on 16/12/14.
 */
@Entity(name = "User_Group")
public class UserGroup {
    @Id
    private int id;

    @Column
    private String name;

    @Column
    private int acc_point_min;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAcc_point_min() {
        return acc_point_min;
    }

    public void setAcc_point_min(int acc_point_min) {
        this.acc_point_min = acc_point_min;
    }
}
