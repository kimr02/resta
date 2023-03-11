package restAssured.restAssured;

import org.testng.annotations.Test;

public class DiffDataProviderClass {
// use dataprovider from Test01_Example Class
	
	//@Test (dataProvider = "SearchProvider", dataProviderClass =Test01_Example.class )
	public void dataTest (String firstname, String lastname, int id) {
		
		System.out.println("FName: " +firstname + " LName: " + lastname + " ID : " +id);
		
		
	}
	@Test
	void randomNumber () {
		Math.random();
		int counter = 0;
		for (counter =0; counter <5; counter++) {
	
		
		if (counter == 3) {
			break;
		}
		System.out.println(Math.random()*100);
		}
	}
	

}
