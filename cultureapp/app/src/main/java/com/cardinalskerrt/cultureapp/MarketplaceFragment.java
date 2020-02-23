package com.cardinalskerrt.cultureapp;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MarketplaceFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    RecyclerView marketRecycler;
    RecyclerAdapter marketRecyclerAdapter;
    HorizontalScrollView adScroll;

    ArrayList<CardModel> cardModels = new ArrayList<>();
    DummyAccount dummy;
    ArrayList<DummyAccount> dummyAccounts;

    public MarketplaceFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static MarketplaceFragment newInstance() {
        MarketplaceFragment fragment = new MarketplaceFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //marketplace
        marketRecycler = getActivity().findViewById(R.id.marketRecycler);
        adScroll = getActivity().findViewById(R.id.adScroll);
        dummy = new DummyAccount("",1,new int[1],new String[1],"");
        dummyAccounts = dummy.getDummyAccounts();

        for(int i=0;i<dummyAccounts.size();i++){
            for(int j=0;j<3;j++){
                CardModel cardModel = new CardModel(dummyAccounts.get(i).artistName, dummyAccounts.get(i).artistArtString[j]
                        , dummyAccounts.get(i).artistArt[j], dummyAccounts.get(i).profilePicID, 24000);
                cardModels.add(cardModel);
            }
        }

        marketRecyclerAdapter = new RecyclerAdapter(getActivity().getApplicationContext(), cardModels);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext());
        llm.setOrientation(RecyclerView.VERTICAL);
        marketRecycler.setLayoutManager(llm);
        marketRecycler.setAdapter(marketRecyclerAdapter);

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(5000);
                } catch (InterruptedException e){}
                if(adScroll.getChildAt(0).getRight()
                        <= (adScroll.getWidth() + adScroll.getScrollX())){
                    adScroll.fullScroll(View.FOCUS_LEFT);
                } else {
                    adScroll.smoothScrollTo(adScroll.getScrollX()+800,0);
                }
                run();
            }
        });

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_marketplace, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
        private String pieceName;
        private String itemPrice;

        private int imgID;
        private int profPicID;

        private double price;

        CardModel(String artistName, String pieceName, int imgID, int profPicID, double price){
            this.artistName = artistName;
            this.pieceName = pieceName;
            this.imgID = imgID;
            this.profPicID = profPicID;
            this.price = price;

            this.itemPrice = "P"+(int)this.price;
        }

        public int getProfPicID() {
            return profPicID;
        }

        public String getArtistName() {
            return artistName;
        }

        public String getPieceName() {
            return pieceName;
        }

        public String getItemPrice() {
            return "P"+(int)this.price;
        }

        public int getImgID() {
            return imgID;
        }


    }
    private static class CardViewHolder extends RecyclerView.ViewHolder{

        CardView marketCard;
        ImageButton marketImageBtn;
        TextView marketItemPrice;
        TextView marketItemName;
        TextView marketArtistName;
        ImageView marketArtistProfPic;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            marketCard = itemView.findViewById(R.id.marketMainCard);
            marketImageBtn = itemView.findViewById(R.id.marketImageBtn);
            marketArtistName = itemView.findViewById(R.id.marketArtistName);
            marketItemName = itemView.findViewById(R.id.marketPieceName);
            marketItemPrice = itemView.findViewById(R.id.marketPrice);
            marketArtistProfPic = itemView.findViewById(R.id.marketArtistProfilePic);

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
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.marketplace_row, parent, false);
            return new CardViewHolder(view);
        }

        public void onBindViewHolder(@NonNull final CardViewHolder holder, int position) {
            holder.marketItemPrice.setText(cardModels.get(position).getItemPrice());
            holder.marketItemName.setText(cardModels.get(position).getPieceName());
            holder.marketImageBtn.setImageResource(cardModels.get(position).imgID);
            holder.marketArtistName.setText(cardModels.get(position).getArtistName());
            holder.marketArtistProfPic.setImageResource(cardModels.get(position).profPicID);

            holder.marketCard.setOnClickListener(new View.OnClickListener() {
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
