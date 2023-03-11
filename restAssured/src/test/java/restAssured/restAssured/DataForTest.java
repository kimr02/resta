package restAssured.restAssured;

import org.testng.annotations.DataProvider;

public class DataForTest {


	@DataProvider(name = "DataForPost")
	public Object[][] dataForPost () {
		
		Object[][] data = new Object[2][3];
		
//		data[0][1] = "albert";
//		data[0][2] = "Johnson";
//		data[0][3] = 2;
//		
//		data[1][1] = "alex";
//		data[1][2] = "Kim";
//		data[1][3] = 3;
//		
//		return data;
		
		return new Object[][] {
			{"Alex","Kim", 1},
			{"Robert","Kiyoski",2},
			{"Tom","Test",3}
			
		};
	}
}
