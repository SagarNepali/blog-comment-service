package edu.mum.cs544.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank
    private String message;
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date date;
    @NotNull
    private Integer userId;
    @NotNull
    private Integer postId;

    public Comment() {
    }

    public Comment(String message, Date date, Integer userId, Integer postId) {
        this.message = message;
        this.date = date;
        this.userId = userId;
        this.postId = postId;
    }

    public Integer getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

}
