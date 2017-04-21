package main;

import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import java.awt.Frame;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.UIManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import utils.Global;
import views.SplashScreen;

/**
 *
 * @author TP32447
 */
public class Main {
    private static SplashScreen splas;
    public static Global gp                 = Global.getGlobalProp();
        
    private static void SetTheme(){
        try {            
            String LookAndFeel               = gp.getPropValue("Tema", "LookAndFeel");
            String Theme                     = gp.getPropValue("Tema", "Theme");
    
            UIManager.setLookAndFeel(LookAndFeel);
            AluminiumLookAndFeel.setTheme(Theme);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            //log.error("Error Menampilkan Look And Feel " +ex);
        }
    }
    
    private static void ShowSplash(){
        splas = new SplashScreen();
        splas.setVisible(true);
        for (int i = 0; i <= 100; i++) {
            try {
                splas.getLabel().setText("" + i);
                splas.getProgressBar().setValue(i);
                Thread.sleep(30);
            } catch (InterruptedException e) {
                //log.error("Error Menampilkan Splash Screen " +e);
            }
        }
    }
    
    private static void ShowHome(){
        Home home = new Home();
        home.getRibbon().addTask(home.getTask1());
        home.getRibbon().addTask(home.getTask2());
        home.getRibbon().addTask(home.getTask3());
        home.setLocationRelativeTo(null);
        home.setExtendedState(JFrame.MAXIMIZED_BOTH);                    
        home.setVisible(true);
    }
    
    public static void main(String[] args){
        SetTheme();
        ShowSplash();
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
            
                try{
                    //ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
                    ShowHome();
                    splas.dispose();
                }catch(Exception ex){
                    System.out.println("EX : "+ex.toString());
                    System.exit(0);
                }
                
            }
            
        });
    }
}
