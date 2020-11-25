package Adapter


import Model.User
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.jobmart.R

class UserAdapter (private var mContext: Context,
                   private var mUSer: List<User>,
                   private  var isFragment: Boolean = false) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {

        val view = LayoutInflater.from(mContext).inflate(R.layout.user_item_layout, parent,false)
        return UserAdapter.ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return mUSer.size
    }
    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        val user = mUSer[position]
        holder.EmailTextView.text = user.getEmail()
        holder.userTextView.text = user.getFname()
    }

    class ViewHolder (@NonNull itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var EmailTextView: TextView = itemView.findViewById(R.id.user_fullname_search)
        var userTextView: TextView = itemView.findViewById(R.id.user_name_search)
    }

}