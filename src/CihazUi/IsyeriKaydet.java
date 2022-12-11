package CihazUi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CihazDataBase.IsyeriSQL;
import CihazDomain.IsyeriDomain;


import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;

public class IsyeriKaydet extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIsyeri;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IsyeriKaydet frame = new IsyeriKaydet();
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
	public IsyeriKaydet() {
		setResizable(false);
		setTitle("YENÄ° Ä°Å�YERÄ° TANIMLAMA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1198, 679);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(195, 11, 977, 99);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(195, 121, 977, 509);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane.setViewportView(list);
		
		list.setListData(IsyeriSQL.isyeriListele().toArray());
		textFieldIsyeri = new JTextField();
		textFieldIsyeri.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldIsyeri.setBounds(224, 30, 512, 44);
		panel.add(textFieldIsyeri);
		textFieldIsyeri.setColumns(10);
		
		JButton btnNewButton = new JButton("ekle");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textFieldIsyeri.getText().equals("")|textFieldIsyeri.getText().length()>50)										
				{
					JOptionPane.showMessageDialog(null,"Eklenecek isyerini giriniz. 50 Karakteri Gecmemelidir.");
				}					
				else {
				      try {						    	  
				    	  IsyeriDomain addUser=new IsyeriDomain();						    	  
				    	  addUser.setIsyeri(textFieldIsyeri.getText());			    	 							
							JOptionPane.showMessageDialog(null,"Kayit Basarili");
							IsyeriSQL.ekle_isyeri(addUser);
							textFieldIsyeri.setText("");
							
				      }						
					 catch (Exception e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null,"Baglanti Hatasi");								
					}	
				      
				}	
				
				list.setListData(IsyeriSQL.isyeriListele().toArray());
				
			}
		});
		btnNewButton.setBounds(746, 30, 114, 44);
		panel.add(btnNewButton);
		
		JButton btnSil = new JButton("Sil");
		btnSil.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				IsyeriDomain silinecekKisiDomain =(IsyeriDomain)list.getSelectedValue();
				if(silinecekKisiDomain!=null) {
					int n=JOptionPane.showConfirmDialog(null, "Isyeri Silinecek","UYARI !!", JOptionPane.YES_NO_OPTION);
					if(n==0) {
						IsyeriSQL.isyeriSil(silinecekKisiDomain);
						list.setListData(IsyeriSQL.isyeriListele().toArray());					
					}
					else {						
						}					
				}	
				else {JOptionPane.showMessageDialog(null," Silinecek Isyeri secilmedi");}
				
			
			}
			
		});
		btnSil.setBounds(870, 30, 97, 44);
		panel.add(btnSil);
		
		JLabel lblNewLabel_1 = new JLabel("Eklenecek Isyeri");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 30, 204, 44);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(10, 11, 175, 619);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Ana Men\u00FC");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(10, 564, 155, 44);
		panel_1.add(btnNewButton_1);
		
		Icon icon=new ImageIcon("icons/pttkus.png");
		JLabel lblNewLabel = new JLabel(icon);
		lblNewLabel.setBounds(10, 11, 155, 124);
		panel_1.add(lblNewLabel);
		
		Icon icon2=new ImageIcon("icons/pttlogo2.jpg");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IsyeriKaydet.this.dispose();
				MainPanel mPanel=new MainPanel();
				mPanel.setVisible(true);
				
			}
		});
	
		
		setLocationRelativeTo(null);
	}
}
