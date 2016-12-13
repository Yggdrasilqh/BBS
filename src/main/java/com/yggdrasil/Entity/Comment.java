package com.yggdrasil.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by chenq on 2016/12/8,008.
 */
@Entity
public class Comment {
    @Id
    private int id;

    @Column
    private String content;
    @Column
    private String create_date;
    @Column
    private int post_id;
    @Column
    private String create_user_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreate_data() {
        return create_date;
    }

    public void setCreate_data(String create_data) {
        this.create_date = create_data;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getCreate_user_id() {
        return create_user_id;
    }

    public void setCreate_user_id(String create_user_id) {
        this.create_user_id = create_user_id;
    }
}
