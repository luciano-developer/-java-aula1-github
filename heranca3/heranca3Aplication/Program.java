package heranca3Aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import heranca3Entities.Circle;
import heranca3Entities.Retangle;
import heranca3Entities.Shape;
import heranca3Entities.enums.Color;

public class Program {
	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
		List<Shape> shapes = new ArrayList<Shape>();
		System.out.print("Entre com o numero de formas:");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Dados da #"+i+" forma: ");
			System.out.print("Retangulo ou Circulo (r/c)? ");
			char forma = sc.next().toLowerCase().charAt(0);
			System.out.print("Cor (AZUL / VERMELHO / PRETO): ");
			Color color = Color.valueOf(sc.next().toUpperCase());
			if(forma=='r') {
			System.out.print("Largura: ");
			double width = sc.nextDouble();
			System.out.print("Altura: ");
			double heigth = sc.nextDouble();
			
			shapes.add(new Retangle(color, width, heigth));
			}
			if(forma=='c')
			{
				System.out.print("Raio: ");
				double radius = sc.nextDouble();
				shapes.add(new Circle(color, radius));
			}
		}
		
		System.out.println();
		System.out.println("FORMAS: ");
		
		for (Shape shape : shapes) {
			System.out.println(String.format("%.2f%n", shape.area()));
		}
		
		sc.close();
	}
}
