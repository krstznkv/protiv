package com.example.demo.services;

import com.example.demo.entity.reports.EpizootologicalExamination;
import com.example.demo.entity.reports.NaturalFocusOfPlague;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
@Service
public class ExcelService {

    public Resource getEpExReport(List<EpizootologicalExamination> list) throws IOException {
        Workbook ExcelBook = new XSSFWorkbook(new FileInputStream("D://avia/protivCenter/protiv/2.5.1.xlsx"));
        Sheet sheet = ExcelBook.getSheet("2.5");
        CellStyle style5 = ExcelBook.createCellStyle();
        style5.setBorderBottom((short) 1);
        style5.setBorderLeft((short) 1);
        style5.setBorderRight((short) 1);
        style5.setBorderTop((short) 1);
        Font font = ExcelBook.createFont();
        font.setFontHeightInPoints((short) 8);
        font.setFontName("Arial");
        style5.setFont(font);
        for (int i = 0; i < list.size(); i++) {
            Row row = sheet.createRow(13 + i);
            Cell cell = row.createCell(0);
            cell.setCellValue(list.get(i).getStation().getStationName());
            cell.setCellStyle(style5);
            Cell cell1 = row.createCell(1);
            cell1.setCellValue(i + 2);
            cell1.setCellStyle(style5);
            Cell cell2 = row.createCell(2);
            cell2.setCellValue(list.get(i).getArea_pole());
            cell2.setCellStyle(style5);
            Cell cell3 = row.createCell(3);
            cell3.setCellValue(list.get(i).getArea_punkt());
            cell3.setCellStyle(style5);
            Cell cell4 = row.createCell(4);
            cell4.setCellValue(list.get(i).getOrud_pole());
            cell4.setCellStyle(style5);
            Cell cell5 = row.createCell(5);
            cell5.setCellValue(list.get(i).getOrud_punkt());
            cell5.setCellStyle(style5);
            Cell cell6 = row.createCell(6);
            cell6.setCellValue(list.get(i).getMites_km());
            cell6.setCellStyle(style5);
            Cell cell7 = row.createCell(7);
            cell7.setCellValue(list.get(i).getMites_h());
            cell7.setCellStyle(style5);
            Cell cell8 = row.createCell(8);
            cell8.setCellValue(list.get(i).getMammals_rodents());
            cell8.setCellStyle(style5);
            Cell cell9 = row.createCell(9);
            cell9.setCellValue(list.get(i).getMammals_insectivores());
            cell9.setCellStyle(style5);
            Cell cell10 = row.createCell(10);
            cell10.setCellValue(list.get(i).getMammals_predators());
            cell10.setCellStyle(style5);
            Cell cell11 = row.createCell(11);
            cell11.setCellValue(list.get(i).getMammals_others());
            cell11.setCellStyle(style5);
            Cell cel11 = row.createCell(12);
            cel11.setCellValue(list.get(i).getBirds());
            cel11.setCellStyle(style5);
            Cell cell12 = row.createCell(13);
            cell12.setCellValue(list.get(i).getArthropods_blox());
            cell12.setCellStyle(style5);
            Cell cell13 = row.createCell(14);
            cell13.setCellValue(list.get(i).getArthropods_mites());
            cell13.setCellStyle(style5);
            Cell cell14 = row.createCell(15);
            cell14.setCellValue(list.get(i).getArthropods_komar());
            cell14.setCellStyle(style5);
            Cell cell15 = row.createCell(16);
            cell15.setCellValue(list.get(i).getArthropods_other());
            cell15.setCellStyle(style5);
            Cell cell16 = row.createCell(17);
            cell16.setCellValue(list.get(i).getPogadki());
            cell16.setCellStyle(style5);
            Cell cell17 = row.createCell(18);
            cell17.setCellValue(list.get(i).getWater());
            cell17.setCellStyle(style5);
            Cell cell18 = row.createCell(19);
            cell18.setCellValue(list.get(i).getOther());
            cell18.setCellStyle(style5);
        }
        XSSFFormulaEvaluator.evaluateAllFormulaCells((XSSFWorkbook) ExcelBook);
        FileOutputStream book = new FileOutputStream("D://avia/protivCenter/protiv/2.5.xlsx");
        ExcelBook.write(book);
        Resource resource = new FileUrlResource("D://avia/protivCenter/protiv/2.5.xlsx");
        return resource;
    }
    public Resource getNatReport(List<NaturalFocusOfPlague> list1,List<NaturalFocusOfPlague> list2) throws IOException {
        Workbook ExcelBook = new XSSFWorkbook(new FileInputStream("D://avia/protivCenter/protiv/2.5.1.xlsx"));
        Sheet sheet = ExcelBook.getSheet("2.2");
        int rowNum=11;
        int i=0;
        for (NaturalFocusOfPlague rep:list1
             ) {
            Row row = sheet.getRow(rowNum+i);
            Row row1=setRowNat(row,rep);
            Cell cell = row1.getCell(0);
            cell.setCellValue(rep.getStation().getStationName());
            i=i+3;
        }
        rowNum=12;
        i=0;
        for (NaturalFocusOfPlague rep:list2
        ) {
            Row row = sheet.getRow(rowNum+i);
            setRowNat(row,rep);
            i=i+3;
        }
        XSSFFormulaEvaluator.evaluateAllFormulaCells((XSSFWorkbook) ExcelBook);
        FileOutputStream book = new FileOutputStream("D://avia/protivCenter/protiv/2.5.xlsx");
        ExcelBook.write(book);
        Resource resource = new FileUrlResource("D://avia/protivCenter/protiv/2.5.xlsx");
        return resource;
    }
    private Row setRowNat(Row row, NaturalFocusOfPlague rep){
        Cell cell1=row.getCell(3);
        cell1.setCellValue(rep.getArea_fiz());
        Cell cell2=row.getCell(4);
        cell2.setCellValue(rep.getArea_oper());
        Cell cell3=row.getCell(5);
        cell3.setCellValue(rep.getNocit());
        Cell cell4=row.getCell(6);
        cell4.setCellValue(rep.getBlox());
        Cell cell5=row.getCell(7);
        cell5.setCellValue(rep.getOrud_pole());
        Cell cell6=row.getCell(8);
        cell6.setCellValue(rep.getOrud_punkt());
        Cell cell7=row.getCell(9);
        cell7.setCellValue(rep.getEnter());
        Cell cell8=row.getCell(10);
        cell8.setCellValue(rep.getBac_nosit());
        Cell cell9=row.getCell(11);
        cell9.setCellValue(rep.getKrov_all());
        Cell cell10=row.getCell(12);
        cell10.setCellValue(rep.getKrov_blox());
        return row;
    }

}
