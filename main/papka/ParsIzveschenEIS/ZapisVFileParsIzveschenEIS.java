package ParsIzveschenEIS;

import ParsPZ.SpisokZakupok;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ZapisVFileParsIzveschenEIS {

    public String filePath;

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public ZapisVFileParsIzveschenEIS(List<SpisokIzvescheniyEIS> list) throws IOException {


        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Список Извещений из ЕИС");


        int rownum = 0;
        Cell cell;
        Row row;
        //
        HSSFCellStyle style = createStyleForTitle(workbook);

        row = sheet.createRow(rownum);

        //
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Номер измещения ЕИС");
        cell.setCellStyle(style);
        //
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Название лота");
        cell.setCellStyle(style);
        //
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("НАЧАЛЬНАЯ МАКСИМАЛЬНАЯ ЦЕНА ДОГОВОРА");
        cell.setCellStyle(style);
        //
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Способ закупки");
        cell.setCellStyle(style);
        //
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Этап");
        cell.setCellStyle(style);
        //
//        cell = row.createCell(5, CellType.STRING);
//        cell.setCellValue("РАЗМЕЩЕНИЕ ИЗВЕЩЕНИЯ");
//        cell.setCellStyle(style);
//        //
//        cell = row.createCell(6, CellType.STRING);
//        cell.setCellValue("ДОПОЛНИТЕЛЬНАЯ ИНФОРМАЦИЯ");
//        cell.setCellStyle(style);

        // Data
        for (SpisokIzvescheniyEIS emp : list) {
            rownum++;
            row = sheet.createRow(rownum);

            //
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(emp.getNomerZakupkiEIS());
            //
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(emp.getnazvanieLota());
            //
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(emp.getNachalnayaMaxCenalota());
            //
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(emp.getsposobZakupki());
            //
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue(emp.getetapZakupki());
//            //РАЗМЕЩЕНИЕ ИЗВЕЩЕНИЯ
//            cell = row.createCell(5, CellType.STRING);
//            cell.setCellValue(emp.getrazmeshenieIzvesheniya());
//            // ДОПОЛНИТЕЛЬНАЯ ИНФОРМАЦИЯ
//            cell = row.createCell(6, CellType.STRING);
//            cell.setCellValue(emp.getdopolnitelnayaInformachiya());

//            String formula = "0.1*C" + (rownum + 1) + "*D" + (rownum + 1);
//            cell = row.createCell(4, CellType.FORMULA);
//            cell.setCellFormula(formula);
        }

        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd_HH-mm-s"); // формат для названия файла
        Date date = new Date();

        File file = new File("D:/RDI/FileSkachivaniya/SpisokPZ-NomeraEIS" + dateFormat.format(date) + ".xls");
        file.getParentFile().mkdirs();

        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        System.out.println("Created file: " + file.getAbsolutePath());
        filePath = file.getPath();
    }

}
