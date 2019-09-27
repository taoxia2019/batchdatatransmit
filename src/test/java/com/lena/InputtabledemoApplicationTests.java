package com.lena;

import com.lena.dao.ItemRepository;
import com.lena.entity.Appraisalitem;
import com.lena.service.ItemService;
import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.ExpressionImpl;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InputtabledemoApplicationTests {
    @Autowired
    private ItemService itemService;

	@Test
	public void contextLoads() {
//		JexlContext jc =new MapContext();
//		jc.set("x",560);
//		jc.set("y",50);
//		Expression expression = new JexlEngine().createExpression("(x-y)/13");
//		String s = expression.evaluate(jc).toString();
//		System.out.println(expression.evaluate(jc));

        Appraisalitem ap = itemService.getAppraisalitem((long) 3);
        Double shijishi = ap.getShijishi();
        Double mubiaozhi = ap.getMubiaozhi();
        String caozuofu = ap.getCaozuofu();

        Double evaluate = evaluate(shijishi, mubiaozhi, caozuofu);
		System.out.println(evaluate);


	}

	public Double evaluate(Double y, Double x, String exper){
        DecimalFormat    df   = new DecimalFormat("######0.00");
        JexlContext jc =new MapContext();

		jc.set("y",y);
        jc.set("x",x);
		Expression expression = new JexlEngine().createExpression(exper);
		Double value=Double.parseDouble(expression.evaluate(jc).toString());
        String format = df.format(value);
        return Double.parseDouble(format);
	}

	@Test
	public void getDate(){
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.now().getMonthValue()+"月");
        System.out.println(LocalDate.now().getDayOfMonth()>20?LocalDate.now().getMonthValue():LocalDate.now().getMonthValue()-1);


    }

}
