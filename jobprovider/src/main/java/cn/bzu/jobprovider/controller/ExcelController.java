package cn.bzu.jobprovider.controller;

import cn.bzu.jobprovider.dao.JobUpdateMapper;
import cn.bzu.jobprovider.pojo.JobUpdate;
import cn.bzu.jobprovider.pojo.Msg;
import org.apache.ibatis.annotations.Delete;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

@RestController
public class ExcelController {
    @Autowired
    private JobUpdateMapper mapper;
    @GetMapping(value = "/excel" )
    public void getExcel (HttpServletResponse response) throws Exception {
        System.out.println("开始报表");
        List<JobUpdate> list = mapper.selectJobUpdate();
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet =wb.createSheet("job");
        HSSFRow row = null;
     //   row = sheet.createRow(0);
     //   row.setHeight((short)(26.25*20));
    //    row.createCell(0).setCellValue("员工职务变动列表");
      //  row.getCell(0).setCellStyle(getStyle(wb,0));//设置样式
//           for(int i = 1;i <= 3;i++){
//            //   row.createCell(i).setCellStyle(getStyle(wb,0));
//           }
//           CellRangeAddress rowRegion = new CellRangeAddress(0,0,0,4);
////           sheet.addMergedRegion(rowRegion);
//           CellRangeAddress columnRegion = new CellRangeAddress(0,0,0,0);
//           sheet.addMergedRegion(columnRegion);
           row = sheet.createRow(0);
       //    row.createCell(0).setCellStyle(getStyle(wb,3));
           row.setHeight((short)(22.50*20));
           row.createCell(0).setCellValue("记录id");
           row.createCell(1).setCellValue("变更职员");
           row.createCell(2).setCellValue("前职务");
           row.createCell(3).setCellValue("后职务");
           row.createCell(4).setCellValue("更改时间");
//           for(int i = 1;i <= 5;i++){
//             //  row.getCell(i).setCellStyle(getStyle(wb,1));
//           }
           for(int i = 0;i < list.size();i++){
               row = sheet.createRow(i+1);
               JobUpdate jobUpdate = list.get(i);
               row.createCell(0).setCellValue(jobUpdate.getJobUpdateId());
               row.createCell(1).setCellValue(jobUpdate.getUpdateWorker());
               row.createCell(2).setCellValue(jobUpdate.getBeforeId());
               row.createCell(3).setCellValue(jobUpdate.getAfterId());
               row.createCell(4).setCellValue(jobUpdate.getUpdateTime());

           }         //默认行高
           sheet.setDefaultRowHeight((short)(16.5*25));        //列宽自适应
           for(int i=0;i<=13;i++){
               sheet.autoSizeColumn(i);
           }
//            File file = new File("C:\\Users\\Shinelon\\Desktop\\乱七八糟\\javastudy\\excel.xls");
//        FileOutputStream os = new FileOutputStream(file);
         response.setContentType("application/vnd.ms-excel;charset=utf-8");
           OutputStream os = response.getOutputStream();
           wb.write(os);
           os.flush();
           os.close();


    }     /**     * 获取样式
     * @param hssfWorkbook
     * * @param styleNum
     * * @return     */
//    public HSSFCellStyle getStyle(HSSFWorkbook hssfWorkbook, Integer styleNum){
//        HSSFCellStyle style = hssfWorkbook.createCellStyle();
//        style.setBorderRight(BorderStyle.THIN); //右边框
//        style.setBorderBottom(BorderStyle.THIN);//下边框
//        HSSFFont font = hssfWorkbook.createFont();
//        font.setFontName("微软雅黑");//设置字体为微软雅黑
//        HSSFPalette palette = hssfWorkbook.getCustomPalette();//拿到palette颜色板,可以根据需要设置颜色
//         switch (styleNum){
//             case(0):{
//                 style.setAlignment(HorizontalAlignment.CENTER_SELECTION);//跨列居中
//                 font.setBold(true);//粗体
//                 font.setFontHeightInPoints((short) 14);//字体大小
//                 style.setFont(font);
//
//                 style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//             }break;
//             case(1):{
//                 font.setBold(true);//粗体
//                 font.setFontHeightInPoints((short) 11);//字体大小
//                  style.setFont(font);
//             } break;
//             case(2):{
//                 font.setFontHeightInPoints((short)10);
//                 style.setFont(font);
//             }
//             break;
//             case(3):{
//                 style.setFont(font);
//
//                 style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//             }
//             break;
//         }
//         return style;
//    }
}

