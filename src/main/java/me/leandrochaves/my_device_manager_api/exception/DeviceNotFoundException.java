package me.leandrochaves.my_device_manager_api.exception;

public class DeviceNotFoundException extends RuntimeException {

  public DeviceNotFoundException(String brand, String message) {
    super(message + brand);
  }
  
  public DeviceNotFoundException(Long id, String message) {
    super(message + id);
  }

}
