package com.test.recaptcha.service.model;

import java.util.List;

public class CaptchaException extends RuntimeException {

    public CaptchaException(String message) {
        super(message);
    }

    public CaptchaException(List<String> messages) {
        super(String.join(",", messages));
    }
}
