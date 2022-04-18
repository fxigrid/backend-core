package com.jpmc.social.backendcore.connectors.utilities;

import com.github.javafaker.Faker;
import com.jpmc.social.backendcore.connectors.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class TestDataGenerator {

    @Autowired
    private Faker faker ;

    public int getRandomIntegerLessThan10() {
        Random random = new Random();
        return random.nextInt(10- 1) + 1;
    }

    public Comment getCommentVo(){
        Comment commentObject = new Comment();
        commentObject.setEmail(this.faker.internet().emailAddress());
        commentObject.setName(this.faker.name().fullName());
        commentObject.setPostId(this.faker.random().nextInt(this.getRandomIntegerLessThan10()));
        commentObject.setBody(this.faker.buffy().quotes());
        return  commentObject;
    }

    public Post getPostVO(){
        Post postObject = new Post() ;
        postObject.setBody(this.faker.buffy().quotes());
        postObject.setTitle(this.faker.book().title());
        postObject.setUserId(this.faker.random().nextInt(this.getRandomIntegerLessThan10()));
        return postObject;
    }

    public User getUserVo(){
        User userObject = new User() ;
        Address addressObject = new Address();
        Geo geoObject = new Geo();
        Company companyObject = new Company();

        userObject.setName(this.faker.name().fullName());
        userObject.setUsername(this.faker.name().username());
        userObject.setEmail(this.faker.internet().emailAddress());

        addressObject.setStreet(this.faker.address().streetName());
        addressObject.setSuite(this.faker.address().buildingNumber());
        addressObject.setCity(this.faker.address().city());
        addressObject.setZipcode(this.faker.address().zipCode());
        geoObject.setLat(this.faker.address().latitude());
        geoObject.setLng(this.faker.address().longitude());
        addressObject.setGeo(geoObject);

        userObject.setAddress(addressObject);
        userObject.setPhone(this.faker.phoneNumber().phoneNumber());
        userObject.setWebsite(this.faker.internet().domainName());

        companyObject.setName(this.faker.company().name());
        companyObject.setCatchPhrase(this.faker.company().catchPhrase());
        companyObject.setBs(this.faker.company().bs());
        userObject.setCompany(companyObject);

        return userObject;
    }
}
