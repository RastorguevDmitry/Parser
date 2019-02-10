package ParsIzveschenEIS;

import MainPackage.ZapisVFile;
import ParsIzveschenEIS.SpisokIzvescheniyEIS;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import MyWindow.*;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParsIzvescheniyaEIS {

    public static String dateBegin;
    public static String dateEnd;
    public String filePath;


    private static Document getPage() throws IOException {

        dateBegin = MyWindow.dateBegin;
        dateEnd = MyWindow.dateEnd;
        String url1 = "http://zakupki.gov.ru/epz/order/extendedsearch/results.html?morphology=on&openMode=USE_DEFAULT_PARAMS" +
         "&pageNumber=1&sortDirection=false&recordsPerPage=_500&showLotsInfoHidden=false&fz223=on&af=on&ca=on&" +
         "pc=on&pa=on&currencyIdGeneral=-1&publishDateFrom=" + dateBegin + "&publishDateTo=" + dateEnd +
         "&agencyTitle=%D0%9F%D0%A3%D0%91%D0%9B%D0%98%D0%A7%D0%9D%D0%9E%D0%95+%D0%90%D0%9A%D0%A6%D0%98%D0%9E%D0%9D%D0%95%D0%A0%D0%9D%D0%9E%D0%95+%D0%9E%D0%91%D0%A9%D0%95%D0%A1%D0%A2%D0%92%D0%9E+%22%D0%9C%D0%9E%D0%A1%D0%9A%D0%9E%D0%92%D0%A1%D0%9A%D0%90%D0%AF+%D0%9E%D0%91%D0%AA%D0%95%D0%94%D0%98%D0%9D%D0%95%D0%9D%D0%9D%D0%90%D0%AF+%D0%AD%D0%9B%D0%95%D0%9A%D0%A2%D0%A0%D0%9E%D0%A1%D0%95%D0%A2%D0%95%D0%92%D0%90%D0%AF+%D0%9A%D0%9E%D0%9C%D0%9F%D0%90%D0%9D%D0%98%D0%AF%22"+
        "&agencyCode=06480000001&agencyFz94id=816370&agencyFz223id=9422&regionDeleted=false&sortBy=UPDATE_DATE";
        Document page = Jsoup.parse(new URL(url1), 60000);
        return page;
    }

    public  ParsIzvescheniyaEIS() throws Exception {

        Document page = getPage();
        List<SpisokIzvescheniyEIS> list = new ArrayList<SpisokIzvescheniyEIS>();

           // Element spisokZakupokNaStraniche = page.select("div[class=\"paginator greyBox \"]").get(1);
            Elements zakupokiSClassomODD = page.select("div[class=\"registerBox registerBoxBank margBtm20\"]");


            for (Element name : zakupokiSClassomODD) {      //перебираем закупки на странице

                Elements td = name.select("strong");
                String sposobZakupki = td.get(0).text();
                String nachalnayaMaxCenalota  = td.get(1).text();
                nachalnayaMaxCenalota = nachalnayaMaxCenalota.replaceAll(" ","");
                nachalnayaMaxCenalota = nachalnayaMaxCenalota.replaceAll(" ","");
                //этап
                Elements span = name.select("span");
                String etapZakupki = span.get(0).text();
                etapZakupki = etapZakupki.substring(0, etapZakupki.indexOf("/")-1);

                //class="descriptTenderTd"
                String NomerZakupkiEIS = ParsPZ.MyPatterns.getNomerZakupkiEISFromString(name.select(
                        "td[class=\"descriptTenderTd\"]").text());

                Elements dd = name.select("dd");
                String nazvanieLota = dd.get(4).text();

                ParsIzveschenEIS.SpisokIzvescheniyEIS e1 = new ParsIzveschenEIS.SpisokIzvescheniyEIS(
                        NomerZakupkiEIS,
                        nazvanieLota,
                        etapZakupki,
                        sposobZakupki,
                        nachalnayaMaxCenalota);
                list.add(e1);
            }

        ZapisVFileParsIzveschenEIS zapisVFileParsIzveschenEIS = new ZapisVFileParsIzveschenEIS(list);
        filePath = zapisVFileParsIzveschenEIS.filePath;
    }



}
