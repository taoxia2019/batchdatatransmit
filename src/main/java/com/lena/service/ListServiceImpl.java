package com.lena.service;

import com.lena.dao.ListRepositry;
import com.lena.entity.AppraisalList;
import com.lena.utils.JexlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ListServiceImpl
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/9/26 7:59
 * @Version 1.0
 */
@Service
public class ListServiceImpl implements ListService {
    @Autowired
    private ListRepositry listRepositry;
    @Override
    public AppraisalList getAppraisallist(Long id) {
        return listRepositry.findById(id).get();
    }

    @Override
    public Page<AppraisalList> listAppraisallist(Pageable pageable) {
        return listRepositry.findAll(pageable);
    }

    @Override
    public AppraisalList saveAppraisallist(AppraisalList appraisallist) {
        //分别获取当前的目标值、实际值以及运算符
        Double y = appraisallist.getShijishi();
        Double x = appraisallist.getMubiaozhi();
        String czf = appraisallist.getCaozuofu();
        Double evaluate = JexlUtils.evaluate(y, x, czf);
        //获取经过运算符计算的考核结果
        appraisallist.setKaohejieguo(evaluate);

        return listRepositry.save(appraisallist);
    }

    @Override
    public AppraisalList updateAppraisallist(Long id, AppraisalList appraisallist) {
        //分别获取当前的目标值、实际值以及运算符
        Double y = appraisallist.getShijishi();
        Double x = appraisallist.getMubiaozhi();
        String czf = appraisallist.getCaozuofu();
        Double evaluate = JexlUtils.evaluate(y, x, czf);
        appraisallist.setKaohejieguo(evaluate);
        return listRepositry.save(appraisallist);
    }

    @Override
    public void deleteAppraisallist(Long id) {
        listRepositry.deleteById(id);

    }

    @Override
    public List<AppraisalList> findAll() {
        return listRepositry.findAll();
    }
}
