package com.lena.service;

import com.lena.entity.Appraisalitem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemService {
    Appraisalitem getAppraisalitem(Long id);

    Page<Appraisalitem> listAppraisalitem(Pageable pageable);

    Appraisalitem saveAppraisalitem(Appraisalitem appraisalitem);

    Appraisalitem updateAppraisalitem(Long id,Appraisalitem appraisalitem);

    void deleteAppraisalitem(Long id);
    List<Appraisalitem> findAll();
}
