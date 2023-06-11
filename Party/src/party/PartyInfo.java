package party;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import com.toedter.calendar.JCalendar;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.SwingConstants;
public class PartyInfo extends JFrame {

	private JPanel contentPane;
	private JTextField familyNameField;
	private JTextField peopleField;
	private JTextField dateField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PartyInfo frame = new PartyInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PartyInfo() {
		setTitle("PartyInfo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		ImageIcon img = new ImageIcon("C:\\Users\\Jewel\\eclipse-workspace\\Party\\src\\party\\img\\conf.png");
		setIconImage(img.getImage());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel idLbl = new JLabel("ID: 14523");
		idLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		idLbl.setBounds(84, 10, 152, 40);
		contentPane.add(idLbl);
		
		JLabel partyOrderLbl = new JLabel("Party order");
		partyOrderLbl.setFont(new Font("Tahoma", Font.PLAIN, 31));
		partyOrderLbl.setBounds(283, 10, 187, 52);
		contentPane.add(partyOrderLbl);
		
		JLabel importantLbl = new JLabel("");
		importantLbl.setBounds(10, 64, 226, 216);
		importantLbl.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\Jewel\\eclipse-workspace\\Party\\src\\party\\img\\order.png").getImage().getScaledInstance(importantLbl.getWidth(), importantLbl.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(importantLbl);
		
		JLabel familyName = new JLabel("Family name:");
		familyName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		familyName.setBounds(248, 124, 126, 31);
		contentPane.add(familyName);
		
		familyNameField = new JTextField();
		familyNameField.setBounds(405, 133, 116, 20);
		contentPane.add(familyNameField);
		familyNameField.setColumns(10);
		
		JLabel peopleCount = new JLabel("Number of people:");
		peopleCount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		peopleCount.setBounds(248, 165, 165, 37);
		contentPane.add(peopleCount);
		
		peopleField = new JTextField();
		peopleField.setColumns(10);
		peopleField.setBounds(405, 177, 115, 20);
		contentPane.add(peopleField);
		
		dateField = new JTextField();
		dateField.setToolTipText("Date");
		dateField.setHorizontalAlignment(SwingConstants.CENTER);
		dateField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dateField.setText("Date");
		dateField.setEditable(false);
		dateField.setBounds(554, 165, 165, 20);
		contentPane.add(dateField);
		dateField.setColumns(10);
		
		JPanel checkPanel = new JPanel();
		checkPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		checkPanel.setBounds(239, 222, 444, 140);
		contentPane.add(checkPanel);
		checkPanel.setLayout(null);
		
		JCheckBox christmasChkBtn = new JCheckBox("Christmas pack - 200 lv");
		christmasChkBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonGroup.add(christmasChkBtn);
		christmasChkBtn.setBounds(24, 22, 215, 23);
		checkPanel.add(christmasChkBtn);
		
		JCheckBox weddingChkBtn = new JCheckBox("Wedding - 6000 lv");
		weddingChkBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonGroup.add(weddingChkBtn);
		weddingChkBtn.setBounds(24, 86, 189, 23);
		checkPanel.add(weddingChkBtn);
		
		JCheckBox bdayChkBtn = new JCheckBox("Birthday - 140 lv");
		bdayChkBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonGroup.add(bdayChkBtn);
		bdayChkBtn.setBounds(254, 22, 169, 23);
		checkPanel.add(bdayChkBtn);
		
		JCheckBox conferenceChkBtn = new JCheckBox("Confrence - 4500 lv");
		conferenceChkBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonGroup.add(conferenceChkBtn);
		conferenceChkBtn.setBounds(254, 86, 184, 23);
		checkPanel.add(conferenceChkBtn);
		
		JEditorPane notesArea = new JEditorPane();
		notesArea.setToolTipText("Notes");
		notesArea.setFont(new Font("Tahoma", Font.PLAIN, 18));
		notesArea.setText("Notes...");
		notesArea.setBounds(14, 292, 222, 131);
		contentPane.add(notesArea);
		
		JButton menuBtn = new JButton("Menu");
		menuBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		menuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Main();
			}
		});
		menuBtn.setBounds(478, 400, 89, 46);
		contentPane.add(menuBtn);
		
		JButton sendOrederBtn = new JButton("Send order");
		sendOrederBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sendOrederBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter fw = new FileWriter("sentOrder.txt", true);					
					fw.write(familyNameField.getText()+ " " + peopleField.getText()+ " "+ dateField.getText() + " ");
					
					if(christmasChkBtn.isSelected()) {
						fw.write(christmasChkBtn.getText());
					}else if(bdayChkBtn.isSelected()) {
						fw.write(bdayChkBtn.getText());
					}else if(weddingChkBtn.isSelected()) {
						fw.write(weddingChkBtn.getText());
					}else if(conferenceChkBtn.isSelected()){
						fw.write(conferenceChkBtn.getText());
					}
					
					fw.write(" " + notesArea.getText()+"\n\n");
					
					fw.close();
				}catch(IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		sendOrederBtn.setBounds(577, 400, 142, 46);
		contentPane.add(sendOrederBtn);
		
		JCalendar calendar = new JCalendar();
		calendar.getDayChooser().addPropertyChangeListener("day", (PropertyChangeListener) new PropertyChangeListener() {
			   @Override
			   public void propertyChange(PropertyChangeEvent e) {
			      Date date = calendar.getDate();
			      DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			      dateField.setText(String.valueOf(format.format(date)));
			   }
			});
		calendar.setBounds(526, 10, 213, 153);
		contentPane.add(calendar);
		
		setVisible(true);
	}
}
