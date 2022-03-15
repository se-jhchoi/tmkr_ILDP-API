package se.app.customer.userInfoAgree;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class UserInfoAgreeResource extends EntityModel<UserInfoAgreeDto> {

    public UserInfoAgreeResource(UserInfoAgreeDto cust, Link... links) {
        super(cust, links);
    }
}
