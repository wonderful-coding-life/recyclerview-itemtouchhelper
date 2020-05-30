package com.example.itemtouchhelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieList.add("언더워터 - 2020.05.27");
        movieList.add("위대한 쇼맨 - 2020.05.21");
        movieList.add("프리즌 이스케이프 - 2020.05.06");
        movieList.add("그집 - 2020.05.27");
        movieList.add("카페 벨에포크 - 2020.05.20");
        movieList.add("미스비 헤이 비어 - 2020.05.27");
        movieList.add("아홉 스닝 - 2020.05.27");
        movieList.add("초미의 관심사 - 2020.05.27");
        movieList.add("더 플랫폼 - 2020.05.13");
        movieList.add("조조 래빗 - 2020.02.05");
        movieList.add("패왕별희 디 오리지널 - 2020.05.01");
        movieList.add("라이프 오브 파이 - 2018.04.12");
        movieList.add("톰보이 2020.05.14");
        movieList.add("지푸리가라도 잡고 싶은 짐승들 - 2020.02.19");
        movieList.add("킬러의 보디가드 무삭제 특별한 - 2020.05.20");
        movieList.add("날씨의 아이 - 2020.05.21");
        movieList.add("조금씩, 천천히 안녕 - 2020.05.27");
        movieList.add("나는 보리 - 2020.05.21");
        movieList.add("레미: 집 없는 아이 - 2020.05.28");
        movieList.add("루팡 3세: 더 퍼스트 - 2020.05.21");
        movieList.add("트롤: 월드 투어 2020.04.29");
        movieList.add("레이니 데이인 뉴욕 - 2020.05.06");
        movieList.add("설국열차 - 2020.08.01");

        RecyclerView movieListView = findViewById(R.id.movie_list);
        movieListView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        movieListView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        SimpleTextAdapter adapter = new SimpleTextAdapter(movieList);
        movieListView.setAdapter(adapter);

        // set item touch helper for dragging and swiping
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SimpleTextItemTouchHelperCallback(adapter));
        itemTouchHelper.attachToRecyclerView(movieListView);
        adapter.setItemTouchHelper(itemTouchHelper);
    }
}
