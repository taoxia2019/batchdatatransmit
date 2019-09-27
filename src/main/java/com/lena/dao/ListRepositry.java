package com.lena.dao;

import com.lena.entity.AppraisalList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ListRepositry extends JpaRepository<AppraisalList,Long>,JpaSpecificationExecutor<AppraisalList> {
}
