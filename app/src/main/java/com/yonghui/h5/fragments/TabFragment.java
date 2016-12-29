package com.yonghui.h5.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.yonghui.h5.androidrnsample.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TabFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private View mFragmentView;
    private LinearLayout placeOrder;
    private LinearLayout showOrders;
    private LinearLayout showChart;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TabFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TabFragment newInstance(String param1, String param2) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentView = inflater.inflate(R.layout.fragment_tab, container, false);
        initBtns();
        return mFragmentView;
    }

    private void initBtns() {
        TabFragment that = this;
        placeOrder = (LinearLayout) mFragmentView.findViewById(R.id.placeOrder);
        showOrders = (LinearLayout) mFragmentView.findViewById(R.id.showOrders);
        showChart = (LinearLayout) mFragmentView.findViewById(R.id.showChart);
        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                that.onButtonPressed(0);
            }
        });
        showOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                that.onButtonPressed(1);
            }
        });
        showChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                that.onButtonPressed(2);
            }
        });
        that.onButtonPressed(0);
    }

    public void activeBtn(int index) {
        switch (index) {
            case 0:
                placeOrder.setSelected(true);
                showOrders.setSelected(false);
                showChart.setSelected(false);
                break;
            case 1:
                placeOrder.setSelected(false);
                showOrders.setSelected(true);
                showChart.setSelected(false);
                break;
            case 2:
                placeOrder.setSelected(false);
                showOrders.setSelected(false);
                showChart.setSelected(true);
                break;
        }
    }

    public void onButtonPressed(int index) {
        if (mListener != null) {
            mListener.onTabFragmentInteraction(index);
            activeBtn(index);
        }
    }

    @Override
    public void onAttach(Activity context) {
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onTabFragmentInteraction(int tabIndex);
    }
}
