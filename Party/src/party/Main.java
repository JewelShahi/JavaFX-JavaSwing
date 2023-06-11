package party;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setTitle("Party Center");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 422, 482);
		setVisible(true);
		setLocationRelativeTo(null);
		ImageIcon img = new ImageIcon("C:\\Users\\Jewel\\eclipse-workspace\\Party\\src\\party\\img\\conf.png");
		setIconImage(img.getImage());
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Please get into a account");
			}
			
		});
		mnFile.add(menuSave);
		
		JMenuItem menuClear = new JMenuItem("Clear");
		menuClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Please get into a account");
			}
		});
		mnFile.add(menuClear);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Please get into a account");
			}
		});
		mnFile.add(menuExit);
		
		JMenu mnServices = new JMenu("Services");
		menuBar.add(mnServices);
		
		JMenuItem menuChristmas = new JMenuItem("Christmas ");
		menuChristmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Please get into a account");
			}
		});
		mnServices.add(menuChristmas);
		
		JMenuItem menuBirthday = new JMenuItem("Birthday");
		menuBirthday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Please get into a account");
			}
		});
		mnServices.add(menuBirthday);
		
		JMenuItem menuWedding = new JMenuItem("Wedding");
		menuWedding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Please get into a account");
			}
		});
		mnServices.add(menuWedding);
		
		JMenuItem menuConfrence = new JMenuItem("Confrence");
		menuConfrence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Please get into a account");
			}
		});
		mnServices.add(menuConfrence);
		
		JMenu mnContacts = new JMenu("Contacts");
		menuBar.add(mnContacts);
		
		JMenuItem menuContacts = new JMenuItem("Contacts");
		menuContacts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Contacts();
			}
		});
		mnContacts.add(menuContacts);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel partyCenterLbl = new JLabel("Party Center");
		partyCenterLbl.setFont(new Font("Arial Black", Font.BOLD, 30));
		partyCenterLbl.setBounds(98, 0, 233, 66);
		contentPane.add(partyCenterLbl);
		
		JLabel strImg = new JLabel("");
		strImg.setBounds(0, 36, 407, 350);
		strImg.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\Jewel\\eclipse-workspace\\Party\\src\\party\\img\\people.png").getImage().getScaledInstance(strImg.getWidth(), strImg.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(strImg);
		
		JButton logInBtn = new JButton("Login");
		logInBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		logInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login();
				
			}
		});
		logInBtn.setBounds(78, 396, 122, 23);
		contentPane.add(logInBtn);
		
		JButton regBtn = new JButton("Register");
		regBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		regBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Register();
			}
		});
		regBtn.setBounds(210, 396, 121, 23);
		contentPane.add(regBtn);
		
	}

}
