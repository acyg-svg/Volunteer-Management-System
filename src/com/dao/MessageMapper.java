package com.dao;

import java.util.Vector;

import com.zzk.bean.ExpressMessage;

public interface MessageMapper {

	public int insertExpress(zhiyuanzheMessage m);

	public int updateExpress(zhiyuanzheMessage m);

	public Vector<zhiyuanzheMessage> queryAllExpress();

}
