package main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import org.pushingpixels.flamingo.api.common.JCommandButton;
import org.pushingpixels.flamingo.api.common.icon.ImageWrapperResizableIcon;
import org.pushingpixels.flamingo.api.common.icon.ResizableIcon;
import org.pushingpixels.flamingo.api.ribbon.*;
import org.pushingpixels.flamingo.api.ribbon.resize.CoreRibbonResizePolicies;
import org.pushingpixels.flamingo.api.ribbon.resize.IconRibbonBandResizePolicy;
import static org.pushingpixels.flamingo.api.ribbon.RibbonElementPriority.*;


public final class Home extends JRibbonFrame {

    private static final long serialVersionUID = 1L;
    public RibbonTask task1,task2,task3;
    
    public static ResizableIcon getResizableIconFromResource(String resource) {

	return ImageWrapperResizableIcon.getIcon(Home.class
		.getClassLoader().getResource(resource), new Dimension(48, 48));
    }
    
    public Home(){
        initComponents();
    }

    public void initComponents() {
                    
        JRibbonBand band1 = new JRibbonBand(
                                             "Hello",
                                            getResizableIconFromResource("48px-Crystal_Clear_app_Staroffice.png"));
        JRibbonBand band2 = new JRibbonBand("world!", null);
        JRibbonBand band3 = new JRibbonBand("world!", null);

                JCommandButton button1 = new JCommandButton(
                                                        "Square",
                                                        getResizableIconFromResource("48px-Crystal_Clear_app_kthememgr.png"));
                JCommandButton button2 = new JCommandButton(
                                                        "Circle",
                                                        getResizableIconFromResource("48px-Crystal_Clear_app_ksame.png"));
                JCommandButton button3 = new JCommandButton(
                                                        "Triangle",
                                                        getResizableIconFromResource("48px-Crystal_Clear_app_error.png"));
                JCommandButton button4 = new JCommandButton(
                                                        "Star",
                                                        getResizableIconFromResource("48px-Crystal_Clear_action_bookmark.png"));
            button1.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    button1ActionPerformed();
                }
            });
                    
                    
            band1.addCommandButton(button1, TOP);
            band1.addCommandButton(button2, MEDIUM);
            band1.addCommandButton(button3, MEDIUM);
            band1.addCommandButton(button4, MEDIUM);

            band1.setResizePolicies((List) Arrays.asList(
                            new CoreRibbonResizePolicies.None(band1.getControlPanel()),
                            new CoreRibbonResizePolicies.Mirror(band1.getControlPanel()),
                            new CoreRibbonResizePolicies.Mid2Low(band1.getControlPanel()),
                            new CoreRibbonResizePolicies.High2Low(band1.getControlPanel()),
                            new IconRibbonBandResizePolicy(band1.getControlPanel())));
            band2.setResizePolicies((List) Arrays
                            .asList(new IconRibbonBandResizePolicy(band2
                                    .getControlPanel())));
            band3.setResizePolicies((List) Arrays
                            .asList(new IconRibbonBandResizePolicy(band2
                                    .getControlPanel())));

            task1 = new RibbonTask("One", band1);
            task2 = new RibbonTask("Two", band2);
            task3 = new RibbonTask("Three", band3);
            pack();    
    }
    
    public RibbonTask getTask1(){
        return task1;
    }
    public RibbonTask getTask2(){
        return task2;
    }
    public RibbonTask getTask3(){
        return task3;
    }
    
    
    private void button1ActionPerformed() {
        System.out.println("Nothiiing");
    }
    
    /*
    public static void main(String[] args){
       
	SwingUtilities.invokeLater(new Runnable() {

	    @Override
	    public void run() {
                Home hom = new Home();
                hom.setVisible(true);
                hom.getRibbon().addTask(hom.getTask1());
            }

            
        });
    }
    */
    
}
