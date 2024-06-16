package de.herhold.stroeerkata.exception;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@ControllerAdvice
public class CustomErrorHandler {

    @ExceptionHandler(WebClientException.class)
    @ResponseBody
    ProblemDetail handleAbstractRestException(WebClientResponseException e) {
        return ProblemDetail.forStatusAndDetail(e.getStatusCode(), e.getMessage());
    }
}
