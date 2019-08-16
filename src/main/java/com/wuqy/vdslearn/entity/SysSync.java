package com.wuqy.vdslearn.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单信息扩展字段实体类
 * 
 * @author zsjeay
 */
@Data
public class SysSync implements Serializable {

	private static final long serialVersionUID = -1256237248084904437L;

	/**
	 * 主键id
	 */
	private int id;
	
	/**
	 * 同步类型
	 */
	private String syncType;
	
	/**
	 * 查询开始数
	 */
	private Integer start;
	
	/**
	 * 查询结束数
	 */
	private Integer end;
	
	/**
	 * 总条数
	 */
	private Integer total;
	
	/**
	 * 数据同步开始时间
	 */
	private Date syncStartTime;
	
	/**
	 * 数据同步截止时间
	 */
	private Date syncEndTime;
	
	/**
	 * 操作时间
	 */
	private Date operateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSyncType() {
		return syncType;
	}

	public void setSyncType(String syncType) {
		this.syncType = syncType;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}


}
