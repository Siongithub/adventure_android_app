package team12.cs4850.com.adventurecreator;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EventListActivity extends MyBaseActivity {

    private TextView adventureLabel;

    private RecyclerView eventRecyclerView;
    private ZEventAdapter zEventAdapter;
    //private ArrayList<ZEvent> eventList = new ArrayList<>();

//    private Query query;
//    private ValueEventListener myQueryListener;

    private static final String TAG = "EventListPage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adventureLabel = findViewById(R.id.eventsLabel);
        eventRecyclerView = findViewById(R.id.mEventsRecycler);

        eventRecyclerView.setHasFixedSize(true);
        LinearLayoutManager myLayoutMgr = new LinearLayoutManager(this);
//        myLayoutMgr.setReverseLayout(true);
//        myLayoutMgr.setStackFromEnd(true);
        eventRecyclerView.setLayoutManager(myLayoutMgr);

        adventureLabel.setText(currAdventure.adventureName);

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_event_list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_signout:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        if (isSignedIn()) {
//            FirebaseUser user = auth.getCurrentUser();
//            tvLoggedInAs.setText(getString(R.string.LoggedInAs) + user.getDisplayName());
//
            attachRecyclerViewAdapter();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    public void btnClick(View view) {
//        Intent editAdventureIntent;
//        switch (view.getId()) {
//            case R.id.btnNew:
//                currAdventure = null;
//                editAdventureIntent = new Intent(EventListActivity.this, EditOrCreateAdventureActivity.class);
//                //editAdventureIntent.putExtra("isNew", true);
//                isNew = true;
//                startActivity(editAdventureIntent);
//                break;
//            case R.id.btnEdit:
//
//                if (zAdventureAdapter.selected_position != RecyclerView.NO_POSITION) {
//                    currAdventure = adventureList.get(zAdventureAdapter.selected_position);
//                    editAdventureIntent = new Intent(EventListActivity.this, EditOrCreateAdventureActivity.class);
//                    //editAdventureIntent.putExtra("isNew", false);
//                    isNew = false;
//                    startActivity(editAdventureIntent);
//                }
//                else {
//                    //Snackbar.make(view, getResources().getString(R.string.NoAdventureSelected), Snackbar.LENGTH_SHORT)
//                    //        .setAction("Action", null).show();
//                    Toast.makeText(this, getResources().getString(R.string.NoAdventureSelected), Toast.LENGTH_SHORT).show();
//                }
//                break;
//            case R.id.btnDelete:
//                if (zAdventureAdapter.selected_position != RecyclerView.NO_POSITION) {
//                    currAdventure = adventureList.get(zAdventureAdapter.selected_position);
//
//                    android.app.AlertDialog.Builder adb = new android.app.AlertDialog.Builder(this)
//                            .setTitle(getString(R.string.DeleteAdventure))
//                            .setMessage(getString(R.string.AreYouSure))
//                            .setCancelable(true)
//                            .setNegativeButton(getString(android.R.string.cancel), null)
//                            .setPositiveButton(getString(android.R.string.yes), new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    String adventureKey = currAdventure.adventureKey;
//                                    mDatabase.child("adventures").child(adventureKey).removeValue();
//                                    mDatabase.child("users").child(auth.getUid()).child("myAdventures").child(adventureKey).removeValue();
//
//                                }
//                    });
//                    android.app.AlertDialog confirmDialog = adb.create();
//                    confirmDialog.show();
//                }
//                else {
//                    //Snackbar.make(view, getResources().getString(R.string.NoAdventureSelected), Snackbar.LENGTH_SHORT)
//                    //        .setAction("Action", null).show();
//                    Toast.makeText(this, getResources().getString(R.string.NoAdventureSelected), Toast.LENGTH_SHORT).show();
//                }
//
//                break;
//        }
    }

    private void attachRecyclerViewAdapter() {


//        if (myQueryListener != null) {
//            query.removeEventListener(myQueryListener);
//        }
//
//        query = mDatabase.child("adventures").orderByChild("userid").equalTo(auth.getUid());
//
        zEventAdapter = new ZEventAdapter(currAdventure.events);
        eventRecyclerView.setAdapter(zEventAdapter);
//
//        myQueryListener = query.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                //Toast.makeText(getBaseContext(), "calling onDataChange", Toast.LENGTH_SHORT).show();
//                adventureList = new ArrayList<>();
//                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                    ZAdventure zAdventure = postSnapshot.getValue(ZAdventure.class);
//                    adventureList.add(zAdventure);
//
//                    zAdventureAdapter.updateList(adventureList);
//                    //mEmptyListMessage.setText(getResources().getString(R.string.no_items));
//                    //mEmptyListMessage.setVisibility(!dataSnapshot.hasChildren() ? View.VISIBLE : View.GONE);
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                // Getting Post failed, log a message
//                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//                // ...
//            }
//        });
    }



}

