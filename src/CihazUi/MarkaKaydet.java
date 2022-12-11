package CihazUi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CihazDataBase.IsyeriSQL;
import CihazDataBase.MarkaSQL;
import CihazDomain.IsyeriDomain;
import CihazDomain.MarkaDomain;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;

public class MarkaKaydet extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldMarka;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarkaKaydet frame = new MarkaKaydet();
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
	public MarkaKaydet() {
		setResizable(false);
		setTitle("YENÄ° MARKA TANIMLA");
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
		panel.setLayout(null);
		panel.setBounds(205, 11, 967, 141);
		contentPane.add(panel);
		
		textFieldMarka = new JTextField();
		textFieldMarka.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldMarka.setColumns(10);
		textFieldMarka.setBounds(207, 48, 510, 48);
		panel.add(textFieldMarka);
		
		JButton btnNewButton_1 = new JButton("Ekle");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.BOLD, 14));
		list.setBounds(205, 163, 967, 467);
		contentPane.add(list);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textFieldMarka.getText().equals("")|textFieldMarka.getText().length()>50)										
				{
					JOptionPane.showMessageDialog(null,"Eklenecek markayi giriniz. 50 karakteri geçmemelidir.");
				}					
				else {
				      try {						    	  
				    	  MarkaDomain addUser=new MarkaDomain();						    	  
				    	  addUser.setMarka(textFieldMarka.getText());			    	 							
							JOptionPane.showMessageDialog(null,"Kayit Basarili");
							MarkaSQL.ekle_marka(addUser);
							textFieldMarka.setText("");
							
				      }						
					 catch (Exception e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null,"Baglanti Hatasi");								
					}	
				      
				}	
				
				list.setListData(MarkaSQL.markaListele().toArray());
				
			}
		});
		btnNewButton_1.setBounds(727, 48, 110, 48);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Sil");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MarkaDomain silinecekMarkaDomain =(MarkaDomain)list.getSelectedValue();
				if(silinecekMarkaDomain!=null) {
					int n=JOptionPane.showConfirmDialog(null, "Marka Silinecek","UYARI !!", JOptionPane.YES_NO_OPTION);
					if(n==0) {
						MarkaSQL.markaSil(silinecekMarkaDomain);
						list.setListData(MarkaSQL.markaListele().toArray());					
					}
					else {						
						}					
				}	
				else {JOptionPane.showMessageDialog(null," Silinecek marka secilmedi");}
				
				
				
				
			}
		});
		btnNewButton_1_1.setBounds(847, 48, 110, 48);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Eklenecek Marka");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 48, 187, 48);
		panel.add(lblNewLabel_1);
		
		list.setListData(MarkaSQL.markaListele().toArray());
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(10, 11, 185, 619);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Ana Men\u00FC");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(10, 567, 165, 41);
		panel_1.add(btnNewButton);
		
		
		Icon icon1=new ImageIcon("icons/pttkus.png");
		JLabel lblNewLabel = new JLabel(icon1);
		lblNewLabel.setBounds(10, 11, 165, 115);
		panel_1.add(lblNewLabel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MarkaKaydet.this.dispose();
				MainPanel mPanel=new MainPanel();
				mPanel.setVisible(true);
				
			}
		});
	}

}
