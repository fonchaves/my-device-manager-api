package me.leandrochaves.my_device_manager_api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

  @GetMapping("/{id}")
  public Optional<Device>  findById(@PathVariable Long id) {
    return deviceService.findById(id);
  }

  @PostMapping()
  public Device saveDevice(@RequestBody Device device){
    return deviceService.save(device);
  }
  
}
