package com.lemonfree.dja.service;

import com.lemonfree.dja.entity.Statistic;

import java.util.List;

public interface StatisticService {

	List<Statistic> findAll();

	Statistic findById(Long id);

	void save(Statistic entity);

	long count();

	void delete(Statistic entity);

	void deleteById(Long id);

	void deleteAll();

	List<Statistic> findAllByPageNo(int pageNo);
}
