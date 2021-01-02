package com.sfofana.rest.service;

import com.sfofana.rest.model.AccountHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

    @Value("${loginUrl}")
    public String loginUrl;

    @Autowired
    RestTemplate restTemplate;

    public AccountHolder postRequest(AccountHolder holder) {
        holder.setEmail("master@gmail.com");
        holder.setPassword("demo");

        return restTemplate.postForObject(loginUrl, holder, AccountHolder.class);
    }
}
