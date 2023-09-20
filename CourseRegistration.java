import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CourseRegistration extends JFrame{
	
	private LinkedList<Course> courseList = new LinkedList<Course>();
	private HashMap<String, Course> courseMap = new HashMap<String, Course>();
	private ArrayList<TimeSlot> timeSlots = new ArrayList<TimeSlot>();
	private double creditCount = 0;
	
	public CourseRegistration(String windowTitle) {
		super(windowTitle);
		String[] day = {"ST", "MW", "RA"};
		for(int i = 0; i < 3; i++)
		{	
			Time startTime = new Time(8, 00);
			Time endTime = new Time(9, 15);
			for(int j = 0; j < 7; j++) {
				timeSlots.add(new TimeSlot(day[i], startTime.clone(), endTime.clone()));
				startTime.addTime(85);
				endTime.addTime(85);
			}
		}
		
		for(int k = 0; k < 21; k++) {
			System.out.println(timeSlots.get(k));
		}
		
		courseMap.put("CSE115", new Course("CSE115", "Programming in C", 3.0, 20, new int[]{2, 2, 6, 3, 6, 8, 5, 4, 13, 5, 16, 12, 3 ,4, 9,13 , 14, 3, 8, 8}));
		courseMap.put("CSE115L", new Course("CSE115L", "Programming in C", 1.0, 20, new int[]{4, 6, 4, 7, 5, 8, 4, 8, 12, 19, 20, 13, 13, 8, 4, 11, 11, 12, 16, 17}));
		courseMap.put("CSE173", new Course("CSE173", "Discrete Mathmatics", 3.0, 14, new int[]{9, 1, 7, 10, 7, 6, 10, 6, 1, 7, 9, 2, 8, 7}));
		courseMap.put("CSE215", new Course("CSE215", "Programming in Java", 3.0, 24, new int[]{8, 4, 3, 18, 7, 12, 7, 11, 8, 2, 19, 10, 19, 10, 21, 17, 7, 20, 19, 1, 20, 6, 20, 10}));
		courseMap.put("CSE215L", new Course("CSE215L", "Programming in Java", 1.0, 24, new int[]{9, 15, 16, 10, 5, 6, 4, 9, 4, 2, 11, 1, 11, 16, 17, 9, 2, 19, 2, 16, 20, 11, 6, 19}));
	}
	
	public void createUI() {
		this.setSize(600, 500);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		Point p = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
	    p.x -= 270;
	    p.y -= 250;
	    this.setLocation(p);
				
		JLabel label1 = new JLabel("ID: ");
		JLabel label2 = new JLabel("Course: ");
		JLabel label3 = new JLabel("Section: ");
		JLabel label4 = new JLabel("Total Credit:  0");
		
		label1.setBounds(20, 20, 70, 30);
		label2.setBounds(20, 60, 70, 30);
		label3.setBounds(230, 60, 70, 30);
		label4.setBounds(430, 260, 100, 30);
		
		JTextField txtID = new JTextField();
		JComboBox<String> cmbxCourse = new JComboBox<String>();
		JComboBox<String> cmbxSection = new JComboBox<String>();
		
		txtID.setBounds(90, 20, 120, 30);
		cmbxCourse.setBounds(90, 60, 120, 30);
		cmbxSection.setBounds(290, 60, 70, 30);
		
		cmbxCourse.addItem("CSE115");
		cmbxCourse.addItem("CSE115L");
		cmbxCourse.addItem("CSE173");
		cmbxCourse.addItem("CSE215");
		cmbxCourse.addItem("CSE215L");
		
		cmbxCourse.setSelectedItem(null);
		cmbxSection.setSelectedItem(null);
		
		cmbxCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbxSection.removeAllItems();
				Course c = courseMap.get((String)cmbxCourse.getSelectedItem());
				for(int i = 1; i <= c.getSectionCount(); i++) {
					cmbxSection.addItem(Integer.toString(i));
				}
				cmbxSection.setSelectedItem(null);
			}
		});
		
		JButton btnAdd = new JButton("Add");
		JButton btnSave = new JButton("Save");
		JButton btnRemove = new JButton("Remove");
		
		btnAdd.setBounds(380, 60, 70, 30);
		btnSave.setBounds(240, 280, 90, 40);
		btnRemove.setBounds(460, 60, 83, 30);
		
		btnAdd.setFocusPainted(false);
		btnSave.setFocusPainted(false);
		btnRemove.setFocusPainted(false);
		
		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.addColumn("SL");
	    model.addColumn("ID");
	    model.addColumn("Title");
	    model.addColumn("TimeSlot");
	    model.addColumn("Credit");
	    	    
	    JTable table = new JTable(model);
	    
	    table.getTableHeader().setReorderingAllowed(false);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    
	    	    
	    table.getColumnModel().getColumn(0).setPreferredWidth(40);
	    table.getColumnModel().getColumn(1).setPreferredWidth(80);
	    table.getColumnModel().getColumn(2).setPreferredWidth(190);
	    table.getColumnModel().getColumn(3).setPreferredWidth(150);
	    table.getColumnModel().getColumn(4).setPreferredWidth(60);
	    
	    JScrollPane sp = new JScrollPane(table);
	    sp.setBounds(20, 110, 525, 150);
		
		this.add(label1);
		this.add(label2);
		this.add(txtID);
		this.add(cmbxCourse);
		this.add(label3);
		this.add(cmbxSection);
		this.add(btnAdd);
		this.add(btnRemove);
		this.add(sp);
		this.add(label4);
		this.add(btnSave);
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmbxCourse.getSelectedItem() == null || cmbxSection.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(CourseRegistration.this, "Please enter all fields");
					return;
				}
				
				for (int i = 0; i < courseList.size(); i++) {
					Course c = courseList.get(i);
					String str = c.getId().split("\\.")[0];
					if(str.equals((String)cmbxCourse.getSelectedItem()))
						continue;
					if(TimeSlot.checkTimeClash(c.getTimeSlot(), timeSlots.get(courseMap.get((String)cmbxCourse.getSelectedItem()).getTimeSlots()[Integer.parseInt((String)cmbxSection.getSelectedItem()) - 1] - 1))) {						
						JOptionPane.showMessageDialog(CourseRegistration.this, "Course time clashes with: " + c.getId());
						return;
					}
				}
				
				for(int i = 0; i < courseList.size(); i++) {
					Course c = courseList.get(i);
					String str = c.getId().split("\\.")[0];
										
					if(((String)cmbxCourse.getSelectedItem()).equals(str)) {
						int result = JOptionPane.showConfirmDialog(CourseRegistration.this, "Do you want to change section?", "Bruh", JOptionPane.YES_NO_OPTION);
						if(result != 0) {
							return;
						}
						else {
							int section = Integer.parseInt((String)cmbxSection.getSelectedItem());
							TimeSlot t = timeSlots.get(courseMap.get(str).getTimeSlots()[section - 1] - 1);
							c.setTimeSlot(t);
							c.setId(cmbxCourse.getSelectedItem() + "." + cmbxSection.getSelectedItem());
							model.removeRow(i);
							model.insertRow(i, new Object[] {i+1, c.getId(), c.getTitle(), c.getTimeSlot(), c.getCredit()});
							return;
						}
					}
				}
				String course = (String)cmbxCourse.getSelectedItem();
				int section = Integer.parseInt((String)cmbxSection.getSelectedItem());
				TimeSlot t = timeSlots.get(courseMap.get(course).getTimeSlots()[section - 1] - 1);
				Course c = courseMap.get(course).clone(t);
				c.setId(c.getId() + "." + cmbxSection.getSelectedItem());
				courseList.add(c);
				model.addRow(new Object[] {courseList.size(), c.getId(), c.getTitle(), c.getTimeSlot(), c.getCredit()});
				creditCount += c.getCredit();
				label4.setText("Total Credit:  " + creditCount);
			}
		});
		
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1)
					return;
				int index = table.getSelectedRow();
				creditCount -= courseList.get(index).getCredit();
				label4.setText("Total Credit:  " + creditCount);
				courseList.remove(index);
				model.removeRow(index);
				for (int i = 0; i < courseList.size(); i++) {
					model.setValueAt(i+1, i, 0);
				}				
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("src\\Courses.txt");
				FileWriter fr;
				try {
					fr = new FileWriter(file, false);
					fr.write("UserID: " + txtID.getText() + "\n\nCourses:\n");
					for(Course course : courseList) {
						fr.write(course.getId() + "\t\"" + course.getTitle() + "\"\t" + course.getTimeSlot() + "\t" + course.getCredit() + "\n");
					}
					fr.close();
					JOptionPane.showMessageDialog(CourseRegistration.this, "Saved Successfully!");
				} catch (IOException e1) {
					System.out.println("SZZ Error");
				}
			}
		});
		
		this.setVisible(true);
	}
}