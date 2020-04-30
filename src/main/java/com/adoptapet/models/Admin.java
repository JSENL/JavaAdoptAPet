package com.adoptapet.models;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "admin_table")
public class Admin {
  @Id
  @SequenceGenerator(name = "admin_table_generator", sequenceName = "admin_table_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_table_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @Column
  @NotBlank
  private String name;

  @Column
  @NotBlank
  private String username;

  @Column
  @NotBlank
  private String password;
}
