package ua.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>, JpaSpecificationExecutor<Role>{

	@Query(value="SELECT r FROM Role r LEFT JOIN FETCH r.privileges p WHERE r.name=:name")
	Role findByName(@Param("name")String name);

}
