package Model

class Profile {
   
    private var Education: String =""
    private var Profession: String =""
    private var Interest: String =""
    private var Goal: String =""
   
    private var FName: String =""
    private var LName: String =""
  
    private var userID: String =""

    constructor()
    constructor(FName: String,LNAme:String,userID: String,Education: String,Profession: String,Interest: String,Goal: String  )
    {
       
        this.Education= Education
        this.Profession = Profession
        this.Interest=Interest
        this.Goal=Goal
        this.FName= FName
        this.LName = LName
        this.userID= userID
       
    }
    fun getFName(): String
    {
        return FName
    }
    fun setFName(FName: String)
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
    fun getuserID(): String
    {
        return userID
    }
    fun setuserID(userID: String)
    {
        this.userID = userID
    }
   
    fun getEducation(): String
    {
        return Education
    }

    fun setEducation(Education: String)
    {
        this.Education = Education
    }

    fun getProfession(): String
    {
        return Profession
    }

    fun setProfession(Profession: String)
    {
        this.Profession =Profession
    }

    fun getInterest(): String
    {
        return Interest
    }

    fun setInterest(Interest: String)
    {
        this.Interest = Interest
    }
    fun getGoal(): String
    {
        return Goal
    }
    fun setGoal(Goal: String)
    {
        this.Goal = Goal
    }



}