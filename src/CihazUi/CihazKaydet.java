package CihazUi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CihazDataBase.CihazTanimlaSQL;
import CihazDataBase.CihazTuruSQL;
import CihazDataBase.IsyeriSQL;
import CihazDataBase.MarkaSQL;
import CihazDomain.CihazTanimlaDomain;
import CihazDomain.MarkaDomain;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.SystemColor;

public class CihazKaydet extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldModel;
	private JTextField textFieldMac;
	private JTextField textFieldSeri;
	private JTextField textFieldGBT;
	private JTextField textFieldGsuresi;
	private JTextField textFieldZPS;
	private JTextField textFieldAciklama;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CihazKaydet frame = new CihazKaydet();
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
	public CihazKaydet() {
		setResizable(false);
		setTitle("Cihaz Tanımla");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1198, 679);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(212, 11, 960, 619);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JComboBox comboBoxIsyeri = new JComboBox(IsyeriSQL.isyeriListele().toArray());
		comboBoxIsyeri.setForeground(new Color(128, 0, 0));
		comboBoxIsyeri.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBoxIsyeri.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBoxIsyeri.setBounds(263, 11, 612, 42);
		panel.add(comboBoxIsyeri);
		
		JLabel lblNewLabel = new JLabel("\u0130\u015Fyeri");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 243, 42);
		panel.add(lblNewLabel);
		
		JComboBox comboBoxCihTur = new JComboBox(CihazTuruSQL.cihazTuruListele().toArray());
		comboBoxCihTur.setForeground(new Color(128, 0, 0));
		comboBoxCihTur.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBoxCihTur.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBoxCihTur.setBounds(263, 64, 612, 42);
		panel.add(comboBoxCihTur);
		
		JLabel lblCihazTr = new JLabel("Cihaz\u0131n T\u00FCr\u00FC");
		lblCihazTr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCihazTr.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCihazTr.setBounds(10, 64, 243, 42);
		panel.add(lblCihazTr);
		
		JComboBox comboBoxMarkasi = new JComboBox(MarkaSQL.markaListele().toArray());
		comboBoxMarkasi.setForeground(new Color(128, 0, 0));
		comboBoxMarkasi.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBoxMarkasi.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBoxMarkasi.setBounds(263, 117, 612, 42);
		panel.add(comboBoxMarkasi);
		
		JLabel lblMarkas = new JLabel("Cihaz\u0131n Markas\u0131");
		lblMarkas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMarkas.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMarkas.setBounds(10, 117, 243, 42);
		panel.add(lblMarkas);
		
		JLabel lblModeli = new JLabel("Modeli");
		lblModeli.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModeli.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblModeli.setBounds(10, 170, 243, 42);
		panel.add(lblModeli);
		
		JLabel lblMacAdresi = new JLabel("Mac Adresi");
		lblMacAdresi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMacAdresi.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMacAdresi.setBounds(10, 223, 243, 42);
		panel.add(lblMacAdresi);
		
		JLabel lblSeriNo = new JLabel("Seri Numaras\u0131");
		lblSeriNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSeriNo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSeriNo.setBounds(10, 276, 243, 42);
		panel.add(lblSeriNo);
		
		JLabel lblGarantiBalayTarihi = new JLabel("Garanti Ba\u015Flay\u0131\u015F Tarihi");
		lblGarantiBalayTarihi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGarantiBalayTarihi.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGarantiBalayTarihi.setBounds(10, 329, 243, 42);
		panel.add(lblGarantiBalayTarihi);
		
		JLabel lblMarkas_4_1 = new JLabel("Garanti S\u00FCresi");
		lblMarkas_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMarkas_4_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMarkas_4_1.setBounds(10, 382, 243, 42);
		panel.add(lblMarkas_4_1);
		
		JLabel lblMarkas_4_2 = new JLabel("Zimmetli Personelin Sicili");
		lblMarkas_4_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMarkas_4_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMarkas_4_2.setBounds(10, 435, 243, 42);
		panel.add(lblMarkas_4_2);
		
		JLabel lblMarkas_4_3 = new JLabel("A\u00E7\u0131klama");
		lblMarkas_4_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMarkas_4_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMarkas_4_3.setBounds(10, 488, 243, 42);
		panel.add(lblMarkas_4_3);
		
		textFieldModel = new JTextField();
		textFieldModel.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldModel.setBorder(new LineBorder(new Color(171, 173, 179)));
		textFieldModel.setBounds(263, 170, 612, 42);
		panel.add(textFieldModel);
		textFieldModel.setColumns(10);
		
		textFieldMac = new JTextField();
		textFieldMac.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldMac.setColumns(10);
		textFieldMac.setBorder(new LineBorder(new Color(171, 173, 179)));
		textFieldMac.setBounds(263, 223, 612, 42);
		panel.add(textFieldMac);
		
		textFieldSeri = new JTextField();
		textFieldSeri.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldSeri.setColumns(10);
		textFieldSeri.setBorder(new LineBorder(new Color(171, 173, 179)));
		textFieldSeri.setBounds(263, 276, 612, 42);
		panel.add(textFieldSeri);
		
		textFieldGBT = new JTextField();
		textFieldGBT.setForeground(new Color(165, 42, 42));
		textFieldGBT.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldGBT.setText("BILINMIYOR");
		textFieldGBT.setColumns(10);
		textFieldGBT.setBorder(new LineBorder(new Color(171, 173, 179)));
		textFieldGBT.setBounds(263, 329, 612, 42);
		panel.add(textFieldGBT);
		
		textFieldGsuresi = new JTextField();
		textFieldGsuresi.setForeground(new Color(165, 42, 42));
		textFieldGsuresi.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldGsuresi.setText("BILINMIYOR");
		textFieldGsuresi.setColumns(10);
		textFieldGsuresi.setBorder(new LineBorder(new Color(171, 173, 179)));
		textFieldGsuresi.setBounds(263, 382, 612, 42);
		panel.add(textFieldGsuresi);
		
		textFieldZPS = new JTextField();
		textFieldZPS.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldZPS.setColumns(10);
		textFieldZPS.setBorder(new LineBorder(new Color(171, 173, 179)));
		textFieldZPS.setBounds(263, 435, 612, 42);
		panel.add(textFieldZPS);
		
		textFieldAciklama = new JTextField();
		textFieldAciklama.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldAciklama.setColumns(10);
		textFieldAciklama.setBorder(new LineBorder(new Color(171, 173, 179)));
		textFieldAciklama.setBounds(263, 488, 612, 42);
		panel.add(textFieldAciklama);
		
		JButton btnKaydet = new JButton("Cihaz Kaydet");
		btnKaydet.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				  if(comboBoxIsyeri.getSelectedItem().equals("")|comboBoxCihTur.getSelectedItem().equals("")|comboBoxMarkasi.getSelectedItem().equals("")|textFieldModel.getText().equals("")|textFieldModel.getText().length()>50|textFieldMac.getText().length()>50|textFieldSeri.getText().length()>50|textFieldGBT.getText().length()>50|textFieldGsuresi.getText().length()>50|textFieldZPS.getText().length()>50|textFieldAciklama.getText().length()>50)										
				{
					
					  
					  JOptionPane.showMessageDialog(null,"Gerekli alanlari doldurunuz. Veriler 50 karakteri gecemez.");
				}					
				else {
				      try {						    	  
				    	  CihazTanimlaDomain addUser=new CihazTanimlaDomain();
				    	  
				    	  addUser.setIsyeri(comboBoxIsyeri.getSelectedItem().toString());
				    	  addUser.setCihazTuru(comboBoxCihTur.getSelectedItem().toString());
				    	  addUser.setMarka(comboBoxMarkasi.getSelectedItem().toString());
				    	  addUser.setModel(textFieldModel.getText());
				    	  addUser.setMacadresi(textFieldMac.getText());
				    	  addUser.setSeriNo(textFieldSeri.getText());
				    	  addUser.setgBTarih(textFieldGBT.getText());
				    	  addUser.setgSuresi(textFieldGsuresi.getText());
				    	  addUser.setzPSicili(textFieldZPS.getText());
				    	  addUser.setAciklama(textFieldAciklama.getText());
				    	  
				    	  
							JOptionPane.showMessageDialog(null,"Kayit Basarili");
							
							
							CihazTanimlaSQL.ekle_cihaz(addUser);
							
							textFieldModel.setText("");
							textFieldMac.setText("");
							textFieldSeri.setText("");
							textFieldZPS.setText("");
							textFieldAciklama.setText("");
							textFieldGsuresi.setText("BILINMIYOR");
							textFieldGBT.setText("BILINMIYOR");
							
							
							
							
							
				      }						
					 catch (Exception e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null,"Baglanti Hatasi");								
					}	
				      
				}	
				
			
				 
				 
				
			}
		});
		btnKaydet.setBounds(656, 552, 219, 42);
		panel.add(btnKaydet);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(10, 11, 192, 619);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Ana Men\u00FC");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(10, 561, 172, 47);
		panel_1.add(btnNewButton);
		
		Icon icon4=new ImageIcon("icons/pttkus.png");
		JLabel lblNewLabel_1 = new JLabel(icon4);
		lblNewLabel_1.setBounds(10, 11, 172, 125);
		panel_1.add(lblNewLabel_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CihazKaydet.this.dispose();
				MainPanel mPanel=new MainPanel();
				mPanel.setVisible(true);
				
			}
		});
		
		setLocationRelativeTo(null);
	}
}
