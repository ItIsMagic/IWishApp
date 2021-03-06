package com.example.IWish.api;

import android.util.Log;

import com.example.IWish.ApiConfig;
import com.example.IWish.Model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class UserApi extends BaseApi<User> {

    public UserApi() {
        this.actionUrl = ApiConfig.BASE_URL + "/users/";
    }

    @Override
    protected User createFromJson(JSONObject jsonObject) {
        return new User(jsonObject);
    }

    public User createUser(String email, String password, String firstName, String lastName) throws ExecutionException, InterruptedException, JSONException {
        String result = this.http.get(actionUrl + "create?" + "email=" + email + "&password=" + password +"&firstName=" + firstName +"&lastName=" + lastName).get();

        JSONObject jsonObject = new JSONObject(result);
        return new User(jsonObject);
    }

    public JSONArray findsUser(String id, String email, String firstName, String lastName) throws ExecutionException, InterruptedException, JSONException {
        boolean first = true;
        String parameters = "";

        if(!id.isEmpty()){
            parameters += "id=" + id;
            first = false;
        }
        if(!email.isEmpty()){
            if(first){
                parameters += "email=" + email;
                first = false;
            }else{
                parameters += "&email=" + email;
            }
        }
        if(!firstName.isEmpty()){
            if(first){
                parameters += "firstName=" + firstName;
                first = false;
            }else{
                parameters += "&firstName=" + firstName;
            }
        }
        if(!lastName.isEmpty()){
            if(first){
                parameters += "firstName=" + lastName;
                first = false;
            }else{
                parameters += "&firstName=" + lastName;
            }
        }
        String result = this.http.get(actionUrl + "?" + parameters).get();
        return new JSONArray(result);
    }

    public User addCategory(long id, long fk) throws InterruptedException, ExecutionException, JSONException {
        return super.addRelation(id, "categories", fk);
    }

    public User deleteCategory(long id, long fk) throws InterruptedException, ExecutionException, JSONException {
        return super.deleteRelation(id, "categories", fk);
    }

    public User addConcerned(long id, long fk) throws InterruptedException, ExecutionException, JSONException {
        return super.addRelation(id, "concernedWishlists", fk);
    }

    public User deleteConcerned(long id, long fk) throws InterruptedException, ExecutionException, JSONException {
        return super.deleteRelation(id, "concernedWishlists", fk);
    }

    public User addManagedPrizePool(long id, long fk) throws InterruptedException, ExecutionException, JSONException {
        return super.addRelation(id, "managedPrizePools", fk);
    }

    public User addDonation(long id, long fk) throws InterruptedException, ExecutionException, JSONException {
        return super.addRelation(id, "donations", fk);
    }
}
