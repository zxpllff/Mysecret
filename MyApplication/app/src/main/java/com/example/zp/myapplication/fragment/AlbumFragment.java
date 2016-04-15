package com.example.zp.myapplication.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.zp.myapplication.R;
import com.squareup.picasso.Picasso;

/**
 * Created by ZHANGPING129 on 2016-04-07.
 */
public class AlbumFragment extends BaseFragment {
    private RecyclerView mRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.fragment_album,null);
        return mView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(!isCreated){
            isCreated=true;
            init();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void init(){
        mRecyclerView=(RecyclerView)mView.findViewById(R.id.album_recycleview);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(new AlbumAdapter(getActivity()));
    }


    private class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder >{

        private Context mContext;

        public AlbumAdapter(Context context){
            mContext=context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v=LayoutInflater.from(mContext).inflate(R.layout.item_album_menu,null);
            ViewHolder vh=new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            if(holder!=null){
            //    Picasso.with(getActivity()).load("").into(holder.mImageView);
            }
        }

        @Override
        public int getItemCount() {
            return 100;
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            public ImageView mImageView;
            public ViewHolder(View itemView) {
                super(itemView);
                mImageView=(ImageView)itemView.findViewById(R.id.album_img);
            }

        }
    }
}
