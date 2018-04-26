package anjocaido.console;

import java.awt.Adjustable;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.DropMode;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class OutputConsole
  extends JFrame
{
  int threadsUsing = 0;
  private JScrollPane jScrollPane1;
  private JTextArea jTextArea1;
  
  public OutputConsole() { initComponents();
    jScrollPane1.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener()
    {
      public void adjustmentValueChanged(AdjustmentEvent e) {
        e.getAdjustable().setValue(e.getAdjustable().getMaximum());
      }
    });
    pack();
    setVisible(true);
  }
  







  private void initComponents()
  {
    jScrollPane1 = new JScrollPane();
    jTextArea1 = new JTextArea();
    
    setDefaultCloseOperation(2);
    setTitle("Error Console");
    
    jScrollPane1.setAutoscrolls(true);
    jScrollPane1.setColumnHeaderView(null);
    jScrollPane1.setCursor(new Cursor(0));
    jScrollPane1.setDebugGraphicsOptions(-1);
    
    jTextArea1.setColumns(20);
    jTextArea1.setEditable(false);
    jTextArea1.setRows(5);
    jTextArea1.setDropMode(DropMode.INSERT);
    jScrollPane1.setViewportView(jTextArea1);
    
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, -1, 636, 32767).addContainerGap()));
    





    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, -1, 227, 32767).addContainerGap()));
    






    pack();
  }
  


  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run() {
        new OutputConsole().setVisible(true);
      }
    });
  }
  
  public void appendText(String text) {
    jTextArea1.append(text);
    jTextArea1.selectAll();
    
    if (threadsUsing <= 0) {
      waitToDispose();
    }
  }
  
  public void acquire() {
    threadsUsing += 1;
  }
  
  public void release() {
    threadsUsing -= 1;
    if (threadsUsing <= 0) {
      waitToDispose();
    }
  }
  
  public void waitToDispose() {
    jTextArea1.append("\n\nThreads have Stopped... closing this window in 15 Seconds...\nIf you want to copy this, do it NOW!");
    try
    {
      Thread.sleep(15000L);
    }
    catch (InterruptedException ex) {}finally {
      dispose();
    }
  }
}
