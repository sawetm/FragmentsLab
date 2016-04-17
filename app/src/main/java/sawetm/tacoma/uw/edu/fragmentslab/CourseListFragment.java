package sawetm.tacoma.uw.edu.fragmentslab;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sawetm.tacoma.uw.edu.fragmentslab.course.CourseContent;
//import sawetm.tacoma.uw.edu.fragmentslab.course.CourseContent.DummyItem;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnCourseListFragmentInteractionListener}
 * interface.
 */
public class CourseListFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_POSITION = "POSITION";
    // TODO: Customize parameters
    private int mColumnCount = 1;
//    @Override
//    public void onStart() {
//        super.onStart();
//        // During startup, check if there are arguments passed to the fragment.
//        // onStart is a good place to do this because the layout has already been
//        // applied to the fragment at this point so we can safely call the method
//        // below that sets the article text.
//        Bundle args = getArguments();
//        if (args != null) {
//            // Set article based on argument passed in
//            updateCourseItemView(args.getInt(ARG_POSITION));
//        } else if (mColumnCount != -1) {
//            // Set article based on saved instance state defined during onCreateView
//            updateCourseItemView(mColumnCount);
//        }
//
//    }
//    public void updateCourseItemView(int pos) {
//        TextView courseIdTextView = (TextView) getActivity().findViewById(R.id.coorse_detail_id);
//        courseIdTextView.setText((CharSequence) CourseContent.ITEMS.get(pos).id);
//        TextView courseTitleTextView = (TextView) getActivity().findViewById(R.id.coorse_detail_title);
//        courseTitleTextView.setText((CharSequence) CourseContent.ITEMS.get(pos).title);
//        TextView courseShortDescTextView = (TextView) getActivity().findViewById(R.id.coorse_detail_description);
//        courseShortDescTextView.setText((CharSequence) CourseContent.ITEMS.get(pos).description);
//
//    }
        private OnCourseListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CourseListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static CourseListFragment newInstance(int columnCount) {
        CourseListFragment fragment = new CourseListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setContentView(R.layout.activity_course);
//
//        if (findViewById(R.id.fragment_container)!= null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.fragment_container, new CourseListFragment())
//                    .commit();
//
//        }


        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyCourseRecyclerViewAdapter(CourseContent.ITEMS, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnCourseListFragmentInteractionListener) {
            mListener = (OnCourseListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnCourseListFragmentInteractionListener {
        void OnCourseListFragmentInteractionListener(int position);
    }
}
