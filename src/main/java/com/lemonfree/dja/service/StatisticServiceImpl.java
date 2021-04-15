package com.lemonfree.dja.service;

import com.lemonfree.dja.common.Constant;
import com.lemonfree.dja.entity.Statistic;
import com.lemonfree.dja.repo.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {

	@Autowired
	private StatisticRepository statisticRepository;

	@Override
	public List<Statistic> findAll() {
		return (List<Statistic>) statisticRepository.findAll();
	}

	@Override
	public Statistic findById(Long id) {
		return statisticRepository.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void save(Statistic entity) {
		statisticRepository.save(entity);
	}

	@Override
	public long count() {
		return statisticRepository.count();
	}

	@Transactional
	@Override
	public void delete(Statistic entity) {
		statisticRepository.delete(entity);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		statisticRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() {
		statisticRepository.deleteAll();
	}

	@Override
	public List<Statistic> findAllByPageNo(int pageNo) {
		PageRequest pageRequest = PageRequest.of(pageNo, Constant.COMMON_PAGING_SIZE, Sort.by("id").descending());
		return statisticRepository.findAll(pageRequest).getContent();
	}
}
