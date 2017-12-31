//package ua.repository;
//
//import java.util.List;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import ua.entity.Friend;
//
//public interface FriendRepository extends JpaRepository<Friend, Integer>, JpaSpecificationExecutor<Friend> {
//
//	@Query("SELECT f FROM Friend f LEFT JOIN FETCH f.user u LEFT JOIN FETCH f.friend fr WHERE u.username=:username OR fr.username=:username")
//	List<Friend> findAllbyName(@Param("username")String username);
//	
//	@Query("SELECT f FROM Friend f LEFT JOIN FETCH f.user i LEFT JOIN FETCH f.friend o WHERE o.username=:username AND i.username=:friend OR o.username=:friend AND i.username=:username")
//	List<Friend> findFriendByUserAndFriend(@Param("username")String username,@Param("friend")String friend);
//
//
//}
