package com.appkode.house.model.event;


import com.appkode.house.model.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class OnRegistrationCompleteEvent extends ApplicationEvent {
    private User user;
    private String token;

    public OnRegistrationCompleteEvent(User user, String token) {
        super(user);
        this.user = user;
        this.token = token;
    }

}