import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {


    private static Document getPage() throws IOException {

      // String url = "http://www.pogoda.spb.ru/";
        String url =  "http://zakupki.gov.ru/223/plan/public/plan/info/actual-positions.html?planId=377214&planInfoId=2897106&versioned=&activeTab=4&epz=true";
        Document page = Jsoup.parse(new URL(url),3000);
        return page;
    }


            private  static Pattern patternPoiskaNomeraPZ = Pattern.compile("\\b\\d{9}\\b"); // регулярные выражения

            private static String getDateFromString(String stringDate) throws Exception{
            Matcher matcher = patternPoiskaNomeraPZ.matcher(stringDate);
            if (matcher.find()){
                return matcher.group();
            }
            throw new Exception("Cant extract");
              }

            private  static Pattern patternPoiskaNomeraZakupkiEIS = Pattern.compile("№\\d{11},"); // регулярные выражения


            private static String getNomerZakupkiEISFromString(String stringDate) throws Exception{
                Matcher matcher = patternPoiskaNomeraZakupkiEIS.matcher(stringDate);
                if (matcher.find()){
                    return matcher.group();
                }
                throw new Exception("Cant extract");
            }

    private static int printFourValues(Elements values, int index){
        int iterationCount = 4;
        if (index == 0 )
        {
            Element valueLn = values.get(0);
            boolean isEvening = valueLn.text().contains("Вечер");
                            if (isEvening){
                                iterationCount = 2;
                            }
        }
        for(int i = 0; i < iterationCount; i++){
            Element valueLine = values.get(index + i);
            for (Element td: valueLine.select("td")){
                System.out.print(td.text() + "    ");
            }
            System.out.println();
        }


        return  iterationCount;
    }

    public static void main (String[] args) throws Exception {

        Document page = getPage();
        Element spisokZakupokNaStraniche = page.select("table[id=planInfoPosition]").first();
        Elements zakupokiSClassomODD = spisokZakupokNaStraniche.select("tr[class=odd]");
        Elements zakupokiSClassomEVEN = spisokZakupokNaStraniche.select("tr[class=even]");

       // Elements values = tablePosition.select("tr[valign=top]");
        int index = 0;
        for (Element name : zakupokiSClassomODD) {      //перебираем закупки
            String dateString = name.select("td[style=text-align:left; width:60px;]").text();
            String nomerPZ = getDateFromString (dateString);
            String nomerZakupkiEIS = getNomerZakupkiEISFromString (dateString);



            System.out.println(nomerPZ);
            int iterationCount =  printFourValues(zakupokiSClassomODD, index);
            index = index + iterationCount;
        }
    }
}
