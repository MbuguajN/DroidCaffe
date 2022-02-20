package com.james.mydroidcaffev1;

public class Recipe {
    // declare private menber variable
    private final int recipeImage;
    private String recipeTitle;
    private String recipeDescription;

    //create a constructor
    //pass the parameters recipeImage , recipeTitle and recipeDescription

    Recipe(int recipeImage,String recipeTitle, String recipeDescription){
        this.recipeImage=recipeImage;
        this.recipeTitle=recipeTitle;
        this.recipeDescription=recipeDescription;

    }
    //create the getters

    public int getRecipeImage() {
        return recipeImage;
    }

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public String getRecipeDescription() {
        return recipeDescription;
    }
}
