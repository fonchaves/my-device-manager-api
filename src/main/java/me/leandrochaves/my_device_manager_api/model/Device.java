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
  
}
