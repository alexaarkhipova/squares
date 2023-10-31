import android.os.Parcel
import android.os.Parcelable

data class SquareModel(val colorResId: Int, val number: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(), // backgroundResId
        parcel.readInt()  // number
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(colorResId)
        parcel.writeInt(number)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SquareModel> {
        override fun createFromParcel(parcel: Parcel): SquareModel {
            return SquareModel(parcel)
        }

        override fun newArray(size: Int): Array<SquareModel?> {
            return arrayOfNulls(size)
        }
    }
}




