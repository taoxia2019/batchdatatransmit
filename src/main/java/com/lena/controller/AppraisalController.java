package com.lena.controller;

import com.lena.base.DataGridView;
import com.lena.entity.AppraisalList;
import com.lena.entity.Appraisalitem;
import com.lena.service.ItemService;
import com.lena.service.ListService;
import com.lena.utils.ExcelUtil;
import com.lena.utils.ResponseUtil;
import com.lena.vo.AppraisalVo;

import com.lena.vo.ImportVo;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AppraisalController
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/9/11 7:59
 * @Version 1.0
 */
@Controller
public class AppraisalController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private ListService listService;



    @ResponseBody
    @RequestMapping("/editfield")
    public DataGridView editfield(Integer id,String apprField,String fieldValue){
        System.out.println("---------");
        System.out.println(id+"-----"+apprField+"-----"+fieldValue);
        System.out.println("---------");
        int savefield = itemService.savefield(id, apprField, fieldValue);
        if(savefield>0){
            System.out.println("保存成功--------------------");
        }

        return new DataGridView();
    }

    @RequestMapping("/getlist123")
    @ResponseBody
    public DataGridView getPage(Model model) {
//        AppraisalVo appraisalVo = new AppraisalVo();
//        // 测试用,返回五条数据
//        appraisalVo.setApps(itemService.findAll2());
//        model.addAttribute("appraisalVo", appraisalVo);

        System.out.println(new DataGridView(100, itemService.findAll3()));
        return new DataGridView(100, itemService.findAll3());
    }

    @GetMapping("/")
    public String getListPage1(Model model) {
//        AppraisalVo appraisalVo = new AppraisalVo();
//        // 测试用,返回五条数据
//        appraisalVo.setApps(itemService.findAll2());
//        model.addAttribute("appraisalVo", appraisalVo);

        return "/index3";
    }


    @GetMapping("list")
    public String getListPage(Model model) {

        model.addAttribute("list", listService.findAll());

        return "/list";
    }

    //从编辑按钮跳转到编辑页面，根据ID携带考核项目数据
    @GetMapping("/update/{id}")
    public String getUpdatePage(@PathVariable Long id, Model model){
        AppraisalList appraisallist = listService.getAppraisallist(id);
        model.addAttribute("appr",appraisallist);

        return "/updatepage";
    }
    //更新考核项目数据，1条
    @PostMapping("/update")
    public String update(AppraisalList appraisalList){

        listService.updateAppraisallist(appraisalList.getId(),appraisalList);
        return "redirect:/list";
    }

    //从初始化表中提交考核结果
    @PostMapping("/input")
    public String input(AppraisalVo vo) {

        vo.getApps().forEach(a->{
            AppraisalList b = new AppraisalList();
            //使用BeanUtils工具类转换对象类型。
            BeanUtils.copyProperties(a,b);
            listService.saveAppraisallist(b);
        });

        System.out.println("------------");
        return "redirect:/list";
    }

    @PostMapping("/importall")
    @ResponseBody
    public ImportVo importExcel2(MultipartFile file,Model model) throws IOException {

        // 獲取流對象
        // MultipartFile 的filename必須和input的name屬性名稱一致
        InputStream is = file.getInputStream();
        // 導入流對象
        HSSFWorkbook wb = new HSSFWorkbook(is);
        // 獲取sheet表的名稱
        HSSFSheet sheet = wb.getSheet("初始化3");
        HSSFCell cell1 = sheet.getRow(0).getCell(0);

        // 獲取有數據的最後一行
        int lastRowNum = sheet.getLastRowNum();

        List<Appraisalitem> apprList=new ArrayList<>();
        // 除掉標題行,進行遍歷
        for (int i = 1; i <= lastRowNum; i++) {
            if (0 == sheet.getRow(i).getCell(0).toString().length()) {
                break;
            }
            // 獲取pojo對象
            Appraisalitem appr = new Appraisalitem();
            //ID
            appr.setId(Long.parseLong(ExcelUtil.getCellValues(sheet.getRow(i).getCell(0))));
            //月份
            if(null==ExcelUtil.getCellValues(sheet.getRow(i).getCell(1))){
                appr.setKaoheyuefen(null);
            }else {
                appr.setKaoheyuefen(ExcelUtil.getCellValues(sheet.getRow(i).getCell(1)));
            }
            //部门分厂
            appr.setBeikaohedanwei(ExcelUtil.getCellValues(sheet.getRow(i).getCell(2)));
            //项目
            appr.setKaohexiangmu(ExcelUtil.getCellValues(sheet.getRow(i).getCell(3)));
            //标准
            appr.setBiaozhun(ExcelUtil.getCellValues(sheet.getRow(i).getCell(4)));
            //周期
            appr.setZhouqi(ExcelUtil.getCellValues(sheet.getRow(i).getCell(5)));
            //单位
            appr.setDanwei(ExcelUtil.getCellValues(sheet.getRow(i).getCell(6)));
            //目标值 非空判断
            if(null==ExcelUtil.getCellValues(sheet.getRow(i).getCell(7))){
                appr.setMubiaozhi(null);
            }else {
                appr.setMubiaozhi(Double.parseDouble(ExcelUtil.getCellValues(sheet.getRow(i).getCell(7))));
            }
            //实际值 非空判断
            if(null==ExcelUtil.getCellValues(sheet.getRow(i).getCell(8))){
                appr.setShijishi(null);
            }else {
                appr.setShijishi(Double.parseDouble(ExcelUtil.getCellValues(sheet.getRow(i).getCell(8))));
            }

            //考核结果 非空判断
            if(null==ExcelUtil.getCellValues(sheet.getRow(i).getCell(9))){
                appr.setKaohejieguo(null);
            }else {
                appr.setKaohejieguo(Double.parseDouble(ExcelUtil.getCellValues(sheet.getRow(i).getCell(9))));
            }

            //操作符 非空判断
            if(null==ExcelUtil.getCellValues(sheet.getRow(i).getCell(10))){
                appr.setCaozuofu("0*0");
            }else {
                appr.setCaozuofu(ExcelUtil.getCellValues(sheet.getRow(i).getCell(10)));
            }
            //考核单位
            appr.setKaohedanwei(ExcelUtil.getCellValues(sheet.getRow(i).getCell(11)));
            //备注  非空判断
            if(null==ExcelUtil.getCellValues(sheet.getRow(i).getCell(12))){
                appr.setBeizhu(null);
            }else {
                appr.setBeizhu(ExcelUtil.getCellValues(sheet.getRow(i).getCell(12)));
            }
            itemService.saveAppraisalitem(appr);
            //apprList.add(appr);
        }





        //用于layui的回调
        ImportVo res = new ImportVo();
        res.setCode(0);
        res.setMsg("上传成功");
        res.setData(apprList);
        return res;
    }


    @RequestMapping("/exportall")
    public void exportAll(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {

        // 加載數據庫數據
        List<Appraisalitem> list = itemService.findAll();
        // 建立工作簿
        HSSFWorkbook wb = new HSSFWorkbook();
        // 建立sheet表格
        HSSFSheet sheet = wb.createSheet("考核数据");
        //文件名稱
        String fileName = "2019年组织绩效考核数据填报表";
        // 表格行標題
        HSSFRow row = sheet.createRow(0);
        String[] header = {"ID", "月份", "部门分厂", "项目", "标准", "周期", "单位", "目标值", "实际值", "考核结果", "考核单位", "操作符", "备注"};
        // 創建表格
        HSSFCell cell = null;
        // 遍歷行標題
        for (int i = 0; i < header.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(header[i]);
        }
        ;
        // 設置行數據的起始位置
        int rowCount = 1;
        // 遍歷list存取的對象
        for (Appraisalitem appraisalitem : list) {
            row = sheet.createRow(rowCount);
            row.createCell(0).setCellValue(appraisalitem.getId());
            row.createCell(1).setCellValue(appraisalitem.getKaoheyuefen());
            row.createCell(2).setCellValue(appraisalitem.getBeikaohedanwei());
            row.createCell(3).setCellValue(appraisalitem.getKaohexiangmu());
            row.createCell(4).setCellValue(appraisalitem.getBiaozhun());
            row.createCell(5).setCellValue(appraisalitem.getZhouqi());
            row.createCell(6).setCellValue(appraisalitem.getDanwei());
            row.createCell(7).setCellValue(appraisalitem.getMubiaozhi());
            row.createCell(8).setCellValue(appraisalitem.getShijishi());
            if (appraisalitem.getKaohejieguo() == null) {
                row.createCell(9).setCellValue("");
            }
            row.createCell(10).setCellValue(appraisalitem.getKaohedanwei());
            row.createCell(11).setCellValue(appraisalitem.getCaozuofu());
            if (appraisalitem.getKaohejieguo() == null) {
                row.createCell(12).setCellValue("");
            }
            rowCount++;
        }


        OutputStream output = response.getOutputStream();
        response.reset();
        //解决火狐浏览器下载错误问题
        String s = request.getHeader("USER-AGENT").toLowerCase();
        if (s.indexOf("firefox") > 0) {
            response.setHeader("Content-disposition", "attachment; filename="
                    + new String(fileName.getBytes("UTF-8"), "ISO8859-1") + ".xls");
        } else {
            response.setHeader("Content-disposition", "attachment; filename="
                    + java.net.URLEncoder.encode(fileName, "utf-8") + ".xls");
        }

        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();


    }

    //下载月度考核结果
    @RequestMapping("/exportalllist")
    public void exportAllList(HttpServletRequest request,
                          HttpServletResponse response) throws Exception {

        // 加載數據庫數據
        List<AppraisalList> list = listService.findAll();
        //  模板地址

//        Resource resource = new ClassPathResource("excel/model1.xls");
//        File file = resource.getFile();
        //建立输入流
//        FileInputStream fis=new FileInputStream(file);
//        System.out.println(file.getName());
        // 建立工作簿
        HSSFWorkbook wb = new HSSFWorkbook();
        // 建立sheet表格
        HSSFSheet sheet = wb.createSheet("考核数据");

        //文件名稱
        String fileName = "2019年"+ (LocalDate.now().getMonthValue()-1)+"月"+"组织绩效考核数据结果";
        // 表格行標題
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue(fileName);
        String[] header = {"序号", "部门分厂", "项目", "标准", "周期", "单位", "目标值", "实际值", "考核结果","备注"};
        // 創建表格
        HSSFCell cell = null;
        // 遍歷行標題
        for (int i = 0; i < header.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(header[i]);
        }
        // 設置行數據的起始位置
        int rowCount = 1;
        // 遍歷list存取的對象
        for (AppraisalList a : list) {
            row = sheet.createRow(rowCount);
            row.createCell(0).setCellValue(rowCount-1);
            row.createCell(1).setCellValue(a.getBeikaohedanwei());
            row.createCell(2).setCellValue(a.getKaohexiangmu());
            row.createCell(3).setCellValue(a.getBiaozhun());
            row.createCell(4).setCellValue(a.getZhouqi());
            row.createCell(5).setCellValue(a.getDanwei());
            row.createCell(6).setCellValue(a.getMubiaozhi());
            row.createCell(7).setCellValue(a.getShijishi());
            row.createCell(8).setCellValue(a.getKaohejieguo());
            row.createCell(9).setCellValue(a.getBeizhu());

            rowCount++;
        }

        ResponseUtil.export(request,response,wb,fileName);
    }



}
