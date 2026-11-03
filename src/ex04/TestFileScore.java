package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Member {
	private int		num;
	private String	name;
	private int		kor;
	private int		eng;
	private int		mat;
	private int		tot;
	private double  avg;
	
	public Member(int num, String name, int kor, int eng, int mat) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		
	}

	public Member(String line) {
		String [] li = line.trim().split(",");
		num = Integer.parseInt(li[0].trim());
		name = li[1].trim();
		kor = Integer.parseInt(li[2].trim());
		eng = Integer.parseInt(li[3].trim());
		mat = Integer.parseInt(li[4].trim());
		
					tot	=	kor + eng + mat;
					avg	=	(double)tot	/	3.0;
		String		fmt	=	"%d %s %d %d %d %d %.2f";
		String		msg	=	String.format(fmt, 
				num, name, kor, eng, mat, tot, avg);
		
		
	}

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

	@Override
	public String toString() {
		String fmt =" %d %s  %d %d %d %d %.3f\n";
		String msg = String.format(fmt, num, name, kor, eng, mat, tot, avg);
		return msg;
	}	
	
	
}

public class TestFileScore {

	public static void main(String[] args) throws IOException {
		String			path	="D:\\hein\\java\\PrjIO\\src\\ex04\\";

		String			infile	="score.txt";
		FileReader		fr		=	new FileReader (path + infile);
		BufferedReader  br		=	new BufferedReader(fr);
		
		String			outfile ="result.txt";
		FileWriter		fw		=	new FileWriter(path + outfile);
		BufferedWriter 	bw		=	new BufferedWriter(fw);
		
		br.readLine();	
		ArrayList<Member> ml =new ArrayList <Member>();
		String line = "";
		String title = "순번 이름 국어 영어 수학 총점 평균";
		fw.write(title+"\n");
		while ((line=br.readLine())!= null) {
			Member memb = new Member(line);
			ml.add(memb);
		}
		 ml.sort((o1, o2) -> Integer.compare(o2.getTot(), o1.getTot()));
		 for (Member memb : ml) {
			    System.out.print(memb); 
			    fw.write(memb.toString());
			}
		
		
		br.close();
		bw.close();
		fr.close();
		fw.close();
	}



}
