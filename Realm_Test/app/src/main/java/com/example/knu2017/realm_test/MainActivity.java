package com.example.knu2017.realm_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.knu2017.realm_test.Adapter.RealmAdapter;
import com.example.knu2017.realm_test.Model.TestModel;

import java.util.List;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.btnRefresh)
    Button btnRefresh;

    RecyclerView.LayoutManager layoutManager;
    RealmAdapter adapter;
    List<TestModel> homeList;

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: 2018-01-06 Butterknife init & view inflations
        ButterKnife.bind(this);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        realm = Realm.getDefaultInstance();

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm.executeTransactionAsync(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        TestModel testModel = realm.createObject(TestModel.class);
                        testModel.setUserUUID(UUID.randomUUID().toString());
                        testModel.setName("hello world");
                        testModel.setAge(20);
                    }
                }, new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(MainActivity.this, "DB Save Successeeeesd", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
