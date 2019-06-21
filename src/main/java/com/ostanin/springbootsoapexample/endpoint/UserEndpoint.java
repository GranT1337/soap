package com.ostanin.springbootsoapexample.endpoint;

import com.ostanin.spring.*;
import com.ostanin.springbootsoapexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

    @Autowired
    private UserService userService;

    @PayloadRoot(namespace = "http://ostanin.com/spring",
            localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        response.setUser(userService.getUsers(request.getName()));
        return response;

    }

    @PayloadRoot(namespace = "http://ostanin.com/spring",
            localPart = "createUserRequest")
    @ResponsePayload
    public GetUserResponse createUserRequest(@RequestPayload CreateUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        userService.createUser(request.getUser());
        response.setUser(request.getUser());
        return response;
    }

    @PayloadRoot(namespace = "http://ostanin.com/spring",
            localPart = "deleteUserRequest")
    @ResponsePayload
    public DeleteUserResponse deleteUserRequest(@RequestPayload DeleteUserRequest request) {
        DeleteUserResponse response = new DeleteUserResponse();
        userService.deleteUser(request.getEpmId());
        response.setStatus(true);
        return response;
    }

    @PayloadRoot(namespace = "http://ostanin.com/spring",
            localPart = "updateUserRequest")
    @ResponsePayload
    public UpdateUserResponse updateUserRequest(@RequestPayload UpdateUserRequest request) {
        UpdateUserResponse response = new UpdateUserResponse();
        try {
            userService.updateUser(request.getUser());
            response.setUser(request.getUser());
            response.setStatus(true);
        } catch (RuntimeException e) {
            response.setStatus(false);
        }
        return response;
    }
}
