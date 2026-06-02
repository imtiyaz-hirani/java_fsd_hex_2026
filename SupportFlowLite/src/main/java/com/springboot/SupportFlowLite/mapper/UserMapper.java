package com.springboot.SupportFlowLite.mapper;

import com.springboot.SupportFlowLite.dto.CustomerReqDto;
import com.springboot.SupportFlowLite.model.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static User mapDtoToEntity(CustomerReqDto customerReqDto) {
        User user = new User();
        user.setUsername(customerReqDto.username());
        user.setPassword(customerReqDto.password());
        return user;
    }
}
