package com.lemonfree.dja.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Batch Job Abstract Class
 *
 * @author l2jong
 * @since 2021-04-24
 */
public abstract class Job {

	private String jobId;

	private static final Logger logger = LoggerFactory.getLogger(Job.class);

	public void extract() {
		logger.info("Batch Job (" + jobId + ") Extract START!");
	}

	public void transform() {
		logger.info("Batch Job (" + jobId + ") Transform START!");
	}

	public void load() {
		logger.info("Batch Job (" + jobId + ") Lransform START!");
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
}
