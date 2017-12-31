package ua.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.FriendReqest;

public interface FriendRequestRepository extends JpaRepository<FriendReqest, Integer>, JpaSpecificationExecutor<FriendReqest>{

	@Query(value="SELECT f FROM FriendReqest f LEFT JOIN FETCH f.input LEFT JOIN FETCH f.output o WHERE o.username=:username ",
			countQuery="SELECT count(f.id) FROM FriendReqest f")
	Page<FriendReqest> findAllPagebleWithPrincipal(@Param("username")String username,Pageable pageable);

	@Query(value="SELECT f FROM FriendReqest f LEFT JOIN FETCH f.input LEFT JOIN FETCH f.output o WHERE o.username=:username AND f.cheack='FALSE' ",
			countQuery="SELECT count(f.id) FROM FriendReqest f")
	Page<FriendReqest> findAllCheackePagebleWithPrincipal(@Param("username")String username,Pageable pageable);

	@Query("SELECT f FROM FriendReqest f LEFT JOIN FETCH f.input i LEFT JOIN FETCH f.output o WHERE o.username=:username AND i.username=:friend OR o.username=:friend AND i.username=:username")
	List<FriendReqest> findByUserAndFriendName(@Param("username")String username,@Param("friend")String friend);
}
