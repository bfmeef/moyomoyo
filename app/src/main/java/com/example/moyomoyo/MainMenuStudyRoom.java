package com.example.moyomoyo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moyomoyo.studyrooms.StudyRoomDTO;
import com.example.moyomoyo.studyrooms.StudyRoomListAdapter;

import java.util.ArrayList;


public class MainMenuStudyRoom extends Fragment {

    private RecyclerView recyclerView;
    private StudyRoomListAdapter adapter;
    private ArrayList<StudyRoomDTO> studyRoomDTOArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_main_menu_study_room,
                container, false);

        recyclerView = rootView.findViewById(R.id.list_study_room);
        studyRoomDTOArrayList = new ArrayList<>();

        adapter = new StudyRoomListAdapter(studyRoomDTOArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));


        return rootView;
    }
}