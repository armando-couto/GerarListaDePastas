package br.com.gerador.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Um programa que gera o nome das pastas.
 * 
 * @author Armando Couto
 * 
 */

public class Gerador implements Serializable {

	private static final long serialVersionUID = 1L;

	private JFileChooser chooser;
	private File file;
	private File diretorios[];
	private FileWriter fw;
	private BufferedWriter bw;

	public Gerador() {
		chooser = new JFileChooser();
	}

	public void gerar() {
		
		// Diretório raiz.
		chooser.setCurrentDirectory(new File("C:"+File.separator));
		// restringe a amostra a diretorios apenas.
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		// Permite selecionar vários arquivos. 
		chooser.setMultiSelectionEnabled(true);
		
		if (chooser.showOpenDialog(null) == 0) {
			try {
				String nome = JOptionPane.showInputDialog(null, "Digite o nome do arquivo?");
				file = new File(nome+".txt");
				file.createNewFile();
				fw = new FileWriter(file);
				bw = new BufferedWriter(fw);
					diretorios = chooser.getSelectedFiles();
		            for (File pasta : diretorios) {
						bw.write(pasta.getName());
						bw.newLine();
					}
	            bw.close();
	            JOptionPane.showMessageDialog(null, "Arquivo gerado com sucesso.");
        	} catch(FileNotFoundException e) {
        		System.out.println("Arquivo não foi encontrado");
        	} catch(IOException e) {
        		System.out.println("Erro ao acessar arquivo"+ file);
        	}
		}
	}
 	
	public static void main(String[] args) throws IOException {
		new Gerador().gerar();
	}
}