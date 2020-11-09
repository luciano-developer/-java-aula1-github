package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Comment;
import entities.Post;

public class Program2 {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Comment c1 = new Comment("boa viagem!");
		Comment c2 = new Comment("viagem incrivel!");
		
		Post post = new Post(sdf.parse("21/06/2018 13:55:44"), "Viagem para Nova Zelandia",
				"Conteudo da viagem", 12);
		
		post.addComment(c1);
		post.addComment(c2);
		System.out.println(post.toString());
	}

}
