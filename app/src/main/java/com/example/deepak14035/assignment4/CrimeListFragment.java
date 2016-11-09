package com.example.deepak14035.assignment4;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;
import java.util.UUID;

public class CrimeListFragment extends Fragment{
    RecyclerView mCrimeRecyclerView;
    static public CrimeAdapter mAdapter;
    private static final int REQUEST_CRIME = 1;
    public static final String EXTRA_CRIME_ID = "crime_id";
    public UUID updatedUUID;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_crime_list_fragment , container, false);
        mCrimeRecyclerView = (RecyclerView) view.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

// User touched the dialog's negative button


private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTitleTextView;
        private TextView mDateTextView;
        Crime mCrime;
        private CheckBox mSolvedCheckBox;
        public CrimeHolder(View itemView){
            super(itemView);
            mTitleTextView = (TextView)itemView.findViewById(R.id.list_item_crime_title_text_view);
            mDateTextView = (TextView)itemView.findViewById(R.id.list_item_crime_date_text_view);
            mSolvedCheckBox =(CheckBox)itemView.findViewById(R.id.list_item_crime_solved_text_view);
            mTitleTextView.setOnClickListener(this);
            mDateTextView.setOnClickListener(this);
        }

        void bindCrime(Crime crime){
            mCrime=crime;
            mTitleTextView.setText(mCrime.getTitle());
            mDateTextView.setText(mCrime.getDate());
            mSolvedCheckBox.setChecked(mCrime.getSolved());
        }

        @Override
        public void onClick(View v){
            Log.d("a", "here"+mCrime.getId());
            Intent intent = CrimePagerActivity.newIntent(getActivity(), mCrime.getId());
            //startActivityForResult(intent, REQUEST_CRIME);
            startActivity(intent);

        }
    }

    private void updateUI(){
        CrimeLab cl = CrimeLab.get(getActivity());
        List<Crime> crimes = cl.getCrimes();

        if (mAdapter == null) {
            mAdapter=new CrimeAdapter(crimes);
            mCrimeRecyclerView.setAdapter(mAdapter);
        }
        else{
            mAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==REQUEST_CRIME){
            Log.d("a", "asd");
            updatedUUID = (UUID)data.getSerializableExtra(EXTRA_CRIME_ID);
        }

    }

    public class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{
        public List<Crime> mCrimes;
        public CrimeAdapter(List<Crime> crime){
            mCrimes=crime;
        }



        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int ViewType){
            LayoutInflater lf = LayoutInflater.from(getActivity());
            //parent.setBackgroundColor(new Color("Green"));
            View view = lf.inflate(R.layout.list_item_crime, parent, false);

            return new CrimeHolder(view);
        }

        @Override
        public void onBindViewHolder(CrimeHolder ch, int position){
            ch.itemView.setBackgroundColor(position % 2 == 0 ?
                    Color.rgb(128, 128, 128) : Color.rgb(63, 173, 168));
            Crime crime = mCrimes.get(position);
            ch.bindCrime(crime);
        }



        @Override
        public int getItemCount(){
            return mCrimes.size();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }
}
