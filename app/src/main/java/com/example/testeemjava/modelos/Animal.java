package com.example.testeemjava.modelos;

import com.example.testeemjava.model.User;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

public class Animal implements Serializable {

    public String id;

    public String name;

    public String age;

    public String breed;

    public String description;

    public String urlImage;

    public String petSize;

    public String petRecommendedTo;

    public String coatLength;

    public String genre;

    public String petType;

    public String color;

    public String bloodType;

    public boolean vaccinated;

    public boolean disease;

    public User users;

    public Animal(String id, String name, String age, String breed, String description,
                  String urlImage, String petSize, String petRecommendedTo, String coatLength,
                  String genre, String petType, String color, String bloodType, boolean vaccinated,
                  boolean disease, User users) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.description = description;
        this.urlImage = urlImage;
        this.petSize = petSize;
        this.petRecommendedTo = petRecommendedTo;
        this.coatLength = coatLength;
        this.genre = genre;
        this.petType = petType;
        this.color = color;
        this.bloodType = bloodType;
        this.vaccinated = vaccinated;
        this.disease = disease;
        this.users = users;
    }

    public Animal() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getPetSize() {
        return petSize;
    }

    public void setPetSize(String petSize) {
        this.petSize = petSize;
    }

    public String getPetRecommendedTo() {
        return petRecommendedTo;
    }

    public void setPetRecommendedTo(String petRecommendedTo) {
        this.petRecommendedTo = petRecommendedTo;
    }

    public String getCoatLength() {
        return coatLength;
    }

    public void setCoatLength(String coatLength) {
        this.coatLength = coatLength;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public boolean isDisease() {
        return disease;
    }

    public void setDisease(boolean disease) {
        this.disease = disease;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id.equals(animal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
