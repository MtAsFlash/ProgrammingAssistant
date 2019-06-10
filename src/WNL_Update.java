

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WNL_Update{
	private int timeDifference;//第几天
	private int whatWeek;//星期几
	public WNL_Update(int year,int month) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = "1917-1-1";
		String dateStr2 = year+"-"+month+"-"+1;
		Date date1,date2;
		try {
			date1 = df.parse(dateStr);
			date2 = df.parse(dateStr2);
			this.timeDifference = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
			this.whatWeek = timeDifference%7;
		} catch (ParseException e) {
			System.out.println("计算日期失败");
			e.printStackTrace();
		}
	}
	public int getTimeDifference() {
		return timeDifference;
	}
	public int getWhatWeek() {
		return whatWeek;
	}
}
