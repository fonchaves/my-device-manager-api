package me.leandrochaves.my_device_manager_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.leandrochaves.my_device_manager_api.exception.DeviceAlreadyExistsException;
import me.leandrochaves.my_device_manager_api.exception.DeviceNotFoundException;
import me.leandrochaves.my_device_manager_api.model.Device;
import me.leandrochaves.my_device_manager_api.repository.DeviceRepository;

@Component
public class DeviceService {

  @Autowired
  DeviceRepository deviceRepository;

  public List<Device> findAll() {
    return deviceRepository.findAll();
  }

  public Device findById(Long id){
    return deviceRepository.findById(id)
      .orElseThrow(() -> new DeviceNotFoundException(id, "Could not found device with id = "));
  }

  public List<Device> findByBrand(String brand) {

    List<Device> devicesList =  deviceRepository.findByBrand(brand);
    if (!devicesList.isEmpty()) {
      throw new DeviceNotFoundException(brand, "Could not found device with brand = ");
    }

    return devicesList;
  }

  public Device save(Device device) {
    
    List<Device> devicesList =  deviceRepository.findByName(device.getName());
    if (!devicesList.isEmpty()) {
      throw new DeviceAlreadyExistsException("Device name already exists.");
    }
    
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

  public void deleteById(Long id) {

    Device device = deviceRepository.findById(id)
      .orElseThrow(() -> new DeviceNotFoundException(id, "Could not found device with id = "));

    deviceRepository.delete(device);
  } 
}