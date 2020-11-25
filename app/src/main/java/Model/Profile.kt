package Model

class Profile
{
    private var Email: String =""
    private var FName: String =""
    private var LName: String =""
    private var MName: String =""
    private var usersID: String =""

    constructor()

    constructor(Email: String, FName: String, LName: String, MName: String, usersID: String)
    {
        this.Email = Email
        this.FName = FName
        this.LName = LName
        this.MName = MName
        this.usersID = usersID
    }

    fun getEmail(): String{
        return Email
    }


    fun getFname(): String{
        return FName
    }

    fun getMName(): String{
        return MName
    }

    fun getLName(): String{
        return LName
    }
    fun getusersID(): String{
        return usersID
    }

    fun setEmail(Email: String) {
        this.Email = Email
    }
    fun setFname( FName: String) {
        this.FName = FName
    }
    fun setMName( MName: String) {
        this.MName = MName
    }
    fun setLName( LName: String) {
        this.LName = LName
    }

    fun getEducation(): String{
        return
    }

    fun setLName( LName: String) {
        this.LName = LName
    }

    fun setusersID( usersID: String) {
        this.usersID = usersID
    }

}