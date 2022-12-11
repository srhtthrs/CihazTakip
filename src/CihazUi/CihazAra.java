package CihazUi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CihazDataBase.CihazTanimlaSQL;
import CihazDataBase.IsyeriSQL;
import CihazDataBase.MarkaSQL;
import CihazDomain.CihazTanimlaDomain;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.DebugGraphics;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.ComponentOrientation;
import java.awt.Frame;

public class CihazAra extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CihazAra frame = new CihazAra();
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
	public CihazAra() {
		setResizable(false);
		setBackground(SystemColor.inactiveCaption);
		setTitle("CİHAZ ARA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1294, 763);
		contentPane = new JPanel();
		contentPane.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 11, 155, 714);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JButton btnNewButton = new JButton("Ana Men\u00FC");
		btnNewButton.setBounds(10, 647, 136, 49);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		
		Icon icon5=new ImageIcon("icons/pttkus.png");
		JLabel lblNewLabel = new JLabel(icon5);
		lblNewLabel.setBounds(10, 11, 136, 91);
		panel.add(lblNewLabel);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(175, 11, 1103, 714);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 90, 1072, 609);
		panel_1.add(scrollPane_1);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table.setFont(new Font("Calibri", Font.BOLD, 14));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.setSelectionBackground(SystemColor.info);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setCellSelectionEnabled(true);
		table.setRowHeight(25);
		
		 
		

		
	 	
		scrollPane_1.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Isyeri");
		lblNewLabel_1.setBounds(10, 11, 154, 45);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 18));
		JComboBox comboBoxAra = new JComboBox(IsyeriSQL.isyeriListele().toArray());
		comboBoxAra.setBounds(188, 12, 735, 44);
		panel_1.add(comboBoxAra);
		comboBoxAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table.setModel(CihazTanimlaSQL.isyeriBulDefaultTableModel(comboBoxAra.getSelectedItem().toString()));
			}
		});
		comboBoxAra.setBackground(SystemColor.info);
		comboBoxAra.setFont(new Font("Dialog", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CihazAra.this.dispose();
				MainPanel mPanel=new MainPanel();
				mPanel.setVisible(true);
				
			}
		});
		JButton btnTmnListele = new JButton("Tumunu Listele");
		btnTmnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				table.setModel(CihazTanimlaSQL.tumuBulDefaultTableModel(comboBoxAra.getSelectedItem().toString()));
				
			}
		});
		btnTmnListele.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTmnListele.setBounds(10, 587, 136, 49);
		panel.add(btnTmnListele);
		
	
	}
}
