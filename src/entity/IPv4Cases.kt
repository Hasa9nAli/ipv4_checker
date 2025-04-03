package entity
data class IPv4Cases(
    val isSizeOfSlotsEqualFour: Boolean = false,
    val isLessThan255: Boolean = false,
    val isLengthMoreThanOneAndNotStartWithZero: Boolean = false,
    val isLengthOfSlotLessThanThree: Boolean = false,
    val isSlotNotInt: Boolean = false,
    val isSlotNumber: Boolean = false,
    val isNotBeNegative: Boolean = false,
    val isSlotSizeEqualFour: Boolean = false,
    val diagnosisErrors: List<String> = emptyList(),
    val allSuccessCases: List<String> = emptyList()
)