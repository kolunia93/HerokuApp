package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Integer>, JpaSpecificationExecutor<Privilege>{

	
	@Query(value="SELECT p FROM Privilege p WHERE p.name=:name")
	Privilege findByName(@Param("name")String name);


}
