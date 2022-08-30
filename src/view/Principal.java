package view;

import controller.RedesController;
import javax.swing.JOptionPane;
public class Principal {

	public static void main(String[] args) {
		RedesController procController = new RedesController();
		
        int teste = 0;
		
		while(teste != 9) {
		
			teste = Integer.parseInt(JOptionPane.showInputDialog("1 - ip\n2 - ping\n9 - finalizar"));
			
		
			if(teste == 1) procController.ip();
			if(teste == 2) procController.ping();

	}

}}
