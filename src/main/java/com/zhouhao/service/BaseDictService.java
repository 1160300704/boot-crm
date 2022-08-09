package com.zhouhao.service;

import com.zhouhao.po.BaseDict;
import java.util.List;

public interface BaseDictService {
    List<BaseDict> findBaseDictByTypeCode(String typecode);
}
