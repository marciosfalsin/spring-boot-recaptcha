package com.test.recaptcha.service;

import com.test.recaptcha.service.model.CaptchaException;
import com.test.recaptcha.service.model.CaptchaResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class CaptchaValidator {
    private static final String GOOGLE_RECAPTCHA_ENDPOINT = "https://www.google.com/recaptcha/api/siteverify";

    @Value("${google.recaptcha.secret}")
    private String recaptchaSecret;

    public boolean validate(String captchaResponse, String recaptchaSecret) {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<>();
        requestMap.add("secret", recaptchaSecret == null ? this.recaptchaSecret : recaptchaSecret);
        requestMap.add("response", captchaResponse);
        CaptchaResponse response = restTemplate.postForObject(GOOGLE_RECAPTCHA_ENDPOINT, requestMap, CaptchaResponse.class);

        if (response == null)
            throw new CaptchaException("Invalid captcha");

        if (Boolean.FALSE.equals(response.getSuccess()))
            throw new CaptchaException(response.getErrorCodes());

        if (response.getScore() != null && response.getScore() < 0.5)
            throw new CaptchaException("Insufficient Score: " + response.getScore());

        return true;
    }
}
