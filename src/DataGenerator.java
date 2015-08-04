import java.util.Random;


public class DataGenerator {
	/*
	 * Begin Initialization of Local Variables 
	 **/
	private String startline;
	private String endline = ");";
	
	private String[] years = {"2010","2011","2012","2013","2014","2015","2016","2017"};
	
	private String[] termLetter = {"U","F","S"};
	private double[] termLetterChance = {.02, .49, .49};
	
	private Decider<Integer>[][] department = new Decider[11][2];
	
	private Integer[][] courses = new Integer[11][4];
	{
		int count = 1;
		for(int i = 0; i < courses.length; i++)
		{
			for(int j = 0; j < courses[0].length; j++)
			{
				courses[i][j] = count;
				count++;
			}
		}
	}
	
	private Integer[][] faculty = new Integer[11][5];
	{
		int count = 1;
		for(int i = 0; i < faculty.length; i++)
		{
			for(int j = 0; j < faculty[0].length; j++)
			{
				faculty[i][j] = count;
				count++;
			}
		}
	}
	Decider<String> yearD;
	Decider<String> termD;
	Decider<Decider[]> depD;
	/* 
	 * End Initialization
	 * 
	 * Begin Functions
	 */
	
	public DataGenerator(String startline)
	{
		this.startline = startline;
		
		yearD = new Decider<String>(years);
		termD = new Decider<String>(termLetterChance, termLetter);
		
		for(int i = 0; i < department.length; i++)
		{
			department[i][0] = new Decider<Integer>(courses[i]);
			department[i][1] = new Decider<Integer>(faculty[i]);
		}
		
		depD = new Decider<Decider[]>(department);
		
		
	} 
	//Next, figure out what to do with the data. Probably keep it within here, hardcode it in for now
	
	public String writeLine()
	{
		Random random = new Random();
		Decider<Integer>[] department = depD.zone(random.nextDouble());
		Integer course = department[0].zone(random.nextDouble());
		Integer faculty = department[1].zone(random.nextDouble());
		String term = yearD.zone(random.nextDouble()) + termD.zone(random.nextDouble());
		
		String full = startline + course + "," + faculty + ",'" + term + "'" + endline;
		return full;
		
	}
	
}
