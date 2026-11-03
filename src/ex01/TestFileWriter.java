package ex01;

import java.io.FileWriter;
import java.io.IOException;

public class TestFileWriter {

	public static void main(String[] args) throws IOException {
		// Java 에서는 "" 안에 \ 를 한개만 넣으면 애러
		// 			   ""      \ -> \\
		String 		filename = "D:\\hein\\java\\PrjIO\\src\\ex01\\bts.txt";
		//String 		filename2 = "D:/hein/java/PrjIO/src/ex01";
		//System.out.println(filename);
		// 파일 생성 : open ~ close 하면 새로운 파일이 생성
		// Java 는 open 명령을 new 할 때 실행한다.
		String [] 	names = { "RM", "진","슈가","제이홉","지민","뷔","정국"	};
		FileWriter fw	=new FileWriter (filename + "");
		
		for (int i = 0; i < names.length; i++) {
			fw.write((i + 1) + "." + names[i] + "\n ");
		} 
		
		fw.close();
		System.out.println(filename +"가 저장되었습니다.");
		
		
	}

}
