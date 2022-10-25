package br.com.moraes.prestadorservico.api.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "postal-code", nullable = false, length = 8)
    private String postalCode;

    @Column(nullable = false, length = 10)
    private String number;

    @Column(nullable = false, length = 15)
    private String block;

    @Column(nullable = false, length = 15)
    private String batch;

    @Column(length = 50)
    private String complement;

    @Column(length = 50)
    private String reference;

    @Column(length = 50)
    private String district;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_city")
    private City city;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Person person;
}
