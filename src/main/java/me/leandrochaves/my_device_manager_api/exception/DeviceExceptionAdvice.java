package me.leandrochaves.my_device_manager_api.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

@ControllerAdvice
public class DeviceExceptionAdvice {

  @ResponseBody
  @ExceptionHandler(DeviceNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String deviceNotFoundHandler(DeviceNotFoundException ex) {
    return ex.getMessage();
  }

  @ResponseBody
  @ExceptionHandler(DeviceAlreadyExistsException.class)
  @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
  String deviceAlreadyExistsHandler(DeviceAlreadyExistsException ex) {
    return ex.getMessage();
  }
  
  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
      Map<String, String> errors = new HashMap<>();
      ex.getBindingResult().getAllErrors().forEach((error) -> {
          String fieldName = ((FieldError) error).getField();
          String errorMessage = error.getDefaultMessage();
          errors.put(fieldName, errorMessage);
      });
      return errors;
  }
  
}
