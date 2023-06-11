package party;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

public class Contacts extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Contacts dialog = new Contacts();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	void takePicture(JPanel panel) {
		BufferedImage img = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
		panel.print(img.getGraphics());		
		try {
			ImageIO.write(img, "png", new File("contactInfo.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Contacts() {
		setTitle("Contacts");
		setBounds(100, 100, 565, 311);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		ImageIcon img = new ImageIcon("party/img/conf.png");
		setIconImage(img.getImage());
		
			JLabel contactsImg = new JLabel(""); 
			contactsImg.setBounds(10, 11, 224, 224);
			contactsImg.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\Jewel\\eclipse-workspace\\Party\\src\\party\\img\\contacts.png").getImage().getScaledInstance(contactsImg.getWidth(), contactsImg.getHeight(), Image.SCALE_DEFAULT)));
			contentPanel.add(contactsImg);
		
			JLabel contactLbl = new JLabel("Contacts:");
			contactLbl.setFont(new Font("Tahoma", Font.PLAIN, 25));
			contactLbl.setBounds(258, 44, 118, 29);
			contentPanel.add(contactLbl);
			
			JLabel phoneLbl = new JLabel("<html><p style=\"color: red;\">Phone number:</p> <p style=\"color: blue;\">0877512054</p></html>");
			phoneLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
			phoneLbl.setBounds(258, 84, 236, 55);
			contentPanel.add(phoneLbl);
			
			JLabel addressLbl = new JLabel("Address: Sofia, bul. \"Bulgaria\"");
			addressLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
			addressLbl.setBounds(258, 148, 283, 36);
			contentPanel.add(addressLbl);
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
				JButton btnSave = new JButton("Save Image");
				btnSave.setFont(new Font("Tahoma", Font.PLAIN, 16));
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						takePicture(contentPanel);
					}
				});
				btnSave.setActionCommand("Save");
				buttonPane.add(btnSave);
				getRootPane().setDefaultButton(btnSave);
			JButton btnMenu = new JButton("Menu");
			btnMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new Main();
				}
			});
			btnMenu.setActionCommand("Cancel");
			buttonPane.add(btnMenu);
			setVisible(true);
	}

}
