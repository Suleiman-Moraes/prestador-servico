package br.com.moraes.prestadorservico.api.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "uf")
public class Uf implements Serializable {

    @Id
    private Long id;

    @Column(nullable = false, length = 25)
    private String name;
    
    @Column(nullable = false, length = 2)
    private String initials;
    
    private Long ibge;
    
    @Column(nullable = false, length = 50)
    private String country;

    @OneToMany(mappedBy = "uf", fetch = FetchType.LAZY)
    private List<City> citys;
}
