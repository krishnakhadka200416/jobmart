package Adapter

import Model.Profile
import ViewModels.SearchViewModel
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.jobmart.R


class ProfileAdapter(
        private var model: SearchViewModel,
        private var usercontext: Context,
        private var userlist: List<Profile>,
        private var Fragment: Boolean = false) : RecyclerView.Adapter<ProfileAdapter.ViewHolder>()
{
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

                val view = LayoutInflater.from(usercontext).inflate(R.layout.result_layout,parent,false)
                return ProfileAdapter.ViewHolder(view)
        }
        override fun getItemCount(): Int {
               return userlist.size
        }

        override fun onBindViewHolder(holder: ProfileAdapter.ViewHolder, position: Int) {
                val userobtainer = userlist[position]
                holder.Name.text = userobtainer.getFName() + " " +userobtainer.getLName()


               // Picasso.get().load(userobtainer.getProfileImageUrl()).placeholder(R.drawable.profile).into(holder.ProfilePicture)





                holder.itemView.setOnClickListener(View.OnClickListener {
                        Log.d("ProfileAdapter", "userobtainer:${userobtainer.toString()}")
                        Log.d("ProfileAdapter","context:$usercontext")
                        model.select(userobtainer)

                        val imm = usercontext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                        imm.hideSoftInputFromWindow(it.windowToken, 0)

                        it.findNavController().navigate(R.id.navigation_profile, null)

                })
        }
        class ViewHolder (@NonNull itemView: View):RecyclerView.ViewHolder(itemView)
        {
                val Name: TextView = itemView.findViewById(R.id.search_list_element_user_name)
                val ProfilePicture :ImageView = itemView.findViewById(R.id.search_list_element_image)
        }


}







