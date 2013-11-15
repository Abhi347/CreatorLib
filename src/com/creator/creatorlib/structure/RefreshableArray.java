package com.creator.creatorlib.structure;

import java.util.ArrayList;

public class RefreshableArray implements Refreshable{
	private ArrayList<Refreshable> mRefreshData;
	
	public RefreshableArray(ArrayList<Refreshable> refreshData){
		setRefreshData(refreshData);
	}

	public ArrayList<Refreshable> getRefreshData() {
		return mRefreshData;
	}

	public void setRefreshData(ArrayList<Refreshable> mRefreshData) {
		this.mRefreshData = mRefreshData;
	}
	
	
}
