package com.lena.service;

import com.lena.dao.ItemRepository;
import com.lena.entity.Appraisalitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ItemServiceImpl
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/9/11 7:50
 * @Version 1.0
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Override
    public Appraisalitem getAppraisalitem(Long id) {
        return null;
    }

    @Override
    public Page<Appraisalitem> listAppraisalitem(Pageable pageable) {

        return itemRepository.findAll(pageable);
    }

    @Override
    public Appraisalitem saveAppraisalitem(Appraisalitem appraisalitem) {
        return null;
    }

    @Override
    public Appraisalitem updateAppraisalitem(Long id, Appraisalitem appraisalitem) {
        return null;
    }

    @Override
    public void deleteAppraisalitem(Long id) {

    }

    @Override
    public List<Appraisalitem> findAll() {
        return itemRepository.findAll();
    }
}
