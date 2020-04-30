package com.adoptapet.models;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="pet_types")
@Getter
@Setter
public class PetType {
@Id
@SequenceGenerator(name = "pets_types_generator", sequenceName = "pet_types_id_seq", allocationSize = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pets_types_generator")
@Column(name = "id", nullable = false, unique = true)
private Integer id;

@Column
  @NotBlank
private String type;

@Column
  private String description;

  @OneToMany(mappedBy = "petType", cascade = CascadeType.ALL)
  private List<AdoptablePet> adoptablePet;

}
