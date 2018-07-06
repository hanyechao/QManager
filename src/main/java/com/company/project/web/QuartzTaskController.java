package com.company.project.web;

import java.util.Map;
import java.util.Set;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.cache.CacheManagerImpl;
import com.company.project.cache.EntityCache;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.quartz.QuartzManager;

@RestController
@RequestMapping("/quartz/task")
public class QuartzTaskController {

	@Autowired
	QuartzManager quartzManager;

	@Autowired
	CacheManagerImpl cacheManagerImpl;

	final String KEY = "QUARTZ_TASK_STATE_KEY";

	@PostMapping("/pauseAll")
	public Result pauseAll() throws SchedulerException {
		EntityCache cacheByKey = cacheManagerImpl.getCacheByKey(KEY);
		if (cacheByKey == null) {
			cacheManagerImpl.putCache(KEY, new EntityCache("false", 0, System.currentTimeMillis()));
		} else if (Boolean.parseBoolean((String) cacheByKey.getDatas()) == true) {
			cacheManagerImpl.clearByKey(KEY);
			cacheManagerImpl.putCache(KEY, new EntityCache("false", 0, System.currentTimeMillis()));
		}
		quartzManager.getScheduler().pauseAll();
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/resumeAll")
	public Result resumeAll() throws SchedulerException {
		EntityCache cacheByKey = cacheManagerImpl.getCacheByKey(KEY);
		if (cacheByKey == null) {
			cacheManagerImpl.putCache(KEY, new EntityCache("true", 0, System.currentTimeMillis()));
		} else if (Boolean.parseBoolean((String) cacheByKey.getDatas()) == false) {
			cacheManagerImpl.clearByKey(KEY);
			cacheManagerImpl.putCache(KEY, new EntityCache("true", 0, System.currentTimeMillis()));
		}
		quartzManager.getScheduler().resumeAll();
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/getSchedulerState")
	public Result getSchedulerState() throws SchedulerException {

		return ResultGenerator.genSuccessResult(
				cacheManagerImpl.getCacheDataByKey(KEY) == null ? true : cacheManagerImpl.getCacheDataByKey(KEY));
	}

	@PostMapping("/removeJob")
	public Result removeJob(@RequestParam String groupId) throws SchedulerException {
		Set<String> allKeys = new CacheManagerImpl().getAllKeys();
		System.err.println(allKeys);
		return ResultGenerator.genSuccessResult(quartzManager.getScheduler().isShutdown());
	}

}
