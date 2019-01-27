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

public class ZapisVFile {

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public ZapisVFile(List<SpisokZakupok> list) throws IOException {


        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Список номеров ПЗ из ЕИС");


        int rownum = 0;
        Cell cell;
        Row row;
        //
        HSSFCellStyle style = createStyleForTitle(workbook);

        row = sheet.createRow(rownum);

        // EmpNo
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Номер закупки из плана закупки ЕИС");
        cell.setCellStyle(style);
        // EmpName
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Номер измещения ЕИС");
        cell.setCellStyle(style);
        // Salary
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Название лота");
        cell.setCellStyle(style);
        // Grade
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("НАЧАЛЬНАЯ МАКСИМАЛЬНАЯ ЦЕНА ДОГОВОРА");
        cell.setCellStyle(style);
        // Bonus
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("СРОК ИСПОЛНЕНИЯ ДОГОВОРА");
        cell.setCellStyle(style);

        // Data
        for (SpisokZakupok emp : list) {
            rownum++;
            row = sheet.createRow(rownum);

            // EmpNo (A)
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(emp.getEmpNo());
            // EmpName (B)
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(emp.getEmpName());
            // Salary (C)
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(emp.getSalary());
            // Grade (D)
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(emp.getNachalnayaMaxCenalota());
            // Bonus (E)
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue(emp.getSrokIspolneniyaDogovora());

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


    }


}
