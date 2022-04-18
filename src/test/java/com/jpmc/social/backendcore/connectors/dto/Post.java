package com.jpmc.social.backendcore.connectors.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Post {
    private int userId;
    private int id;
    private String title;
    private String body;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    //TODO equals() and hashCode() are ignoring post:id values now, to facilitate comparison  data comparison , fix after persistence layer or data persistence is applied
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return userId == post.userId  && Objects.equal(title, post.title) && Objects.equal(body, post.body);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userId, title, body);
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
