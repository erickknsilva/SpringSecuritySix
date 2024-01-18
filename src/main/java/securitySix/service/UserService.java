package securitySix.service;

import securitySix.dto.UserRequest;
import securitySix.dto.UserResponse;

public interface UserService {

    UserResponse createdUser(UserRequest request) ;

}
