package MyWindow;

import ParsIzveschenEIS.ParsIzvescheniyaEIS;
import ParsPZ.*;
import MainPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyWindow extends JFrame {
    //основное окно
    private JPanel mainWindowForChois = new JPanel();

    //часть для работы с ПЗ
    private JPanel panelForPZ = new JPanel();
    private Button buttonNewFindPZ = new Button("Обновить план закупок");
    //часть для работы с Извещениями
    private JPanel panelForIzvescheniya = new JPanel();
    private Button buttonNewFindIzvescheniya = new Button("Найти объявленные закупки");
    //часть для работы с Договорами
    private JPanel panelForDogovory = new JPanel();
    private Button buttonForDogovory = new Button("Найти договоры");

    public static String dateBegin, dateEnd;


    public MyWindow() {
        super("Работа с закупками");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        // mainWindowForChois.setLayout( new BorderLayout(5,5));
        mainWindowForChois.setLayout(new GridLayout(3, 1, 5, 5));
        mainWindowForChois.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panelForPZ.setLayout(new GridLayout(1, 3, 5, 5));
        panelForIzvescheniya.setLayout(new GridLayout(1, 3, 5, 5));
        panelForDogovory.setLayout(new GridLayout(1, 3, 5, 5));

        // Слушатель нажатия кнопки "Найти объявленные закупки"
        buttonNewFindIzvescheniya.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        buttonNewFindPZ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ParserPZ parserPZ = new ParserPZ();
                    DialogWindow dialogWindow = new DialogWindow(MyWindow.this, parserPZ.filePath);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

// слушатель нажатия кнопки Найти объявленные закупки
        buttonNewFindIzvescheniya.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Calendar cal = Calendar.getInstance(); //текущее время
                    SimpleDateFormat s = new SimpleDateFormat("dd.MM.yyyy");
                    dateEnd = s.format(new Date(cal.getTimeInMillis())); //текущая дата в формате
                    cal.add(Calendar.DATE, -50); // от текущей минус 7 дней
                    dateBegin = s.format(new Date(cal.getTimeInMillis())); //дата начала периода в формате

                    ParsIzvescheniyaEIS parsIzvescheniyaEIS = new ParsIzvescheniyaEIS();

                    DialogWindow dialogWindow = new DialogWindow(MyWindow.this, parsIzvescheniyaEIS.filePath);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        //  добавление кнопок в панели
        panelForPZ.add(buttonNewFindPZ);
        panelForIzvescheniya.add(buttonNewFindIzvescheniya);
        panelForDogovory.add(buttonForDogovory);


        // mainWindowForChois.setLayout(new GridLayout());

        // добавление панелей в основоное окно

        mainWindowForChois.add(panelForPZ);
        mainWindowForChois.add(panelForIzvescheniya);
        mainWindowForChois.add(panelForDogovory);

        // mainWindowForChois.add(panelForIzvescheniya,BorderLayout.SOUTH);


        getContentPane().add(mainWindowForChois);
        setSize(600, 600);
        setLocationRelativeTo(null); // посередине
        setVisible(true);

    }


}
