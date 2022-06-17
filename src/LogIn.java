import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField loginPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setTitle("Log In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 275, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblZooImg = new JLabel("");
		lblZooImg.setForeground(new Color(255, 255, 255));
		lblZooImg.setIcon(new ImageIcon("E:\\Xeon Gaming\\Downloads\\scene-with-zoo-entrance-in-forest-background-vector (2).jpg"));
		lblZooImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblZooImg.setFont(new Font("Perpetua Titling MT", Font.BOLD, 24));
		lblZooImg.setBackground(new Color(255, 255, 255));
		lblZooImg.setBounds(-11, 0, 278, 123);
		contentPane.add(lblZooImg);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 204));
		panel.setBounds(0, 123, 267, 248);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogInText = new JLabel("Log In : ");
		lblLogInText.setBounds(0, 0, 267, 21);
		panel.add(lblLogInText);
		lblLogInText.setFont(new Font("Perpetua", Font.BOLD, 21));
		lblLogInText.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(0, 36, 257, 14);
		panel.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(10, 86, 236, 20);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password  : ");
		lblPassword.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(0, 142, 257, 14);
		panel.add(lblPassword);
		
		loginPass = new JPasswordField();
		loginPass.setBounds(10, 192, 236, 20);
		panel.add(loginPass);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 51, 0));
		panel_1.setBounds(0, 371, 259, 82);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Information inf = new Information();
				inf.show();
				
				String name = txtUsername.getText();
				int pass = Integer.parseInt(loginPass.getText());
			}
		});
		btnLogin.setBounds(25, 11, 89, 23);
		panel_1.add(btnLogin);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(84, 45, 89, 23);
		panel_1.add(btnExit);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText("");
				loginPass.setText("");
			}
		});
		btnReset.setBounds(143, 11, 89, 23);
		panel_1.add(btnReset);
	}
}
