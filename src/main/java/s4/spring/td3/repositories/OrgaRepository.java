package s4.spring.td3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import s4.spring.td3.models.Organization;

public interface OrgaRepository extends JpaRepository<Organization, Integer> {

}
