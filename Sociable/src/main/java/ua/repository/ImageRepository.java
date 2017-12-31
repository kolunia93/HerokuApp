package ua.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Image;



public interface ImageRepository extends JpaRepository<Image, Integer>, JpaSpecificationExecutor<Image>{

	@Query(value="SELECT i FROM Image i LEFT JOIN FETCH i.user u WHERE u.username=:username")
	List<Image> findAllByPrincipal(@Param("username")String username);
	
	@Query(value="SELECT i FROM Image i LEFT JOIN FETCH i.user u WHERE u.username=:username",
			countQuery="SELECT count(i.id) FROM Image i")
	Page<Image> findPagebleByUserName(@Param("username")String username, Pageable pageable);

}
