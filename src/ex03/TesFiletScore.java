package ex03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Student {
	private int 	num;
	private String	name;
	private int 	kor;
	private int 	eng;
	private int 	mat;
	private int 	tot;
	private double 	avg;
	// Constructor
	public Student(int num, String name, int kor, int eng, int mat) {
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	public Student(String line) {
		String []li =	line.trim().split(",");
		this.num = Integer.parseInt(li[0].trim());
		this.name = li[1].trim();
		this.kor = Integer.parseInt(li[2].trim());
		this.eng = Integer.parseInt(li[3].trim());
		this.mat = Integer.parseInt(li[4].trim());
	}
	// Getter Setter
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	// toStirng
	@Override
	public String toString() {
		this.tot = kor+eng+mat;
		this.avg = this.tot/3.0;
		String fmt ="%d %s  %d %d %d %d %.3f";
		String msg = String.format(fmt, num, name, kor, eng, mat, tot, avg);
		return msg;
	}
	
}

public class TesFiletScore {

	public static void main(String[] args) throws IOException {
		// 파일 경로
				String			path	="D:\\hein\\java\\PrjIO\\src\\ex03\\";

				String			infile	="score.txt";
				FileReader		fr		=	new FileReader (path + infile);
				BufferedReader  br		=	new BufferedReader(fr);
				
				String			outfile ="result.txt";
				FileWriter		fw		=	new FileWriter(path + outfile);
				BufferedWriter 	bw		=	new BufferedWriter(fw);
				
				br.readLine();		// 입력파일의 제목줄 skip
				String			line	=	"";
				
				String		title ="번호 이름 국어 영어 수학 총점 평균";
				System.out.println(title);
				fw.write(title + "\n");
				while( (line = br.readLine()) !=null) {
					Student stud = new Student(line);
					System.out.println(stud+"\n");
					fw.write(stud.toString()+"\n");
				}
				
				br.close();
				bw.close();
				fr.close();
				fw.close();
	}

}
