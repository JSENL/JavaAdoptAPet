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
public class Pet {
@Id
@SequenceGenerator(name = "pets_generator", sequenceName = "pets_id_seq", allocationSize = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pets_generator")
@Column(name = "id", nullable = false, unique = true)
private Integer id;

@Column(name="type")
  @NotBlank
private String type;

@Column(name="description")
  private String description;

  @OneToMany(mappedBy = "petType", cascade = CascadeType.ALL)
  private List<AdoptablePet> adoptablePets;

}
