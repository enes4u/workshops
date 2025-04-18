package com.pluralsight;

public class Book {

    private int id;
    private  String isbn;
    private  String title;
    private boolean isCheckedOut;
    private  String checkedOutTo;

    public Book( int id , String isbn, String title, boolean isCheckedOut, String checkedOutTo) {
        this.id= id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getIsCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    //methods
    public void checkOut(String name){
        this.isCheckedOut=true;
        this.checkedOutTo=name;
        System.out.println("Id number  "+ id +"  ISBN number : " + isbn+"   \""+ title+ "\" "+ "has been checked out to" +name +". " );

    }
    public  void checkedIn (){
        this.isCheckedOut=false;
        this.checkedOutTo="";
        System.out.println(" Title of the book:  "+ title + " has been checked in");

    }

//done with methods getters and setter hopefully
    //maybe string create method last
    //
    @Override
    public String toString(){
        return "ID "+ id+ "  , ISBN: "+ isbn + ", Title: \" " + "\", Checked Out To: \"" + checkedOutTo + "\"";

    }
}
