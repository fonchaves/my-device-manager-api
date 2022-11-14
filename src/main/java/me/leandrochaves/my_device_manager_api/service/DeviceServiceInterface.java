package me.leandrochaves.my_device_manager_api.service;

import org.springframework.data.domain.Page;

import me.leandrochaves.my_device_manager_api.exception.DeviceAlreadyExistsException;
import me.leandrochaves.my_device_manager_api.exception.DeviceNotFoundException;

public interface DeviceServiceInterface<T> extends CrudService<T> {
  
  T save(T t) throws DeviceAlreadyExistsException;

  Page<T> findAll(int page, int size);

  T findById(Long id) throws DeviceNotFoundException;
  
  Page<T> findByBrand(String brand, int page, int size) throws DeviceNotFoundException;
  
  T updateById(Long id, T t);

  T updatePartialById(Long id, T t);

  void deleteById(Long id) throws DeviceNotFoundException;

}
