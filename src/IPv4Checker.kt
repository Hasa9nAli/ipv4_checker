import entity.IPv4Cases
import utils.*
import utils.ValidationMessages.IS_NUMBER_FAIL
import utils.ValidationMessages.IS_NUMBER_SUCCESS
import utils.ValidationMessages.LEADING_ZERO_FAIL
import utils.ValidationMessages.LEADING_ZERO_SUCCESS
import utils.ValidationMessages.NUMERIC_RANGE_FAIL
import utils.ValidationMessages.NUMERIC_RANGE_SUCCESS
import utils.ValidationMessages.SLOT_LENGTH_FAIL
import utils.ValidationMessages.SLOT_LENGTH_SUCCESS
import utils.ValidationMessages.SLOT_SIZE_FAIL
import utils.ValidationMessages.SLOT_SIZE_SUCCESS


class IPv4Checker(private val logger: LoggerOperations) : LoggerOperations by logger {
    private var state = IPv4Cases()

    private fun updateState(iPv4Cases: IPv4Cases) {
        state = iPv4Cases
    }

    private fun checkValidate(ipv4: String) {
        val splitText = splitTextByDot(ipv4.trim())

        if (isLengthTextEqualFour(splitText.size)) {
            updateState(
                state.copy(
                    isSizeOfSlotsEqualFour = true,
                    allSuccessCases = state.allSuccessCases.addAndUpdate(ipv4 + SLOT_SIZE_SUCCESS)
                )
            )

            splitText.map {
                if (isLengthMoreThanOneAndStartWithZero(it)) {
                    updateState(
                        state.copy(
                            isLengthMoreThanOneAndNotStartWithZero = true,
                            allSuccessCases = state.allSuccessCases.addAndUpdate(it + LEADING_ZERO_SUCCESS)
                        )
                    )

                } else if (isLengthEqualOne(it)) {
                    updateState(
                        state.copy(
                            isLengthMoreThanOneAndNotStartWithZero = true,
                            allSuccessCases = state.allSuccessCases.addAndUpdate(it + LEADING_ZERO_SUCCESS)
                        )
                    )
                } else {
                    updateState(
                        state.copy(
                            isLengthMoreThanOneAndNotStartWithZero = false,
                            diagnosisErrors = state.diagnosisErrors.addAndUpdate(it + LEADING_ZERO_FAIL)
                        )
                    )
                }

                if (isLessThanThree(it)) {
                    updateState(
                        state.copy(
                            isLengthOfSlotLessThanThree = true,
                            allSuccessCases = state.allSuccessCases.addAndUpdate(it + SLOT_LENGTH_SUCCESS)
                        )
                    )

                } else {
                    updateState(
                        state.copy(
                            isLengthOfSlotLessThanThree = false,
                            diagnosisErrors = state.diagnosisErrors.addAndUpdate(it + SLOT_LENGTH_FAIL)
                        )
                    )
                }

                try {
                    if (isInRange255(it)) {
                        updateState(
                            state.copy(
                                isLessThan255 = true,
                                allSuccessCases = state.allSuccessCases.addAndUpdate(it + NUMERIC_RANGE_SUCCESS)
                            )
                        )
                    } else {
                        updateState(
                            state.copy(
                                isLessThan255 = false,
                                diagnosisErrors = state.diagnosisErrors.addAndUpdate(it + NUMERIC_RANGE_FAIL)
                            )
                        )
                    }

                    updateState(
                        state.copy(
                            isSlotNumber = true,
                            allSuccessCases = state.allSuccessCases.addAndUpdate(it + IS_NUMBER_SUCCESS)
                        )
                    )
                } catch (e: Exception) {

                    updateState(
                        state.copy(
                            isSlotNumber = false,
                            diagnosisErrors = state.diagnosisErrors.addAndUpdate(it + IS_NUMBER_FAIL)
                        )
                    )
                }
            }
        } else {

            updateState(
                state.copy(
                    isSlotNumber = false,
                    diagnosisErrors = state.diagnosisErrors.addAndUpdate(ipv4 + SLOT_SIZE_FAIL)
                )
            )
        }
    }

    fun printErrorCases() {
        state.diagnosisErrors.map {
            logger.log(it)
        }
    }

    fun printCorrectCase() {
        state.allSuccessCases.map {
            logger.log(it)
        }
    }

    fun isAddressValid(ipv4: String): Boolean {
        checkValidate(ipv4)
        return state.diagnosisErrors.isEmpty()
    }
}
