
interface DegreeEarningDocument {
	public String getTitle();
}

class Dissertation implements DegreeEarningDocument {

	String title;
	/*Dissertation specific data*/
    public Dissertation(String title) {
    	this.title = title;
    	System.out.println("Dissertation named " + title + " created");
    }
	@Override
	public String getTitle() {
		
		return title;
	}
}

class Thesis implements DegreeEarningDocument {

	String title;
	/*Thesis specific data*/
    public Thesis(String title) {
    	this.title = title;
    	System.out.println("Thesis named " + title + " created");
    }
	@Override
	public String getTitle() {
		
		return title;
	}
}

class Project implements DegreeEarningDocument {
	String title;
	/*Project specific data*/
    public Project(String title) {
    	this.title = title;
    	System.out.println("Project named " + title + " created");
    }
	@Override
	public String getTitle() {
		return title;
	}
}

interface GraduateStudent {
	public DegreeEarningDocument createDocument(String title);
}

class PHD implements GraduateStudent {
	DegreeEarningDocument doc;
	public PHD() {
	}

	@Override
	public DegreeEarningDocument createDocument(String title) {
		return new Dissertation(title);
	}
}

class MSThesis implements GraduateStudent {
	DegreeEarningDocument doc;
	public MSThesis() {
	}

	@Override
	public DegreeEarningDocument createDocument(String title) {
		return new Thesis(title);
	}
}

class MSnonThesis implements GraduateStudent {
	DegreeEarningDocument doc;
	public MSnonThesis() {
	}

	@Override
	public DegreeEarningDocument createDocument(String title) {
		return new Project(title);
	}
}

public class FactoryMethodDemo {
	public static void main(String[] args) {
		PHD Emre = new PHD();
		Emre.createDocument("AI + Tools");
		
		MSThesis Gurkan = new MSThesis();
		Gurkan.createDocument("Traffic Jams");
		
		MSnonThesis Ozgur = new MSnonThesis();
		Ozgur.createDocument("ODTU cok pahali");
	}
}
