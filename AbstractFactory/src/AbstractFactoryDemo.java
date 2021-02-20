interface StudentFactory {
    
    public Course createCourse();
    public Paper createPaper();
    public DegreeDocument createDegreeErnDoc();
}

class UndrGraduateStudentFactory implements StudentFactory {

    @Override
    public Course createCourse() {
        
        return new UndrGraduateStudentCourse();
    }

    @Override
    public Paper createPaper() {
        
        return  new TechnicalReport();
    }

    @Override
    public DegreeDocument createDegreeErnDoc() {
        
        return new ProjectReport();
    } 
}

class MsStudentFactory implements StudentFactory {
    
    @Override
    public Course createCourse() {
        
        return new MsStudentCourse();
    }

    @Override
    public Paper createPaper() {
        
        return new ConferencePaper();
    }

    @Override
    public DegreeDocument createDegreeErnDoc() {
        
        return new MsThesis();
    }    
}

class PhdStudentFactory implements StudentFactory {
    @Override
    public Course createCourse() {
        
        return new PhdStudentCourse();
    }

    @Override
    public Paper createPaper() {
        
        return new JournalPaper();
    }

    @Override
    public DegreeDocument createDegreeErnDoc() {
        
        return new Dissertation();
    }
}

interface Course {
    public String getCourseName();
}

class UndrGraduateStudentCourse implements  Course{

    @Override
    public String getCourseName() {
        
        return "Under Graduate Student Course";
    }   
}

class MsStudentCourse implements Course{

    @Override
    public String getCourseName() {
        
        return "Ms Student Course";
    } 
}

class PhdStudentCourse implements Course{

    @Override
    public String getCourseName() {
        
        return "Phd Student Course";
    }
}

interface DegreeDocument {
    public String getDegreeDocName();
}

class ProjectReport implements DegreeDocument{

    @Override
    public String getDegreeDocName() {
        
        return "Project Report";
    }   
}

class MsThesis implements DegreeDocument{

    @Override
    public String getDegreeDocName() {
        
        return "Ms Thesis";
    } 
}

class Dissertation implements DegreeDocument{

    @Override
    public String getDegreeDocName() {
        
        return "Dissertation";
    }
}

interface Paper {
    public String getPaperName();
}

class TechnicalReport implements Paper{

    @Override
    public String getPaperName() {
        
        return "Technical Report";
    }
    
}

class JournalPaper implements Paper{

    @Override
    public String getPaperName() {
        
        return "Journal Paper";
    }
}

class ConferencePaper implements Paper{

    @Override
    public String getPaperName() {
        return "Conference Paper";
    }
    
}

class Student {
    
    private String type;
    private Course course;
    private Paper paper;
    private DegreeDocument degreeDocument;
    
    public Student(String type, Course course, Paper paper, DegreeDocument degreeDocument) {
        this.type = type;
        this.course = course;
        this.paper = paper;
        this.degreeDocument = degreeDocument;
    }

    public String getType() {
        return type;
    }

    public Course getCourse() {
        return course;
    }

    public Paper getPaper() {
        return paper;
    }

    public DegreeDocument getDegreeDocument() {
        return degreeDocument;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public void setDegreeDocument(DegreeDocument degreeDocument) {
        this.degreeDocument = degreeDocument;
    }
    
    public void printInfo(){
        System.out.println("Type: "+ this.type);
        System.out.println("Course: "+ this.course.getCourseName());
        System.out.println("Paper: "+ this.paper.getPaperName());
        System.out.println("Degree Document: "+ this.degreeDocument.getDegreeDocName());
    }
    
}
  

public class AbstractFactoryDemo {

	public static void main(String[] args) {
		StudentFactory msStudentFactory = new MsStudentFactory();
        
        Student msStudent = new Student("MS Student", msStudentFactory.createCourse(), 
                msStudentFactory.createPaper(), msStudentFactory.createDegreeErnDoc());
        
        msStudent.printInfo();
        System.out.println();
        
        StudentFactory underGrStudentFactory = new UndrGraduateStudentFactory();
        
        Student underGrStudent = new Student("Under Graduate Student", underGrStudentFactory.createCourse(), 
                underGrStudentFactory.createPaper(), underGrStudentFactory.createDegreeErnDoc());
        
        underGrStudent.printInfo();
        
        System.out.println();
        StudentFactory phdStudentFactory = new PhdStudentFactory();
        
        Student phdStudent = new Student("Under Graduate Student", phdStudentFactory.createCourse(), 
                phdStudentFactory.createPaper(), phdStudentFactory.createDegreeErnDoc());
        
        phdStudent.printInfo();

	}

}
