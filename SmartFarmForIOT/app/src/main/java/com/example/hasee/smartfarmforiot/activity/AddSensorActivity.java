package com.example.hasee.smartfarmforiot.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hasee.smartfarmforiot.R;
import com.example.hasee.smartfarmforiot.base.BaseActivity;
import com.example.hasee.smartfarmforiot.util.UrlType;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.example.hasee.smartfarmforiot.util.HttpUtil.sendPost;

public class AddSensorActivity extends BaseActivity {


    @InjectView(R.id.sensorName)
    EditText sensorName;
    @InjectView(R.id.sensorAddress)
    EditText sensorAddress;
    @InjectView(R.id.connectAddress)
    EditText connectAddress;
    @InjectView(R.id.add_btn)
    Button addBtn;

    @Override
    protected void setContentView() throws UnsupportedEncodingException {
        setContentView(R.layout.activity_add_sensor);
        ButterKnife.inject(this);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()){
            case R.id.add_btn:
                add();
                break;
            default:
                break;
        }
    }

    private void add(){
        JSONObject object = new JSONObject();
        try {
            object.put("sensorName",sensorName.getText().toString());
            object.put("sensorAddress",sensorAddress.getText().toString());
            object.put("connectAddress",connectAddress.getText().toString());
            String params = String.valueOf(object);
            sendPost(UrlType.getUrl(UrlType.HOST, UrlType.ADDSENSOR), params, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String data = response.body().toString();
                    if(data.equals("1")){
                        showToast("添加成功");
                    }else{
                        showToast("添加失败");
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
