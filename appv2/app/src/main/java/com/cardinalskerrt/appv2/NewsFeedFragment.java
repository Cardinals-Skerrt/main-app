package com.cardinalskerrt.appv2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsFeedFragment extends Fragment {

    private RecyclerAdapter newsRecyclerAdapter;
    private RecyclerView newsRecycler;
    private OnFragmentInteractionListener mListener;

    DummyAccount dummy;
    ArrayList<DummyAccount> dummyAccounts;
    ArrayList<CardModel> cardModels = new ArrayList<>();

    public NewsFeedFragment() {
        // Required empty public constructor
    }

    public static NewsFeedFragment newInstance(String param1, String param2) {
        NewsFeedFragment fragment = new NewsFeedFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dummy = new DummyAccount("",1,new int[3],new String[1],"");
        dummyAccounts = dummy.getDummyAccounts();
        newsRecycler = getActivity().findViewById(R.id.newsfeedRecycler);

        for(int i=0;i<dummyAccounts.size();i++){
            CardModel cardModel = new CardModel(dummyAccounts.get(i).artistName, "Hello!", "Yah yah yah yah yah skrrrrrrrrrrrrrrrt"
                    , "December 25, 2020", "Yo this is sick AF!", "Boring :/", dummyAccounts.get(i).artistArt[0]
                    , dummyAccounts.get(i).profilePicID, R.drawable.ic_mode_comment_black_24dp, R.drawable.ic_mode_comment_black_24dp, 5, 5);

            cardModels.add(cardModel);
        }

        newsRecyclerAdapter = new RecyclerAdapter(getActivity().getApplicationContext(), cardModels);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext());
        llm.setOrientation(RecyclerView.VERTICAL);
        newsRecycler.setLayoutManager(llm);
        newsRecycler.setAdapter(newsRecyclerAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news_feed, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    private static class CardModel{

        private String artistName;
        private String newsTitle;
        private String newsSubTitle;
        private String newsDate;
        private String newsComment1;
        private String newsComment2;
        private int newsLikeCounter;
        private int newsCommentCounter;

        private int itemPicID;
        private int profPicID;
        private int newsCommentProfPic1;
        private int newsCommentProfPic2;

        CardModel(String artistName, String newsTitle, String newsSubTitle, String newsDate
                , String newsComment1, String newsComment2, int itemPicID, int profPicID
                , int newsCommentProfPic1, int newsCommentProfPic2, int newsLikeCounter, int newsCommentCounter){
            this.artistName = artistName;
            this.newsTitle = newsTitle;
            this.newsSubTitle = newsSubTitle;
            this.newsDate = newsDate;
            this.newsComment1 = newsComment1;
            this.newsComment2 = newsComment2;
            this.itemPicID = itemPicID;
            this.profPicID = profPicID;
            this.newsCommentProfPic1 = newsCommentProfPic1;
            this.newsCommentProfPic2 = newsCommentProfPic2;
            this.newsLikeCounter = newsLikeCounter;
            this.newsCommentCounter =newsCommentCounter;
        }

        public int getNewsLikeCounter() {
            return newsLikeCounter;
        }

        public int getNewsCommentCounter() {
            return newsCommentCounter;
        }

        public String getArtistName() {
            return artistName;
        }

        public String getNewsTitle() {
            return newsTitle;
        }

        public String getNewsSubTitle() {
            return newsSubTitle;
        }

        public String getNewsDate() {
            return newsDate;
        }

        public String getNewsComment1() {
            return newsComment1;
        }

        public String getNewsComment2() {
            return newsComment2;
        }

        public int getItemPicID() {
            return itemPicID;
        }

        public int getProfPicID() {
            return profPicID;
        }

        public int getNewsCommentProfPic1() {
            return newsCommentProfPic1;
        }

        public int getNewsCommentProfPic2() {
            return newsCommentProfPic2;
        }

    }
    private class CardViewHolder extends RecyclerView.ViewHolder{

        CardView newsCard;
        ImageView newsImage;
        TextView newsArtistName;
        TextView newsTitle;
        TextView newsSubTitle;
        TextView newsLikeCounter;
        TextView newsCommentCounter;
        TextView newsDate;
        TextView comment1;
        TextView comment2;
        ImageView commenter1;
        ImageView commenter2;
        ImageView newsArtistProfPic;
        ImageButton newsLikeBtn;
        ImageButton newsCommentBtn;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            newsCard = itemView.findViewById(R.id.newsCard);
            newsImage = itemView.findViewById(R.id.newsImage);
            newsArtistName = itemView.findViewById(R.id.artistName);
            newsDate = itemView.findViewById(R.id.newsDate);
            newsLikeCounter = itemView.findViewById(R.id.newsLikeCounter);
            newsCommentCounter = itemView.findViewById(R.id.newsCommentCounter);
            newsTitle = itemView.findViewById(R.id.newsTitle);
            newsSubTitle = itemView.findViewById(R.id.newsShortMsg);
            comment1 = itemView.findViewById(R.id.newsComment1);
            comment2 = itemView.findViewById(R.id.newsComment2);
            commenter1 = itemView.findViewById(R.id.newsCommentProf1);
            commenter2 = itemView.findViewById(R.id.newsCommentProf2);
            newsArtistProfPic = itemView.findViewById(R.id.artistProfPic);
            newsLikeBtn = itemView.findViewById(R.id.newsLikeBtn);
            newsCommentBtn = itemView.findViewById(R.id.newsCmmntBtn);
        }
    }
    private class RecyclerAdapter extends RecyclerView.Adapter<CardViewHolder>{

        Context context;
        ArrayList<CardModel> cardModels;

        RecyclerAdapter(Context context, ArrayList<CardModel> cardModels){
            this.context = context;
            this.cardModels = cardModels;
        }

        @NonNull
        @Override
        public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.newsfeed_row, parent, false);
            return new CardViewHolder(view);
        }

        public void onBindViewHolder(@NonNull final CardViewHolder holder, int position) {

            holder.newsArtistName.setText(cardModels.get(position).getArtistName());
            holder.newsSubTitle.setText(cardModels.get(position).getNewsSubTitle());
            holder.newsDate.setText(cardModels.get(position).getNewsDate());
            holder.newsArtistProfPic.setImageResource(cardModels.get(position).getProfPicID());
            holder.newsTitle.setText(cardModels.get(position).getNewsTitle());
            holder.newsImage.setImageResource(cardModels.get(position).getItemPicID());
            holder.comment1.setText(cardModels.get(position).getNewsComment1());
            holder.comment2.setText(cardModels.get(position).getNewsComment2());
            holder.commenter1.setImageResource(cardModels.get(position).getNewsCommentProfPic1());
            holder.commenter2.setImageResource(cardModels.get(position).getNewsCommentProfPic2());

            holder.newsLikeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Animation bounce = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.bounce);
                    holder.newsLikeBtn.startAnimation(bounce);
                }
            });

            holder.newsCommentBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        @Override
        public int getItemCount() {
            return cardModels.size();
        }
    }
}
