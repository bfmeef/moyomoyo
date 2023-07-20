package com.example.moyomoyo.studyrooms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moyomoyo.R;

import java.util.ArrayList;

public class StudyRoomListAdapter extends RecyclerView.Adapter<StudyRoomListAdapter.ViewHolder> {
    private ArrayList<StudyRoomDTO> studyRoomDTOArrayList = new ArrayList<>();

    public StudyRoomListAdapter(ArrayList<StudyRoomDTO> data){
        studyRoomDTOArrayList = data;
    }

    interface OnItemClickListener {
        void onItemClick(StudyRoomListAdapter.ViewHolder viewHolder, View v, int position);
    }

    // 리스너 객체 참조 변수
    private OnItemClickListener mListener = null;

    // 리스너 객체 참조를 어댑터에 전달하는 메서드
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvStudyRoomName;
        TextView tvStudyRoomManager;
        TextView tvStudyRoomContact;
        TextView tvStudyRoomLocation;
        TextView tvStudyRoomInfo;
        TextView tvStudyRoomCapacity;

        ViewHolder(View itemView){
            super(itemView);

            tvStudyRoomName = itemView.findViewById(R.id.tv_study_room_name);
            tvStudyRoomManager = itemView.findViewById(R.id.tv_study_room_manager);
            tvStudyRoomContact = itemView.findViewById(R.id.tv_study_room_contact);
            tvStudyRoomLocation = itemView.findViewById(R.id.tv_study_room_location);
            tvStudyRoomInfo = itemView.findViewById(R.id.tv_study_room_info);
            tvStudyRoomCapacity = itemView.findViewById(R.id.tv_study_room_capacity);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        mListener.onItemClick(StudyRoomListAdapter.ViewHolder.this, view, pos);
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

        View view = inflater.inflate(R.layout.list_study_room, parent, false);
        StudyRoomListAdapter.ViewHolder viewHolder = new StudyRoomListAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        StudyRoomDTO item = studyRoomDTOArrayList.get(position);

        holder.tvStudyRoomName.setText(item.getName());
        holder.tvStudyRoomManager.setText(item.getManager());
        holder.tvStudyRoomContact.setText(item.getContact());
        holder.tvStudyRoomLocation.setText(item.getLocation());
        holder.tvStudyRoomInfo.setText(item.getInfo());
        holder.tvStudyRoomCapacity.setText(item.getCapacity());
    }

    // Adapter 에 사용되는 데이터의 개수를 리턴
    @Override
    public int getItemCount(){
        return studyRoomDTOArrayList.size();
    }
}