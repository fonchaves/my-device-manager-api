package me.leandrochaves.my_device_manager_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class DeviceNotFoundException extends RuntimeException {

  public DeviceNotFoundException(String brand, String message) {
    super(message + brand);
  }
  
  public DeviceNotFoundException(Long id, String message) {
    super(message + id);
  }

}
