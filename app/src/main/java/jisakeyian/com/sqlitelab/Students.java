package jisakeyian.com.sqlitelab;

/**
 * Created by Ian James on 2017/11/01.
 */

public class Students {

    int _id;
    String Sname;
    String course;

    public  Students(){

    }
    public Students( int id,String S_name,String S_course){
        this._id = id;
        this. Sname= S_name;
        this. course = S_course;
    }
    public Students( String S_name,String S_course){
        this. Sname= S_name;
        this. course = S_course;
    }

    public int getID(){
        return  this._id;
    }
    public  String getSName(){
        return this.Sname;
    }
    public String getCourse(){
        return this.course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setId(int id) {
        this._id = id;
    }

    public void setName(String S_name) {
        this.Sname = S_name;
    }
}

