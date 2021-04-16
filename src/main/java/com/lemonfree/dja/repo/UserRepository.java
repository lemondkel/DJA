package com.lemonfree.dja.repo;

import com.lemonfree.dja.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	Page<User> findAll(Pageable pageable);

	@Query(nativeQuery = true, value = "SELECT\n\tLISTAGG(dtu.NAME, ',') WITHIN GROUP (\n\tORDER BY id) AS NAME\nFROM\n\tDJA_TB_USR dtu")
	String getNames();
}
