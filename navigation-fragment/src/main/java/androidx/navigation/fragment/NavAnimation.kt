package androidx.navigation.fragment

import android.os.Parcel
import android.os.Parcelable

/**
 * @param destinationId
 * @param anims [enterAnim,exitAnim,popEnterAnim,popExitAnim]
 */
data class NavAnimation(val destinationId: Int, val anims: IntArray):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.createIntArray()?: intArrayOf()
    ) {
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NavAnimation

        if (destinationId != other.destinationId) return false
        if (!anims.contentEquals(other.anims)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = destinationId
        result = 31 * result + anims.contentHashCode()
        return result
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(destinationId)
        parcel.writeIntArray(anims)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NavAnimation> {
        override fun createFromParcel(parcel: Parcel): NavAnimation {
            return NavAnimation(parcel)
        }

        override fun newArray(size: Int): Array<NavAnimation?> {
            return arrayOfNulls(size)
        }
    }
}

