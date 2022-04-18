package com.jpmc.social.backendcore.connectors.dao.daoImpl;

import com.jpmc.social.backendcore.connectors.dao.DBAccessDAO;
import com.jpmc.social.backendcore.connectors.dao.DBAccessService;
import com.jpmc.social.backendcore.connectors.dto.Comment;
import com.jpmc.social.backendcore.connectors.dto.Post;
import com.jpmc.social.backendcore.connectors.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component("jsonLayerService")
public class DBAccessServiceImpl implements DBAccessService {

    @Autowired
    @Qualifier("jsonLayerDB")
    DBAccessDAO dbAccessDAO;


    @Override
    public List<Comment> getCommentsFromDBServices() {
        try {
            return this.dbAccessDAO.getCommentsFromDAO();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getUsersFromDBServices() {
        try {
            return this.dbAccessDAO.getUsersFromDAO();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Post> getPostsFromDBServices() {
        try {
            return this.dbAccessDAO.getPostsFromDAO();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
