import javax.swing.*;
import java.awt.*;

import static UI.ServerInferface.dict_frame;

/**
 * Created by Cyan on 2016/12/6.
 */
public class DictClient{
    /*改*/
   public static void main(String args[]){
       //DictFrame dict_frame = new DictFrame();
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    dict_frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
