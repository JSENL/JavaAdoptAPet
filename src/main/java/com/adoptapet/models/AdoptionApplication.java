package com.adoptapet.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Entity
@Table(name = "adoption_applications")
public class AdoptionApplication {
  @Id
  @SequenceGenerator(name = "adoption_applications_generator", sequenceName = "adoption_applications_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adoption_applications_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @NotBlank
  @Column
  private String name;

  @NotBlank
  @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message = "Invalid phone number")
  @Column(name = "phone_number")
  private String phoneNumber;

  @Email
  @NotBlank
  @Column
  private String email;

  @NotBlank
  @Column(name = "home_status")
  private String homeStatus;

  @NotBlank
  @Column(name = "application_status")
  private String applicationStatus;

  @OneToOne
  @JoinColumn(name = "pet_id", nullable = false)
  private AdoptablePet adoptablePet;
}
