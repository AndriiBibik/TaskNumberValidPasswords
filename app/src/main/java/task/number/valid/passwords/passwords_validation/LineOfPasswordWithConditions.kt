package task.number.valid.passwords.passwords_validation

class LineOfPasswordWithConditions(private val lineOfPasswordWithConditions: String) {

    // regex - means regular expression
    private val regexLineValidator = ".{1}[ ]+[0-9]+[-][0-9]+[:][ ]+.+".toRegex()
    private val regexMinMaxNumberCharactersBlock = "[\\s]([0-9]+)[-]([0-9]+)[:][\\s]".toRegex()
    private val regexPasswordSection = "[^: ]+\$".toRegex()

    fun isLineValid(): Boolean {
        return regexLineValidator.containsMatchIn(lineOfPasswordWithConditions)
    }

    fun getCharacterFromConditions() = lineOfPasswordWithConditions[0]

    fun getNumberCharacterMin(): Int {
        val (min, max) = regexMinMaxNumberCharactersBlock.find(lineOfPasswordWithConditions)!!.destructured
        return Integer.valueOf(min)
    }

    fun getNumberCharactersMax(): Int {
        val (min, max) = regexMinMaxNumberCharactersBlock.find(lineOfPasswordWithConditions)!!.destructured
        return Integer.valueOf(max)
    }

    fun getPassword(): String? {
        return regexPasswordSection.find(lineOfPasswordWithConditions)?.value
    }
}