package jp.ac.chibafjb.exam;

import java.util.List;

import jp.ac.chibafjb.db.ExamDB01;

public class Exam01 {
	final static String DB_ID = "";
	final static String DB_PASS = "";
	
	public static void main(String[] args) {
		//DBに接続
		ExamDB01 db = new ExamDB01(DB_ID,DB_PASS);
		//データの挿入
		db.addMessage("あいうえお");
		
		//メッセージの抽出
		List<String> listMsg = db.getMessage();
		for(String msg : listMsg)
		{
			System.out.format("%s\n",msg);
		}
		//データベースの切断
		db.close();
	}

}
