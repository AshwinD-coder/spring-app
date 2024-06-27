//package org.example.ecom.user.resource;
//
//import org.example.ecom.user.repository.UserType;
//import org.example.ecom.user.usecase.register.UserRegisterRequest;
//import org.example.ecom.user.usecase.register.UserRegisterUseCaseImpl;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.test.context.event.annotation.BeforeTestClass;
//import org.springframework.test.context.event.annotation.BeforeTestMethod;
//
//class UserResourceTest {
//
//
//    @Mock
//    private UserRegisterUseCaseImpl userRegisterUseCase;
//
//    @Mock
//    private UserResource userResource;
//
//    public UserResourceTest(UserRegisterUseCaseImpl userRegisterUseCase, UserResource userResource) {
//        this.userRegisterUseCase = userRegisterUseCase;
//        this.userResource = userResource;
//    }
//
//    @Test
//    void shouldRegisterUser() {
//        UserRegisterRequest request = getUserRegisterRequest();
//        userResource.registerUser(request);
//
//    }
//
//    private UserRegisterRequest getUserRegisterRequest() {
//        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
//        userRegisterRequest.setFirstName("Test");
//        userRegisterRequest.setLastName("User");
//        userRegisterRequest.setEmail("test@test.com");
//        userRegisterRequest.setPassword("password");
//        userRegisterRequest.setConfirmPassword("password");
//        userRegisterRequest.setUserType(UserType.IT_OFFICER);
//        userRegisterRequest.setMobileNumber("123456789");
//        return userRegisterRequest;
//    }
//}