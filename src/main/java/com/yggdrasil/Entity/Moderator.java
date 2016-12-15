package com.yggdrasil.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created by Yggdrasil on 16/12/14.
 */
@Entity
@IdClass(ModeratorPK.class)
public class Moderator {
    @Id
    private String user_id;
    @Id
    private int layout_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getLayout_id() {
        return layout_id;
    }

    public void setLayout_id(int layout_id) {
        this.layout_id = layout_id;
    }
}
