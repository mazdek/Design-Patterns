import java.util.*;

interface Item {
    public int calculate();
}

class Silver implements Item {

	private int point;
	
    public Silver() {
    	point = 5;
    }

    public int calculate() {
        return point;
    }
}

class Gold implements Item {

	private int point;
	
    public Gold() {
    	point = 10;
    }

    public int calculate() {
        return point;
    }
}

class Diamond implements Item {

	private int point;
	
    public Diamond() {
    	point = 50;
    }

    public int calculate() {
        return point;
    }
}

class Chest implements Item {

    public Chest() {
    }


	private int point = 0;
    private ArrayList<Item> items = new ArrayList<Item>();

    public void add(Item i) {
    	items.add(i);
    }

    public void remove(Item i) {
    	items.remove(i);
    }

    public ArrayList<Item> getChildren() {
    	return items;
    }
    
    public int calculate() {
    	int result = 0;
        for (Item temp : items) {
        	result += temp.calculate();
		}
        
        point = result;
        return point;
    }

}

public class CompositeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gold g0 = new Gold();
		Gold g1 = new Gold();
		Gold g2 = new Gold();
		
		Silver s0 = new Silver();
		Silver s1 = new Silver();
		Silver s2 = new Silver();
		
		Diamond d0 = new Diamond();
		Diamond d1 = new Diamond();
		
		Chest c0 = new Chest();
		Chest c1 = new Chest();
		Chest c2 = new Chest();
		
		c2.add(s0); //5
		c2.add(d0); //50
		
		c1.add(g0); //10
		c1.add(s1); //5
		c1.add(c2); //55
		
		c0.add(c1); //70
		c0.add(g1); //10
		c0.add(g2); //10
		c0.add(s2); //5
		c0.add(d1); //50
		
		int c2Points = c2.calculate();
		
		int c1Points = c1.calculate();
		
		int c0Points = c0.calculate();
		
		System.out.println("Chest 2's total point: " + c2Points);
		System.out.println("Chest 1's total point: " + c1Points);
		System.out.println("Chest 0's total point: " + c0Points);
	}
}
