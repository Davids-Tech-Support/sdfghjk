package net.minecraft;

import anjocaido.minecraftmanager.MinecraftBackupManager;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.VolatileImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.imageio.ImageIO;

public class LoginForm extends Panel
{
  private static final long serialVersionUID = 1L;
  private java.awt.Image bgImage;
  private TextField userName = new TextField(20);
  private Checkbox forceUpdateBox = new Checkbox("Force Update");
  private Button launchButton = new Button("Enter Game");
  private Label errorLabel = new Label("", 1);
  private Label creditsVersion = new Label("v12.2");
  private Button openManager = new Button("Backup Manager");
  private LauncherFrame launcherFrame;
  private boolean outdated = false;
  private VolatileImage img;
  
  public LoginForm(LauncherFrame launcherFrame) {
    this.launcherFrame = launcherFrame;
    
    GridBagLayout gbl = new GridBagLayout();
    setLayout(gbl);
    
    add(buildLoginPanel());
    try {
      bgImage = ImageIO.read(LoginForm.class.getResource("dirt.png")).getScaledInstance(32, 32, 16);
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    readUsername();
    launchButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent ae) {
        if (forceUpdateBox.getState()) {
          launcherFrame.forceUpdate = true;
        }
        launcherFrame.login(userName.getText());
      }
    });
  }
  
  private void readUsername() {
    try {
      File lastLogin = new File(MinecraftUtil.getWorkingDirectory(), "lastlogin");
      
      Cipher cipher = getCipher(2, "passwordfile");
      DataInputStream dis;
      DataInputStream dis; if (cipher != null) {
        dis = new DataInputStream(new javax.crypto.CipherInputStream(new FileInputStream(lastLogin), cipher));
      } else {
        dis = new DataInputStream(new FileInputStream(lastLogin));
      }
      userName.setText(dis.readUTF());
      dis.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  private void writeUsername() {
    try {
      File lastLogin = new File(MinecraftUtil.getWorkingDirectory(), "lastlogin");
      
      Cipher cipher = getCipher(1, "passwordfile");
      DataOutputStream dos;
      DataOutputStream dos; if (cipher != null) {
        dos = new DataOutputStream(new CipherOutputStream(new FileOutputStream(lastLogin), cipher));
      } else {
        dos = new DataOutputStream(new FileOutputStream(lastLogin));
      }
      dos.writeUTF(userName.getText());
      dos.writeUTF("");
      dos.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  private Cipher getCipher(int mode, String password) throws Exception {
    Random random = new Random(43287234L);
    byte[] salt = new byte[8];
    random.nextBytes(salt);
    PBEParameterSpec pbeParamSpec = new PBEParameterSpec(salt, 5);
    
    SecretKey pbeKey = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(new PBEKeySpec(password.toCharArray()));
    Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
    cipher.init(mode, pbeKey, pbeParamSpec);
    return cipher;
  }
  
  public void update(Graphics g)
  {
    paint(g);
  }
  
  public void paint(Graphics g2)
  {
    int w = getWidth() / 2;
    int h = getHeight() / 2;
    if ((img == null) || (img.getWidth() != w) || (img.getHeight() != h)) {
      img = createVolatileImage(w, h);
    }
    
    Graphics g = img.getGraphics();
    for (int x = 0; x <= w / 32; x++) {
      for (int y = 0; y <= h / 32; y++) {
        g.drawImage(bgImage, x * 32, y * 32, null);
      }
    }
    g.setColor(Color.LIGHT_GRAY);
    
    String msg = "Minecraft Launcher";
    g.setFont(new Font(null, 1, 20));
    FontMetrics fm = g.getFontMetrics();
    g.drawString(msg, w / 2 - fm.stringWidth(msg) / 2, h / 2 - fm.getHeight() * 2);
    
    g.dispose();
    g2.drawImage(img, 0, 0, w * 2, h * 2, null);
  }
  
  private Panel buildLoginPanel() {
    Panel panel = new Panel()
    {
      private static final long serialVersionUID = 1L;
      private Insets insets = new Insets(12, 24, 16, 32);
      
      public Insets getInsets()
      {
        return insets;
      }
      
      public void update(Graphics g)
      {
        paint(g);
      }
      
      public void paint(Graphics g)
      {
        super.paint(g);
        int hOffs = 0;
        
        g.setColor(Color.BLACK);
        g.drawRect(0, 0 + hOffs, getWidth() - 1, getHeight() - 1 - hOffs);
        g.drawRect(1, 1 + hOffs, getWidth() - 3, getHeight() - 3 - hOffs);
        g.setColor(Color.WHITE);
        
        g.drawRect(2, 2 + hOffs, getWidth() - 5, getHeight() - 5 - hOffs);
      }
    };
    panel.setBackground(Color.GRAY);
    BorderLayout layout = new BorderLayout();
    layout.setHgap(0);
    layout.setVgap(8);
    panel.setLayout(layout);
    
    GridLayout gl1 = new GridLayout(0, 1);
    GridLayout gl2 = new GridLayout(0, 1);
    gl1.setVgap(2);
    gl2.setVgap(2);
    Panel titles = new Panel(gl1);
    Panel values = new Panel(gl2);
    
    titles.add(new Label("Username:", 2));
    titles.add(new Label("", 2));
    values.add(userName);
    values.add(forceUpdateBox);
    
    panel.add(titles, "West");
    panel.add(values, "Center");
    
    Panel loginPanel = new Panel(new BorderLayout());
    
    Panel registerPanel = new Panel(new BorderLayout());
    try {
      if (outdated) {
        Label accountLink = new Label("You need to update the launcher!")
        {
          private static final long serialVersionUID = 0L;
          
          public void paint(Graphics g)
          {
            super.paint(g);
            
            int x = 0;
            int y = 0;
            
            FontMetrics fm = g.getFontMetrics();
            int width = fm.stringWidth(getText());
            int height = fm.getHeight();
            
            if (getAlignment() == 0) {
              x = 0;
            } else if (getAlignment() == 1) {
              x = getBoundswidth / 2 - width / 2;
            } else if (getAlignment() == 2) {
              x = getBoundswidth - width;
            }
            y = getBoundsheight / 2 + height / 2 - 1;
            
            g.drawLine(x + 2, y, x + width - 2, y);
          }
          
          public void update(Graphics g)
          {
            paint(g);
          }
        };
        accountLink.setCursor(Cursor.getPredefinedCursor(12));
        accountLink.addMouseListener(new MouseAdapter()
        {
          public void mousePressed(MouseEvent arg0)
          {
            try {
              Desktop.getDesktop().browse(new URL("http://www.minecraft.net/download.jsp").toURI());
            } catch (Exception e) {
              e.printStackTrace();
            }
          }
        });
        accountLink.setForeground(Color.BLUE);
        registerPanel.add(accountLink, "West");
        registerPanel.add(new Panel(), "Center");
      } else {
        Label accountLink = new Label("Need account?")
        {
          private static final long serialVersionUID = 0L;
          
          public void paint(Graphics g)
          {
            super.paint(g);
            
            int x = 0;
            int y = 0;
            
            FontMetrics fm = g.getFontMetrics();
            int width = fm.stringWidth(getText());
            int height = fm.getHeight();
            
            if (getAlignment() == 0) {
              x = 0;
            } else if (getAlignment() == 1) {
              x = getBoundswidth / 2 - width / 2;
            } else if (getAlignment() == 2) {
              x = getBoundswidth - width;
            }
            y = getBoundsheight / 2 + height / 2 - 1;
            
            g.drawLine(x + 2, y, x + width - 2, y);
          }
          
          public void update(Graphics g)
          {
            paint(g);
          }
        };
        accountLink.setCursor(Cursor.getPredefinedCursor(12));
        accountLink.addMouseListener(new MouseAdapter()
        {
          public void mousePressed(MouseEvent arg0)
          {
            try {
              Desktop.getDesktop().browse(new URL("http://www.minecraft.net/register.jsp").toURI());
            } catch (Exception e) {
              e.printStackTrace();
            }
          }
        });
        accountLink.setForeground(Color.BLUE);
        registerPanel.add(creditsVersion, "West");
        registerPanel.add(new Panel(), "Center");
      }
    }
    catch (Error localError) {}
    loginPanel.add(registerPanel, "Center");
    loginPanel.add(launchButton, "East");
    Panel anjoPanel = new Panel();
    openManager.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {
        new MinecraftBackupManager().setVisible(true);
      }
    });
    anjoPanel.add(openManager);
    loginPanel.add(anjoPanel, "South");
    panel.add(loginPanel, "South");
    
    errorLabel.setFont(new Font(null, 2, 16));
    errorLabel.setForeground(new Color(8388608));
    panel.add(errorLabel, "North");
    
    return panel;
  }
  
  public void setError(String errorMessage) {
    removeAll();
    add(buildLoginPanel());
    errorLabel.setText(errorMessage);
    validate();
  }
  
  public void loginOk() {
    writeUsername();
  }
}
