package com.jpmc.social.backendcore.connectors.dao;

import com.jpmc.social.backendcore.connectors.dto.Comment;
import com.jpmc.social.backendcore.connectors.dto.Post;
import com.jpmc.social.backendcore.connectors.dto.User;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public interface DBAccessDAO {
     List<Comment> getCommentsFromDAO() throws IOException;
     List<User> getUsersFromDAO() throws IOException;
     List<Post> getPostsFromDAO() throws IOException;
}
