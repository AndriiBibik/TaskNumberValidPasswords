package task.number.valid.passwords.passwords_validation

class PasswordValidator() {

    companion object {

        fun isValid(lineOfPasswordWithConditions: LineOfPasswordWithConditions): Boolean {

            val characterToCheck = lineOfPasswordWithConditions.getCharacterFromConditions()
            val minNumberCharacters = lineOfPasswordWithConditions.getNumberCharacterMin()
            val maxNumberCharacters = lineOfPasswordWithConditions.getNumberCharactersMax()
            val password = lineOfPasswordWithConditions.getPassword()

            val numberCharactersInPassword = password
                                        ?.filter { ch -> ch === characterToCheck.toChar() }?.length

            return (numberCharactersInPassword in minNumberCharacters..maxNumberCharacters)
        }
    }
}