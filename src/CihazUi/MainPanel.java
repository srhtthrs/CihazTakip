package CihazUi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPanel frame = new MainPanel();
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
	public MainPanel() {
		setResizable(false);
		setTitle("\u0130\u015EYER\u0130 C\u0130HAZ TANIMLAMA UYGULAMASI - ANA MEN\u00DC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1198, 679);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 11, 213, 618);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("\u0130\u015F Yeri Ekle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainPanel.this.dispose();
				IsyeriKaydet iKaydet=new IsyeriKaydet();
				iKaydet.setVisible(true);
				
				
			}
		});
		btnNewButton.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(10, 566, 193, 41);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cihaz T\u00FCr\u00FC Ekle");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainPanel.this.dispose();
				CihazTuruKaydet mPanel=new CihazTuruKaydet();
				mPanel.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(10, 514, 193, 41);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Marka Ekle");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainPanel.this.dispose();
				MarkaKaydet mPanel=new MarkaKaydet();
				mPanel.setVisible(true);
				
				
				
			}
		});
		btnNewButton_2.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2.setBounds(10, 462, 193, 41);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Cihaz Tan\u0131mla");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainPanel.this.dispose();
				CihazKaydet cKaydet=new CihazKaydet();
				cKaydet.setVisible(true);
				
			}
		});
		btnNewButton_3.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_3.setBounds(10, 267, 193, 41);
		panel.add(btnNewButton_3);
		
		Icon icon = new ImageIcon("icons/pttkus.png");
		JLabel lblNewLabel = new JLabel(icon);
		lblNewLabel.setBounds(10, 11, 148, 99);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_3_1 = new JButton("Cihaz Ara");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainPanel.this.dispose();
				CihazAra cAra=new CihazAra();
				cAra.setVisible(true);
				
				
				
			}
		});
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_3_1.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3_1.setBounds(10, 319, 193, 41);
		panel.add(btnNewButton_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("-------------------");
		lblNewLabel_3.setForeground(new Color(240, 230, 140));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 413, 193, 38);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("-------------------");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(new Color(240, 230, 140));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1.setBounds(10, 218, 193, 38);
		panel.add(lblNewLabel_3_1);
		
		JButton btnNewButton_3_1_1 = new JButton("Cihaz Sil");
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainPanel.this.dispose();
				CihazSil cSil=new CihazSil();
				cSil.setVisible(true);
				
			}
		});
		btnNewButton_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_3_1_1.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3_1_1.setBounds(10, 371, 193, 41);
		panel.add(btnNewButton_3_1_1);
		
		
		Icon icon2=new ImageIcon("icons/pttbinas.jpg");
		JLabel lblNewLabel_1 = new JLabel(icon2);
		lblNewLabel_1.setBounds(349, 127, 712, 486);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u0130STANBUL PTT B\u00D6LGE BA\u015EM\u00DCD\u00DCRL\u00DC\u011E\u00DC");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(233, 23, 939, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("TEKNOLOJ\u0130 M\u00DCD\u00DCRL\u00DC\u011E\u00DC");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(233, 66, 939, 32);
		contentPane.add(lblNewLabel_2_1);
		
		setLocationRelativeTo(null);
	}
}
