package CihazUi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CihazDataBase.CihazTanimlaSQL;
import CihazDataBase.IsyeriSQL;
import CihazDomain.CihazTanimlaDomain;


import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class CihazSil extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CihazSil frame = new CihazSil();
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
	public CihazSil() {
		setTitle("Cihaz Sil");
		setBackground(SystemColor.inactiveCaption);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1198, 679);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 11, 179, 619);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(); 
		scrollPane.setBounds(199, 84, 973, 546);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		Icon icon5=new ImageIcon("icons/pttkus.png");
		JLabel lblNewLabel = new JLabel(icon5);
		lblNewLabel.setBounds(10, 11, 159, 120);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ana Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CihazSil.this.dispose();
				MainPanel mPanel=new MainPanel();
				mPanel.setVisible(true);
				
			}
		});
		btnNewButton.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(10, 561, 159, 47);
		panel.add(btnNewButton);
		
		JButton btnCihazSil = new JButton("Cihaz Sil");
		btnCihazSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CihazTanimlaDomain silinecekCihazDomain =(CihazTanimlaDomain)list.getSelectedValue();
				if(silinecekCihazDomain!=null) {
					int n=JOptionPane.showConfirmDialog(null, "Cihazi Silmek istedigine Emin Misin?","UYARI !!", JOptionPane.YES_NO_OPTION);
					if(n==0) {
						CihazTanimlaSQL.cihazTSil(silinecekCihazDomain);
						list.setListData(CihazTanimlaSQL.cihazListele().toArray());					
					}
					else {						
						}					
				}	
				else {JOptionPane.showMessageDialog(null," Silinecek Cihaz secilmedi");}}
				
		
				
			
		});
		btnCihazSil.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCihazSil.setBackground(UIManager.getColor("CheckBox.background"));
		btnCihazSil.setBounds(10, 503, 159, 47);
		panel.add(btnCihazSil);
		
		JComboBox comboBoxAra = new JComboBox(IsyeriSQL.isyeriListele().toArray());
		comboBoxAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				list.setListData(CihazTanimlaSQL.bulIsyeriCihaz(comboBoxAra.getSelectedItem().toString()).toArray());
			}
		});
		
		comboBoxAra.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBoxAra.setBounds(319, 11, 493, 43);
		contentPane.add(comboBoxAra);
		
		JLabel lblNewLabel_1 = new JLabel("Isyeri");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(199, 11, 110, 43);
		contentPane.add(lblNewLabel_1);
		
	
		
		list.setListData(CihazTanimlaSQL.cihazListele().toArray());
		setLocationRelativeTo(null);
		
	}
}
