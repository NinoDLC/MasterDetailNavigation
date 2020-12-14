package fr.delcey.masterdetailnavigation

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.list_fragment.*

class ListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        CurrentPropertyIdRepo.getCurrentPropertyIdLiveData().observe(viewLifecycleOwner) {
            val selectableItemBackground = TypedValue()

            requireContext().theme.resolveAttribute(android.R.attr.selectableItemBackground, selectableItemBackground, true)

            when (it) {
                "1" -> {
                    list_item_1.setBackgroundColor(Color.RED)
                    list_item_2.setBackgroundResource(selectableItemBackground.resourceId)
                    list_item_3.setBackgroundResource(selectableItemBackground.resourceId)
                }
                "2" -> {
                    list_item_1.setBackgroundResource(selectableItemBackground.resourceId)
                    list_item_2.setBackgroundColor(Color.RED)
                    list_item_3.setBackgroundResource(selectableItemBackground.resourceId)
                }
                "3" -> {
                    list_item_1.setBackgroundResource(selectableItemBackground.resourceId)
                    list_item_2.setBackgroundResource(selectableItemBackground.resourceId)
                    list_item_3.setBackgroundColor(Color.RED)
                }
            }
        }

        list_item_1.setOnClickListener {
            CurrentPropertyIdRepo.setCurrentPropertyId("1")

            if (!resources.getBoolean(R.bool.isTablet)) {
                Navigation.findNavController(view).navigate(ListFragmentDirections.actionListScreenToDetail())
            }
        }
        list_item_2.setOnClickListener {
            CurrentPropertyIdRepo.setCurrentPropertyId("2")

            if (!resources.getBoolean(R.bool.isTablet)) {
                Navigation.findNavController(view).navigate(ListFragmentDirections.actionListScreenToDetail())
            }
        }
        list_item_3.setOnClickListener {
            CurrentPropertyIdRepo.setCurrentPropertyId("3")

            if (!resources.getBoolean(R.bool.isTablet)) {
                Navigation.findNavController(view).navigate(ListFragmentDirections.actionListScreenToDetail())
            }
        }
    }
}