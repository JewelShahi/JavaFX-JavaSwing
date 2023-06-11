package party;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.LineBorder;
import java.awt.Color;


public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField fNameField;
	private JTextField familyNameField;
	private JTextField userField;
	private JTextField passField;
		
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 324);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		ImageIcon img = new ImageIcon("C:\\Users\\Jewel\\eclipse-workspace\\Party\\src\\party\\img\\conf.png");
		setIconImage(img.getImage());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		mainPanel.setBounds(10, 10, 260, 260);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel fNameLbl = new JLabel("First name:");
		fNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fNameLbl.setBounds(21, 27, 106, 14);
		mainPanel.add(fNameLbl);
		
		fNameField = new JTextField();
		fNameField.setBounds(154, 28, 86, 20);
		mainPanel.add(fNameField);
		fNameField.setColumns(10);
		
		familyNameField = new JTextField();
		familyNameField.setColumns(10);
		familyNameField.setBounds(154, 82, 86, 20);
		mainPanel.add(familyNameField);
		
		JLabel familyNameLbl = new JLabel("Family name:");
		familyNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		familyNameLbl.setBounds(21, 74, 123, 28);
		mainPanel.add(familyNameLbl);
		
		JLabel cityLbl = new JLabel("City");
		cityLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cityLbl.setBounds(21, 129, 70, 21);
		mainPanel.add(cityLbl);
		
		userField = new JTextField();
		userField.setColumns(10);
		userField.setBounds(154, 178, 86, 20);
		mainPanel.add(userField);
		
		JLabel userNameLbl = new JLabel("Username:");
		userNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		userNameLbl.setBounds(21, 177, 123, 14);
		mainPanel.add(userNameLbl);
		
		passField = new JTextField();
		passField.setColumns(10);
		passField.setBounds(154, 224, 86, 20);
		mainPanel.add(passField);
		
		JLabel passLbl = new JLabel("Password:");
		passLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passLbl.setBounds(21, 224, 123, 14);
		mainPanel.add(passLbl);
		
		JComboBox cityMenu = new JComboBox();
		cityMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cityMenu.setModel(new DefaultComboBoxModel(new String[] {"Sofia", "Varna ", "Burgas", "Pleven", "Veliko Tarnovo"}));
		cityMenu.setToolTipText("");
		cityMenu.setBounds(154, 128, 86, 22);
		mainPanel.add(cityMenu);
		
		JCheckBox agreeCheckBox = new JCheckBox("I agree");
		agreeCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		agreeCheckBox.setBounds(295, 137, 97, 23);
		contentPane.add(agreeCheckBox);
		
		JButton registerBtn = new JButton("Register");
		registerBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					FileWriter fw1 = new FileWriter("register.txt", true);
					fw1.write(fNameField.getText() + "\n");
					fw1.write(familyNameField.getText( )+ "\n");
					fw1.write("Username:" + userField.getText( )+ "\n");
					fw1.write("Password:" + passField.getText() + "\n");
					fw1.write(agreeCheckBox.isSelected() + "\n");
					fw1.write(cityMenu.getSelectedItem() + "\n\n");
					fw1.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				
				dispose();
				new Main();
			}
		});
		registerBtn.setBounds(280, 182, 120, 45);
		contentPane.add(registerBtn);
		
		JLabel regLbl = new JLabel("Registration");
		regLbl.setFont(new Font("Tahoma", Font.PLAIN, 25));
		regLbl.setBounds(280, 56, 135, 45);
		contentPane.add(regLbl);
		setVisible(true);
	}
}
