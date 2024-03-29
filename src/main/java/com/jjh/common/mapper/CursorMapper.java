package com.jjh.common.mapper;

import org.apache.ibatis.cursor.Cursor;

public interface CursorMapper<T> {

    /**
     * 游标查询数据
     */
    public Cursor<T> cursorList(T t);

}
