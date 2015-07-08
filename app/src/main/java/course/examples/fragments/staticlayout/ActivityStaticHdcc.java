package course.examples.fragments.staticlayout;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by precuay on 6/28/15.
 *
 * HDCC : Handle Device Configuration Change
 *
 * 1.inflates activity xml view
 * 2.links Fragment details/quotes xml tag
 * 3.populate java arrays with values
 * 4.implement title's fragment selection
 *
 */
public class ActivityStaticHdcc
        extends Activity
        implements FragmentHdccTitles.TitleSelectionListener {

    private static final String TAG = "ActivityStaticHdcc";
    private FragmentHdccQuotes mFragmentHdccQuotes;

    public static String[] mTitlesDataArray;
    public static String[] mQuotesDataArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //inflates activity xml view
        setContentView(R.layout.activity_statichdcc);

        //links Fragment xml tag
        mFragmentHdccQuotes =
                (FragmentHdccQuotes) getFragmentManager().findFragmentById(R.id.details);

        //populate java arrays with values
        mTitlesDataArray = getResources().getStringArray(R.array.Titles);
        mQuotesDataArray = getResources().getStringArray(R.array.Quotes);
    }

    //implement title's fragment selection
    @Override
    public void onTitleSelection(int index) {
        if (mFragmentHdccQuotes.getShownIndex() != index) {
            mFragmentHdccQuotes.showQuoteAtIndex(index);
        }
    }

}