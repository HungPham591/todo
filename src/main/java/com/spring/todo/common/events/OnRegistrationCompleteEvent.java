package com.spring.todo.common.events;

import com.spring.todo.model.inputs.AccountInput;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;
import java.util.Locale;

@Setter
@Getter
public class OnRegistrationCompleteEvent extends ApplicationEvent {
    private String appUrl;
    private Locale locale;
    private AccountInput accountInput;

    public OnRegistrationCompleteEvent(Object source) {
        super(source);
    }

    public OnRegistrationCompleteEvent(Object source, Clock clock) {
        super(source, clock);
    }

    public OnRegistrationCompleteEvent(AccountInput accountInput, Locale locale, String appUrl) {
        super(accountInput);

        this.accountInput = accountInput;
        this.locale = locale;
        this.appUrl = appUrl;
    }
}
