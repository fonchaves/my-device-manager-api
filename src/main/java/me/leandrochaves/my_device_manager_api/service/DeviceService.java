package me.leandrochaves.my_device_manager_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.leandrochaves.my_device_manager_api.model.Device;
import me.leandrochaves.my_device_manager_api.repository.DeviceRepository;

@Component
public class DeviceService {

  @Autowired
  DeviceRepository deviceRepository;

  public Device save(Device device) {

    //TODO: Add logic to check duplicated devices

    return deviceRepository.save(device);
  } 
}