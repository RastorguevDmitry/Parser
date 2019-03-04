package MainPackage;

import MyWindow.MyWindow;


public class MainParser {


    public static void main(String[] args) throws Exception {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyWindow();
            }
        });


    }


}


