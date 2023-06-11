package party;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passField;

	String usersFilePath="register.txt";
	ArrayList<String> allUsernames = new ArrayList<>();
	HashMap<String, String> usernameANDpassword = new HashMap<>();

	public void getUsers(){
		File file = new File(usersFilePath);
		String username = "";
		String password = "";
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			Object[] lines = br.lines().toArray();
			for(int i = 0; i<lines.length; i++){
				String[] row = lines[i].toString().split(":");
				if(row[0].equals("Username")) {
					username = row[1];

					allUsernames.add(username);
				}
				if(row[0].equals("Password")) 
					password = row[1];
					
				if(!username.equals("") && !password.equals(""))
					usernameANDpassword.put(username, password);
			}

			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}catch(FileNotFoundException e2) {
			JOptionPane.showMessageDialog(this, "File Not Found!", "Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean checkIfUserNameExist(String usr){
		boolean exist = false;
		for(String username: allUsernames) {
			if(username.equals(usr))
				exist = true;
		}
		return exist;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Login() {
		setTitle("LogIn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 261);
		contentPane = new JPanel();
		contentPane.setToolTipText("Login");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		ImageIcon img = new ImageIcon("C:\\Users\\Jewel\\eclipse-workspace\\Party\\src\\party\\img\\conf.png");
		setIconImage(img.getImage());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel componentPanel = new JPanel();
		componentPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		componentPanel.setToolTipText("");
		componentPanel.setBounds(221, 40, 271, 160);
		contentPane.add(componentPanel);
		componentPanel.setLayout(null);
		
		JLabel userLbl = new JLabel("Username:");
		userLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		userLbl.setBounds(22, 22, 100, 31);
		componentPanel.add(userLbl);
		
		userField = new JTextField();
		userField.setToolTipText("Username");
		userField.setBounds(132, 31, 118, 20);
		componentPanel.add(userField);
		userField.setColumns(10);
		
		JLabel passLbl = new JLabel("Password:");
		passLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passLbl.setBounds(22, 79, 100, 37);
		componentPanel.add(passLbl);
		
		passField = new JPasswordField();
		passField.setToolTipText("Password");
		passField.setBounds(132, 91, 118, 20);
		componentPanel.add(passField);
		
		JButton enterBtn = new JButton("Enter");
		enterBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		enterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = userField.getText().trim();
				String password = passField.getText().trim();
				
				
				if(username.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(null, "Enter valid name and password");
				}else {
					getUsers();
					if(checkIfUserNameExist(username)) {
						for(String uname: usernameANDpassword.keySet()) {
							
							if(uname.equals(username)) {
								if(usernameANDpassword.get(uname).equals(password)) {
									dispose();
									new PartyInfo();
									break;
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Username and password are wrong!", "ERROR",JOptionPane.ERROR_MESSAGE);
							}
						}
						
						
					}else {
						JOptionPane.showMessageDialog(null, "Enter valid name and password");
					}
				}
			}
		});
		enterBtn.setBounds(89, 126, 89, 23);
		componentPanel.add(enterBtn);
		
		JLabel logLbl = new JLabel("Login");
		logLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		logLbl.setBounds(221, 0, 75, 30);
		contentPane.add(logLbl);
		
		JLabel loginImg = new JLabel("");
		loginImg.setBounds(10, 29, 171, 171);
		loginImg.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\Jewel\\eclipse-workspace\\Party\\src\\party\\img\\user.png").getImage().getScaledInstance(loginImg.getWidth(), loginImg.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(loginImg);
		setVisible(true);
	}
}
