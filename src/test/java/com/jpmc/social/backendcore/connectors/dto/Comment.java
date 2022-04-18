package com.jpmc.social.backendcore.connectors.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Comment {

    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    //TODO equals() and hashCode() are ignoring comment:id values now, to facilitate data comparison , fix after persistence layer or data persistence is applied
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return postId == comment.postId && Objects.equal(name, comment.name) && Objects.equal(email, comment.email) && Objects.equal(body, comment.body);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(postId,  name, email, body);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "postId=" + postId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
