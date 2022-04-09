package com.example.simplebackgroundtask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private final ArrayList<User> mUserList;
    private final Context context;
    private final IItemClickListener onItemClickListener;


    public UserListAdapter(Context context, ArrayList<User> userList, IItemClickListener onItemClickListener) {
        this.context = context;
        this.mUserList = userList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(context);
        View mItemView = mInflater.inflate(R.layout.userlist_item, parent, false);
        return new UserViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mUserList.get(position);
        if (user == null) {
            return;
        }
        String mCurrent = mUserList.get(position).name;
        holder.tvUserName.setText(mCurrent);
//        holder.tvEmail.setText(mCurrent);
//        holder.tvGender.setText(mCurrent);
//        holder.tvStatus.setText(mCurrent);
        holder.itemView.setOnClickListener(view -> onItemClickListener.onItemClicked(user));
        holder.btnDelete.setOnClickListener(view -> onItemClickListener.onDeleteButtonClicked(user.id));
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }


    public class UserViewHolder extends RecyclerView.ViewHolder {
        public final TextView tvUserName;
//        public final TextView tvEmail;
//        public final TextView tvGender;
//        public final TextView tvStatus;
        public final ImageView btnDelete;
        final UserListAdapter mAdapter;

        public UserViewHolder(View itemView, UserListAdapter adapter) {
            super(itemView);
            tvUserName = itemView.findViewById(R.id.userName);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            this.mAdapter = adapter;
        }
    }
}
