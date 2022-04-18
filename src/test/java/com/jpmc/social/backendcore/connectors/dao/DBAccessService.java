package com.jpmc.social.backendcore.connectors.dao;

import com.jpmc.social.backendcore.connectors.dto.Comment;
import com.jpmc.social.backendcore.connectors.dto.Post;
import com.jpmc.social.backendcore.connectors.dto.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DBAccessService {
    List<Comment> getCommentsFromDBServices();
    List<User> getUsersFromDBServices();
    List<Post> getPostsFromDBServices();
}
