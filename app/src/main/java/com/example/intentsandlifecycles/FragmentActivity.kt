package com.example.intentsandlifecycles

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentActivity : Fragment() {

    // fragment lifecycle methods
    override fun onAttach(context: Context) {
        super.onAttach(context)

        Log.i("Fragment", "Fragment: onAttach method")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Fragment", "Fragment: onCreate method")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.i("Fragment", "Fragment: onCreateView method")
        return inflater.inflate(R.layout.activity_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("Fragment", "Fragment: onViewCreated method")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Fragment", "Fragment: onStart method")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Fragment", "Fragment: onResume method")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Fragment", "Fragment: onPause method")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Fragment", "Fragment: onStop method")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("Fragment", "Fragment: onDestroyView method")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Fragment", "Fragment: onDestroy method")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("Fragment", "Fragment: onDetach method")
    }
}