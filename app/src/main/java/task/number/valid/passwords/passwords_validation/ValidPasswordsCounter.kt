package task.number.valid.passwords.passwords_validation

import java.io.BufferedReader

class ValidPasswordsCounter() {

    companion object {

        fun count(passwordsFile: BufferedReader): Int {
            return fileOfPasswordsIntoArrayListOfLines(passwordsFile)
                    .filter { line ->
                        PasswordValidator.isValid(line)
            }.count()
        }

        private fun fileOfPasswordsIntoArrayListOfLines(passwordsFile: BufferedReader)
            : MutableList<LineOfPasswordWithConditions> {

            val listOfLines = mutableListOf<LineOfPasswordWithConditions>()
            var lineString = passwordsFile.readLine()
            while (lineString != null) {
                LineOfPasswordWithConditions(lineString.trim()).apply {
                    if (this.isLineValid())
                        listOfLines.add(this)
                }
                lineString = passwordsFile.readLine()
            }
            return listOfLines
        }
    }
}