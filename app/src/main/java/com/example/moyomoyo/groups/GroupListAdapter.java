package com.example.moyomoyo.groups;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moyomoyo.R;

import java.util.ArrayList;

public class GroupListAdapter extends RecyclerView.Adapter<GroupListAdapter.ViewHolder> {
    private ArrayList<GroupDTO> groupDTOArrayList = new ArrayList<>();

    public GroupListAdapter(ArrayList<GroupDTO> data) {
        groupDTOArrayList = data;
    }

    interface OnItemClickListener {
        void onItemClick(GroupListAdapter.ViewHolder viewHolder, View v, int position);
    }

    // 리스너 객체 참조 변수
    private OnItemClickListener mListener = null;

    // 리스너 객체 참조를 어댑터에 전달하는 메서드
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvGroupName;
        TextView tvGroupInfo;
        TextView tvGroupField;

        ViewHolder(View itemView){
            super(itemView);

            tvGroupName = itemView.findViewById(R.id.tv_group_title);
            tvGroupInfo = itemView.findViewById(R.id.tv_group_info);
            tvGroupField = itemView.findViewById(R.id.tv_group_keyword);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        mListener.onItemClick(GroupListAdapter.ViewHolder.this, view, pos);
                    }
                }
            });
        }
    }

    // 아이템 뷰를 위한 뷰홀더 객체를 생성하여 리턴
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.list_group, parent, false);
        GroupListAdapter.ViewHolder viewHolder = new GroupListAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        GroupDTO item = groupDTOArrayList.get(position);

        holder.tvGroupName.setText(item.getName());
        holder.tvGroupInfo.setText(item.getInfo());
        holder.tvGroupField.setText(item.getField());
    }

    // Adapter 에 사용되는 데이터의 개수를 리턴
    @Override
    public int getItemCount(){
        return groupDTOArrayList.size();
    }
}
