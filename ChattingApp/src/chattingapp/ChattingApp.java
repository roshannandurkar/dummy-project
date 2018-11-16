package chattingapp;

import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.multi.MultiLookAndFeel;
import javax.swing.plaf.synth.SynthLookAndFeel;

public class ChattingApp {

    public static void main(String[] args) {
        try 
        {
            UIManager.setLookAndFeel(new AluminiumLookAndFeel());
            new ChattingWindow().setVisible(true);
        }
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex+"NLT");
        }
    }
    
}
