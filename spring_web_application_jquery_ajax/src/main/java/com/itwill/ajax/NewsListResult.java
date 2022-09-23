package com.itwill.ajax;

import java.util.List;



public class NewsListResult {
	private int count;
	private List<News> newsList;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

}
