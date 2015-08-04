
public class Main {

	public static void main(String[] args) {
		String temp = "insert into sections values(section_seq.nextval,";
		DataGenerator gen = new DataGenerator(temp);
		
		for(int i = 0; i < 500; i++)
		{
			System.out.println(gen.writeLine());
		}

	}

}
