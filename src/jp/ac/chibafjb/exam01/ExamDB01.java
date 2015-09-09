package jp.ac.chibafjb.exam01;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.ac.chibafjb.db.OracleDB;

public class ExamDB01 extends OracleDB
{
	//コンストラクタ
	public ExamDB01(String id,String pass)
	{
		//DBに接続
		if(!connect("ux4",id,pass))
		{
			//接続に失敗
			System.err.println("接続エラー");
		}
		else
		{
			//テーブルが無ければ作成
			if(!isTable("exam01"))
				execute("create table exam01(msg varchar(200))");
		}
	}
	//データの挿入
	public void addMessage(String msg)
	{
		execute(String.format("insert into exam01 values('%s')",STR(msg)));
	}
	//データの削除
	public void delMessage()
	{
		execute("delete from exam01");
	}
	//データの抽出
	public List<String> getMessage()
	{
		ArrayList<String> list = new ArrayList<String>();
		try {
			ResultSet res = query("select * from exam01");	
			while(res.next())
			{
				list.add(res.getString(1));
			}
		} catch (SQLException e) {
			System.err.println("データ抽出中にエラー");
		}
		return list;
	}
}