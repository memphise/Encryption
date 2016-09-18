package com.csdn.lhy.encryption;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{

    @BindView(R.id.btn_encode)
    Button btnEncode;
    @BindView(R.id.btn_decode)
    Button btnDecode;
    @BindView(R.id.et_Msg)
    EditText etMsg;
    @BindView(R.id.tv_base64)
    TextView tvBase64;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_encode, R.id.btn_decode})
    public void onClick(View view){
        switch(view.getId()){
            case R.id.btn_encode:
                if(!TextUtils.isEmpty(etMsg.getText())){
                    String base64Info = Base64.encodeToString(etMsg.getText().toString().getBytes(), Base64.DEFAULT);
                    tvBase64.setText(base64Info);
                }
                break;
            case R.id.btn_decode:
                if(!TextUtils.isEmpty(tvBase64.getText())){
                    byte[] decodeInfo = Base64.decode(tvBase64.getText().toString(), Base64.DEFAULT);
                    if(decodeInfo != null){
                        tvBase64.setText("反编译回："+new String(decodeInfo));
                    }
                }
                break;
        }
    }
}
