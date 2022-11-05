package me.leandrochaves.my_device_manager_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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

  @GetMapping()
  public List<Device> findAll() {
    return deviceService.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Device>  findById(@PathVariable Long id) {
    return deviceService.findById(id);
  }

  @GetMapping("/{brand}")
  public Optional<Device>  findByBrand(@PathVariable String brand) {
    return deviceService.findByBrand(brand);
  }

  @PostMapping()
  public Device saveDevice(@RequestBody Device device){
    return deviceService.save(device);
  }

  @DeleteMapping()
  public String deleteDevice(@RequestBody Device device){
    return deviceService.delete(device);
  }
}
