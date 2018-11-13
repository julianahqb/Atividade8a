package com.example.professor.atividade8a;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ButtonFragment.OnChangeColorListener} interface
 * to handle interaction events.
 */
public class ButtonFragment extends Fragment implements View.OnClickListener {

    private OnChangeColorListener listener;

    public ButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_button, container, false);
        Button btnBlack = (Button) view.findViewById(R.id.btnBlack);
        Button btnBlue = (Button) view.findViewById(R.id.btnBlue);
        Button btnGreen = (Button) view.findViewById(R.id.btnGreen);
        Button btnRed = (Button) view.findViewById(R.id.btnRed);
        Button btnYellow = (Button) view.findViewById(R.id.btnYellow);
        btnBlack.setOnClickListener(this);
        btnBlue.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
        btnRed.setOnClickListener(this);
        btnYellow.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        int color;
        int id = v.getId();

        if (id == R.id.btnBlack) {
            color = Color.BLACK;
        } else if (id == R.id.btnBlue) {
            color = Color.BLUE;
        } else if (id == R.id.btnGreen) {
            color = Color.GREEN;
        } else if (id == R.id.btnRed) {
            color = Color.RED;
        } else if (id == R.id.btnYellow) {
            color = Color.YELLOW;
        } else {
            color = Color.WHITE;
        }
        if (listener != null) {
            listener.changeColor(color);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnChangeColorListener) {
            listener = (OnChangeColorListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnChangeColorListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnChangeColorListener {
        public void changeColor(int color);
    }
}
