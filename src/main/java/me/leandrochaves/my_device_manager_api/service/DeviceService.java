package me.leandrochaves.my_device_manager_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import me.leandrochaves.my_device_manager_api.converter.DeviceConverter;
import me.leandrochaves.my_device_manager_api.dto.DeviceDTO;
import me.leandrochaves.my_device_manager_api.exception.DeviceAlreadyExistsException;
import me.leandrochaves.my_device_manager_api.exception.DeviceNotFoundException;
import me.leandrochaves.my_device_manager_api.model.Device;
import me.leandrochaves.my_device_manager_api.repository.DeviceRepository;

@Service
public class DeviceService {

  @Autowired
  DeviceRepository deviceRepository;

  @Autowired
  DeviceConverter deviceConverter;

  public Page<Device> findAll(int page, int size) {
    Pageable p = PageRequest.of(page, size);
    return deviceRepository.findAll(p);
  }

  public Device findById(Long id){
    return deviceRepository.findById(id)
      .orElseThrow(() -> new DeviceNotFoundException(id, "Could not found device with id = "));
  }

  public Page<Device> findByBrand(String brand, int page, int size) {

    Pageable p = PageRequest.of(page, size);

    Page<Device> devicesList =  deviceRepository.findAllByBrand(brand, p);
    if (devicesList.isEmpty()) {
      throw new DeviceNotFoundException(brand, "Could not found device with brand = ");
    }

    return devicesList;
  }

  public DeviceDTO save(DeviceDTO deviceDTO) {
    
    Device device = deviceConverter.convertDtoToEntity(deviceDTO);

    List<Device> devicesList =  deviceRepository.findByName(device.getName());
    if (!devicesList.isEmpty()) {
      throw new DeviceAlreadyExistsException("Device name already exists.");
    }

    device = deviceRepository.save(device);
    
    return deviceConverter.convertEntityToDto(device);
  }

  public DeviceDTO updateById(Long id, DeviceDTO newDeviceDTO) {

    final Device newDevice = deviceConverter.convertDtoToEntity(newDeviceDTO);

    Device updatedDevice =  deviceRepository.findById(id)
      .map(device -> {
        device.setName(newDevice.getName());
        device.setBrand(newDevice.getBrand());
        return deviceRepository.save(device);
      })
      .orElseGet(() -> {
        newDevice.setId(id);
        return deviceRepository.save(newDevice);
      });

      return deviceConverter.convertEntityToDto(updatedDevice);
  }

  public DeviceDTO updatePartialById(Long id, DeviceDTO newDeviceDTO) {

    final Device newDevice = deviceConverter.convertDtoToEntity(newDeviceDTO);
    
    Device updatedDevice = deviceRepository.findById(id)
      .map(device -> {
        device.setName(newDevice.getName() == null? device.getName() : newDevice.getName() );
        device.setBrand(newDevice.getBrand() == null? device.getBrand() : newDevice.getBrand());
        return deviceRepository.save(device);
      })
      .orElseGet(() -> {
        newDevice.setId(id);
        return deviceRepository.save(newDevice);
      });

      return deviceConverter.convertEntityToDto(updatedDevice);
  }

  public void deleteById(Long id) {

    Device device = deviceRepository.findById(id)
      .orElseThrow(() -> new DeviceNotFoundException(id, "Could not found device with id = "));

    deviceRepository.delete(device);
  } 
}