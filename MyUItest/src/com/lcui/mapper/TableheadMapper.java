package com.lcui.mapper;

import com.lcui.po.Tablehead;
import com.lcui.po.TableheadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TableheadMapper {
    int countByExample(TableheadExample example);

    int deleteByExample(TableheadExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tablehead record);

    int insertSelective(Tablehead record);

    List<Tablehead> selectByExample(TableheadExample example);

    Tablehead selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tablehead record, @Param("example") TableheadExample example);

    int updateByExample(@Param("record") Tablehead record, @Param("example") TableheadExample example);

    int updateByPrimaryKeySelective(Tablehead record);

    int updateByPrimaryKey(Tablehead record);
}