package me.leandrochaves.my_device_manager_api.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class DeviceDTO {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Brand is mandatory")
    private String brand;

}
