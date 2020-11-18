import java.util.ArrayList;

public class Node
{
	private ArrayList<String[]> table;
	
	public Node()
	{
		table = new ArrayList<>();
	}
	
	public void addEntry(String[] entry)
	{
		if (entry.length != 3)
		{
			System.out.println("This entry's format is wrong!");
			return;
		}
		
		table.add(entry);
	}
	
	public String toString()
	{
		String temp = "";
		
		for (int i = 0; i < table.size(); i++)
		{
			for (int j = 0; j < table.get(j).length; j++)
			{
				System.out.print(table.get(i)[j].concat(" "));
			}
			
			System.out.println();
		}
		
		return temp;
	}
}
