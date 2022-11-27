package com.prueba.ejemplo.services;

import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class RetoService {

	public String reto(String matriz) {
		try {
			int matrix[][] = convertirStringAMatriz(matriz);
			int resultado[][] = rotarMatriz(matrix);
			String matrizGirada = matrizAString(resultado);

			return matrizGirada;
		}catch(Exception e) {
			return e.getMessage();
		}
		
	}
	
	public int[][] convertirStringAMatriz(String matriz) throws Exception{
		try {
			String[] matrizTemporal = matriz.replaceAll("\\s", "").split("],\\[");
			for (int i = 0; i < matrizTemporal.length; i++) {
				matrizTemporal[i] = matrizTemporal[i].replaceAll("]]|\\[\\[", "");
			}

		    int filas = matrizTemporal.length;
		    int columnas = matrizTemporal[0].split(",").length;
		        
		    if(filas !=columnas) {
		    	throw new Exception("La matriz debe ser cuadrada: NxN");
		    }

		    int[][] matrix = new int[matrizTemporal.length][columnas];

		    for (int i = 0; i < filas; i++) {
		        String[] numeros = matrizTemporal[i].split(",");
		        for (int j = 0; j < numeros.length; j++) {
		            matrix[i][j] = Integer.parseInt(numeros[j]);
		        }
		    }
		    return matrix;
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public int[][] rotarMatriz(int matriz[][]){
		int filas = matriz.length;
		int bandera = filas-1;
		int[][] resultado = new int[filas][filas];
		
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < filas; j++) {
                resultado[bandera-i][j] = matriz[j][i];
            }
        }
        return resultado;
	}
	
	public String matrizAString(int matrix[][]){
		String resultado = "";
        for (int i = 0; i < matrix.length; i++) {
        	resultado +=Arrays.toString(matrix[i]);
        }
        return resultado;
	}
}