package com.james.mydroidcaffev1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

// create a recipe adapter that extends recyclerview .adapter and use the recyclerview.ViewHolder

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    //declare the private member variables recipe data and context

    private ArrayList<Recipe> recipeData;
    private Context myContext;
    /*
    create a constructor to pass in the recipe data and the context
     */
    RecipeAdapter(ArrayList<Recipe> mRecipeData,Context context){
        //initialize the objects
        this.myContext=context;
        this.recipeData=mRecipeData;
    }


    @NonNull
    @Override
    /*
    1.1 implement the method onCreateViewHolder for creating viewHolder objects
    @parameter parent the view group of which the view object will be added after it is bound to the adapter position
    @parameter view viewType of the new view
    @return the new created viewHolder
     */
    public RecipeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // create a new view holder abd
        return new ViewHolder(LayoutInflater.from(myContext).inflate(R.layout.recipe_list_item,parent,false));
    }
    /*
    required for binding the vie of the data
    @holder ViewHolder which the data should be put
    @positions of the adapter position

     */

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.ViewHolder holder, int position) {

        //get the current view object using its position and populate it wit data
        Recipe currentRecipe= recipeData.get(position);

        //populate the current view with data

        holder.bindTo(currentRecipe);

    }
    /*
    required for getting size of the data set
    @return the size of the dataset

     */

    @Override
    public int getItemCount() {

        return recipeData.size();
    }

    //create the ViewHolder class that represents each and every row

    public class ViewHolder extends RecyclerView.ViewHolder{

        /*
        create constructor for the viewHolder used in onCreateViewHolder
        !param itemView rootView of the recipe _list
         */

        // declare the private member variables that the vieHolder will hold
        private ImageView myRecipeImage;
        private TextView myRecipeTitle;
        private TextView myRecipeDescription;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            myRecipeImage=itemView.findViewById(R.id.recipe_image);
            myRecipeTitle=itemView.findViewById(R.id.recipe_title);
            myRecipeDescription=itemView.findViewById(R.id.recipe_description);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int dessertPosition = getAdapterPosition();
                    Recipe currentDessert =recipeData.get(dessertPosition);
                    if (dessertPosition==0){
                        Intent donutIntent = new Intent(myContext,DonutActivity.class);
                        donutIntent.putExtra("dTitle",currentDessert.getRecipeTitle());
                        donutIntent.putExtra("dImage",currentDessert.getRecipeImage());
                        donutIntent.putExtra("dDescription", currentDessert.getRecipeDescription());
                        myContext.startActivity(donutIntent);

                    }else{
                        Toast.makeText(myContext, "Create an activity for the dessert", Toast.LENGTH_LONG).show();;
                    }
                }
            });

        }
/*
create a method to bind the current view with data(image title and description)
 */
        public void bindTo(Recipe currentRecipe) {

            /*
            populate the view with the data
            for loading rhe image
            @implement the glide library first in you gradle module (app )
             */

            Glide.with(myContext).load(currentRecipe.getRecipeImage()).into(myRecipeImage);
            myRecipeTitle.setText(currentRecipe.getRecipeTitle());
            myRecipeDescription.setText(currentRecipe.getRecipeDescription());


        }
    }
}
