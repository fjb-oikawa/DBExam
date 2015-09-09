package jp.ac.chibafjb.exam02;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.ac.chibafjb.db.OracleDB;

public class ExamDB02 extends OracleDB
{
	public class ExamData
	{
		public String msg;
		public int value;
	}
	
	//コンストラクタ
	public ExamDB02(String id,String pass)
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
			if(!isTable("exam02"))
				execute("create table exam02(msg varchar(200),value number)");
		}
	}
	//データの挿入
	public void addMessage(String msg,int value)
	{
		execute(String.format("insert into exam02 values('%s','%d')",STR(msg),value));
	}
	//データの削除
	public void delMessage()
	{
		execute("delete from exam02");
	}
	//データの抽出
	public List<ExamData> getMessage()
	{
		ArrayList<ExamData> list = new ArrayList<ExamData>();
		try {
			ResultSet res = query("select * from exam02");	
			while(res.next())
			{
				ExamData data = new ExamData();
				data.msg = res.getString(1);
				data.value = res.getInt(2);
				list.add(data);
			}
		} catch (SQLException e) {
			System.err.println("データ抽出中にエラー");
		}
		return list;
	}
}