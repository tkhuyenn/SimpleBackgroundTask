package com.example.simplebackgroundtask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements IItemClickListener {

//    private TextView mTextView;
//    private Handler mHandler;
//    private ProgressBar progressBar;
//    private Button button;

    private RecyclerView mRecyclerView;
    private UserListAdapter mAdapter;
    ArrayList<User> mWordList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mTextView = findViewById(R.id.textView1);
//        progressBar = findViewById(R.id.progressBar);
//
//        button = findViewById(R.id.button);
//        mHandler = new Handler();

        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new UserListAdapter(this, mWordList, this);

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchUser();
    }

    @Override
    public void onItemClicked(User user) {
        navigateToDetailScreen(user);
    }

    @Override
    public void onDeleteButtonClicked(int userId) {
        deleteUser(userId);
    }

    private void fetchUser() {
        ApiClient.getAPI().getAllUsers().enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                mWordList.clear();
                mWordList.addAll(response.body());
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {

            }
        });
    }

    private void deleteUser(int userId) {
        ApiClient.getAPI().deleteUser(userId).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                fetchUser();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void navigateToDetailScreen(User user) {
        Intent intent = new Intent(this, UserDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("user_data", user);
        intent.putExtras(bundle);
        this.startActivity(intent);
    }

    public void startTask(View view) {
//        mTextView.setText("Loading...");
//        // Chạy trên Main Thread, chạy trên UI Thread
//
//
//        progressBar.setVisibility(View.VISIBLE);
//
//        button.setVisibility(View.INVISIBLE);

//        new Thread(()-> {
//            try {
//                URL url = new URL("https://gorest.co.in/public/v2/users");
//                HttpsURLConnection httpsConnection = (HttpsURLConnection) url.openConnection();
//                BufferedReader in = new BufferedReader(new InputStreamReader(httpsConnection.getInputStream()));
//                String inputLine;
//                StringBuffer response = new StringBuffer();
//                while ((inputLine = in.readLine()) != null) {
//                    response.append(inputLine);
//                }
//                in.close();
//                mHandler.post(()-> {
//               // Chạy trong Main Thread, chạy trên UI Thread
//                    button.setVisibility(View.VISIBLE);
//                    progressBar.setVisibility(View.INVISIBLE);
//
//                    mTextView.setText(response);
//                });
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }).start();


//        ApiClient.getAPI().getAllUsers().enqueue(new Callback<ArrayList<User>>() {
//            @Override
//            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
//                ArrayList<User> userList = response.body();
//                mTextView.setText("Number of Users: " + userList.size());
//                progressBar.setVisibility(View.INVISIBLE);
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
//                mTextView.setText("Error:" + t.getMessage());
//                progressBar.setVisibility(View.INVISIBLE);
//            }
//        });


//        ApiClient.getAPI().getUsersByID(2917).enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                User user = response.body();
//                mTextView.setText(user.name);
//                progressBar.setVisibility(View.INVISIBLE);
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                mTextView.setText("Error:" + t.getMessage());
//                progressBar.setVisibility(View.INVISIBLE);
//            }
//        });

//        User user = new User();
//        user.name = "Nguyen Thi Thu Trang";
//        user.email = "trang@test.com";
//        user.gender = "female";
//        user.status = "Active";
//
//        ApiClient.getAPI().addUser(user).enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                User user = response.body();
//                mTextView.setText("User ID: " + user.id);
//                progressBar.setVisibility(View.INVISIBLE);
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                mTextView.setText("Error:" + t.getMessage());
//                progressBar.setVisibility(View.INVISIBLE);
//            }
//        });


    }


}