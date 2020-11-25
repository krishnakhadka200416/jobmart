package ViewModels

import Model.User
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChatViewModel: ViewModel(){
    val selectedUser: MutableLiveData<User> = MutableLiveData<User>()

    fun select(user: User)
    {
        selectedUser.value = user
    }
}