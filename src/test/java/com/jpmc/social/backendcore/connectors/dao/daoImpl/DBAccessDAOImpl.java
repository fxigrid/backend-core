package com.jpmc.social.backendcore.connectors.dao.daoImpl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpmc.social.backendcore.connectors.dao.DBAccessDAO;
import com.jpmc.social.backendcore.connectors.dto.Comment;
import com.jpmc.social.backendcore.connectors.dto.Post;
import com.jpmc.social.backendcore.connectors.dto.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component("jsonLayerDB")
public class DBAccessDAOImpl implements DBAccessDAO {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${db_values_comments}")
    private String db_values_comments;
    @Value("${db_values_users}")
    private String db_values_users;
    @Value("${db_values_posts}")
    private String db_values_posts;


    @Override
    public List<Comment> getCommentsFromDAO() throws IOException {
        return this.objectMapper.readValue(new File(db_values_comments), new TypeReference<>() {
        });
    }

    @Override
    public List<User> getUsersFromDAO() throws IOException {
        return this.objectMapper.readValue(new File(db_values_users), new TypeReference<>() {
        });
    }

    @Override
    public List<Post> getPostsFromDAO() throws IOException {
        return this.objectMapper.readValue(new File(db_values_posts), new TypeReference<>() {
        });
    }
}
