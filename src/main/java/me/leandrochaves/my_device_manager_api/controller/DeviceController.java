package me.leandrochaves.my_device_manager_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.leandrochaves.my_device_manager_api.model.Device;
import me.leandrochaves.my_device_manager_api.service.DeviceService;

@RestController
@RequestMapping("/api")
public class DeviceController {

  @Autowired
  DeviceService deviceService;

  @GetMapping("/device")
  public List<Device> getAllDevices() {
    return deviceService.findAll();
  }

  @PostMapping("/device")
  public Device createDevice(@RequestBody Device device){
    return deviceService.save(device);
  }

  @GetMapping("/device/{id}")
  public Device getDeviceById(@PathVariable Long id) throws Exception {
    return deviceService.findById(id);
  }

  @GetMapping("/device/brand/{brand}")
  public Device getDeviceByBrand(@PathVariable String brand) throws Exception {
    return deviceService.findByBrand(brand);
  }

  @PutMapping("/device/{id}")
  public Device updateDeviceById(@PathVariable Long id, @RequestBody Device device) {
    return deviceService.updateById(id, device);
  }

  @DeleteMapping("/device/{id}")
  public String deleteDevice(@PathVariable Long id) throws Exception{
    return deviceService.deleteById(id);
  }
}
