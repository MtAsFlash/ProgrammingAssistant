package biYeSheJi;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
	String str;
	public GetDate() {
		// TODO Auto-generated constructor stub
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm");
		String dateNowStr = sdf.format(date);
		str = dateNowStr;
	}
}
