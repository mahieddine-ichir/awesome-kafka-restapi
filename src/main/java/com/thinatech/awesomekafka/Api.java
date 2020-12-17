package com.thinatech.awesomekafka;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/api")
class Api {

    private final Application application;

    public Api(Application application) {
        this.application = application;
    }

    @PostMapping
    void write(HttpServletRequest httpServletRequest) throws IOException {
        application.write(httpServletRequest.getInputStream().readAllBytes());
    }

    @PostMapping("{key}")
    void writeWithKey(HttpServletRequest httpServletRequest, @PathVariable String key) throws IOException {
        application.write(key, httpServletRequest.getInputStream().readAllBytes());
    }

}
