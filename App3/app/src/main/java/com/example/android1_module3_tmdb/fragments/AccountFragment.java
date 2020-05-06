package com.example.android1_module3_tmdb.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.android1_module3_tmdb.R;
import com.example.android1_module3_tmdb.api.APIService;
import com.example.android1_module3_tmdb.api.RetrofitConfiguration;
import com.example.android1_module3_tmdb.models.DeleteSessionIdRequest;
import com.example.android1_module3_tmdb.models.DeleteSessionIdResponse;
import com.example.android1_module3_tmdb.models.GetCreateRequestTokenResponse;
import com.example.android1_module3_tmdb.models.PostCreateSessionRequest;
import com.example.android1_module3_tmdb.models.PostCreateSessionResponse;
import com.example.android1_module3_tmdb.models.PostCreateSessionWithLoginRequest;
import com.example.android1_module3_tmdb.models.PostCreateSessionWithLoginResponse;
import com.example.android1_module3_tmdb.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tv_sign_in)
    TextView tvSignIn;
    APIService service;
    @BindView(R.id.ll_spinkit)
    LinearLayout llSpinkit;
    @BindView(R.id.ll_sign_in)
    LinearLayout llSignIn;
    @BindView(R.id.tv_sign_out)
    TextView tvSignOut;
    @BindView(R.id.ll_sign_out)
    LinearLayout llSignOut;

    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        ButterKnife.bind(this, view);
        service = RetrofitConfiguration.getInstance().create(APIService.class);
        return view;
    }

    @OnClick(R.id.tv_sign_in)
    public void onViewClicked(View v) {
        switch (v.getId()){
            case R.id.tv_sign_in:
                createRequestToken();
                break;
            case R.id.tv_sign_out:
                break;
        }

    }

    private void createRequestToken() {

        Call<GetCreateRequestTokenResponse> call = service.getCreateRequestToken();
        call.enqueue(new Callback<GetCreateRequestTokenResponse>() {
            @Override
            public void onResponse(Call<GetCreateRequestTokenResponse> call, Response<GetCreateRequestTokenResponse> response) {
                if (response.code() == 200) {
                    String requestToken = response.body().getRequest_token();
                    createSessionWithLogin(requestToken);
                }
            }

            @Override
            public void onFailure(Call<GetCreateRequestTokenResponse> call, Throwable t) {

            }
        });
    }

    private void createSessionWithLogin(String requestToken) {
        PostCreateSessionWithLoginRequest body = new PostCreateSessionWithLoginRequest();
        body.setUsername(etUsername.getText().toString());
        body.setPassword(etPassword.getText().toString());
        body.setRequest_token(requestToken);
        Call<PostCreateSessionWithLoginResponse> call = service.postCreateSessionWithLogin(body);
        call.enqueue(new Callback<PostCreateSessionWithLoginResponse>() {
            @Override
            public void onResponse(Call<PostCreateSessionWithLoginResponse> call, Response<PostCreateSessionWithLoginResponse> response) {
                if (response.code() == 200) {
                    createSession(requestToken);
                }
            }

            @Override
            public void onFailure(Call<PostCreateSessionWithLoginResponse> call, Throwable t) {

            }
        });
    }

    private void createSession(String requestToken) {
        PostCreateSessionRequest body = new PostCreateSessionRequest();
        body.setRequest_token(requestToken);
        Call<PostCreateSessionResponse> call = service.postCreateSession(body);
        call.enqueue(new Callback<PostCreateSessionResponse>() {
            @Override
            public void onResponse(Call<PostCreateSessionResponse> call, Response<PostCreateSessionResponse> response) {
                if (response.code() == 200) {
                    Log.d("sessionid", "onResponse: session_id:"+response.body().getSession_id());
                }
            }

            @Override
            public void onFailure(Call<PostCreateSessionResponse> call, Throwable t) {

            }
        });
    }

    private void signOut(){
        llSpinkit.setVisibility(View.VISIBLE);
        DeleteSessionIdRequest body = new DeleteSessionIdRequest();
        body.setSession_id(Utils.getSessionId(getContext()));
        Call<DeleteSessionIdResponse> call = service.deleteSessionId(body);
        call.enqueue(new Callback<DeleteSessionIdResponse>() {
            @Override
            public void onResponse(Call<DeleteSessionIdResponse> call, Response<DeleteSessionIdResponse> response) {
                if (response.code() == 200) {
                    Utils.saveSessionId(null,getContext());
                }
            }

            @Override
            public void onFailure(Call<DeleteSessionIdResponse> call, Throwable t) {

            }
        });
    }
}
