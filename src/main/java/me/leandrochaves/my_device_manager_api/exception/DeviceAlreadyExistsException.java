package me.leandrochaves.my_device_manager_api.exception;

public class DeviceAlreadyExistsException extends RuntimeException {

  public DeviceAlreadyExistsException(String message) {
    super(message);
  }

}
