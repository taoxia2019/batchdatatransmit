package com.lena.service;

import com.lena.entity.AppraisalList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ListService {
    AppraisalList getAppraisallist(Long id);

    Page<AppraisalList> listAppraisallist(Pageable pageable);

    AppraisalList saveAppraisallist(AppraisalList appraisallist);

    AppraisalList updateAppraisallist(Long id, AppraisalList appraisallist);

    void deleteAppraisallist(Long id);
    List<AppraisalList> findAll();
}
