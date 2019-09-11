package com.lena.dao;

import com.lena.entity.Appraisalitem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName ItemRepository
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/9/11 7:51
 * @Version 1.0
 */
public interface ItemRepository extends JpaRepository<Appraisalitem,Long>,JpaSpecificationExecutor<Appraisalitem> {

}
