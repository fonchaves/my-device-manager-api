package me.leandrochaves.my_device_manager_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.leandrochaves.my_device_manager_api.model.Device;
import me.leandrochaves.my_device_manager_api.service.DeviceService;

@RestController
@RequestMapping("/device")
public class DeviceController {

  @Autowired
  DeviceService deviceService;

  public Device saveDevice(@RequestBody Device device){
    return deviceService.save(device);
  }
  
}
