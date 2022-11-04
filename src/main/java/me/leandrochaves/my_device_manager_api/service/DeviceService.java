package me.leandrochaves.my_device_manager_api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.leandrochaves.my_device_manager_api.model.Device;
import me.leandrochaves.my_device_manager_api.repository.DeviceRepository;

@Component
public class DeviceService {

  @Autowired
  DeviceRepository deviceRepository;

  public Optional<Device> findById(Long id) {
    return deviceRepository.findById(id);
  }

  public Device save(Device device) {

    //TODO: Add logic to check duplicated devices

    return deviceRepository.save(device);
  } 
}