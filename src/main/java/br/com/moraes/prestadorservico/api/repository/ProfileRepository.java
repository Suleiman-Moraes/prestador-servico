package br.com.moraes.prestadorservico.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.moraes.prestadorservico.api.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Profile findTopByName(String name);
}
