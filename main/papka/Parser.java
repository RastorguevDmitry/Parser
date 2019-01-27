import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {


    private static Document getPage(int str) throws IOException {

        // String url = "http://www.pogoda.spb.ru/";
        String url1 = "http://zakupki.gov.ru/223/plan/public/plan/info/positions.html?planInfoId=2897106&planId=377214&d-5492750-p=";
        String url2 = "&versioned=&activeTab=4&epz=true";

        Document page = Jsoup.parse(new URL(url1 + str + url2), 60000);
        return page;
    }


    private static Pattern patternPoiskaNomeraPZ = Pattern.compile("\\b\\d{9}\\b"); // регулярные выражения

    private static String getDateFromString(String stringDate) throws Exception {
        Matcher matcher = patternPoiskaNomeraPZ.matcher(stringDate);
        if (matcher.find()) {
            return matcher.group();
        }
        throw new Exception("Cant extract");
    }

    private static Pattern patternPoiskaNomeraZakupkiEIS = Pattern.compile("\\d{11}"); // регулярные выражения


    private static String getNomerZakupkiEISFromString(String stringDate) throws Exception {
        Matcher matcher = patternPoiskaNomeraZakupkiEIS.matcher(stringDate);
        if (matcher.find()) {
            return matcher.group();
        }
        return "0";
        //throw new Exception("Cant extract");
    }

    private static int printFourValues(Elements values, int index) {
        int iterationCount = 4;
        for (int i = 0; i < iterationCount; i++) {
            Element valueLine = values.get(index + i);
            for (Element td : valueLine.select("td")) {
                System.out.print(td.text() + "    ");
            }
            System.out.println();
        }


        return iterationCount;
    }

    public static void main(String[] args) throws Exception {

        List<Employee> list = new ArrayList<Employee>();
        for (int str = 1; str <= 2; str++) {

            Document page = getPage(str);
            Element spisokZakupokNaStraniche = page.select("tbody").get(3);
            Elements zakupokiSClassomODD = spisokZakupokNaStraniche.select("tr");
            Elements zakupokiSClassomEVEN = spisokZakupokNaStraniche.select("tr[class=even]");

            // Elements values = tablePosition.select("tr[valign=top]");
            int index = 0;

            for (Element name : zakupokiSClassomODD) {      //перебираем закупки
                // String dateString = name.select("td[style=text-align:left; width:60px;]").text();
                // String nomerPZ = getDateFromString (dateString);
                // String nomerZakupkiEIS = getNomerZakupkiEISFromString (dateString);

                Elements td = name.select("td");

                //Разбор яцейки с номером плана закупки
                String nomerPZElement = td.get(0).select("td[style=text-align:left; width:60px;]").text();
                String nomerPZ = getDateFromString(nomerPZElement);
                //Разбор яцейки с названием лота
                String nazvanieLota = td.get(1).text();
                //Разбор яцейки НАЧАЛЬНАЯ МАКСИМАЛЬНАЯ ЦЕНА ДОГОВОРА
                String nachalnayaMaxCenalota = td.get(2).text();
                //Разбор яцейки РАЗМЕЩЕНИЕ ИЗВЕЩЕНИЯ
                String razmeshenieIzvesheniya = td.get(3).text();
                //Разбор яцейки  СРОК ИСПОЛНЕНИЯ ДОГОВОРА
                String srokIspolneniyaDogovora = td.get(4).text();
                //Разбор яцейки  ДОПОЛНИТЕЛЬНАЯ ИНФОРМАЦИЯ
                String dopolnitelnayaInformachiya = td.get(5).text();
                String NomerZakupkiEIS = getNomerZakupkiEISFromString(dopolnitelnayaInformachiya);

                Employee e1 = new Employee(nomerPZ, NomerZakupkiEIS, nazvanieLota, nachalnayaMaxCenalota, srokIspolneniyaDogovora);
                list.add(e1);


               // System.out.println(nomerPZ + "  " + NomerZakupkiEIS);

            }
        }


        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Список номеров ПЗ из ЕИС");

       // List<Employee> list = EmployeeDAO.listEmployees();

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
        for (Employee emp : list) {
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

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }


}


