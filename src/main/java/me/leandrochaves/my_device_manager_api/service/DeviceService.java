package me.leandrochaves.my_device_manager_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.leandrochaves.my_device_manager_api.model.Device;
import me.leandrochaves.my_device_manager_api.repository.DeviceRepository;

@Component
public class DeviceService {

  @Autowired
  DeviceRepository deviceRepository;

  public List<Device> findAll() {
    return deviceRepository.findAll();
  }

  public Device findById(Long id) throws Exception {
    return deviceRepository.findById(id)
      .orElseThrow(() -> new Exception("Device not found on Database!"));
  }

  public Device findByBrand(String brand) throws Exception {
    return deviceRepository.findByBrand(brand)
      .orElseThrow(() -> new Exception("Brand not found on Database!"));
  }

  public Device save(Device device) {
    //TODO: Add logic to check duplicated devices
    return deviceRepository.save(device);
  }

  public Device updateById(Long id, Device newDevice) {

    return deviceRepository.findById(id)
      .map(device -> {
        device.setName(newDevice.getName());
        device.setBrand(newDevice.getBrand());
        return deviceRepository.save(device);
      })
      .orElseGet(() -> {
        newDevice.setId(id);
        return deviceRepository.save(newDevice);
      });
  }

  public Device updatePartialById(Long id, Device newDevice) {
    
    return deviceRepository.findById(id)
      .map(device -> {
        device.setName(newDevice.getName() == null? device.getName() : newDevice.getName() );
        device.setBrand(newDevice.getBrand() == null? device.getBrand() : newDevice.getBrand());
        return deviceRepository.save(device);
      })
      .orElseGet(() -> {
        newDevice.setId(id);
        return deviceRepository.save(newDevice);
      });
  }

  public String deleteById(Long id) throws Exception {

    Device device = deviceRepository.findById(id)
      .orElseThrow(() -> new Exception("Device not found on Database!"));

    deviceRepository.delete(device);
    
    return "Device "+ device.getId() + " deleted";
  } 
}