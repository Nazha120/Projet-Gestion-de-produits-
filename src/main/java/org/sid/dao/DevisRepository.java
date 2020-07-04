package org.sid.dao;

import java.util.List;

import org.sid.entities.Devis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DevisRepository extends JpaRepository<Devis, Long>{
	@Query("select d from Devis d where d.quantite like :x ")
	public List<Devis> chercher(@Param("x") String mc);

}
