package me.leandrochaves.my_device_manager_api.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "devices")
public class Device {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  private String name;
  private String brand;

  @Column(name = "createdAt", updatable=false)
  @CreationTimestamp
  private Timestamp createdAt;

  @Column(name = "updatedAt")
  @UpdateTimestamp
  private Timestamp updatedAt;

  // CONSTRUCTORS

  public Device() {
    super();
  }

  public Device(String name, String brand) {
    this.name = name;
    this.brand = brand;
  }

  public Device(Long id, String name, String brand) {
    this.id = id;
    this.name = name;
    this.brand = brand;
  }

  public Device(Long id, String name, String brand, Timestamp createdAt, Timestamp updatedAt) {
    this.id = id;
    this.name = name;
    this.brand = brand;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  // GETTERS AND SETTERS
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }
  
}
