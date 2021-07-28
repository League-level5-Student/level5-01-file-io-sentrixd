package _03_To_Do_List;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	
	public static ArrayList<String> epiclist = new ArrayList<String>();
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Todo list");
		JPanel panel = new JPanel();
		
		frame.add(panel);
		
		panel.setLayout(new FlowLayout());
		
		JButton addTask = new JButton();
		JButton viewTasks = new JButton();
		JButton removeTask = new JButton();
		JButton saveList = new JButton();
		JButton loadList = new JButton();
		
		addTask.setText("Add Task");
		viewTasks.setText("View Tasks");
		removeTask.setText("Remove task");
		saveList.setText("Save list");
		loadList.setText("Load List");
		
		addTask.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = new JOptionPane().showInputDialog("What to add to the list:");
				input = input + "";
				
				epiclist.add(input);
			}
		});
		
		viewTasks.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				load();
				String output = ""; 
				for (String s:epiclist) {
					output = output + s + "\n";
				}
				System.out.println(output);
			}
		});
		
		removeTask.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = new JOptionPane().showInputDialog("Task to remove:");
				epiclist.remove(input);
			}
		});
		
		saveList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		
		loadList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				load();
				String output = ""; 
				for (String s:epiclist) {
					output = output + s + "\n";
				}
				System.out.println(output);
			}
		});
		
		panel.add(addTask);
		panel.add(viewTasks);
		panel.add(removeTask);
		panel.add(saveList);
		panel.add(loadList);
		
		frame.setSize(200, 300);  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);  
	}
	
	private static void save() {
		try {
			FileWriter fw = new FileWriter("src/_03_To_Do_List/save.txt");
			
			for (String s: epiclist) {
				fw.write(s+"\n");
			}
				
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void load() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/save.txt"));
			String line = br.readLine();
			
			epiclist.clear();
			
			while(line != null){
				epiclist.add(line);
				line = br.readLine();
			}
			
			br.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
