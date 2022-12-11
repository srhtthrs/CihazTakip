package CihazUi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CihazDataBase.CihazTuruSQL;
import CihazDataBase.MarkaSQL;
import CihazDomain.CihazTuruDomain;
import CihazDomain.MarkaDomain;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;

public class CihazTuruKaydet extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCihTur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CihazTuruKaydet frame = new CihazTuruKaydet();
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
	public CihazTuruKaydet() {
		setTitle("YENÝ CÝHAZ TANIMLA");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1198, 679);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(199, 11, 973, 142);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textFieldCihTur = new JTextField();
		textFieldCihTur.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldCihTur.setBounds(268, 48, 455, 48);
		panel.add(textFieldCihTur);
		textFieldCihTur.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(199, 164, 973, 466);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane.setViewportView(list);
		
		list.setListData(CihazTuruSQL.cihazTuruListele().toArray());
		
		
		JButton btnNewButton_1 = new JButton("Ekle");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(textFieldCihTur.getText().equals("")|textFieldCihTur.getText().length()>50)										
				{
					JOptionPane.showMessageDialog(null,"Eklenecek Cihaz Turunu giriniz. 50 karakteri geçmemelidir.");
				}					
				else {
				      try {						    	  
				    	  CihazTuruDomain addUser=new CihazTuruDomain();						    	  
				    	  addUser.setCihazturu(textFieldCihTur.getText());			    	 							
							JOptionPane.showMessageDialog(null,"Kayit Basarili");
							CihazTuruSQL.ekle_cihazTuru(addUser);
							textFieldCihTur.setText("");
							
				      }						
					 catch (Exception e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null,"Baglanti Hatasi");								
					}	
				      
				}	
				
				list.setListData(CihazTuruSQL.cihazTuruListele().toArray());
				
			}
				
				
			
		});
		btnNewButton_1.setBounds(733, 48, 110, 48);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Sil");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				CihazTuruDomain silinecekCihazTuruDomain =(CihazTuruDomain)list.getSelectedValue();
				if(silinecekCihazTuruDomain!=null) {
					int n=JOptionPane.showConfirmDialog(null, "Cihaz Turu Silinecek","UYARI !!", JOptionPane.YES_NO_OPTION);
					if(n==0) {
						CihazTuruSQL.cihazTuruSil(silinecekCihazTuruDomain);
						list.setListData(CihazTuruSQL.cihazTuruListele().toArray());					
					}
					else {						
						}					
				}	
				else {JOptionPane.showMessageDialog(null," Silinecek cihaz turu secilmedi");}
				
				
				
			}
		});
		btnNewButton_1_1.setBounds(853, 48, 110, 48);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Eklecek Cihaz Tan\u0131mla");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 51, 248, 45);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(10, 11, 179, 619);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Ana Men\u00FC");
		btnNewButton.setBounds(10, 566, 159, 42);
		panel_1.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		
		Icon icon3=new ImageIcon("icons/pttkus.png");
		JLabel lblNewLabel = new JLabel(icon3);
		lblNewLabel.setBounds(10, 11, 159, 123);
		panel_1.add(lblNewLabel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CihazTuruKaydet.this.dispose();
				MainPanel mPanel=new MainPanel();
				mPanel.setVisible(true);
			}
		});
		
	}
}
