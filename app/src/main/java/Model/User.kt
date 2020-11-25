package Model

class User
{
    private var Email: String =""
    private var FName: String =""
    private var LName: String =""
    private var MName: String =""
    private var userID: String =""

    constructor()
    constructor(Email: String,FName: String,LName: String,MName: String,userID: String  )
    {
        this.Email = Email
        this.FName= FName
        this.LName = LName
        this.MName=MName
        this.userID=userID
    }
    fun getEmail(): String
    {
        return Email
    }

    fun setEmail(Email: String)
    {
        this.Email = Email
    }
    fun getFname(): String
    {
        return FName
    }

    fun setFname(FName: String)
    {
        this.FName = FName
    }

    fun getLName(): String
    {
        return LName
    }

    fun setLName(LName: String)
    {
        this.LName =LName
    }

    fun getMName(): String
    {
        return MName
    }

    fun setMName(MName: String)
    {
      this.MName = MName
    }
    fun getuserID(): String
    {
        return userID
    }
    fun setuserID(userID: String)
    {
        this.userID = userID
    }

}