package ViewModels

import Model.Profile
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel: ViewModel() {
    val selectedUser: MutableLiveData<Profile> = MutableLiveData<Profile>()
    val currentlyLoggedInUser: MutableLiveData<Profile> = MutableLiveData<Profile>()

    fun select(user : Profile){
        selectedUser.value = user
    }

    fun setCurrentUser(user: Profile)
    {
        currentlyLoggedInUser.value = user
    }

}