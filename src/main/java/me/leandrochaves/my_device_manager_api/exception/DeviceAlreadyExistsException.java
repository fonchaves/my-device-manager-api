package me.leandrochaves.my_device_manager_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class DeviceAlreadyExistsException extends RuntimeException {

  public DeviceAlreadyExistsException(String message) {
    super(message);
  }

}
