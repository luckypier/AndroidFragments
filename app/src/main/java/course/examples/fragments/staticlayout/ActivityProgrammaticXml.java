package course.examples.fragments.staticlayout;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import course.examples.fragments.staticlayout.FragmentProgrammaticXmlTitles.ListSelectionListener;


/**
 * Created by precuay on 08/07/15.
 */
public class ActivityProgrammaticXml extends Activity implements ListSelectionListener {

    public static String[] mTitleArray;
    public static String[] mQuoteArray;

    // Get a reference to the QuotesFragment
    private final FragmentProgrammaticXmlQuotes mQuoteFragment = new FragmentProgrammaticXmlQuotes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("TAG", getClass().getSimpleName() + ":entered onCreate()");

        super.onCreate(savedInstanceState);

        // Get the string arrays with the titles and qutoes
        mTitleArray = getResources().getStringArray(R.array.Titles);
        mQuoteArray = getResources().getStringArray(R.array.Quotes);

        setContentView(R.layout.activity_programmaticxml);



        // Get a reference to the FragmentManager
        FragmentManager fragmentManager = getFragmentManager();

        // Begin a new FragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();

        // Add the TitleFragment
        fragmentTransaction.add(R.id.title_frame, new FragmentProgrammaticXmlTitles());

        // Add the QuoteFragment
        fragmentTransaction.add(R.id.quote_frame, mQuoteFragment);

        // Commit the FragmentTransaction
        fragmentTransaction.commit();
    }

    // Called when the user selects an item in the TitlesFragment
    @Override
    public void onListSelection(int index) {
        Log.i("TAG", getClass().getSimpleName() + ":entered onListSelection()");

        if (mQuoteFragment.getShownIndex() != index) {

            // Tell the QuoteFragment to show the quote string at position index
            mQuoteFragment.showQuoteAtIndex(index);
        }
    }

}
