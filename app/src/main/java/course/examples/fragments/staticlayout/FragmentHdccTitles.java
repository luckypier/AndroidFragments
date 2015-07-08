package course.examples.fragments.staticlayout;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by precuay on 6/28/15.
 *
 * IMPORTANT extends from ListFragment
 * 1.Set up a listener for title selected
 * 2.Fill the xml list with TextView - mTitlesDataArray and if it's neccesary, sets item selected
 * 3.Declares interface for activity implementation (activity has know of FragmentHdccQuotes)
 * 4.ListFragment's onListItemClick method call activity implementation
 *
 */
public class FragmentHdccTitles extends ListFragment {

    private static final String TAG = "FragmentHdccTitles";

    //declare an interface
    private TitleSelectionListener mListener = null;

    //>>> Added for FragmentStaticConfigLayout
    private int mTitleCurrIdx = -1;
    //<<< Added for FragmentStaticConfigLayout

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            //Fill/assign the interface
            mListener = (TitleSelectionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnArticleSelectedListener");
        }
    }

    //>>> Added for FragmentStaticConfigLayout
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);

    }
    //<<< Added for FragmentStaticConfigLayout

    @Override
    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);

        //Fill the xml list with TextView - mTitlesDataArray
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        setListAdapter(new ArrayAdapter<String>(
                getActivity(),  //interesting, get the activity instance
                R.layout.fragment_statichdcc_title,
                ActivityStaticHdcc.mTitlesDataArray)
        );

        //>>> Added for FragmentStaticConfigLayout
        //if it's neccesary, sets item selected
        if (-1 != mTitleCurrIdx)
            getListView().setItemChecked(mTitleCurrIdx, true);
        //<<< Added for FragmentStaticConfigLayout

    }

    //Declares interface for activity implementation (activity has know of FragmentHdccQuotes)
    public interface TitleSelectionListener {
        public void onTitleSelection(int index);
    }

    //ListFragment's onListItemClick method call activity implementation
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        /*getListView().setItemChecked(position, true);
        mListener.onTitleSelection(position);*/

        //>>> Added for FragmentStaticConfigLayout
        if (position != mTitleCurrIdx) {
            mListener.onTitleSelection(position);
            mTitleCurrIdx = position;
        }

        l.setItemChecked(mTitleCurrIdx, true);
        //<<< Added for FragmentStaticConfigLayout
    }

}