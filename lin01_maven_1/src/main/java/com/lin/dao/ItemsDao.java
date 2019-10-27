package com.lin.dao;

import com.lin.domain.Items;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsDao {

    /**
     * 通过id查询item
     *
     * @return
     */
    Items findItemById(Integer id);


}
