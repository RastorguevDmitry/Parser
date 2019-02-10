package MainPackage;

import MyWindow.MyWindow;


public class MainParser {


//    private static Document getPage(int str) throws IOException {
//
//        String url1 = "http://zakupki.gov.ru/223/plan/public/plan/info/positions.html?planInfoId=2897106&planId=377214&d-5492750-p=";
//        String url2 = "&versioned=&activeTab=4&epz=true";
//
//        Document page = Jsoup.parse(new URL(url1 + str + url2), 60000);
//        return page;
//    }

    public static void main(String[] args) throws Exception {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyWindow();
            }
        });



//        List<ParsPZ.SpisokZakupok> list = new ArrayList<ParsPZ.SpisokZakupok>();
//        for (int str = 1; str <= 2; str++) {
//            Document page = getPage(str);
//            Element spisokZakupokNaStraniche = page.select("tbody").get(3);
//            Elements zakupokiSClassomODD = spisokZakupokNaStraniche.select("tr");
//            Elements zakupokiSClassomEVEN = spisokZakupokNaStraniche.select("tr[class=even]");
//
//            for (Element name : zakupokiSClassomODD) {      //перебираем закупки на странице
//                Elements td = name.select("td"); // перебираем текст в строке
//
//                //Разбор яцейки с номером плана закупки
//                String nomerPZElement = td.get(0).select("td[style=text-align:left; width:60px;]").text();
//                String nomerPZ = ParsPZ.MyPatterns.getDateFromString(nomerPZElement);
//                //Разбор яцейки с названием лота
//                String nazvanieLota = td.get(1).text();
//                //Разбор яцейки НАЧАЛЬНАЯ МАКСИМАЛЬНАЯ ЦЕНА ДОГОВОРА
//                String nachalnayaMaxCenalota = td.get(2).text();
//                //Разбор яцейки РАЗМЕЩЕНИЕ ИЗВЕЩЕНИЯ
//                String razmeshenieIzvesheniya = td.get(3).text();
//                //Разбор яцейки  СРОК ИСПОЛНЕНИЯ ДОГОВОРА
//                String srokIspolneniyaDogovora = td.get(4).text();
//                //Разбор яцейки  ДОПОЛНИТЕЛЬНАЯ ИНФОРМАЦИЯ
//                String dopolnitelnayaInformachiya = td.get(5).text();
//                String NomerZakupkiEIS = ParsPZ.MyPatterns.getNomerZakupkiEISFromString(dopolnitelnayaInformachiya);
//
//                ParsPZ.SpisokZakupok e1 = new ParsPZ.SpisokZakupok(nomerPZ, NomerZakupkiEIS, nazvanieLota,//
//                        nachalnayaMaxCenalota, srokIspolneniyaDogovora, razmeshenieIzvesheniya, dopolnitelnayaInformachiya);
//                list.add(e1);
//
//            }
//        }
//        new MainPackage.ZapisVFile(list);
    }


}


