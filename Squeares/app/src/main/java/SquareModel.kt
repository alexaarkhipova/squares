import android.os.Parcel
import android.os.Parcelable

class SquareModel() : Parcelable {
    constructor(parcel: Parcel) : this()

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        // Здесь можно сохранить какие-либо данные, если это необходимо
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




