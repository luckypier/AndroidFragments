package course.examples.fragments.staticlayout;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by precuay on 6/28/15.
 *
 * IMPORTANT extends from Fragment
 * 1.Method to update the Quote text with a titleSelectedIndex
 * 2.inflate fragment_statichdcc_quote XML
 * 3.onActivityCreated set set the TextView
 * 4.After Configuration change, set the Quote text
 *
 */
public class FragmentHdccQuotes extends Fragment {

    private TextView mQuoteTextView = null;
    private int mQuoteCurrIdx = -1;
    //>>> Modified for FragmentStaticConfigLayout
    //private int mQuoteArrayLen;
    private int mQuoteArrayLen = 0;
    //<<< Modified for FragmentStaticConfigLayout

    private static final String TAG = "FragmentHdccQuotes";

    public int getShownIndex() {
        return mQuoteCurrIdx;
    }

    //Method to update the Quote text with a titleSelectedIndex
    public void showQuoteAtIndex(int titleSelectedIndex) {
        if (titleSelectedIndex < 0 || titleSelectedIndex >= mQuoteArrayLen)
            return;
        mQuoteCurrIdx = titleSelectedIndex;
        mQuoteTextView.setText(ActivityStaticHdcc.mQuotesDataArray[mQuoteCurrIdx]);
    }

    //>>> Added for FragmentStaticConfigLayout
    @Override
    public void onCreate(Bundle savedInstanceState) {

        Log.i(TAG, getClass().getSimpleName() + ":onCreate()");

        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
    //<<< Added for FragmentStaticConfigLayout

    //inflate fragment_statichdcc_quote XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(
                R.layout.fragment_statichdcc_quote,
                container,
                false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //onActivityCreated set set the TextView
        mQuoteTextView = (TextView) getActivity().findViewById(R.id.quoteView); //get the TextView by ID
        mQuoteArrayLen = ActivityStaticHdcc.mQuotesDataArray.length;

        //>>> Added for FragmentStaticConfigLayout
        //After Configuration change, set the Quote text
        showQuoteAtIndex(mQuoteCurrIdx);
        //<<< Added for FragmentStaticConfigLayout
    }

}