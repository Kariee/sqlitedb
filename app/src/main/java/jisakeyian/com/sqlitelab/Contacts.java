package jisakeyian.com.sqlitelab;

/**
 * Created by Ian James on 2017/11/01.
 */

public class Contacts {
    int _id;
    String _name;
    String _phone_number;

    public Contacts(){

    }

    public Contacts(int id, String name, String phoneNum){
        this._id = id;
        this. _name= name;
        this. _phone_number = phoneNum;
    }
    public Contacts( String name, String phoneNum){
        this. _name= name;
        this. _phone_number = phoneNum;
    }

    public int getID (){
        return this._id;

    }

    public String getName (){
        return this._name;

    }
    public String getPhone (){
        return this._phone_number;
    }

    public  void setID(int id){
        this._id = id;
    }
    public  void setName(String name){
        this._name = name;
    }
    public  void setPhone(String phone_Num){
        this._phone_number = phone_Num;
    }

}
