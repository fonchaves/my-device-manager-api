package me.leandrochaves.my_device_manager_api.service;

import org.springframework.data.domain.Page;

public interface CrudService<T> {

  T save(T t);

  Page<T> findAll(int page, int size);

  T updateById(Long id, T t);

  void deleteById(Long id);
  
}
