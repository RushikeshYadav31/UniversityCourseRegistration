package university_course_system;

public class Student {
   private int studId;
   private String studName;
   public Student(int studId,String studName){
       this.studId=studId;
       this.studName=studName;

   }
    public int getStudId(){
        return studId;
    }
    public void setStudId(int studId){
        this.studId=studId;
    }

    public String getStudName(){
        return studName;
    }
    public void setStudName(String studName){
        this.studName=studName;
    }

}
