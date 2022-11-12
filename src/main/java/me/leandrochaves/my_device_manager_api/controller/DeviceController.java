package me.leandrochaves.my_device_manager_api.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import me.leandrochaves.my_device_manager_api.dto.DeviceDTO;
import me.leandrochaves.my_device_manager_api.service.DeviceService;

@RestController
@RequestMapping("/api")
public class DeviceController {

  @Autowired
  DeviceService deviceService;

  @GetMapping("/device")
  public Page<DeviceDTO> getAllDevices(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size) {

    return deviceService.findAll(page, size);
  }

  @PostMapping("/device")
  @ResponseStatus(HttpStatus.CREATED)
  public DeviceDTO createDevice(@Valid @RequestBody DeviceDTO deviceDTO) {
    return deviceService.save(deviceDTO);
  }

  @GetMapping("/device/{id}")
  public DeviceDTO getDeviceById(@PathVariable Long id) {
    return deviceService.findById(id);
  }

  @PutMapping("/device/{id}")
  public DeviceDTO updateDeviceById(@PathVariable Long id, @Valid @RequestBody DeviceDTO deviceDTO) {
    return deviceService.updateById(id, deviceDTO);
  }

  @PatchMapping("/device/{id}")
  public DeviceDTO updatePartialDeviceById(@PathVariable Long id, @Valid @RequestBody DeviceDTO deviceDTO) {
    return deviceService.updatePartialById(id, deviceDTO);
  }

  @DeleteMapping("/device/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteDevice(@PathVariable Long id) {
    deviceService.deleteById(id);
  }

  @GetMapping("/device/brand")
  public Page<DeviceDTO> getDeviceByBrand(
      @RequestParam(defaultValue = "0", name = "q") String query,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size) {
    return deviceService.findByBrand(query, page, size);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
      Map<String, String> errors = new HashMap<>();
      ex.getBindingResult().getAllErrors().forEach((error) -> {
          String fieldName = ((FieldError) error).getField();
          String errorMessage = error.getDefaultMessage();
          errors.put(fieldName, errorMessage);
      });
      return errors;
  }

}
