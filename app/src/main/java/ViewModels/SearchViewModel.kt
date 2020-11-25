package ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import

class SearchViewModel : ViewModel() {
    val selectedUser: MutableLiveData<ProfileUser> = MutableLiveData<ProfileUser>()
    val currentlyLoggedInUser: MutableLiveData<ProfileUser> = MutableLiveData<ProfileUser>()

    // when we do selectedUser.value we will get the User object that was passed in
    fun select(user : ProfileUser) {
        selectedUser.value = user
    }

    fun setCurrentUser(user: ProfileUser) {
        currentlyLoggedInUser.value = user
    }
