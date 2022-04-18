package com.jpmc.social.backendcore.connectors.utilities;

import com.jpmc.social.backendcore.connectors.dto.Comment;
import com.jpmc.social.backendcore.connectors.dto.Post;
import com.jpmc.social.backendcore.connectors.dto.User;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.springframework.stereotype.Component;

@Component
public class TestDataRepository {

    private ResponseOptions<Response> response;
    private int randomIndex ;
    private Comment commentVo;
    private Post postVo;
    private User userVo;

    public ResponseOptions<Response> getResponse() {
        return response;
    }

    public void setResponse(ResponseOptions<Response> response) {
        this.response = response;
    }

    public int getRandomIndex() {
        return randomIndex;
    }

    public void setRandomIndex(int randomIndex) {
        this.randomIndex = randomIndex;
    }

    public Comment getCommentVo() {
        return commentVo;
    }

    public void setCommentVo(Comment commentVo) {
        this.commentVo = commentVo;
    }

    public Post getPostVo() {
        return postVo;
    }

    public void setPostVo(Post postVo) {
        this.postVo = postVo;
    }

    public User getUserVo() {
        return userVo;
    }

    public void setUserVo(User userVo) {
        this.userVo = userVo;
    }

}
