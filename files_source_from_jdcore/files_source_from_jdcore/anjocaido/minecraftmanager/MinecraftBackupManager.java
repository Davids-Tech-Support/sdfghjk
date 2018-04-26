package anjocaido.minecraftmanager;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class MinecraftBackupManager extends javax.swing.JFrame
{
  private JButton backupgame;
  private javax.swing.JCheckBox fullgamebackup;
  private JButton jButton1;
  private JButton jButton2;
  private JButton jButton5;
  private JLabel jLabel1;
  private JLabel jLabel10;
  private JLabel jLabel12;
  private JLabel jLabel2;
  private JLabel jLabel3;
  private JLabel jLabel4;
  private JLabel jLabel5;
  private JLabel jLabel6;
  private JLabel jLabel7;
  
  public MinecraftBackupManager()
  {
    try
    {
      javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    }
    catch (ClassNotFoundException ex) {}catch (InstantiationException ex) {}catch (IllegalAccessException ex) {}catch (javax.swing.UnsupportedLookAndFeelException ex) {}
    


    initComponents();
    refreshButtons();
  }
  







  private void initComponents()
  {
    worldgroup = new javax.swing.ButtonGroup();
    jTabbedPane1 = new javax.swing.JTabbedPane();
    jPanel1 = new javax.swing.JPanel();
    jPanel3 = new javax.swing.JPanel();
    world1 = new JRadioButton();
    world2 = new JRadioButton();
    world3 = new JRadioButton();
    world4 = new JRadioButton();
    world5 = new JRadioButton();
    jPanel4 = new javax.swing.JPanel();
    jButton1 = new JButton();
    jButton2 = new JButton();
    jLabel3 = new JLabel();
    jLabel4 = new JLabel();
    jLabel5 = new JLabel();
    jLabel6 = new JLabel();
    jLabel10 = new JLabel();
    jPanel2 = new javax.swing.JPanel();
    uninstall = new JButton();
    saveuninstall = new javax.swing.JCheckBox();
    backupgame = new JButton();
    jButton5 = new JButton();
    jLabel1 = new JLabel();
    jLabel2 = new JLabel();
    jLabel7 = new JLabel();
    fullgamebackup = new javax.swing.JCheckBox();
    jSeparator1 = new javax.swing.JSeparator();
    jLabel8 = new JLabel();
    jLabel12 = new JLabel();
    
    setDefaultCloseOperation(2);
    setTitle("Minecraft Backup Manager (by AnjoCaido)");
    
    worldgroup.add(world1);
    world1.setForeground(new java.awt.Color(255, 0, 0));
    world1.setText("World 1");
    
    worldgroup.add(world2);
    world2.setForeground(new java.awt.Color(255, 0, 0));
    world2.setText("World 2");
    
    worldgroup.add(world3);
    world3.setForeground(new java.awt.Color(255, 0, 0));
    world3.setText("World 3");
    
    worldgroup.add(world4);
    world4.setForeground(new java.awt.Color(255, 0, 0));
    world4.setText("World 4");
    
    worldgroup.add(world5);
    world5.setForeground(new java.awt.Color(255, 0, 0));
    world5.setText("World 5");
    
    GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(world1).addComponent(world2).addComponent(world3).addComponent(world4).addComponent(world5)).addContainerGap(-1, 32767)));
    










    jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(world1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(world2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(world3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(world4).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(world5).addContainerGap(-1, 32767)));
    














    jButton1.setText("Do Backup");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        MinecraftBackupManager.this.jButton1ActionPerformed(evt);
      }
      
    });
    jButton2.setText("Restore Backup");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        MinecraftBackupManager.this.jButton2ActionPerformed(evt);
      }
      
    });
    GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(jButton2, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(jButton1, GroupLayout.Alignment.LEADING, -1, 118, 32767)).addContainerGap()));
    







    jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(jButton1).addGap(18, 18, 18).addComponent(jButton2).addContainerGap(-1, 32767)));
    








    jLabel3.setText("Everything will be stored in a Zip format.");
    
    jLabel4.setText("But I will use .mcworld extension,  cuz that makes me happy.");
    
    jLabel5.setText("You can restore any previous world number, to any world number you desire.");
    
    jLabel6.setText("Ex: You create a backup of World 2, but then you can restore it to World 1.");
    
    jLabel10.setForeground(new java.awt.Color(255, 0, 0));
    jLabel10.setText("RED color marks the Worlds you don't have!");
    
    GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(jPanel3, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(jPanel4, -2, -1, -2)).addComponent(jLabel10).addComponent(jLabel3))).addComponent(jLabel4).addComponent(jLabel5).addComponent(jLabel6)).addContainerGap(109, 32767)));
    

















    jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(jPanel3, -2, -1, -2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel10).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel4, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(jLabel3))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel4).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel5).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel6).addContainerGap()));
    



















    jTabbedPane1.addTab("Game Saves", jPanel1);
    
    uninstall.setText("Uninstall Game");
    uninstall.setEnabled(false);
    uninstall.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        MinecraftBackupManager.this.uninstallActionPerformed(evt);
      }
      
    });
    saveuninstall.setText("Complete Uninstall (Include Game Saves/Worlds)");
    saveuninstall.setEnabled(false);
    
    backupgame.setText("Backup Game (Binaries)");
    backupgame.setEnabled(false);
    backupgame.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        MinecraftBackupManager.this.backupgameActionPerformed(evt);
      }
      
    });
    jButton5.setText("Restore Game");
    jButton5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        MinecraftBackupManager.this.jButton5ActionPerformed(evt);
      }
      
    });
    jLabel1.setText("You might want to backup the whole game at least once after it's installed.");
    
    jLabel2.setText("Never know when there is an update out there that breaks everything.");
    
    jLabel7.setText("Zip format again, but .mcgame extension. It really makes me happy.");
    
    fullgamebackup.setText("Entire Folder (Inc. Saves or any other file there)");
    fullgamebackup.setEnabled(false);
    fullgamebackup.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        MinecraftBackupManager.this.fullgamebackupActionPerformed(evt);
      }
      
    });
    GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(6, 6, 6).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jLabel2).addComponent(jLabel7).addComponent(jLabel1))).addComponent(jSeparator1, -1, 551, 32767).addGroup(jPanel2Layout.createSequentialGroup().addComponent(uninstall).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(saveuninstall)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(backupgame).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(fullgamebackup)).addComponent(jButton5, -2, 239, -2)).addContainerGap()));
    





















    jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(uninstall).addComponent(saveuninstall)).addGap(3, 3, 3).addComponent(jSeparator1, -2, 10, -2).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(backupgame).addComponent(fullgamebackup)).addGap(18, 18, 18).addComponent(jButton5).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel7).addContainerGap(-1, 32767)));
    






















    jTabbedPane1.addTab("Game Installation", jPanel2);
    
    jLabel8.setText("by AnjoCaido - v1.1");
    
    jLabel12.setText("Backup/Restore take some seconds, wait for \"Done!\".");
    
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(jTabbedPane1, GroupLayout.Alignment.LEADING, -1, 563, 32767).addGroup(layout.createSequentialGroup().addComponent(jLabel12).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, 32767).addComponent(jLabel8))).addContainerGap()));
    










    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(jTabbedPane1, -1, 234, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel8).addComponent(jLabel12)).addContainerGap()));
    










    pack();
  }
  
  private void uninstallActionPerformed(java.awt.event.ActionEvent evt) {
    int result = javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure that you want to uninstall Minecraft?\nCan't Undo It! (unless you have backup, hehe)", "Are you sure? (Uninstallation)", 0, 2);
    
    if ((result == 1) || (result == -1)) {
      return;
    }
    BackupUtil.uninstallGame(saveuninstall.isSelected());
    javax.swing.JOptionPane.showMessageDialog(this, "Done!", "Uninstallation", -1);
    refreshButtons();
  }
  
  private void backupgameActionPerformed(java.awt.event.ActionEvent evt) {
    JFileChooser save = new JFileChooser();
    java.util.Calendar now = java.util.GregorianCalendar.getInstance();
    save.setSelectedFile(new java.io.File(String.format("MCGame_" + (fullgamebackup.isSelected() ? "Complete_" : "") + "%1$tY-%1$tm-%1$td_%1$tH-%1$tM-%1$tS" + "_Backup." + "mcgame", new Object[] { now })));
    save.setFileSelectionMode(0);
    save.setFileFilter(new BackupUtil.GameFileFilter());
    int result = save.showSaveDialog(this);
    if (result != 0) {
      return;
    }
    java.io.File f = save.getSelectedFile();
    if (f == null) {
      return;
    }
    BackupUtil.backupGame(f, fullgamebackup.isSelected());
    javax.swing.JOptionPane.showMessageDialog(this, "Done!", "Game Backup", -1);
  }
  
  private void jButton5ActionPerformed(java.awt.event.ActionEvent evt)
  {
    int result = javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure that you want to restore WHOLE Minecraft?\nIT MIGHT OVERWRITE ALL YOUR DATA\n(if is a complete backup, you'll lose all your actual worlds/saves!)\nMake sure you have your most recent save games backed up before this!", "Are you sure? (Full Game Restoration)", 0, 2);
    


    if ((result == 1) || (result == -1)) {
      return;
    }
    JFileChooser save = new JFileChooser();
    save.setFileSelectionMode(0);
    save.setFileFilter(new BackupUtil.GameFileFilter());
    save.showOpenDialog(this);
    java.io.File f = save.getSelectedFile();
    if ((f == null) || (!f.exists())) {
      return;
    }
    try {
      BackupUtil.restoreGame(f);
    } catch (IllegalStateException ex) {
      javax.swing.JOptionPane.showMessageDialog(this, "Failed!\nInvalid Zip Contents!\nthe game folder inside must have 'minecraft_backup' as name.", "Game Restoration", 0);
      

      return;
    }
    javax.swing.JOptionPane.showMessageDialog(this, "Done!", "Game Restoration", -1);
    refreshButtons();
  }
  
  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    int world = getWorldSelected();
    if (world < 0) {
      javax.swing.JOptionPane.showMessageDialog(this, "Error. Please Select a World to Backup first!", "World Backup", 0);
      return;
    }
    if (!BackupUtil.getWorldNFolder(world).exists()) {
      javax.swing.JOptionPane.showMessageDialog(this, "Sorry, but this world doesn't Exist!", "World Backup", 0);
      return;
    }
    JFileChooser save = new JFileChooser();
    java.util.Calendar now = java.util.GregorianCalendar.getInstance();
    save.setFileSelectionMode(0);
    save.setSelectedFile(new java.io.File(String.format("MCWorld" + world + "_" + "%1$tY-%1$tm-%1$td_%1$tH-%1$tM-%1$tS" + "_Backup." + "mcworld", new Object[] { now })));
    
    save.setFileFilter(new BackupUtil.WorldFileFilter());
    int result = save.showSaveDialog(this);
    if (result != 0) {
      return;
    }
    java.io.File f = save.getSelectedFile();
    if (f == null) {
      return;
    }
    BackupUtil.backupWorld(world, f);
    javax.swing.JOptionPane.showMessageDialog(this, "Done!", "World Backup", -1);
  }
  
  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    int world = getWorldSelected();
    if (world < 0) {
      javax.swing.JOptionPane.showMessageDialog(this, "Error. Please Select a World to Restore first!", "World Restoration", 0);
      return;
    }
    if (BackupUtil.getWorldNFolder(world).exists()) {
      int result = javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure that you want to overwrite World " + world + "?\n" + "Can't Undo It! (unless you have backup, hehe)", "Are you sure? (World Restoration)", 0, 2);
      
      if ((result == 1) || (result == -1)) {
        return;
      }
    }
    
    JFileChooser save = new JFileChooser();
    save.setFileSelectionMode(0);
    save.setFileFilter(new BackupUtil.WorldFileFilter());
    save.showOpenDialog(this);
    java.io.File f = save.getSelectedFile();
    if (f == null) {
      return;
    }
    try {
      BackupUtil.restoreWorld(world, f);
    } catch (IllegalStateException ex) {
      javax.swing.JOptionPane.showMessageDialog(this, "Failed!\nInvalid Zip Contents!\nthe world folder inside must have 'world_backup' as name.", "World Restoration", 0);
      

      return;
    }
    javax.swing.JOptionPane.showMessageDialog(this, "Done!", "World Restoration", -1);
    refreshButtons();
  }
  
  private void fullgamebackupActionPerformed(java.awt.event.ActionEvent evt) {
    if (fullgamebackup.isSelected()) {
      backupgame.setText("Backup Game (Complete)");
    } else {
      backupgame.setText("Backup Game (Binaries)");
    }
  }
  
  public int getWorldSelected() {
    if (world1.isSelected()) {
      return 1;
    }
    if (world2.isSelected()) {
      return 2;
    }
    if (world3.isSelected()) {
      return 3;
    }
    if (world4.isSelected()) {
      return 4;
    }
    if (world5.isSelected()) {
      return 5;
    }
    return -1;
  }
  


  public static void main(String[] args)
  {
    java.awt.EventQueue.invokeLater(new Runnable()
    {
      public void run() {
        new MinecraftBackupManager().setVisible(true);
      }
    });
  }
  


  private JLabel jLabel8;
  
  private javax.swing.JPanel jPanel1;
  
  private javax.swing.JPanel jPanel2;
  
  private javax.swing.JPanel jPanel3;
  
  private javax.swing.JPanel jPanel4;
  
  private javax.swing.JSeparator jSeparator1;
  
  private javax.swing.JTabbedPane jTabbedPane1;
  
  private javax.swing.JCheckBox saveuninstall;
  
  private JButton uninstall;
  
  private JRadioButton world1;
  
  private JRadioButton world2;
  
  private JRadioButton world3;
  
  private JRadioButton world4;
  
  private JRadioButton world5;
  
  private javax.swing.ButtonGroup worldgroup;
  
  private void refreshButtons()
  {
    if (BackupUtil.getWorldNFolder(1).exists()) {
      world1.setForeground(java.awt.Color.BLACK);
    } else {
      world1.setForeground(java.awt.Color.RED);
    }
    if (BackupUtil.getWorldNFolder(2).exists()) {
      world2.setForeground(java.awt.Color.BLACK);
    } else {
      world2.setForeground(java.awt.Color.RED);
    }
    if (BackupUtil.getWorldNFolder(3).exists()) {
      world3.setForeground(java.awt.Color.BLACK);
    } else {
      world3.setForeground(java.awt.Color.RED);
    }
    if (BackupUtil.getWorldNFolder(4).exists()) {
      world4.setForeground(java.awt.Color.BLACK);
    } else {
      world4.setForeground(java.awt.Color.RED);
    }
    if (BackupUtil.getWorldNFolder(5).exists()) {
      world5.setForeground(java.awt.Color.BLACK);
    } else {
      world5.setForeground(java.awt.Color.RED);
    }
    


    if ((net.minecraft.MinecraftUtil.getBinFolder().exists()) || (net.minecraft.MinecraftUtil.getLoginFile().exists()) || (net.minecraft.MinecraftUtil.getOptionsFile().exists()) || (net.minecraft.MinecraftUtil.getResourcesFolder().exists()) || (net.minecraft.MinecraftUtil.getSavesFolder().exists())) {
      uninstall.setEnabled(true);
    } else {
      uninstall.setEnabled(false);
    }
    
    if (net.minecraft.MinecraftUtil.getSavesFolder().exists()) {
      saveuninstall.setEnabled(true);
    } else {
      saveuninstall.setEnabled(false);
    }
    

    if (net.minecraft.MinecraftUtil.getBinFolder().exists()) {
      backupgame.setEnabled(true);
      fullgamebackup.setEnabled(true);
    } else {
      backupgame.setEnabled(false);
      fullgamebackup.setEnabled(false);
    }
  }
}
