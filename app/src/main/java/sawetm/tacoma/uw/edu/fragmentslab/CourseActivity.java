package sawetm.tacoma.uw.edu.fragmentslab;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


    public class CourseActivity extends AppCompatActivity
            implements CourseListFragment.OnCourseListFragmentInteractionListener{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_course);
            if (findViewById(R.id.fragment_container)!= null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_container, new CourseListFragment())
                        .commit();

            }

//        if(savedInstanceState == null){
//            FragmentTransaction transaction = getSupportFragmentManager()
//                    .beginTransaction().add(R.id.course_list_id, new CourseListFragment());
//            transaction.commit();
//
//        }
        }

        @Override
        public void OnCourseListFragmentInteractionListener(int position) {
            CourseDetailFragment courseDetailFragment = (CourseDetailFragment)
                    getSupportFragmentManager().findFragmentById(R.id.course_detail_fragment_id);

            if (courseDetailFragment != null) {
                // If courseItem frag is available, we're in two-pane layout...

                // Call a method in the student fragment to update its content
                courseDetailFragment.updateCourseItemView(position);

            } else {

                courseDetailFragment = new CourseDetailFragment();
                Bundle args = new Bundle();
                args.putInt(CourseDetailFragment.ARG_POSITION, position);
                courseDetailFragment.setArguments(args);
                FragmentTransaction transaction = getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, courseDetailFragment)
                        .addToBackStack(null);

                // Commit the transaction
                transaction.commit();

            }
        }
    }
