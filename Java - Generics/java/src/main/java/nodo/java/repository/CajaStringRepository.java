package nodo.java.repository;

import nodo.java.models.CajaStringEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CajaStringRepository extends JpaRepository<CajaStringEntity, Long> {
}

