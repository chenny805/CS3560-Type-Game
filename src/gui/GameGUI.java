package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameGUI extends JFrame {
  //accessible components initialized here 
  public JTextField command_line = new JTextField();
  public JTextArea output = new JTextArea();
  public JTextArea room_info = new JTextArea();
  public JTextArea stat_info = new JTextArea();
  public JTextArea map_info = new JTextArea();
  public boolean textInBuffer = false;
  public String bufferText = "null";
  public JScrollPane output_scroll;

  //constructor
  public GameGUI() {
	//frame title
    super("Terminal");
    
    //screen dimensions
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    pack();
    //size of window = 3/4 that of screen
    int frameWidth = (int)(screen.getWidth()*3/4);
    int frameHeight = (int)(screen.getHeight()*3/4);
    setSize(frameWidth,frameHeight);
    //center window
    setLocationRelativeTo(null);
    //exit button exits!
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //sets main frame
    Container frame = this.getContentPane();
    
    //PANELS
    //sizes
    int panelWidth = frame.getWidth();
    int panelHeight = frame.getHeight();
    int console_width = panelWidth*14/20;
    int hud_width = panelWidth - console_width;
    //font
    Font console_font = new Font("Courier New",Font.PLAIN,30);
    //main container
    JPanel pane = new JPanel();
    pane.setBackground(Color.black);
    pane.setSize(panelWidth, panelHeight);
    pane.setLayout(null);
    frame.add(pane);
    
    //console
    	//console_entry container
    JPanel console_entry = new JPanel();
    console_entry.setLayout(null);
    console_entry.setLocation(0,panelHeight*19/20);
    console_entry.setSize(console_width,panelHeight/20);
//    console_entry.setBackground(Color.cyan);
    console_entry.setBackground(Color.black);
    console_entry.setForeground(Color.white);
    pane.add(console_entry);
    	//command_line
    command_line.setLocation(5,5);
    command_line.setSize(console_entry.getWidth()-10,console_entry.getHeight()-10);
    command_line.setFont(console_font);
//    command_line.setBackground(Color.white);
    command_line.setBackground(Color.black);
    command_line.setForeground(Color.white);
    //remove border
    command_line.setBorder(javax.swing.BorderFactory.createEmptyBorder());
    //get focus when window is opened
    addWindowListener( new WindowAdapter() {
        public void windowOpened( WindowEvent e ){
            command_line.requestFocus();
        }
    }); 
    
    //handle text input
    command_line.addKeyListener(new KeyAdapter() {
    	public void keyTyped(KeyEvent e) { 
    		char c = e.getKeyChar();
    		int ascii = (int)c;
    		//get text when enter is pressed
    		if (ascii == 10) {
    			bufferText = command_line.getText();
    			textInBuffer = true;
    			command_line.setText("");
//    			tm.passToBuffer(user_input);
    				
    		}
    		//char limit for command line set to 80
    		if (command_line.getText().length() >= 80 )
    			e.consume(); 
    }});
    
    console_entry.add(command_line);
    	//console_display
    JPanel console_display = new JPanel();
    console_display.setLayout(null);
    console_display.setLocation(0,0);
    console_display.setSize(console_width,panelHeight*19/20);
//    console_display.setBackground(Color.blue);
    console_display.setBackground(Color.black);
    pane.add(console_display);
    	//scroll holder
    	//making scroll pane a global field
    output_scroll = new JScrollPane(output);
    output_scroll.setLocation(0,0);
    output_scroll.setSize(console_display.getSize());
    //invisible scrollbar
    output_scroll.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
    console_display.add(output_scroll);
    	//output
    output.setLayout(null);
    output.setLocation(5, 5);
    output.setSize(output_scroll.getWidth()-10,output_scroll.getHeight()-10);
    output.setFont(console_font);
    output.setLineWrap(true);
    output.setWrapStyleWord(true);
    output.setEditable(false);
//    output.setBackground(Color.blue.brighter());
    output.setBackground(Color.black);
    output.setForeground(Color.WHITE);
    
    //hud
    JPanel hud = new JPanel();
    hud.setLayout(null);
    hud.setLocation(console_width,0);
    hud.setSize(hud_width,panelHeight);
//    hud.setBackground(Color.orange);
    hud.setBackground(Color.black);
    pane.add(hud);
    	//stat_display
    JPanel stat_display = new JPanel();
    stat_display.setLayout(null);
    stat_display.setLocation(0, 0);
    stat_display.setSize(hud_width,panelHeight/3);
//    stat_display.setBackground(Color.orange.brighter());
    stat_display.setBackground(Color.white);
    hud.add(stat_display);
    	//map
    JPanel map = new JPanel();
    map.setLayout(null);
    map.setLocation(0, stat_display.getHeight());
    map.setSize(hud_width,panelHeight/3);
//    map.setBackground(Color.orange.darker());
    map.setBackground(Color.white);
    hud.add(map);
    
    	//room_description (Panel)
    JPanel room_description = new JPanel();
    room_description.setLayout(null);
    room_description.setLocation(0, stat_display.getHeight()+map.getHeight());
    room_description.setSize(hud_width,panelHeight/3);
    room_description.setBackground(Color.white);
    hud.add(room_description);
    
    	//room_description
    room_info.setLayout(null);
    room_info.setLocation(5, 5);
    room_info.setSize(room_description.getWidth()-10,room_description.getHeight()-10);
    room_info.setFont(console_font);
    room_info.setLineWrap(true);
    room_info.setWrapStyleWord(true);
    room_info.setEditable(false);
    room_info.setBackground(Color.black);
    room_info.setForeground(Color.WHITE);
    room_description.add(room_info);
    
    	//stat_info
    stat_info.setLayout(null);
    stat_info.setLocation(5, 5);
    stat_info.setSize(room_description.getWidth()-10, room_description.getHeight()-10);
    stat_info.setFont(new Font("Courier New",Font.PLAIN,20));
    stat_info.setLineWrap(true);
    stat_info.setWrapStyleWord(true);
    stat_info.setEditable(false);
    stat_info.setBackground(Color.black);
    stat_info.setForeground(Color.white);
    stat_display.add(stat_info);
    
    	//map_info
    map_info.setLayout(null);
    map_info.setLocation(5, 5);
    map_info.setSize(room_description.getWidth()-10, room_description.getHeight()-10);
    map_info.setFont(console_font);
    map_info.setLineWrap(true);
    map_info.setWrapStyleWord(true);
    map_info.setEditable(false);
    map_info.setBackground(Color.black);
    map_info.setForeground(Color.white);
    map.add(map_info);
    
    //JLabel label = new JLabel();
    //label.setIcon(new ImageIcon("src/images/map.png"));
    //map.add(label);
    
    setVisible(true); // display this frame
  }
}
