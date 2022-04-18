package com.jpmc.social.backendcore.connectors.utilities;

import com.jpmc.social.backendcore.connectors.dao.DBAccessService;
import com.jpmc.social.backendcore.connectors.dto.Comment;
import com.jpmc.social.backendcore.connectors.dto.Post;
import com.jpmc.social.backendcore.connectors.dto.User;
import com.jpmc.social.backendcore.restUtilities.RestConfigHelper;
import com.jpmc.social.backendcore.restUtilities.RestServices;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResponseValidationHelper {

    @Autowired
    private RestServices restServices;
    @Autowired
    private RestConfigHelper restConfigHelper;
    @Autowired
    private TestDataRepository testDataRepository;
    @Autowired
    @Qualifier("jsonLayerService")
    private DBAccessService dbAccessService;

    /**
     * Validate API Response with DB
     */
    public void validate_APIResponseDataValues_MatchesWith_DBDataValues() {

        boolean isResponseAndDBValuesSame = false;
        if (this.restConfigHelper.getEndPoint().contains("comments")) {
            List<Comment> lsCommentsService = Arrays.asList(this.testDataRepository.getResponse().getBody().as(Comment[].class));
            List<Comment> lsCommentsDb = this.dbAccessService.getCommentsFromDBServices();
            isResponseAndDBValuesSame = lsCommentsService.equals(lsCommentsDb);
        } else if (this.restConfigHelper.getEndPoint().contains("posts")) {
            List<Post> lsPostService = Arrays.asList(this.testDataRepository.getResponse().getBody().as(Post[].class));
            List<Post> lsPostsDb = this.dbAccessService.getPostsFromDBServices();
            isResponseAndDBValuesSame = lsPostService.equals(lsPostsDb);
        } else if (this.restConfigHelper.getEndPoint().contains("users")) {
            List<User> lsUsersService = Arrays.asList(this.testDataRepository.getResponse().getBody().as(User[].class));
            List<User> lsUsersDb = this.dbAccessService.getUsersFromDBServices();
            isResponseAndDBValuesSame = lsUsersService.equals(lsUsersDb);
        }
        Assert.assertTrue("Response and DB values are not same", isResponseAndDBValuesSame);
    }

    /**
     * Validate API Response with DB with filters
     */
    public void validate_APIResponseDataValues_MatchesWith_DBValues_FilteredByRandomIndex() {

        boolean isResponseAndDBValuesSame = false;
        if (this.restConfigHelper.getEndPoint().contains("comments")) {
            Comment commentService = this.testDataRepository.getResponse().getBody().as(Comment.class);
            Comment CommentDb = this.dbAccessService.getCommentsFromDBServices()
                    .stream().filter(commentVo -> commentVo.getId() == this.testDataRepository.getRandomIndex())
                    .findFirst().orElse(new Comment());
            isResponseAndDBValuesSame = commentService.equals(CommentDb);

        } else if (this.restConfigHelper.getEndPoint().contains("posts")) {
            Post postService = this.testDataRepository.getResponse().getBody().as(Post.class);
            Post postDb = this.dbAccessService.getPostsFromDBServices()
                    .stream().filter(postVo -> postVo.getId() == this.testDataRepository.getRandomIndex())
                    .findFirst().orElse(new Post());
            isResponseAndDBValuesSame = postService.equals(postDb);

        } else if (this.restConfigHelper.getEndPoint().contains("users")) {
            User userService = this.testDataRepository.getResponse().getBody().as(User.class);
            User userDb = this.dbAccessService.getUsersFromDBServices()
                    .stream().filter(userVo -> userVo.getId() == this.testDataRepository.getRandomIndex())
                    .findFirst().orElse(new User());
            isResponseAndDBValuesSame = userService.equals(userDb);

        }
        Assert.assertTrue("Response and DB values (filtered by random index)  are not same", isResponseAndDBValuesSame);
    }

    /**
     * Validate API Response with API Request Body
     */
    public void validate_APIResponseDataValues_MatchesWith_APIRequestDataValues() {

        boolean isResponseAndRequestValuesSame = false;

        if (this.restConfigHelper.getEndPoint().contains("comments")) {
            Comment commentService = this.testDataRepository.getResponse().getBody().as(Comment.class);
            Comment commentsPostCall = this.testDataRepository.getCommentVo();
            isResponseAndRequestValuesSame = commentService.equals(commentsPostCall);
        } else if (this.restConfigHelper.getEndPoint().contains("posts")) {
            Post postService = this.testDataRepository.getResponse().getBody().as(Post.class);
            Post postPostCall = this.testDataRepository.getPostVo();
            isResponseAndRequestValuesSame = postService.equals(postPostCall);
        } else if (this.restConfigHelper.getEndPoint().contains("users")) {

            User userService = this.testDataRepository.getResponse().getBody().as(User.class);
            User userPostCall = this.testDataRepository.getUserVo();
            isResponseAndRequestValuesSame = userService.equals(userPostCall);

        }

        Assert.assertTrue("Response and Request values   are not same", isResponseAndRequestValuesSame);
    }

    /**
     * Validate API Response filtered with Query Params with DB filtered with same Query params
     */
    public void validate_ListOfQualifiedResources_In_API_Matches_DB_FilteredBySame_RandomIndex() {

        boolean isResponseAndDBValuesSame = false;
        if (this.restConfigHelper.getEndPoint().contains("comments")) {
            List<Comment> lsCommentsService = Arrays.asList(this.testDataRepository.getResponse().getBody().as(Comment[].class));
            List<Comment> lsCommentsDb = this.dbAccessService.getCommentsFromDBServices()
                    .stream().filter(commentVo -> commentVo.getPostId() == this.testDataRepository.getRandomIndex())
                    .collect(Collectors.toList());
            isResponseAndDBValuesSame = lsCommentsService.equals(lsCommentsDb);
        } else if (this.restConfigHelper.getEndPoint().contains("posts")) {

            List<Post> lsPostService = Arrays.asList(this.testDataRepository.getResponse().getBody().as(Post[].class));
            List<Post> lsPostsDb = this.dbAccessService.getPostsFromDBServices()
                    .stream().filter(postVo -> postVo.getUserId() == this.testDataRepository.getRandomIndex())
                    .collect(Collectors.toList());
            isResponseAndDBValuesSame = lsPostService.equals(lsPostsDb);

        }
        else if (this.restConfigHelper.getEndPoint().contains("users")) {

            List<User> lsUserService = Arrays.asList(this.testDataRepository.getResponse().getBody().as(User[].class));
            List<User> lsUserDb = this.dbAccessService.getUsersFromDBServices()
                    .stream().filter(userVo -> userVo.getId() == this.testDataRepository.getRandomIndex())
                    .collect(Collectors.toList());
            isResponseAndDBValuesSame = lsUserService.equals(lsUserDb);

        }

        Assert.assertTrue("Response and DB values are not same", isResponseAndDBValuesSame);
    }

    /**
     * Validate API Response are  empty for Invalid query params
     */
    public void validate_responseData_list_matches_flag_passed(Boolean isResponseBodyEmpty) {
        List<Object> lsServiceList = new ArrayList<>() ;
        if (this.restConfigHelper.getEndPoint().contains("comments")) {
            lsServiceList = Arrays.asList(this.testDataRepository.getResponse().getBody().as(Comment[].class));
        } else if (this.restConfigHelper.getEndPoint().contains("posts")) {
            lsServiceList = Arrays.asList(this.testDataRepository.getResponse().getBody().as(Post[].class));
        } else if (this.restConfigHelper.getEndPoint().contains("users")) {
            lsServiceList = Arrays.asList(this.testDataRepository.getResponse().getBody().as(User[].class));
        }
        Assert.assertEquals("Assertion Failed : isResponseBodyEmpty Flag Validation", isResponseBodyEmpty, lsServiceList.isEmpty());
    }

}
