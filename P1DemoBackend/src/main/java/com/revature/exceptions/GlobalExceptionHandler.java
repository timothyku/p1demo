package com.revature.exceptions;


//We can use a global exception handler to clean up our code
//Would you rather:
    //Have a try/catch in every single controller for the exceptions thrown in service?
    //OR... have clean controllers and handle all exception stuff here (prefer this way)

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //This lets our handler intercept exceptions thrown in any controller
//@Component //This needs to be a bean for it to work
public class GlobalExceptionHandler {

  //In here, we can define how we want to handle any Exception that could possibly be thrown

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e){
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());

      //401 == UNAUTHORIZED - good for auth errors
      //we send the message in the exception in the response body (should change based on what went wrong)

      
  }

}
