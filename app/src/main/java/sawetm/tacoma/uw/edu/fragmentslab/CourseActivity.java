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
    }

    @Override
    public void OnCourseListFragmentInteractionListener(int position) {
        // Capture the student fragment from the activity layout
        CourseDetailFragment courseItemFragment = (CourseDetailFragment)
                getSupportFragmentManager().findFragmentById(R.id.course_detail_fragment_id);

        if (courseItemFragment != null) {
            // If courseItem frag is available, we're in two-pane layout...

            // Call a method in the student fragment to update its content
            courseItemFragment.updateCourseItemView(position);

        } else {
            // If the frag is not available, we're in the one-pane layout and must swap frags...

            // Create fragment and give it an argument for the selected student
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back

         courseItemFragment = new CourseDetailFragment();
            Bundle args = new Bundle();
            args.putInt(CourseDetailFragment.ARG_POSITION, position);
            courseItemFragment.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.course_list_fragment_id, courseItemFragment)
                    .addToBackStack(null);

            // Commit the transaction
            transaction.commit();

        }

    }
}
