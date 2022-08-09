package com.zhouhao.dao;

import com.zhouhao.po.BaseDict;
import java.util.List;

public interface BaseDictDao {
    List<BaseDict> selectBaseDictByTypeCode(String typecode);
}
