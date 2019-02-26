package bai.smartdevservice.mobiapps.model.data

import android.os.Parcel
import android.os.Parcelable

class ItemPlayer protected constructor(i: Parcel) : Parcelable {

    internal var idPlayer: String? = null
    internal var idTeam: String? = null
    internal var idSoccerXML: String? = null
    internal var idPlayerManager: String? = null
    internal var strNationality: String? = null
    internal var strPlayer: String? = null
    internal var strTeam: String? = null
    internal var strSport: String? = null
    internal var intSoccerXMLTeamID: String? = null
    internal var dateBorn: String? = null
    internal var dateSigned: String? = null
    internal var strSigning: String? = null
    internal var strWage: String? = null
    internal var strBirthLocation: String? = null
    internal var strDescriptionEN: String? = null
    internal var strDescriptionDE: String? = null
    internal var strDescriptionFR: String? = null
    internal var strDescriptionCN: String? = null
    internal var strDescriptionIT: String? = null
    internal var strDescriptionJP: String? = null
    internal var strDescriptionRU: String? = null
    internal var strDescriptionES: String? = null
    internal var strDescriptionPT: String? = null
    internal var strDescriptionSE: String? = null
    internal var strDescriptionNL: String? = null
    internal var strDescriptionHU: String? = null
    internal var strDescriptionNO: String? = null
    internal var strDescriptionIL: String? = null
    internal var strDescriptionPL: String? = null
    internal var strGender: String? = null
    internal var strPosition: String? = null
    internal var strCollege: String? = null
    internal var strFacebook: String? = null
    internal var strWebsite: String? = null
    internal var strTwitter: String? = null
    internal var strInstagram: String? = null
    internal var strYoutube: String? = null
    internal var strHeight: String? = null
    internal var strWeight: String? = null
    internal var intLoved: String? = null
    internal var strThumb: String? = null
    internal var strCutout: String? = null
    internal var strBanner: String? = null
    internal var strFanart1: String? = null
    internal var strFanart2: String? = null
    internal var strFanart3: String? = null
    internal var strFanart4: String? = null
    internal var strLocked: String? = null

    init {
        idPlayer = i.readString()
        idTeam = i.readString()
        idSoccerXML = i.readString()
        idPlayerManager = i.readString()
        strNationality = i.readString()
        strPlayer = i.readString()
        strTeam = i.readString()
        strSport = i.readString()
        intSoccerXMLTeamID = i.readString()
        dateBorn = i.readString()
        dateSigned = i.readString()
        strSigning = i.readString()
        strWage = i.readString()
        strBirthLocation = i.readString()
        strDescriptionEN = i.readString()
        strDescriptionDE = i.readString()
        strDescriptionFR = i.readString()
        strDescriptionCN = i.readString()
        strDescriptionIT = i.readString()
        strDescriptionJP = i.readString()
        strDescriptionRU = i.readString()
        strDescriptionES = i.readString()
        strDescriptionPT = i.readString()
        strDescriptionSE = i.readString()
        strDescriptionNL = i.readString()
        strDescriptionHU = i.readString()
        strDescriptionNO = i.readString()
        strDescriptionIL = i.readString()
        strDescriptionPL = i.readString()
        strGender = i.readString()
        strPosition = i.readString()
        strCollege = i.readString()
        strFacebook = i.readString()
        strWebsite = i.readString()
        strTwitter = i.readString()
        strInstagram = i.readString()
        strYoutube = i.readString()
        strHeight = i.readString()
        strWeight = i.readString()
        intLoved = i.readString()
        strThumb = i.readString()
        strCutout = i.readString()
        strBanner = i.readString()
        strFanart1 = i.readString()
        strFanart2 = i.readString()
        strFanart3 = i.readString()
        strFanart4 = i.readString()
        strLocked = i.readString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(idPlayer)
        parcel.writeString(idTeam)
        parcel.writeString(idSoccerXML)
        parcel.writeString(idPlayerManager)
        parcel.writeString(strNationality)
        parcel.writeString(strPlayer)
        parcel.writeString(strTeam)
        parcel.writeString(strSport)
        parcel.writeString(intSoccerXMLTeamID)
        parcel.writeString(dateBorn)
        parcel.writeString(dateSigned)
        parcel.writeString(strSigning)
        parcel.writeString(strWage)
        parcel.writeString(strBirthLocation)
        parcel.writeString(strDescriptionEN)
        parcel.writeString(strDescriptionDE)
        parcel.writeString(strDescriptionFR)
        parcel.writeString(strDescriptionCN)
        parcel.writeString(strDescriptionIT)
        parcel.writeString(strDescriptionJP)
        parcel.writeString(strDescriptionRU)
        parcel.writeString(strDescriptionES)
        parcel.writeString(strDescriptionPT)
        parcel.writeString(strDescriptionSE)
        parcel.writeString(strDescriptionNL)
        parcel.writeString(strDescriptionHU)
        parcel.writeString(strDescriptionNO)
        parcel.writeString(strDescriptionIL)
        parcel.writeString(strDescriptionPL)
        parcel.writeString(strGender)
        parcel.writeString(strPosition)
        parcel.writeString(strCollege)
        parcel.writeString(strFacebook)
        parcel.writeString(strWebsite)
        parcel.writeString(strTwitter)
        parcel.writeString(strInstagram)
        parcel.writeString(strYoutube)
        parcel.writeString(strHeight)
        parcel.writeString(strWeight)
        parcel.writeString(intLoved)
        parcel.writeString(strThumb)
        parcel.writeString(strCutout)
        parcel.writeString(strBanner)
        parcel.writeString(strFanart1)
        parcel.writeString(strFanart2)
        parcel.writeString(strFanart3)
        parcel.writeString(strFanart4)
        parcel.writeString(strLocked)
    }

    companion object CREATOR : Parcelable.Creator<ItemPlayer> {
        override fun createFromParcel(parcel: Parcel): ItemPlayer {
            return ItemPlayer(parcel)
        }

        override fun newArray(size: Int): Array<ItemPlayer?> {
            return arrayOfNulls(size)
        }
    }
}
