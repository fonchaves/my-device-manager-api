package me.leandrochaves.my_device_manager_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import me.leandrochaves.my_device_manager_api.model.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {

  Optional<Device> findById(Long id);

  Page<Device> findAllByBrand(String brand, Pageable pageable);
  
  List<Device> findByName(String name);
  
}