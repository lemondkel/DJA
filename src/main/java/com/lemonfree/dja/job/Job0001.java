package com.lemonfree.dja.job;

import com.lemonfree.dja.common.DTDJob;
import com.lemonfree.dja.entity.User;
import com.lemonfree.dja.service.UserService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.Date;
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
	@Scheduled(cron = "0 * * * * *") // 왼쪽부터 초/분/시/일/월/요일/[선택]연도
	@Override
	public void makeJob() {
		extract();
		Date today = new Date();
		try {
			Document doc = Jsoup.connect("https://www.acmicpc.net/status?user_id=duruaal").header("Content-Type", "application/json;charset=UTF-8").get();
//		logger.info(doc.html());

			// 4. 요소 탐색
			// 4-1. Attribute 탐색
			System.out.println("[Attribute 탐색]");
			Elements fileblocks = doc.select("table#status-table tbody tr");

			logger.info("사이즈:" + fileblocks.size());
			if (fileblocks.size() == 0) {
				logger.debug("데이터가 없는 사용자!");
			} else {
				int correctCount = 0;
				for (int i = 0; i < fileblocks.size(); i++) {
					Elements timestamps = fileblocks.get(i).select("a[data-timestamp]");
					Date date = null;
					if (timestamps.size() > 0) {
						Timestamp ts = new Timestamp(Long.parseLong(timestamps.get(0).attr("data-timestamp")) * 1000);
						date = new Date(ts.getTime());
						System.out.println(date);
					}
					if (date != null) {
						// Get msec from each, and subtract.
						long diff = today.getTime() - date.getTime();
						diff = (diff / (1000 * 60 * 60 * 24));
						System.out.println(diff + "일 차이!");

						if (diff == 0 || diff == -1) {
							Elements correctElements = fileblocks.get(i).select(".result-ac");
							if (correctElements.size() > 0) {
								correctCount++;
							}
						} else {
							break;
						}
					} else {
						break;
					}

					if (i == fileblocks.size() - 1) {
						// First page Last Elements ...
						// Next crawling..?!
					}
				}

				System.out.println(correctCount + "개 맞음!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


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
