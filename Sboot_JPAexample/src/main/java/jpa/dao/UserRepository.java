package jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import jpa.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	// Custom inbuilt JPA methods
	
	public List<User> findByName(String name);		// findByName() me "Name" is the name of the property in User class, written here in camelCase 
	
	public List<User> findByNameAndCity(String name, String city);

	public List<User> findByCityStartingWith(String prefix);
	
	public List<User> findByStatusContaining(String word);
	
	public List<User> findByAgeOrderByName(int age);
	
	
	// Custom HQL Queries ::
	
	@Query("select u from User u")						// "from User usr" , this query will also work same way ; but "select user" is somewhat more readable 
	public List<User> getAllUserHQL();
	
	@Query("select u from User u where u.city = :ct ")					// : colon ke baad ct tak space nhi hona chahiye, continuous hone chahiye :ct 
	public List<User> getUserByCity(@Param("ct") String city);			// "n" has been binded with String "name"
	
	@Query("select u from User u where u.city = :ct and u.age = :ag")					 
	public List<User> getUserByCityAndAge(@Param("ct") String city , @Param("ag") int age);	
	
	@Query("select u from User u where u.name like :prefixWord% ")					// u.name starts with some word => where u.name like :word%   {see the use of %} 
	public List<User> getUserByNameStartWith(@Param("prefixWord") String word);	
	
	@Query("select u from User u where u.status like %:inword% ")					// u.status having inbetween some word 
	public List<User> getUserByStatusHavingWord(@Param("inword") String word);
	
	
	// Custom Native SQL Queries ::
	
	@Query(value = "select * from user_sbootjpa" , nativeQuery = true)					// NativeQuery takes Table name , not Entity name
	public List<User> getAllUserSQL();
	
	@Query(value = "select * from user_sbootjpa u where u.city = :ct" , nativeQuery = true)						 
	public List<User> getAllUserSQLByCity(@Param("ct") String city );
	
	@Query(value = "select u.name, u.age, u.city from user_sbootjpa u" , nativeQuery = true)						 
	public List<Object[]> getSomeColumnsSQL();
	
	
	
}
