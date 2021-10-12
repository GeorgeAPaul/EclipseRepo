package karmaSutra;

import java.util.*;

public class SexGenerator {
	
	public String[] sexLibrary ()
	{
		String[] sexLib = {"The gentle chimney sweep","Lucky Licky","Oily sexy massage",
				"Butt dog","50 shades of literature... and masturbation",
				"Consumating the mariage missionary stylez","Horny Doctor Clever",
				"The Mistress BDSM","The Master BDSM","Georgina is in town","Mark is in the village"};
		String[] sex = new String[(int)(Math.random() * 2 + 2)];
		
		String[] day = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		
		for(int i = 0; i < sex.length; i++)
		{
			sex[i] = sexLib[(int)(Math.random() * sexLib.length)] + " on a " + day[(int)(Math.random() * day.length)] + "!";
		}
		
		return sex;
	}

}
