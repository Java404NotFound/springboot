package com.rsyx.ch8_2.dao;

import com.rsyx.ch8_2.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;



public interface PersonRepository extends JpaRepository<Person, Long> {
	/**
	 * 根据方法名
	 * @param address
	 * @return
	 */
	List<Person> findByAddress(String address);
	
	Person findByNameAndAddress(String name, String address);

	/**
	 * 根据 @query
	 * @param name
	 * @param address
	 * @return
	 */
	@Query("select p from Person p where p.name= :name and p.address= :address")
	Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);
	
	Person withNameAndAddressNamedQuery(String name, String address);

}
