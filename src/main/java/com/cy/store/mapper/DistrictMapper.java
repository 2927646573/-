package com.cy.store.mapper;

import com.cy.store.entity.District;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DistrictMapper {
    /**
     * 根据父代码号查询区域信息
     * 
     * @param parent 父代码号
     * @return 某个父区域下所有的区域列表
     */
    @Select("select * from t_dict_district where parent=#{parent} order by code ASC")
    List<District> findByParent(String parent);//查询的结果可能是多个,所以放在集合中

    @Select("select * from t_dict_district where code=#{code}")
    String findNameByCode(String code);

}
