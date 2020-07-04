package org.sid.dao;

import java.util.List;

import org.sid.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FactureRepository extends JpaRepository<Facture,Long > {
	@Query("select f from Facture f where f.dateFacture like :x ")
	public List<Facture> chercher(@Param("x") String mc);

}
