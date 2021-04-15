package com.lemonfree.dja.job;

import com.lemonfree.dja.common.DTDJob;
import com.lemonfree.dja.entity.User;
import com.lemonfree.dja.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 사용자 랭킹을 집계해옵니다.
 *
 * @author l2jong
 * @jobId Job0001
 * @description 일배치 :: 사용자 랭킹 집계
 * @since 2021-04-16
 */
@Component
public class Job0001 extends DTDJob {

	private static final Logger logger = LoggerFactory.getLogger(Job0001.class);

	@Autowired
	private UserService userService;

	private List<User> userList;

	@PostConstruct
	@Override
	public void setJob() {
		setJobId("0001");
	}

	/**
	 * 2시마다 일배치 실행 - 백준 풀었는지 안풀었는지 체크
	 *
	 * @author l2jong
	 * @since 2021-02-28
	 */
	@Scheduled(cron = "0 0 2 * * *") // 왼쪽부터 초/분/시/일/월/요일/[선택]연도
	@Override
	public void makeJob() {
		extract();


		// transform();
		// load();
	}

	@Override
	public void extract() {
		super.extract();
	}

	@Override
	public void transform() {
		super.transform();
	}

	@Override
	public void load() {
		super.load();
	}
}
