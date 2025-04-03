package utils

object ValidationMessages {
    const val ENTER_THE_IPV4_ADDRESS = "please enter the ipv4 address : "
    const val SLOT_SIZE_SUCCESS = " -> Success: slots size should be 4 example(192.168.19.3)"
    const val SLOT_SIZE_FAIL = " -> Fail: slots size should be 4"
    const val LEADING_ZERO_SUCCESS = " -> Success: should not start with zero and exist more number after it"
    const val LEADING_ZERO_FAIL = " -> Fail: should not start with zero and exist more number after it"
    const val SLOT_LENGTH_SUCCESS = " -> Success: length of slot should be less than 3"
    const val SLOT_LENGTH_FAIL = " -> Fail: length of slot should be less than 3"
    const val NUMERIC_RANGE_SUCCESS = " -> Success: should be less than or equal 255 and not negative"
    const val NUMERIC_RANGE_FAIL = " -> Fail: should be less than or equal 255 and not negative"
    const val IS_NUMBER_SUCCESS = " -> Success: Slot is Number"
    const val IS_NUMBER_FAIL = " -> Fail: should be Number"
    const val ZERO = "0"
}