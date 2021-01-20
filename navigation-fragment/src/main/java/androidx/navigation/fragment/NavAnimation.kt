package androidx.navigation.fragment

/**
 * @param destinationId
 * @param anims [enterAnim,exitAnim,popEnterAnim,popExitAnim]
 */
data class NavAnimation(val destinationId: Int, val anims: IntArray) {
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
}

