package com.lena.service;

import com.lena.dao.ItemRepository;
import com.lena.dao.ListRepositry;
import com.lena.entity.AppraisalList;
import com.lena.entity.Appraisalitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private ListRepositry listRepositry;
    @Override
    public Appraisalitem getAppraisalitem(Long id) {

        return itemRepository.findById(id).get();
    }

    @Override
    public Page<Appraisalitem> listAppraisalitem(Pageable pageable) {

        return itemRepository.findAll(pageable);
    }

    @Override
    public Appraisalitem saveAppraisalitem(Appraisalitem appraisalitem) {
        System.out.println(appraisalitem.getCaozuofu());

        return itemRepository.save(appraisalitem);

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
        List<Appraisalitem> result=new ArrayList<>();
        List<Appraisalitem> list=itemRepository.findAll();
        list.forEach(appr->{
            if(LocalDate.now().getDayOfMonth()>15) {
                appr.setKaoheyuefen(LocalDate.now().getMonthValue()+"月");
            }else {
                appr.setKaoheyuefen(LocalDate.now().getMonthValue()-1+"月");
            }
            result.add(appr);
        });
        return result;
    }
    // 测试用,返回五条数据
    @Override
    public List<Appraisalitem> findAll2() {
        List<Appraisalitem> result=new ArrayList<>();
        //该方法已过时->PageRequest.of
        //Pageable pageable=new PageRequest(0,5);
        Pageable pageable=PageRequest.of(0,5);
        Page<Appraisalitem> all = itemRepository.findAll(pageable);
        List<Appraisalitem> list = all.getContent();
        list.forEach(appr->{
            if(LocalDate.now().getDayOfMonth()>15) {
                appr.setKaoheyuefen(LocalDate.now().getMonthValue()+"月");
            }else {
                appr.setKaoheyuefen(LocalDate.now().getMonthValue()-1+"月");
            }
            result.add(appr);
        });
        return result;
    }

    @Override
    public List<Appraisalitem> findAll3() {
        return itemRepository.findAll();
    }

    @Override
    public int savefield(Integer id, String apprField, String fieldValue) {
        Optional<Appraisalitem> byId = itemRepository.findById(id.longValue());
        Appraisalitem appraisalitem = byId.get();

        if ("shijishi".equals(apprField)) {
            appraisalitem.setShijishi(Double.parseDouble(fieldValue));
            appraisalitem.setKaohejieguo(appraisalitem.getShijishi()*123);

        }else if("kaohejieguo".equals(apprField)){
            appraisalitem.setKaohejieguo(Double.parseDouble(fieldValue));
        }else {
            appraisalitem.setCaozuofu(fieldValue);
        }
        System.out.println(appraisalitem.getShijishi()+"---------------");
        Appraisalitem save = itemRepository.save(appraisalitem);
        return save!=null?1:0;
    }


}
