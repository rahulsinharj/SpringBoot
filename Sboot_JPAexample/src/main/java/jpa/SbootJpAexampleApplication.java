package jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import jpa.dao.UserRepository;
import jpa.entity.User;

@SpringBootApplication
public class SbootJpAexampleApplication {

	public static void main(String[] args) 
	{
		ApplicationContext context = SpringApplication.run(SbootJpAexampleApplication.class, args);
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		
/*		// Create obj of user - either from a client form
 	-----------------------------------------------------------------------------------------------------*/
		User user1 = new User();
		user1.setName("Shruti");
		user1.setCity("Delhi");
		user1.setStatus("I am Java programmer");
		
		User user2 = new User();
		user2.setName("Priya");
		user2.setCity("Noida");
		user2.setStatus("I am PHP programmer");
		
		User user3 = new User();
		user3.setName("Swati");
		user3.setCity("Gurgaon");
		user3.setStatus("I am Python programmer");
		
		
/*		// Saving SINGLE "User" obj into Database , and also it will return the object of saved "User" ::
 	-----------------------------------------------------------------------------------------------------*/
		User savedUser = userRepository.save(user1);
		System.out.println("Saved User with details : "+savedUser);
		
		
/*		// Saving MULTIPLE "User" obj into DB ::
 	-----------------------------------------------------------------------------------------------------*/		
		List<User> users = List.of(user1, user2, user3);
		Iterable<User> savedAllUsers = userRepository.saveAll(users);		// saveAll() method will take the LIST of USER objects.
		savedAllUsers.forEach(usr ->{
			System.out.println("Saved User : " +usr);
		});
		
		
/*		// Update single User ::
 	-----------------------------------------------------------------------------------------------------*/		
		Optional<User> findUser = userRepository.findById(4);
		User resultUser = findUser.get();
		
		resultUser.setName("Ram");
		User resultendUser = userRepository.save(resultUser);
		
		System.out.println("Updated User : "+resultendUser);
		
		
/*		// Fetching all data from DB ::
 	-----------------------------------------------------------------------------------------------------*/		
		for(User ur : userRepository.findAll()) {				// Iterating all User list through "ForEach loop"
			System.out.println(ur);
		}
		System.out.println("====================================================");
		
				// or either way :		
		
		Iterable<User> itr = userRepository.findAll();			// Iterating all User list through "Iterable"
		itr.forEach(user -> System.out.println(user));			

//		itr.forEach(user -> {System.out.println(user);});		// This line is also fine, but we should use brackets when writing multiple statements in Lambda exp 
		

/*		// Deleting a single entry data from DB ::
 	-----------------------------------------------------------------------------------------------------*/	
		int deleteUserId = 5;
		userRepository.deleteById(deleteUserId);	
		System.out.println("Deleted 1user with id = "+deleteUserId);
		

/*		// Deleting All entry data from DB ::
	-----------------------------------------------------------------------------------------------------*/			
		Iterable<User> allusers = userRepository.findAll();
		allusers.forEach(usr -> System.out.println(usr));
		
		userRepository.deleteAll(allusers);
		System.out.println("All User entries deleted..");
		
	
/*	==============[ CUSTOM Finder JPA METHODS ]===========================================================================
  	=====================================================================================================================*/
		
		
/*		// Custom finder methods for - Fetching entry "ByName"  ::
	-----------------------------------------------------------------------------------------------------*/				
		List<User> userss = userRepository.findByName("Priya");
		userss.forEach(u -> System.out.println(u));
		
		
/*		// Custom finder methods for - Fetching entry "ByName" and "ByCity"  ::
	-----------------------------------------------------------------------------------------------------*/	
		
		List<User> myusers = userRepository.findByNameAndCity("Rahul", "Delhi");
		myusers.forEach(u -> System.out.println(u));
		
		
/*		// Custom finder methods for - Fetching entry which has "city" starting with "D"  ::
	-----------------------------------------------------------------------------------------------------*/	
			
		List<User> ctusers = userRepository.findByCityStartingWith("D");
		ctusers.forEach(u -> System.out.println(u));
		
		
/*		// Custom finder methods for - Fetching entry which having inbetween word = "Java" in 'status' column ::
	-----------------------------------------------------------------------------------------------------*/	
		List<User> stusers = userRepository.findByStatusContaining("Java");
		stusers.forEach(u -> System.out.println(u));
		
		
/*		// Custom finder methods for - Fetching entry with 'age' = 20 , and entry should come is serialOrder{ascending order} of 'name' column ::
	-----------------------------------------------------------------------------------------------------*/			
		List<User> allUserOrderByNames = userRepository.findByAgeOrderByName(20);
		allUserOrderByNames.forEach(u -> System.out.println(u));
		

/*	==============[ CUSTOM HQL Query METHODS ]===========================================================================
  	====================================================================================================================*/
				
		
/*		// Custom HQL Query - for selecting all users :: 
	-----------------------------------------------------------------------------------------------------*/			
		List<User> allUsersHQL = userRepository.getAllUserHQL();
		allUsersHQL.forEach(u -> System.out.println(u));
				
		
/*		// Custom HQL Query - for selecting all users, which have city = "Delhi" :: 
	-----------------------------------------------------------------------------------------------------*/			
		List<User> usersByCity = userRepository.getUserByCity("Delhi");
		usersByCity.forEach(u -> System.out.println(u));
		
		
/*		// Custom HQL Query - for selecting all users, which have 'name' column starting with word = "S" ::
	-----------------------------------------------------------------------------------------------------*/			
		List<User> usersByNameStartWith = userRepository.getUserByNameStartWith("S");	
		usersByNameStartWith.forEach(u -> System.out.println(u));
		
		
/*		// Custom HQL Query - for selecting all users, which having inbetween word = "Java" in 'status' column  ::
	-----------------------------------------------------------------------------------------------------*/			
		List<User> usersByStatusHavingWord = userRepository.getUserByStatusHavingWord("Java");	
		usersByStatusHavingWord.forEach(u -> System.out.println(u));

		
/*		// Custom HQL Query - for selecting all users, which have city = "Delhi" , and age = 20 ::
	-----------------------------------------------------------------------------------------------------*/			
		List<User> usersByCityAndAge = userRepository.getUserByCityAndAge("Delhi", 20);
		usersByCityAndAge.forEach(u -> System.out.println(u));
		
		
/*	==============[ CUSTOM Native SQL Query METHODS ]====================================================================
  	====================================================================================================================*/
		
		
/*		// Custom Native SQL Query - for selecting all users ::
	-----------------------------------------------------------------------------------------------------*/			
		List<User> allUserSQL = userRepository.getAllUserSQL();
		allUserSQL.forEach(u -> System.out.println(u));
		
/*		// Custom Native SQL Query - for selecting all users, which have 'city' = "Noida" ::
	-----------------------------------------------------------------------------------------------------*/			
		List<User> allUsersSQLByCity = userRepository.getAllUserSQLByCity("Noida");
		allUsersSQLByCity.forEach(u -> System.out.println(u));
		
		
/*		// Custom Native SQL Query - for selecting some columns {name,age,city field only} in users ::
	-----------------------------------------------------------------------------------------------------*/			
		List<Object[]> usrentry = userRepository.getSomeColumnsSQL();
		for(Object[] usr : usrentry) {
			System.out.println(usr[0] +" -- "+usr[1] +" -- "+usr[2]);			// name -- age -- city
		}
		

		

/*	=====================================================================================================================*/			
	
						
	}	
	
}
