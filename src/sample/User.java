package sample;

import java.awt.Image;
import java.time.LocalDate;
import java.util.*;

public class User {
    private static int latestUserId = 1000;
    private int userId;
    private String lastName;
    private String firstName;
    private LocalDate dateOfBirth;
    private String sex;
    private String email;
    private String phoneNumber;
    private String adres;
    private Image profilePicture;
    private Date creationDate;
    private List<Integer> Likes;
    private List<Integer> Matches;

    public User(String lastName, String firstName, LocalDate dateOfBirth, String sex, String email,
                String phoneNumber, String adres) {
        this.userId = latestUserId;
        latestUserId++;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.adres = adres;
        this.creationDate = new Date();
        this.Likes = new ArrayList<>();
    }

    //Methods


    //Getters & Setters

    public int getUserId() {
        return userId;
        
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres() {
        this.adres = adres;
    }

    public Image getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Image profilePicture) {
        this.profilePicture = profilePicture;
    }

    public List<Integer> getLikes(){
        return Likes;
    }

    public void addToLiked(int likedPerson){
        this.Likes.add(likedPerson);
    }

    public void addToMatches(int matchId){
        this.Matches.add(matchId);
    }

    public void addToMatches(User user){
        this.Matches.add(user.getUserId());
    }

    public void removeMatch(int user){
        Matches.remove(user);
    }
    public void removeMatch(User user){
        Matches.remove(user.getUserId());
    }

    public String toString(){
        return firstName + " " + lastName;
    }
}