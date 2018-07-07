package com.company.project.cache;

import lombok.Data;

@Data
public class EntityCache<T> {
	/**
	 * 保存的数据
	 */
	private Object datas;

	/**
	 * 设置数据失效时间,为0表示永不失效
	 */
	private long timeOut;

	/**
	 * 最后刷新时间
	 */
	private long lastRefeshTime;

	public EntityCache(T datas, long timeOut, long lastRefeshTime) {
		this.datas = datas;
		this.timeOut = timeOut;
		this.lastRefeshTime = lastRefeshTime;
	}
}
