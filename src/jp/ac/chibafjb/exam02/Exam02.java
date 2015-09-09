package jp.ac.chibafjb.exam02;

import java.util.List;

public class Exam02 {
	final static String DB_ID = "";
	final static String DB_PASS = "";
	
	public static void main(String[] args) {
		//DBに接続
		ExamDB02 db = new ExamDB02(DB_ID,DB_PASS);
		
		//データの挿入
		db.addMessage("ふなえもん",10);
		db.addMessage("ちーばくん",70);
		db.addMessage("ふなっしー",100);
		
		//メッセージの抽出
		List<ExamDB02.ExamData> listMsg = db.getMessage();
		for(ExamDB02.ExamData data : listMsg)
		{
			System.out.format("%s %d\n",data.msg,data.value);
		}
		//データベースの切断
		db.close();
	}

}
