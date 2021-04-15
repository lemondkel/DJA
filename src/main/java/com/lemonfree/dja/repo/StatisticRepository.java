package com.lemonfree.dja.repo;

import com.lemonfree.dja.entity.Statistic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticRepository extends CrudRepository<Statistic, Long> {
	Page<Statistic> findAll(Pageable pageable);
}
