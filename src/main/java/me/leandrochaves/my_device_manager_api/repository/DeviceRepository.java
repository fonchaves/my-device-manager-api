package me.leandrochaves.my_device_manager_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import me.leandrochaves.my_device_manager_api.model.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {

  Optional<Device> findById(Long id);

  Optional<Device> findByBrand(String brand);
  
}