package br.com.gerador.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Serializable;

/**
 * Um programa que gera o nome das pastas.
 * @author Armando Couto
 *
 */

public class Gerador implements Serializable {

	private static final long serialVersionUID = 1L;

	private File file;
	private FileReader fr;
	private BufferedReader br;
	
	public Gerador() {
		
		file = new File("");
	}
	
	
	public static void main(String[] args) {
		
	}
}