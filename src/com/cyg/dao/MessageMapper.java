package com.zzk.dao;

import java.util.Vector;

import com.zzk.bean.ExpressMessage;

public interface ExpressMessageMapper {

	public int insertExpress(ExpressMessage m);

	public int updateExpress(ExpressMessage m);

	public Vector<ExpressMessage> queryAllExpress();

}
