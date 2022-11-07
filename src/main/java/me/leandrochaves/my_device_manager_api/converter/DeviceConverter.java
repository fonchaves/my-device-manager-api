package me.leandrochaves.my_device_manager_api.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import me.leandrochaves.my_device_manager_api.dto.DeviceDTO;
import me.leandrochaves.my_device_manager_api.model.Device;

@Component
public class DeviceConverter {

  public DeviceDTO convertEntityToDto(Device device) {
    ModelMapper modelMapper = new ModelMapper();

    return modelMapper.map(device, DeviceDTO.class);
  }

  public Device convertDtoToEntity(DeviceDTO deviceDTO) {
    ModelMapper modelMapper = new ModelMapper();

    return modelMapper.map(deviceDTO, Device.class);
  }
  
}
